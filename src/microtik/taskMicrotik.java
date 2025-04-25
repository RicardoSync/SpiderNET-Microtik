/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import Corte.CorteHelper;
import SSH.SSHHelper;
import java.util.Optional;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import me.legrange.mikrotik.ApiConnectionException;

/**
 *
 * @author cisco
 */
public class taskMicrotik {

    public void createTask(String nameCliente, String address, String user, String password, String host, int diaCorte, int mesesPagados) throws ApiConnectionException {
        System.out.println("metodo para creacion de la tarea");
        ApiConnection cn = null;

        try {
            cn = ApiConnection.connect(host);
            cn.login(user, password);

            String fechaCorte = CorteHelper.getFechaCorte(diaCorte, mesesPagados);

            String comando = "/system/scheduler/add name=\"" + nameCliente + "\""
                    + " start-date=" + fechaCorte
                    + " start-time=23:58:00 interval=0s on-event=\"/ip firewall address-list add list=corte address=" + address + "\"";

            System.out.println("[INFO] Comando generado: " + comando);
            cn.execute(comando);
            System.out.println("[✅] Tarea de corte creada para: " + fechaCorte);

            JOptionPane.showMessageDialog(null, "Tarea de corte programada para el " + fechaCorte, "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println("[❌] Error al crear la tarea de corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al crear la tarea de corte:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void reprogramarCorteTrasPagoAsync(
            String nombreCliente,
            String address,
            String user,
            String password,
            String host,
            int diaCorte,
            int mesesPagados
    ) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Deseas reprogramar el corte para este cliente?\n(" + nombreCliente + ")",
                "Confirmar reprogramación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcion != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "No se realizó la reprogramación del corte.",
                    "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JDialog dialogoCarga = new JDialog();
        JLabel lbl = new JLabel("Reprogramando corte para: " + nombreCliente + "...", SwingConstants.CENTER);
        dialogoCarga.setUndecorated(true);
        dialogoCarga.add(lbl);
        dialogoCarga.setSize(300, 80);
        dialogoCarga.setLocationRelativeTo(null);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                ApiConnection cn = null;
                try {
                    cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    List<Map<String, String>> schedulers = cn.execute("/system/scheduler/print");

                    Optional<Map<String, String>> schedulerOpt = schedulers.stream()
                            .filter(s -> nombreCliente.equalsIgnoreCase(s.get("name")))
                            .findFirst();

                    if (schedulerOpt.isPresent()) {
                        String idScheduler = schedulerOpt.get().get(".id");
                        cn.execute("/system/scheduler/remove .id=" + idScheduler);
                        System.out.println("[✅] Scheduler eliminado: " + nombreCliente);
                    } else {
                        System.out.println("[⚠️] No se encontró scheduler con nombre: " + nombreCliente);
                    }

                    createTask(nombreCliente, address, user, password, host, diaCorte, mesesPagados);

                } catch (Exception e) {
                    System.err.println("[❌] Error en la reprogramación: " + e.getMessage());
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null,
                            "Error durante la reprogramación:\n" + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
                } finally {
                    if (cn != null) {
                        try {
                            cn.close();
                        } catch (Exception e) {
                            System.err.println("[⚠️] Error al cerrar conexión MikroTik: " + e.getMessage());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                dialogoCarga.dispose();
                JOptionPane.showMessageDialog(null,
                        "Proceso de reprogramación finalizado.",
                        "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        worker.execute();
        dialogoCarga.setVisible(true);
    }


    public void createTaskEsteMes(String nameCliente, String address, String user, String password, String host, int diaCorte) throws ApiConnectionException {
        ApiConnection cn = null;

        try {
            cn = ApiConnection.connect(host);
            cn.login(user, password);

            // 🔄 Obtener la fecha de corte para ESTE MES
            String fechaCorte = CorteHelper.getFechaCorteEsteMes(diaCorte);

            // Armar comando scheduler
            String comando = "/system/scheduler/add name=\"" + nameCliente + "\""
                    + " start-date=" + fechaCorte
                    + " start-time=23:58:00 interval=0s on-event=\"/ip firewall address-list add list=corte address=" + address + "\"";

            System.out.println("[INFO] Comando generado: " + comando);
            cn.execute(comando);
            System.out.println("[✅] Tarea de corte creada para: " + fechaCorte);

            JOptionPane.showMessageDialog(null, "Tarea de corte programada para el " + fechaCorte, "AdmiNET", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.println("[❌] Error al crear la tarea de corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al crear la tarea de corte:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void eliminarTareaEnSegundoPlano(
            String nombreCliente,
            String address,
            String user,
            String password,
            String host,
            int diaCorte
    ) {
        System.out.println("Eliminando la tarea del scheduler en segundo plano");
        JOptionPane.showMessageDialog(null, "Eliminando tarea programada (scheduler)... esto se realizará en segundo plano.", "AdmiNET", JOptionPane.INFORMATION_MESSAGE);

        new Thread(() -> {
            ApiConnection cn = null;
            try {
                cn = ApiConnection.connect(host);
                cn.login(user, password);

                // Buscar el ID del scheduler por nombre
                String buscarComando = "/system/scheduler/print where name=\"" + nombreCliente + "\"";
                List<Map<String, String>> resultados = cn.execute(buscarComando);

                if (!resultados.isEmpty()) {
                    String idScheduler = resultados.get(0).get(".id");

                    // Eliminar el scheduler usando el ID
                    String eliminarComando = "/system/scheduler/remove .id=" + idScheduler;
                    System.out.println("[INFO] Eliminando scheduler ID: " + idScheduler + " para cliente: " + nombreCliente);
                    cn.execute(eliminarComando);

                    System.out.println("[✅] Scheduler anterior eliminado para: " + nombreCliente);
                    JOptionPane.showMessageDialog(null, "Tarea anterior eliminada correctamente.", "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("[⚠️] No se encontró una tarea con el nombre: " + nombreCliente);
                    JOptionPane.showMessageDialog(null, "No se encontró una tarea programada con ese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                System.err.println("[❌] Error al intentar eliminar tarea: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al eliminar la tarea:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (cn != null) {
                    try {
                        cn.close();
                    } catch (Exception e) {
                        System.err.println("[⚠️] Error al cerrar conexión MikroTik: " + e.getMessage());
                    }
                }
            }
        }).start(); // 🚀 Lanzamos el hilo
    }


}
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
import me.legrange.mikrotik.ApiConnectionException;

/**
 *
 * @author cisco
 */
public class taskMicrotik {

    public void createTask(String nameCliente, String address, String user, String password, String host, int diaCorte) throws ApiConnectionException {
        ApiConnection cn = null;

        try {
            cn = ApiConnection.connect(host);
            cn.login(user, password);

            String fechaCorte = CorteHelper.getFechaCorteSiguienteMes(diaCorte);

            // CORREGIDO: se agregan comillas dobles escapadas alrededor del nameCliente
            String comando = "/system/scheduler/add name=\"" + nameCliente + "\""
                    + " start-date=" + fechaCorte
                    + " start-time=00:00:00 interval=1m on-event=\"/ip firewall address-list add list=corte address=" + address + "\"";

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

    public void reprogramarCorteTrasPago(
            String nombreCliente,
            String address,
            String user,
            String password,
            String host,
            int diaCorte
    ) {
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
                JOptionPane.showMessageDialog(null, "No se encontró una tarea programada anterior con ese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("[❌] Error al intentar eliminar tarea: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar la tarea anterior:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    System.err.println("[⚠️] Error al cerrar conexión MikroTik: " + e.getMessage());
                }
            }
        }
        // Crear nueva tarea con fecha del próximo mes
        try {
            createTask(nombreCliente, address, user, password, host, diaCorte);
        } catch (ApiConnectionException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la nueva tarea:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
                    + " start-time=00:00:00 interval=1m on-event=\"/ip firewall address-list add list=corte address=" + address + "\"";

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

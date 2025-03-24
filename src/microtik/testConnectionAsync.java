/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 *
 * @author ricardo
 */
public class testConnectionAsync {

    public void testConnectionAsync(String user, String password, String routerIp) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                ApiConnection con = null;
                try {
                    con = ApiConnection.connect(routerIp);
                    con.login(user, password);
                    return true;
                } catch (Exception e) {
                    System.err.println("Error testConnectionAsync: " + e.getMessage());
                    return false;
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (Exception ex) {
                            // Ignorar
                        }
                    }
                }
            }

            @Override
            protected void done() {
                try {
                    Boolean resultado = get();
                    if (resultado) {
                        JOptionPane.showMessageDialog(null, "Conexión exitosa al router");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo conectar al router", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    // Error al obtener el resultado (interrupción, etc.)
                    JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    public void testPingFromMikrotikAsync(String user, String password, String routerIp, String targetIp) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() {
                ApiConnection con = null;
                try {
                    con = ApiConnection.connect(routerIp);
                    con.login(user, password);

                    // Ejecutar ping
                    List<Map<String, String>> response = con.execute("/ping address=" + targetIp + " count=3");

                    // Verificar si hubo respuesta
                    for (Map<String, String> result : response) {
                        if (result.containsKey("received") && Integer.parseInt(result.get("received")) > 0) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    System.err.println("Error en testPingFromMikrotikAsync: " + e.getMessage());
                    return false;
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (Exception ex) {
                            // Ignorar errores al cerrar
                        }
                    }
                }
            }

            @Override
            protected void done() {
                try {
                    Boolean resultado = get();
                    if (resultado) {
                        JOptionPane.showMessageDialog(null, "La IP tiene conexión desde el MikroTik");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay conexión a la IP desde el MikroTik", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
}

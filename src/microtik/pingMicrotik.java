/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;

/**
 *
 * @author cisco
 */
public class pingMicrotik {
    public void hacerPing(String ip, String user, String password, String routerIp) {
        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Ejecutar el comando de ping
            List<Map<String, String>> response = con.execute("/ping address=" + ip + " count=4");

            // Verificar si hay respuesta
            boolean recibido = false;
            for (Map<String, String> entry : response) {
                if (entry.containsKey("received") && Integer.parseInt(entry.get("received")) > 0) {
                    recibido = true;
                    break;
                }
            }

            // Mostrar resultado
            if (recibido) {
                System.out.println("Ping exitoso a " + ip);
                JOptionPane.showMessageDialog(null, "Ping exitoso a: " + ip);
            } else {
                System.out.println("No hay respuesta del host: " + ip);
                JOptionPane.showMessageDialog(null, "No hay respuesta del host: " + ip);

            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            System.out.println("Error al hacer ping: " + e);
            JOptionPane.showMessageDialog(null, "Error al hacer ping: " + e);
        }
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import Config.Conexion;
import java.sql.*;
import me.legrange.mikrotik.ApiConnection;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 */
public class lucifer {

    public void bloqueoCliente(String routerIp, String user, String password, String targetIp) {
        String blockAccess = "yes"; // Nuevo valor de block-access

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar el `.id` del lease
            List<Map<String, String>> response = con.execute("/ip/dhcp-server/lease/print where address=" + targetIp);

            if (response.isEmpty()) {
                System.out.println("No se encontró un lease para " + targetIp);
                JOptionPane.showMessageDialog(null, "No encontramos esa ip: " + targetIp);
            } else {
                // Obtener el `.id`
                String id = response.get(0).get(".id");

                // Ejecutar el comando `set`
                con.execute("/ip/dhcp-server/lease/set .id=" + id + " block-access=" + blockAccess);
                JOptionPane.showMessageDialog(null, "El cliente se bloqueo de manera exitosa");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tenemos problemas con el microtik: " + routerIp + " tipo: " + e);
        }
    }

    public void desbloqueoCliente(String routerIp, String user, String password, String targetIp) {
        String blockAccess = "no"; // Nuevo valor de block-access

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar el `.id` del lease
            List<Map<String, String>> response = con.execute("/ip/dhcp-server/lease/print where address=" + targetIp);

            if (response.isEmpty()) {
                System.out.println("No se encontró un lease para " + targetIp);
                JOptionPane.showMessageDialog(null, "No encontramos esa ip: " + targetIp);
            } else {
                // Obtener el `.id`
                String id = response.get(0).get(".id");

                // Ejecutar el comando `set`
                con.execute("/ip/dhcp-server/lease/set .id=" + id + " block-access=" + blockAccess);
                JOptionPane.showMessageDialog(null, "El cliente se desbloqueo de manera correcta");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tenemos problemas con el microtik: " + routerIp + " tipo: " + e);
        }
    }

    public void agregarQueueSinPadre(String routerIp, String user, String password, String queueName, String maxLimit, String targetIp) {
        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Agregar la cola simple
            con.execute("/queue/simple/add name=" + queueName
                    + " max-limit=" + maxLimit
                    + " target=" + targetIp);

            System.out.println("Cola agregada correctamente.");
            JOptionPane.showMessageDialog(null, "Cola simple agregada a microtik");

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en modulo MicrotikQueueAdd: " + e);
        }
    }
    
    public void agregarQueuePadre(String routerIP, String user, String password, String queueName, String maxLimit, String targetIp, String padre){
        try {
            ApiConnection con = ApiConnection.connect(routerIP);
            con.login(user, password);
            
            con.execute("/queue/simple/add name =" + queueName
                + " max-limit=" + maxLimit
                + " target=" + targetIp
                + " parent=" + padre);
            
            JOptionPane.showMessageDialog(null, "Cola simple agregada: " + queueName + " con padre: " + padre);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar cola con padre: " + e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDeveloper;

import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ricardo
 */
public class desbloqueo {

    public void envioComandoBloqueo(String username, String password, String ip, String direccionIp) throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect(ip); // Conectar al MikroTik
        try {
            con.login(username, password); // Iniciar sesión en el MikroTik
            // Comando corregido con el formato adecuado
            String test = "/queue/simple/add name=\"Yolanda Escobedo\" target=" + direccionIp + " max-limit=\"100M/10M\"";
            con.execute(test); // Ejecutar el comando
            JOptionPane.showMessageDialog(null, "Cliente desbloqueado con ip: " + direccionIp, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            con.close(); // Asegurar que la conexión se cierre al terminar
        }
    }

    public void envioComandoDesbloqueo(String username, String password, String ip, String direccionIp) throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect(ip); // Conectar al MikroTik
        try {
            con.login(username, password); // Iniciar sesión en el MikroTik

            // Buscar el ID del lease con la IP específica
            List<Map<String, String>> response = con.execute("/ip/dhcp-server/lease/print where address=" + direccionIp);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró el cliente con IP: " + direccionIp, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Extraer el ID del lease
            String leaseId = response.get(0).split(" ")[1]; // Extrae el ID del lease

            // Ejecutar el comando de desbloqueo con el ID obtenido
            String comandoSet = "/ip/dhcp-server/lease/set .id=" + leaseId + " block-access=no";
            con.execute(comandoSet);

            JOptionPane.showMessageDialog(null, "Cliente desbloqueado con IP: " + direccionIp, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            con.close(); // Cerrar la conexión
        }
    }

    public static void main(String[] args) {
        desbloqueo desbloqueo = new desbloqueo();
        String username = "admin";
        String password = "zerocuatro04";
        String ip = "192.168.1.70";
        String direccionIp = "122.122.123.20";
        try {
            desbloqueo.envioComandoDesbloqueo(username, password, ip, direccionIp);
        } catch (MikrotikApiException e) {
            System.out.println(e);
        }
    }
}

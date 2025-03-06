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

    public static void main(String[] args) {
        String routerIp = "192.168.1.70"; // Cambia a la IP de tu MikroTik
        String user = "admin";
        String password = "zerocuatro04";
        String targetIp = "122.122.123.8"; // Dirección IP a modificar
        String blockAccess = "yes"; // Nuevo valor de block-access

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar el `.id` del lease
            List<Map<String, String>> response = con.execute("/ip/dhcp-server/lease/print where address=" + targetIp);

            if (response.isEmpty()) {
                System.out.println("No se encontró un lease para " + targetIp);
            } else {
                // Obtener el `.id`
                String id = response.get(0).get(".id");

                // Ejecutar el comando `set`
                con.execute("/ip/dhcp-server/lease/set .id=" + id + " block-access=" + blockAccess);
                System.out.println("Lease actualizado correctamente.");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void bloquearCliente(String nombreMicrotik, String ipCliente){
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if(cn!=null){
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
            
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombreMicrotik);
                
                resultado = cursor.executeQuery();
                
                if(resultado.next()){
                    String username = resultado.getString("username");
                    String password = resultado.getString("password");
                    String ip = resultado.getString("ip");
                    System.out.println(username + password + ip);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en consulta de microtik" + e, "Modulo bloqueo", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No logramos obtener la conexion");
        }
        
    }
}

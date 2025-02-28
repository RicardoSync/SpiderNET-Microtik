package microtik;

import Config.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Debemos de obtener el usuario, password e ip del microtik que le pasemos
 * haciendo una consulta en la base de datos. Cuanto tengamos esos datos,
 * mandamos el comando de block acceses no a ese microtik con la ip del cliente
 * que obtenemos del modulo pagoWindows.
 *
 */
public class unlockClient {

    public void desbloquearCliente(String direccionIp, String nombreMicrotik) throws MikrotikApiException {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;
            ResultSet resultado = null;

            try {
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombreMicrotik);
                resultado = cursor.executeQuery();

                if (resultado.next()) {
                    String ipMicrotik = resultado.getString("ip");
                    String username = resultado.getString("username");
                    String password = resultado.getString("password");
                    envioComandoBloqueo(username, password, ipMicrotik, direccionIp);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron credenciales para: " + nombreMicrotik, "SpiderNET", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar la base de datos de MikroTik: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.", "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void envioComandoBloqueo(String username, String password, String ip, String direccionIp) throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect(ip); // Conectar al MikroTik
        try {
            con.login(username, password); // Iniciar sesión en el MikroTik

            // Comando corregido con el formato adecuado
            String comando = "ip dhcp-server lease set [find address=" + direccionIp + "] block-access=yes";
            String test = "/queue/simple/add name=\"Yolanda Escobedo\" target=" + direccionIp + " max-limit=\"100M/10M\"";
            con.execute(comando); // Ejecutar el comando
            JOptionPane.showMessageDialog(null, "Cliente desbloqueado con ip: " + direccionIp, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            con.close(); // Asegurar que la conexión se cierre al terminar
        }
    }

}

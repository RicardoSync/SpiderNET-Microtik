package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection con;

    public Conexion() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Leer configuración desde `config.properties`
            String host = ConfigManager.getProperty("db.host");
            String port = ConfigManager.getProperty("db.port");
            String database = ConfigManager.getProperty("db.database");
            String user = ConfigManager.getProperty("db.user");
            String password = ConfigManager.getProperty("db.password");

            // Construir la URL de conexión
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true";


            // Establecer la conexión
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e, "Módulo Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e, "Módulo Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
}

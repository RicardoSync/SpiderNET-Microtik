package activacion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionServidor {
    private Connection con;

    public ConexionServidor() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Leer configuración desde `config.properties`
            String host = "localhost";
            String port = "3306";
            String database = "spidernet";
            String user = "root";
            String password = "spidernet/";

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

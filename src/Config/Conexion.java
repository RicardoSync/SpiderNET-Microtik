package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            // Cargar el driver de MySQL para versiones 8.0+
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spidernet", "cisco", "MinuzaFea265/");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos un error en el modulo de conexion: " + e, "Modulo Conexion", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void closeConnection(){
        try {
            if (con != null){
                con.close();
                System.out.println("Conexion cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e, "Módulo Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Hola Peter, Como has estado
    
}

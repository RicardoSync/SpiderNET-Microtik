package Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Consultas {
    public ArrayList<String> consultarPaquetes(){
        ArrayList<String> paquetes = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if(cn != null){
            PreparedStatement cursor;
            ResultSet rs = null;
            
            try {
                String sql = "SELECT nombre FROM paquetes";
                cursor = cn.prepareStatement(sql);
                rs = cursor.executeQuery();
                
                while(rs.next()){
                    String nombrePaquete = rs.getString("nombre");
                    System.out.println(nombrePaquete);
                    paquetes.add(nombrePaquete);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error en base de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       return paquetes;
    }
    
    public ArrayList<String> consultarAntenasAp(){
        ArrayList<String> antenasAp = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        if(con != null){
            PreparedStatement cursor = null;
            ResultSet rs = null;
            
            try {
                String sql = "SELECT nombre FROM antenasap";
                cursor = con.prepareStatement(sql);
                rs = cursor.executeQuery();
                
                while(rs.next()){
                    String nombreAntenas = rs.getString("nombre");
                    antenasAp.add(nombreAntenas);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenermos un error en base de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return antenasAp;
    }
   
    public ArrayList<String> consultarPlataformas(){
        ArrayList<String> plataformas = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        if(con != null){
            PreparedStatement cursor = null;
            ResultSet rs = null;
            
            try {
                String sql = "SELECT nombre FROM serviciosplataforma";
                cursor = con.prepareStatement(sql);
                rs = cursor.executeQuery();
                
                while(rs.next()){
                    String nombreAntenas = rs.getString("nombre");
                    plataformas.add(nombreAntenas);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenermos un error en base de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return plataformas;
    }

    public ArrayList<ArrayList<String>> consultarClientes(int id) {
        ArrayList<ArrayList<String>> clientes = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet rs = null;

            try {
                String sql = "SELECT id, nombre, telefono, email, direccion, ip_cliente, dia_corte FROM clientes WHERE id = ? ";
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id);
                rs = cursor.executeQuery();

                while (rs.next()) {
                    ArrayList<String> cliente = new ArrayList<>();
                    cliente.add(rs.getString("id"));
                    cliente.add(rs.getString("nombre"));
                    cliente.add(rs.getString("telefono"));
                    cliente.add(rs.getString("email"));
                    cliente.add(rs.getString("direccion"));
                    cliente.add(rs.getString("ip_cliente"));
                    cliente.add(rs.getString("dia_corte"));

                    // Agregar la lista de este cliente a la lista general
                    clientes.add(cliente);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

}

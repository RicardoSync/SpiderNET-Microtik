/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDeveloper;
import Config.Conexion;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import me.legrange.mikrotik.ApiConnection;
/**
 *
 * @author cisco
 */
public class testEnvios {
    
    public void buscarApiDatos(){
        String direcionIp = "172.168.10.254";
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql = "SELECT telefono, api FROM clientes WHERE ip = ?";
        
        if(cn!=null){
            PreparedStatement cursor;
            ResultSet resultado;
            
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, direcionIp);

                resultado = cursor.executeQuery();
                
                if(resultado.next()){
                    String telefono = resultado.getString("telefono");
                    String api = resultado.getString("api");
                    System.out.println("api: " + api + " telefono: " + telefono);
                   // bloquearClientePPoE(api, telefono, direcionIp, "admin", "192.168.1.78", "admin");
                }else{
                    System.out.println("sin datos");
                }
            } catch (Exception e) {
            }
        }
    }

    public void bloquearClientePPoE(String api, String telefono, String address, String user, String host, String password) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);
                    String comandoWhatsapp = "/tool/fetch url=\"https://api.callmebot.com/whatsapp.php?phone="+telefono+"&text=Su+servicio+fue+bloqueado.+Contacta+con+el+administrador&apikey="+api+"\" keep-result=no";
                    
//                    String comando = "/ip/firewall/address-list/add list=corte address=" + address;
//                    System.out.println(comando);
                    System.out.println(comandoWhatsapp);
                    
//                    cn.execute(comando);
//                    cn.execute(comandoWhatsapp);

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "El cliente con dirección IP: " + address + " fue bloqueado de manera exitosa")
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Tenemos un problema al bloquear el cliente: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }
}

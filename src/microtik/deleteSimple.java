/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
/**
 *
 * @author cisco
 */
public class deleteSimple {
    public void eliminarDhcpNetworik(String id, String user, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            String comando = "/ip/dhcp-server/network/remove numbers="+id;
            System.out.println(comando);
            
            cn.execute(comando);
            cn.close();
            JOptionPane.showMessageDialog(null, "Network eliminado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos problemas al eliminar el NetWork: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void eliminarAddres(String id, String user, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            String comando = "/ip/address/remove numbers="+id;
            System.out.println(comando);
            
            cn.execute(comando);
            cn.close();
            JOptionPane.showMessageDialog(null, "Address eliminado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos problemas al eliminar el Address: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }
     public void eliminarPooln(String id, String user, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            String comando = "/ip/pool/remove numbers="+id;
            System.out.println(comando);
            
            cn.execute(comando);
            cn.close();
            JOptionPane.showMessageDialog(null, "Pool eliminado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos problemas al eliminar el Pool: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void eliminarDHCP(String id, String user, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            String comando = "/ip/dhcp-server/remove numbers="+id;
            System.out.println(comando);
            
            cn.execute(comando);
            cn.close();
            JOptionPane.showMessageDialog(null, "DHCP-Server eliminado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos problemas al eliminar el DHCP-Server: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }
}

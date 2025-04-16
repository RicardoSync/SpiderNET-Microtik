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
public class simpleQueue {

    public void configurarDNS(String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comando = "/ip/dns/set servers=8.8.8.8 allow-remote-requests=yes";
            cn.execute(comando);
            JOptionPane.showMessageDialog(null, "DNS configurados de manera exitosa");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Problemas al querer establecer el dns: " + e);
        }
    }

    public void configurarNAT(String wan, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comando = "/ip/firewall/nat/add chain=srcnat out-interface="+wan +" action=masquerade";
            cn.execute(comando);

            JOptionPane.showMessageDialog(null, "Configuracion del NAT de manera exitosa");
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas al configurar el NAT: " + e);
        }
    }

    public void addresList(String addres, String ether, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comando = "/ip/address/add address=" + addres + " interface=" + ether;
            System.out.println(comando);
            cn.execute(comando);
            JOptionPane.showMessageDialog(null, "Lista de ips agrefada");
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos problemas al agregar la lista de ips: " + e);
        }
    }
    
    public void poolRange(String name, String range, String user, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            String comando = "/ip/pool/add name="+name + " ranges="+range;
            System.out.println(comando);
            cn.execute(comando);
            
            JOptionPane.showMessageDialog(null, "El pool de direcciones ip fue creado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tenemos un problema al agregar el pool: " + e);
        }
    }
   
   public void serverDHCP(String address, String gtw, String dns, String user, String password, String host){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = "/ip/dhcp-server/network/add address="+address + " gateway="+gtw + " dns-server="+dns;
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "Server dhcp creado");
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showConfirmDialog(null, "Error al configurar server dhcp: " + e);
       }
   }

   public void asignacionDHCP(String name, String interfaz, String pool, String user, String password, String host, String comentario){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = "/ip/dhcp-server/add name="+name + " interface="+interfaz + " address-pool=" + pool +" disabled=no comment="+comentario;
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "Interfaz: "+ interfaz + " asignada de manera correcta a dhcp");
           cn.close();
           
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(null, "Tenemos un problema para el dhcp: " + e);
       }
   }

   public void eliminarDhcp(String id, String user, String password, String host){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = " /ip/dhcp-server/remove numbers="+id;
           
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "DHCP Server eliminado de manera exitosa");
           cn.close();
           
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(null, "Tenemos un problema para el dhcp: " + e);
       }
   }   
   
   
    public void desabilitarDHCP(String id, String user, String password, String host){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = "/ip/dhcp-server/disable numbers="+id;
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "DHCP se dabilidato de manera exitosa");
           cn.close();
           
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(null, "Tenemos un problema para el dhcp: " + e);
       }
   }
    
   public void habilitarDhcp(String id, String user, String password, String host){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = "/ip/dhcp-server/enable numbers="+id;
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "DHCP se habilito");
           cn.close();
           
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(null, "Tenemos un problema para el dhcp: " + e);
       }
   } 

   public void eliminarNetwork(String id, String user, String password, String host){
       try {
           ApiConnection cn = ApiConnection.connect(host);
           cn.login(user, password);
           
           String comando = "/ip/dhcp-server/network/remove numbers="+id;
           System.out.println(comando);
           cn.execute(comando);
           JOptionPane.showMessageDialog(null, "Network se elimino");
           cn.close();
           
       } catch (Exception e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(null, "Tenemos un problema para eliminar: " + e);
       }
   } 
   
public void eliminarQueue(String user, String password, String host, String direccion_ip) {
//    String sub_red = "/32";
//    try {
//        ApiConnection cn = ApiConnection.connect(host);
//        if (cn == null) {
//            System.out.println("Error: No se pudo conectar a MikroTik.");
//            return;
//        }
//
//        cn.login(user, password);
//
//        // Se construye el comando usando direccion_ip y sub_red concatenados
//        String comando = "/queue/simple/remove [find where target=" + direccion_ip + sub_red + "]";
//        System.out.println("Comando enviado para eliminar queue: " + comando);
//
//        cn.execute(comando);
//        cn.close();
//
//        System.out.println("Queue eliminada correctamente.");
//    } catch (Exception e) {
//        System.out.println("Error al eliminar la queue: " + e.getMessage());
//    }
}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import com.jcraft.jsch.*;
import java.io.InputStream;
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
        String target = direccion_ip + "/32";
        String comando = "/queue/simple/remove [find where target=\"" + target + "\"]";
        System.out.println(comando);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);

            // Saltarse la verificación de clave del host
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect(30000); // Timeout de 30 segundos

            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(comando);
            channel.setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();

            // Leer salida (aunque el comando no devuelve nada si funciona)
            byte[] buffer = new byte[1024];
            while (in.read(buffer, 0, buffer.length) >= 0) {
                // Puedes imprimir si gustas
            }

            channel.disconnect();
            session.disconnect();

            System.out.println("✅ Queue eliminada vía SSH correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error SSH al eliminar la queue: " + e.getMessage());
        }
    }
}

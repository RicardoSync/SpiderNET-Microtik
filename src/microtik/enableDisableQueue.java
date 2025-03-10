//aqui reciboe el nombre del queue, y lo habilita o desabilita
package microtik;

import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;

/**
 *
 * @author ricardo
 */
public class enableDisableQueue {

    public void deshabilitar(String id, String host, String user, String password) {
        try {
            ApiConnection ac = ApiConnection.connect(host);
            ac.login(user, password);

            // Ejecutar el comando con espacio y numbers=
            //ac.execute("/queue/simple/disable numbers=JuanaMedina");
            String comando = ("/queue/simple/disable numbers=" + id);
            ac.execute(comando);
            JOptionPane.showMessageDialog(null, "Queue: " + id + " se deshabilitó correctamente.");
            ac.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en módulo enableDisableQueue: " + e.getMessage());
        }
    }

    public void enable(String id, String host, String user, String password) {
        try {
            ApiConnection ac = ApiConnection.connect(host);
            ac.login(user, password);

            // Ejecutar el comando con espacio y numbers=
            //ac.execute("/queue/simple/disable numbers=JuanaMedina");
            String comando = ("/queue/simple/enable numbers=" + id);
            ac.execute(comando);
            JOptionPane.showMessageDialog(null, "Queue: " + id + " se habilito correctamente.");
            ac.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en módulo enableDisableQueue: " + e.getMessage());
        }
    }

    public void removeQueue(String user, String password, String routerIp, String id) {
        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Ejecutar el comando para eliminar la cola
            con.execute("/queue/simple/remove numbers=" + id);
            JOptionPane.showMessageDialog(null, "Queue eliminado de manera exitosa");

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el modulo remove queue: " + e);
        }
    }
    
    public void makeStatic(String user, String password, String host, String id){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            
            cn.execute("/ip/dhcp-server/lease/make-static numbers=" + id);
            JOptionPane.showMessageDialog(null, "El cliente fue colocado como make-static de manera exitosa");
            cn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al colocar como make-static: " + e);
        }
    }
}

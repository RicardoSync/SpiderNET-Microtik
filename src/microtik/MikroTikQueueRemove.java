import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;

public class MikroTikQueueRemove {
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
}

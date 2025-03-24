import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import me.legrange.mikrotik.ApiConnection;

public class MikroTikQueueRemove {
public void removeQueue(String user, String password, String routerIp, String id) {
    SwingWorker<Void, Void> worker = new SwingWorker<>() {
        @Override
        protected Void doInBackground() {
            try {
                ApiConnection con = ApiConnection.connect(routerIp);
                con.login(user, password);
                
                con.execute("/queue/simple/remove numbers=" + id);
                
                SwingUtilities.invokeLater(() -> 
                    JOptionPane.showMessageDialog(null, "Queue eliminado de manera exitosa")
                );
                
                con.close();
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> 
                    JOptionPane.showMessageDialog(null, "Error en el módulo remove queue: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                );
                System.out.println(e);
            }
            return null;
        }
    };
    worker.execute();
}
}

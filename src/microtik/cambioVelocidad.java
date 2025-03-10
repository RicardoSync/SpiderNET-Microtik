package microtik;

import me.legrange.mikrotik.ApiConnection;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 * Debemos pasar la ip del cliente, junto a su velocidad de subida y bajada de manera correspondiente
 * para poder hacer el cambio 5/04/25
 */
public class cambioVelocidad {

    public void cambioVelocidad(String routerIp, String user, String password, String targetIp, String maxLimit) {
        //concatenar el 32 al final de targetIp ejemlplo 122.122.125.23/32
        try {
            // Conectar al MikroTik
            String ip = targetIp + "/32";
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar la ID de la regla con `find`
            List<Map<String, String>> response = con.execute("/queue/simple/print where target=" + ip);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontro una regla para: " + ip);
            } else {
                // Obtener el `.id` de la regla
                String id = response.get(0).get(".id");

                // Ejecutar el comando `set`
                con.execute("/queue/simple/set .id=" + id + " max-limit=" + maxLimit);
                JOptionPane.showMessageDialog(null, "Se actualizo de manera correcta la velocidad");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tenemos un problema al cambiar la velocidad: " + e);
        }
    }
}

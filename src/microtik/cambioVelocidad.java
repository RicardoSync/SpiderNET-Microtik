package microtik;

import me.legrange.mikrotik.ApiConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ricardo
 * Debemos pasar la ip del cliente, junto a su velocidad de subida y bajada de manera correspondiente
 * para poder hacer el cambio 5/04/25
 */
public class cambioVelocidad {

    public static void main(String[] args) {
        String routerIp = "192.168.1.70"; // Cambia a la IP de tu MikroTik
        String user = "admin";
        String password = "zerocuatro04";
        String targetIp = "122.122.125.10/32"; // Dirección objetivo
        String maxLimit = "100M/10M"; // Nuevo límite

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar la ID de la regla con `find`
            List<Map<String, String>> response = con.execute("/queue/simple/print where target=" + targetIp);

            if (response.isEmpty()) {
                System.out.println("No se encontró una regla para " + targetIp);
            } else {
                // Obtener el `.id` de la regla
                String id = response.get(0).get(".id");

                // Ejecutar el comando `set`
                con.execute("/queue/simple/set .id=" + id + " max-limit=" + maxLimit);
                System.out.println("Límite de ancho de banda actualizado correctamente.");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

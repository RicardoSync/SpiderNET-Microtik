package microtik;

import me.legrange.mikrotik.ApiConnection;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo Debemos pasar la ip del cliente, junto a su velocidad de
 * subida y bajada de manera correspondiente para poder hacer el cambio 5/04/25
 */
public class cambioVelocidad {

    public void cambioVelocidad(String routerIp, String user, String password, String targetIp, String maxLimit, String tiempoBurst) {
        try {
            // Agregar /32 al targetIp
            String ip = targetIp + "/32";
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Buscar la ID de la regla con `find`
            List<Map<String, String>> response = con.execute("/queue/simple/print where target=" + ip);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró una regla para: " + ip);
            } else {
                // Obtener el `.id` de la regla
                String id = response.get(0).get(".id");

                // Extraer valores numéricos de maxLimit
                String[] parts = maxLimit.split("/"); // Divide en subida y bajada
                double maxUpload = extractNumber(parts[0]); // 20M → 20
                double maxDownload = extractNumber(parts[1]); // 20M → 20

                // Calcular Burst Limit (1.5x del Max Limit)
                double burstUpload = maxUpload * 1.5;
                double burstDownload = maxDownload * 1.5;

                // Calcular Burst Threshold (75% del Max Limit)
                double thresholdUpload = maxUpload * 0.75;
                double thresholdDownload = maxDownload * 0.75;

                // Formatear salida en string con "M" al final
                String burstLimit = String.format("%.0fM/%.0fM", burstUpload, burstDownload);
                String burstThreshold = String.format("%.1fM/%.1fM", thresholdUpload, thresholdDownload);

                // Construir comando en una sola línea
                String comando = "/queue/simple/set .id=" + id + " max-limit=" + maxLimit + " burst-limit=" + burstLimit + " burst-threshold=" + burstThreshold + " burst-time=" + tiempoBurst;

                // Ejecutar comando
                con.execute(comando);

                JOptionPane.showMessageDialog(null, "Velocidad y ráfaga actualizadas correctamente.");
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cambiar la velocidad: " + e);
        }
    }

// Método para extraer el número de una cadena con "M" al final
    private static double extractNumber(String value) {
        return Double.parseDouble(value.replace("M", "").trim());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

///queue/simple add name="cliente" target=192.168.10.2/32 max-limit=10M/10M parent=ColaPadre burst-limit=20M/20M burst-threshold=13M/13M burst-time=20s/20s

/**
max-limit=10M/10M → Límite máximo de subida/bajada.
burst-limit=20M/20M → Límite de ráfaga (burst) para subida/bajada.
burst-threshold=13M/13M → Umbral para que el burst se active.
burst-time=20s/20s → Definir tanto upload-burst-time como download-burst-time.

 * @author ricardo
 */
public class queueRafagas {

    public void crearQueuePadre(String nombre, String target, String limit, String user, String paswd, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, paswd);

            // Convertir los valores de limit a enteros (ej: "15M/15M")
            String[] parts = limit.split("/");
            int upload = (int) extractNumber(parts[0]);
            int download = (int) extractNumber(parts[1]);

            String maxLimit = upload + "M/" + download + "M";

            // Escapar nombre con comillas
            String comando = "/queue/simple/add name=\"" + nombre + "\" target=" + target + " max-limit=" + maxLimit;

            //System.out.println(comando);
            cn.execute(comando);

            JOptionPane.showMessageDialog(null, "Cola padre: " + nombre + " creada de manera exitosa", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
            cn.close();

        } catch (MikrotikApiException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en el módulo creación de queue padre: " + e, "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
    }

    //creacion de queue sin parent
    public void crearQueueRafaga(String nombre, String target, String maxLimit, String tiempo, String user, String password, String host) {
        try {
            // Extraer y convertir a enteros
            String[] parts = maxLimit.split("/");
            int maxUpload = (int) extractNumber(parts[0]);
            int maxDownload = (int) extractNumber(parts[1]);

            // Burst: 1.5x (redondeado hacia arriba)
            int burstUpload = (int) Math.ceil(maxUpload * 1.5);
            int burstDownload = (int) Math.ceil(maxDownload * 1.5);

            // Threshold: 75% del max (redondeado hacia abajo)
            int thresholdUpload = (int) (maxUpload * 0.75);
            int thresholdDownload = (int) (maxDownload * 0.75);

            // Formatear todo como enteros con M
            String maxLimitStr = maxUpload + "M/" + maxDownload + "M";
            String burstLimit = burstUpload + "M/" + burstDownload + "M";
            String burstThreshold = thresholdUpload + "M/" + thresholdDownload + "M";

            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comandoPro = "/queue/simple/add name=\"" + nombre + "\""
                    + " target=" + target
                    + " max-limit=" + maxLimitStr
                    + " burst-limit=" + burstLimit
                    + " burst-threshold=" + burstThreshold
                    + " burst-time=" + tiempo;

            System.out.println("[CMD] " + comandoPro);
            cn.execute(comandoPro);

            JOptionPane.showMessageDialog(null, "Cliente agregado a SimpleQueue con ráfaga", "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar el queue: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //creacion de queue con el parent
    public void crearQueueRafagaPadre(String nombre, String target, String maxLimit, String parent, String tiempo, String user, String password, String host) {

        try {
            // Extraer valores numéricos
            String[] parts = maxLimit.split("/"); // Ej: "20M/20M"
            int maxUpload = (int) extractNumber(parts[0]);
            int maxDownload = (int) extractNumber(parts[1]);

            // Cálculos de ráfaga
            int burstUpload = (int) Math.ceil(maxUpload * 1.5);
            int burstDownload = (int) Math.ceil(maxDownload * 1.5);
            int thresholdUpload = (int) (maxUpload * 0.75);
            int thresholdDownload = (int) (maxDownload * 0.75);

            // Formateo en M
            String maxLimitStr = maxUpload + "M/" + maxDownload + "M";
            String burstLimit = burstUpload + "M/" + burstDownload + "M";
            String burstThreshold = thresholdUpload + "M/" + thresholdDownload + "M";

            // Conexión y comando
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comandoPro = "/queue/simple/add name=\"" + nombre + "\""
                    + " target=" + target
                    + " max-limit=" + maxLimitStr
                    + " parent=\"" + parent + "\""
                    + " burst-limit=" + burstLimit
                    + " burst-threshold=" + burstThreshold
                    + " burst-time=" + tiempo;

            System.out.println("[CMD] " + comandoPro);
            cn.execute(comandoPro);

            JOptionPane.showMessageDialog(null, "Cliente agregado a SimpleQueue con ráfaga y padre", "AdmiNET", JOptionPane.INFORMATION_MESSAGE);
            cn.close();

            // Si deseas activar la tarea automática
            // taskMicrotik microtik = new taskMicrotik();
            // microtik.createTask(nombre, target, user, password, host);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar el queue:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // Método para extraer el número de una cadena con "M" al final
    private static double extractNumber(String value) {
        return Double.parseDouble(value.replace("M", "").trim());
    }
}

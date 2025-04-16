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

            String comando = "/queue/simple/add name=" + nombre + " target=" + target + " max-limit=" + limit;
            //System.out.println(comando);
            cn.execute(comando);
            JOptionPane.showMessageDialog(null, "Cola padre: " + nombre + " creada de manera exitosa", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
            cn.close();


        } catch (MikrotikApiException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en el modulo creacion de queue padre: " + e, "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void crearQueueRafaga(String nombre, String taget, String maxLimit, String tiempo, String user, String password, String host) {
        // Extraer valores numéricos de maxLimit
        String[] parts = maxLimit.split("/"); // Divide en subida y bajada
        double maxUpload = extractNumber(parts[0]); // 15M → 15
        double maxDownload = extractNumber(parts[1]); // 15M → 15

        // Calcular Burst Limit (1.5x del Max Limit)
        double burstUpload = maxUpload * 1.5;
        double burstDownload = maxDownload * 1.5;

        // Calcular Burst Threshold (75% del Max Limit) y asegurarse de que sean enteros
        int thresholdUpload = (int) (maxUpload * 0.75);
        int thresholdDownload = (int) (maxDownload * 0.75);

        // Formatear salida en string con "M" al final
        String burstLimit = String.format("%.0fM/%.0fM", burstUpload, burstDownload);
        String burstThreshold = String.format("%dM/%dM", thresholdUpload, thresholdDownload); // Ahora son enteros

        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            String comandoPro = "/queue/simple/add name=" + nombre + " target=" + taget + " max-limit=" + maxLimit + 
                                " burst-limit=" + burstLimit + " burst-threshold=" + burstThreshold + " burst-time=" + tiempo;
            System.out.println(comandoPro);

            cn.execute(comandoPro);
            taskMicrotik microtik = new taskMicrotik();
//            microtik.createTask(nombre, taget, user, password, host);
            JOptionPane.showMessageDialog(null, "Cliente agregado a SimpleQueue junto a ráfaga");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al agregar el queue: " + e);
        }
    }


    // Método para extraer el número de una cadena con "M" al final
    private static double extractNumber(String value) {
        return Double.parseDouble(value.replace("M", "").trim());
    }

    public void crearQueueRafagaPadre(String nombre, String taget, String maxLimit, String parent, String tiempo, String user, String password, String host) {

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

        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);
            String comandoPro = "/queue/simple/add name=" + nombre + " target=" + taget + " max-limit=" + maxLimit + " parent=" + parent + " burst-limit=" + burstLimit + " burst-threshold=" + burstThreshold + " burst-time=" + tiempo;
            System.out.println(comandoPro);

            cn.execute(comandoPro);

            JOptionPane.showMessageDialog(null, "Cliente agregado a SimpleQueue junto a rafaga");
            cn.close();
            taskMicrotik microtik = new taskMicrotik();
//            microtik.createTask(nombre, taget, user, password, host);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al agregar el queue: " + e);
        }

    }
}

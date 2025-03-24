/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;

/**
 *
 * @author cisco
 */
public class actualizaQueueTask {

    /*
    Debemos actualizar la queue existente con el nuevo nombre, una vez cambiado el nombre
    Vamos a buscar la tarea para cambiarle el nombre
     */
    public void actualizarQueue(String address, String newName, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String ip = address + "/32";

            // Buscar el ID de la cola con la dirección IP
            List<Map<String, String>> response = cn.execute("/queue/simple/print where target=" + ip);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ No encontramos esta IP en Queue: " + address);
            } else {
                // Obtener el ID de la regla
                String id = response.get(0).get(".id");

                // Modificar el nombre del Queue con el ID
                String comando = "/queue/simple/set .id=" + id + " name=" + newName;
                System.out.println(comando);
                cn.execute(comando);

                JOptionPane.showMessageDialog(null, "✅ Queue actualizado con éxito: " + newName);
            }

            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error modulo actualizar queue: " + e);
        }
    }

    public void actualizarScheduler(String oldName, String newName, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            // Buscar si existe el scheduler con el nombre actual
            List<Map<String, String>> response = cn.execute("/system/scheduler/print where name=" + oldName);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ No se encontró la tarea programada: " + oldName);
            } else {
                // Obtener los datos actuales
                String onEvent = response.get(0).get("on-event");
                String startTime = response.get(0).get("start-time");
                String interval = response.get(0).get("interval");

                // Eliminar la tarea con el nombre antiguo
                cn.execute("/system/scheduler/remove numbers=" + oldName);

                // Crear la tarea con el nuevo nombre y mismos valores
                String comando = "/system/scheduler/add name="+newName+" start-time=" + startTime+" interval=" + interval+ " on-event=\"" + onEvent + "\"";
                System.out.println("Actualizar tarea: " + comando);
                cn.execute(comando);

                JOptionPane.showMessageDialog(null, "✅ Scheduler actualizado: " + newName);
            }

            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e);
        }
    }
}

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
public class taskMicrotik {

    public void createTask(String nameCliente, String address, String user, String password, String host) {
        /*Cuando se agrega el cliente a simple queue, se crea su tarea con intervalo de 30d
        Cuando el cliente paga se debe eliminar la tarea existente y crear una nueva
         */
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String comando = "/system/scheduler/add name=" + nameCliente + " start-time=00:00:00 interval=30d on-event=\"/ip firewall address-list add list=corte address=" + address + "\"";
            System.out.println(comando);
            cn.execute(comando);
            System.out.println("Agregada la tarea");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Tenemos un problema al integrar al cliente en los cortes automaticos: " + e);
        }
    }


//    public void createTask(String nameCliente, String address, String user, String password, String host) {
//        try {
//            ApiConnection cn = ApiConnection.connect(host);
//            cn.login(user, password);
//            String url = "https://api.callmebot.com/whatsapp.php?phone=+5214981442266&text=Su+servicio+fue+suspendido+porfavor+contacta+con+el+administrador+para+reactivarlo&apikey=3442075";
//            String editCommand = "/system/scheduler/add name=" + nameCliente +
//                    " start-time=00:00:00 interval=30d" +
//                    " on-event=\"/ip firewall address-list add list=corte address=" + address +
//                    "; :delay 2s; /tool/fetch url="+url+" keep-result-no";
//
//            System.out.println("Ejecutando: " + editCommand);
//            cn.execute(editCommand);
//
//            System.out.println("Tarea creada y modificada exitosamente.");
//        } catch (Exception e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Error al configurar la tarea del cliente: " + e);
//        }
//    }

//public void createTask(String nameCliente, String address, String user, String password, String host) {
//    try {
//        ApiConnection cn = ApiConnection.connect(host);
//        cn.login(user, password);
//        
//        // URL sin comillas externas
//        String url = "https://api.callmebot.com/whatsapp.php?phone=+5214981442266&text=Su+servicio+fue+suspendido+porfavor+contacta+con+el+administrador+para+reactivarlo&apikey=3442075";
//        
//        // Comando con la URL entre comillas dobles
//        String editCommand = "/system/scheduler/add name=" + nameCliente +
//                " start-time=00:00:00 interval=30d" +
//                " on-event=\"/ip firewall address-list add list=corte address=" + address +
//                "; :delay 2s; /tool/fetch url=\\\"" + url + "\\\" keep-result=no\"";
//        
//        System.out.println("Ejecutando: " + editCommand);
//        cn.execute(editCommand);
//
//        System.out.println("Tarea creada y modificada exitosamente.");
//    } catch (Exception e) {
//        System.out.println(e);
//        JOptionPane.showMessageDialog(null, "Error al configurar la tarea del cliente: " + e);
//    }
//}


    public void eliminarTaskPorIP(String address, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            String nameCliente = null;

            // 🔍 Intentar encontrar el cliente en "/ppp/active"
            List<Map<String, String>> response = cn.execute("/ppp/active/print where address=" + address);
            if (!response.isEmpty()) {
                nameCliente = response.get(0).get("name");
                System.out.println("📌 Cliente encontrado en PPP Active: " + nameCliente);
            }

            // 🔍 Si no se encontró en "/ppp/active", buscar en "/queue/simple"
            if (nameCliente == null) {
                String ip = address + "/32"; // Formato requerido por MikroTik
                List<Map<String, String>> queueResponse = cn.execute("/queue/simple/print where target=" + ip);
                if (!queueResponse.isEmpty()) {
                    nameCliente = queueResponse.get(0).get("name");
                    System.out.println("📌 Cliente encontrado en Queue Simple: " + nameCliente);
                }
            }

            // ❌ Si no se encontró en ninguna tabla, mostrar error
            if (nameCliente == null) {
                JOptionPane.showMessageDialog(null, "❌ No se encontró un cliente con la IP: " + address);
                cn.close();
                return;
            }

            // Llamar al método para eliminar la tarea
            eliminarTask(nameCliente, address, user, password, host);

            cn.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
            JOptionPane.showMessageDialog(null, "Error al buscar el cliente por IP: " + e);
        }
    }

    public void eliminarTask(String nameCliente, String address, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            // Eliminar la tarea programada
            String comando = "/system/scheduler/remove numbers=" + nameCliente;
            System.out.println(comando);
            cn.execute(comando);

            System.out.println("✅ Eliminada la tarea: " + nameCliente);
            JOptionPane.showMessageDialog(null, "Se eliminó la tarea programada correctamente.");

            cn.close();

            // Volver a crear la tarea (si es necesario)
            createTask(nameCliente, address, user, password, host);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
            createTask(nameCliente, address, user, password, host);
            JOptionPane.showMessageDialog(null, "Tenemos un problema al eliminar la tarea programada: " + e);
            JOptionPane.showMessageDialog(null, "Corte automatico re-creado", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

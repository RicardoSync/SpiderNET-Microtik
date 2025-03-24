/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDeveloper;

import javax.swing.JOptionPane;
import me.legrange.mikrotik.ApiConnection;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
/**
 *
 * @author ricardo
 */
public class pruebasFechas {
    public void agregarYEjecutarBloqueo(String ipCliente, String intervalo, String user, String password, String routerIp) {
        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Crear el script con valores dinámicos
            String script = "/system script add name=BloqueoCliente source=\""
                    + ":local ipcliente \\\"" + ipCliente + "\\\";\n"
                    + ":local bloqueoInicio \\\"00:00:00\\\";\n"
                    + " \n"
                    + ":if ([file find name=BloqueoHora.txt] != \\\"\\\"]) do={\n"
                    + "  :set bloqueoInicio [/file get [find name=BloqueoHora.txt] contents];\n"
                    + "} else={\n"
                    + "  :set bloqueoInicio [/system clock get time];\n"
                    + "  /file print file=BloqueoHora.txt where contents=$bloqueoInicio;\n"
                    + "}\n"
                    + " \n"
                    + ":local horaActual [/system clock get time];\n"
                    + ":local diferencia ([ :totime $horaActual ] - [ :totime $bloqueoInicio ]);\n"
                    + " \n"
                    + ":if ($diferencia < " + intervalo + ") do={\n"
                    + "  :delay 1;\n"
                    + "  /system script run BloqueoCliente;\n"
                    + "} else={\n"
                    + "  /ip firewall address-list add list=corte address=$ipcliente timeout=00:00:" + intervalo + ";\n"
                    + "  /file remove BloqueoHora.txt;\n"
                    + "}\"";
            System.out.println(script);
            // Enviar el script a MikroTik
            con.execute(script);

            // Ejecutar el script
            con.execute("/system script run BloqueoCliente");

            JOptionPane.showMessageDialog(null, "Script de bloqueo agregado y ejecutado para IP: " + ipCliente);

            // Cerrar conexión
            con.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar el script: " + e);
            JOptionPane.showMessageDialog(null, "Error al ejecutar el script: " + e);
        }
    }
}
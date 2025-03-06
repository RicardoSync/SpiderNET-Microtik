import me.legrange.mikrotik.ApiConnection;

public class MikroTikQueueRemove {
    public static void main(String[] args) {
        String routerIp = "192.168.1.70"; // Cambia a la IP de tu MikroTik
        String user = "admin";
        String password = "zerocuatro04";
        String queueName = "prueba"; // Nombre de la cola a eliminar

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Ejecutar el comando para eliminar la cola
            con.execute("/queue/simple/remove numbers=" + queueName);
            System.out.println("Cola '" + queueName + "' eliminada correctamente.");

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

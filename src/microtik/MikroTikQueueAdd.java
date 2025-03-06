import me.legrange.mikrotik.ApiConnection;

public class MikroTikQueueAdd {
    public static void main(String[] args) {
        String routerIp = "192.168.1.70"; // Cambia a la IP de tu MikroTik
        String user = "admin";
        String password = "zerocuatro04";
        String queueName = "prueba2"; // Nombre de la cola
        String maxLimit = "100M/20M"; // Límite de velocidad
        String targetIp = "192.168.10.54"; // IP objetivo

        try {
            // Conectar al MikroTik
            ApiConnection con = ApiConnection.connect(routerIp);
            con.login(user, password);

            // Agregar la cola simple
            con.execute("/queue/simple/add name=" + queueName +
                        " max-limit=" + maxLimit +
                        " target=" + targetIp);

            System.out.println("Cola agregada correctamente.");

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

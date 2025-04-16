package SSH;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.InputStream;

public class SSHHelper {

    public static void eliminarSchedulerPorSSH(String host, String user, String password, String nameScheduler) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("exec");
            String comando = "/system/scheduler/remove [find name=\"" + nameScheduler + "\"]";
            ((ChannelExec) channel).setCommand(comando);
            channel.setInputStream(null);

            InputStream in = channel.getInputStream();
            channel.connect();

            // Leer respuesta por si deseas imprimirla
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    break;
                }
                Thread.sleep(100);
            }

            channel.disconnect();
            session.disconnect();
            System.out.println("Scheduler eliminado por SSH: " + nameScheduler);

        } catch (Exception e) {
            System.out.println("Error al eliminar scheduler por SSH: " + e.getMessage());
        }
    }
}

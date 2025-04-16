package sincronizacion;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class SyncDatabase {

    public static void sincronizarAhora() {
        int opcion = JOptionPane.showConfirmDialog(null,
                "🔄 ¿Deseas sincronizar tus datos con AdmiNET Cloud ahora?",
                "Sincronización Manual",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            try {
                System.out.println("🌀 Iniciando sincronización a las " + java.time.LocalTime.now());
                JOptionPane.showMessageDialog(null, "⏳ Sincronizando base de datos con AdmiNET Cloud...");

                String mysqldumpPath = "C:\\mysql\\bin\\mysqldump.exe";

                String dbUser = "root";
                String dbPass = "zerocuatro04";
                String dbName = "spidernet_web";

                String vpsUser = "root";
                String vpsIP = "200.234.227.222";
                String vpsDbUser = "cisco";
                String vpsDbPass = "MinuzaFea265/";
                int vpsDbPort = 3389;
                String vpsDbName = "spidernet_web";

                File dumpFile = new File("backup.sql");
                ProcessBuilder dumpBuilder = new ProcessBuilder(
                        mysqldumpPath, "-u" + dbUser, "-p" + dbPass, dbName);
                dumpBuilder.redirectOutput(dumpFile);
                Process dumpProcess = dumpBuilder.start();
                int dumpExit = dumpProcess.waitFor();
                if (dumpExit != 0) throw new RuntimeException("❌ Error al crear el backup local.");

                ProcessBuilder scpBuilder = new ProcessBuilder(
                        "scp", "backup.sql", vpsUser + "@" + vpsIP + ":/tmp/backup.sql");
                Process scpProcess = scpBuilder.start();
                int scpExit = scpProcess.waitFor();
                if (scpExit != 0) throw new RuntimeException("❌ Error al enviar el archivo al VPS.");

                String restoreCommand = String.format(
                        "mysql -u%s -p%s -P%d %s < /tmp/backup.sql",
                        vpsDbUser, vpsDbPass, vpsDbPort, vpsDbName);

                ProcessBuilder sshBuilder = new ProcessBuilder(
                        "ssh", vpsUser + "@" + vpsIP, restoreCommand);
                Process sshProcess = sshBuilder.start();
                int sshExit = sshProcess.waitFor();
                if (sshExit != 0) throw new RuntimeException("❌ Error al restaurar en el VPS.");

                JOptionPane.showMessageDialog(null, "✅ Sincronización completada con éxito.");
                System.out.println("✅ Sincronización exitosa a las " + java.time.LocalTime.now());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "❌ Error en la sincronización: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("⏹ Usuario canceló la sincronización.");
        }
    }
}

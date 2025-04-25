package antenas;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class NavegadorUtil {

    public static void abrirIPEnNavegador(String ipCliente) {
        if (Desktop.isDesktopSupported()) {
            try {
                URI url = new URI("http://" + ipCliente);
                Desktop.getDesktop().browse(url);
                System.out.println("🌐 Abriendo: " + url);
            } catch (IOException | URISyntaxException e) {
                System.err.println("❌ Error al abrir la IP en el navegador: " + e.getMessage());
            }
        } else {
            System.err.println("⚠️ Desktop no soportado en este sistema.");
        }
    }
}

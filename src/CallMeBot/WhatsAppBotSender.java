/*
Codigo creado por Richard Gerardo Garcia Escobedo*/
package CallMeBot;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import javax.swing.JOptionPane;

public class WhatsAppBotSender {

    public static void enviarMensajeWhatsApp(String numeroCliente, String apiKey, String nombreCliente, String numeroEmpresa, String direccion, String nombreEmpresa) {
        try {
            // Construir mensaje personalizado
            String mensaje = "👋 ¡Hola " + nombreCliente + "!\n\n"
                                + "🚫 Tu servicio ha sido *suspendido manualmente* por el administrador de *" + nombreEmpresa + "*.\n\n"
                                + "📍 Dirección registrada: " + direccion + "\n\n"
                                + "⚠️ Este es un mensaje automático enviado por nuestro 🤖 bot.\n"
                                + "❗ *Por favor no respondas a este mensaje.*\n\n"
                                + "📞 Si tienes dudas o quieres reactivar tu servicio, contáctanos al *" + numeroEmpresa + "*.\n\n"
                                + "Gracias por tu comprensión 🙏";

            // Codificar el mensaje
            String mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8");

            // Construir la URL
            String urlString = "https://api.callmebot.com/whatsapp.php?phone=" + numeroCliente +
                    "&text=" + mensajeCodificado +
                    "&apikey=" + apiKey;

            // Hacer la conexión
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Obtener el código de respuesta
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ Mensaje enviado correctamente a " + nombreCliente);
                JOptionPane.showMessageDialog(null, "✅ Mensaje enviado correctamente a " + nombreCliente);
            } else {
                System.out.println("⚠️ Error al enviar mensaje. Código HTTP: " + responseCode);
                JOptionPane.showMessageDialog(null, "⚠️ Error al enviar mensaje. Código HTTP: " + responseCode);

            }

        } catch (UnsupportedEncodingException e) {
            System.out.println("❌ Error al codificar el mensaje: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al codificar el mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error al conectar con CallMeBot: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al conectar con CallMeBot: " + e.getMessage());
        }
    }

    public static void enviarMensajePago(String numeroCliente, String apiKey, String nombreCliente,
            String nombrePaquete, double precio, String fechaPago, int diaCorte,
            String numeroEmpresa, String direccion, String nombreEmpresa) {
        try {
            String mensaje = "🎉 ¡Hola " + nombreCliente + "!\n\n"
                    + "✅ Hemos registrado tu pago correctamente el día *" + fechaPago + "*.\n\n"
                    + "📦 Paquete: *" + nombrePaquete + "*\n"
                    + "💰 Monto: $" + String.format("%.2f", precio) + " MXN\n"
                    + "📆 Día de corte: *" + diaCorte + "* de cada mes\n\n"
                    + "📍 Dirección registrada: " + direccion + "\n\n"
                    + "💡 Tu servicio fue activado y está listo para usarse.\n"
                    + "🤖 Este es un mensaje automático del sistema *" + nombreEmpresa + "*.\n"
                    + "📞 Contacto: " + numeroEmpresa;

            String mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8");

            String urlString = "https://api.callmebot.com/whatsapp.php?phone=" + numeroCliente
                    + "&text=" + mensajeCodificado
                    + "&apikey=" + apiKey;

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ Mensaje de pago enviado a " + nombreCliente);
                JOptionPane.showMessageDialog(null, "Mensaje enviado a " + nombreCliente);
            } else {
                System.out.println("⚠️ Error al enviar mensaje. Código: " + responseCode);
                JOptionPane.showMessageDialog(null, "⚠️ Error al enviar mensaje. Código: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("❌ Error al enviar mensaje de pago: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al enviar mensaje de pago: " + e.getMessage());
        }
    }

    
    public static void testWhatsapp(String numeroCliente, String apiKey, String nombreCliente, String numeroEmpresa, String direccion, String nombreEmpresa) {
        try {
            // Construir mensaje personalizado
// Construir mensaje de prueba
                String mensaje = "👋 ¡Hola " + nombreCliente + "!\n\n"
                    + "🧪 Este es un *mensaje de prueba* enviado por el sistema de *" + nombreEmpresa + "*.\n\n"
                    + "✅ El objetivo es verificar que tu número de WhatsApp y la API Key están registrados correctamente en nuestra base de datos.\n\n"
                    + "📍 Dirección registrada: " + direccion + "\n"
                    + "📞 Teléfono de contacto: " + numeroEmpresa + "\n\n"
                    + "⚠️ Este mensaje fue enviado automáticamente por nuestro 🤖 bot.\n"
                    + "❗ *Por favor, no respondas a este mensaje.*\n\n"
                    + "Gracias por formar parte de " + nombreEmpresa + " 🙌";

            // Codificar el mensaje
            String mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8");

            // Construir la URL
            String urlString = "https://api.callmebot.com/whatsapp.php?phone=" + numeroCliente
                    + "&text=" + mensajeCodificado
                    + "&apikey=" + apiKey;

            // Hacer la conexión
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Obtener el código de respuesta
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ Mensaje enviado correctamente a " + nombreCliente);
                JOptionPane.showMessageDialog(null, "✅ Mensaje enviado correctamente a " + nombreCliente);
            } else {
                System.out.println("⚠️ Error al enviar mensaje. Código HTTP: " + responseCode);
                JOptionPane.showMessageDialog(null, "⚠️ Error al enviar mensaje. Código HTTP: " + responseCode);

            }

        } catch (UnsupportedEncodingException e) {
            System.out.println("❌ Error al codificar el mensaje: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al codificar el mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error al conectar con CallMeBot: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al conectar con CallMeBot: " + e.getMessage());
        }
    }

}

package Recibos;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ricardo
 */
public class generadorRecibos {
    public static void generarRecibo(String idCliente, String nombreCliente, String paquete, double monto, String metodoPago, double cantidad, double cambio, String nombreAdmin, String numeroRecibo) throws IOException {
        int width = 400, height = 600;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        // Fondo blanco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Estilo de texto
        Font font = new Font("Arial", Font.PLAIN, 18);
        Font boldFont = new Font("Arial", Font.BOLD, 20);
        Font smallFont = new Font("Arial", Font.PLAIN, 14);

        g.setFont(boldFont);
        g.setColor(Color.BLACK);
        g.drawString("SPIDERNET", 100, 30);
        g.setFont(font);
        g.drawString("Recibo de Pago", 120, 60);

        // Línea separadora
        g.drawLine(20, 80, width - 20, 80);

        // Información
        g.setFont(smallFont);
        g.drawString("Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 20, 100);
        g.drawString("Cliente: " + nombreCliente, 20, 130);
        g.drawString("Paquete: " + paquete, 20, 160);
        g.drawString("Numero recibo: " + numeroRecibo, 20, 175);
        g.drawLine(20, 190, width - 20, 190);

        g.setFont(font);
        g.drawString(String.format("Monto: $%.2f", monto), 20, 210);
        g.drawString("Método de Pago: " + metodoPago, 20, 240);
        g.drawString(String.format("Cantidad Entregada: $%.2f", cantidad), 20, 270);
        g.drawString(String.format("Cambio: $%.2f", cambio), 20, 300);
        g.drawString("Le atendió el usuario: " + nombreAdmin, 20, 330);
        g.drawLine(20, 340, width - 20, 340);

        g.setFont(smallFont);
        g.drawString("¡Gracias por su pago!", 100, 360);

        // Guardar la imagen
        File outputFile = new File(System.getProperty("user.home") + "/Desktop/Recibos SpiderNet/recibo_cliente_" + idCliente + ".png");
        outputFile.getParentFile().mkdirs(); // Crea la carpeta si no existe
        ImageIO.write(image, "PNG", outputFile);

        System.out.println("Recibo guardado como: " + outputFile.getPath());
        g.dispose();
    }

    public static void main(String[] args) throws IOException {
        generarRecibo("123", "Juan Pérez", "Paquete A", 150.50, "Efectivo", 200.00, 49.50, "Carlos López", "0001");
    }    
}

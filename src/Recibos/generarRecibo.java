package Recibos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Locale;
import javax.swing.JOptionPane;

public class generarRecibo {

    public void generarRecibo(String nombreWisp, String cp, String telefono, String rfc, String direccion, String concepto,
            String mesAnio, String nombre, String id, String plan, double mensualidad, String fecha,
            String hora, double paquete, double streaming, double tv, double efectivo, String cajero,
            int descuento, int mesesPagados) {

        // Detectar el sistema operativo y el idioma
        String userLanguage = Locale.getDefault().getLanguage();
        String userHome = System.getProperty("user.home");
        String documentosFolder = (userLanguage.equals("es")) ? "Documentos" : "Documents";
        String recibosFolderPath = Paths.get(userHome, documentosFolder, "SpiderNet Recibos").toString();

        // Crear la carpeta si no existe
        File recibosFolder = new File(recibosFolderPath);
        if (!recibosFolder.exists()) {
            recibosFolder.mkdirs();
        }

        // Nombre del archivo PDF
        String reciboFileName = "Recibo_" + nombreWisp.replace(" ", "_") + "_" + nombre.replace(" ", "_") + ".pdf";
        String reciboFilePath = Paths.get(recibosFolderPath, reciboFileName).toString();

        // Tamaño del ticket
        Rectangle ticketSize = new Rectangle(220, 750);
        Document document = new Document(ticketSize);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reciboFilePath));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(ticketSize.getWidth(), ticketSize.getHeight());

            // Estilo
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));

            // Datos de la empresa
            g.drawString(nombreWisp, 50, 30);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Dirección: " + direccion, 10, 45);
            g.drawString("C.P: " + cp, 10, 60);
            g.drawString("Tel: " + telefono, 10, 75);
            g.drawString("RFC: " + rfc, 10, 90);
            g.drawLine(10, 100, 210, 100);

            // Encabezado del recibo
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("RECIBO DE PAGO", 60, 115);
            g.drawLine(10, 125, 210, 125);

            // Datos del cliente
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Cliente: " + nombre, 10, 140);
            g.drawString("Plan: " + plan + " ($" + String.format("%.2f", mensualidad) + ")", 10, 155);
            g.drawString("Periodo: " + mesAnio, 10, 170);
            g.drawLine(10, 180, 210, 180);

            // Cálculo correcto según meses pagados
            double totalMensualidad = mensualidad * mesesPagados;
            double totalServicios = (streaming + tv) * mesesPagados;
            double totalAntesDescuento = totalMensualidad + totalServicios;

            // Aplicar descuento si existe
            double descuentoAplicado = (descuento > 0 && descuento <= 100) ? totalAntesDescuento * (descuento / 100.0) : 0;
            double totalAPagar = totalAntesDescuento - descuentoAplicado;

            // Calcular cambio
            double cambio = efectivo - totalAPagar;

            // Mostrar detalles en el recibo
            g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString("Mensualidad x " + mesesPagados + " meses: $" + String.format("%.2f", totalMensualidad), 10, 260);
            g.drawString("Servicios x " + mesesPagados + " meses: $" + String.format("%.2f", totalServicios), 10, 275);
            g.drawString("Descuento (" + descuento + "%): -$" + String.format("%.2f", descuentoAplicado), 10, 290);
            g.drawString("TOTAL A PAGAR: $ " + String.format("%.2f", totalAPagar), 10, 305);
            g.drawLine(10, 315, 210, 315);

            // Pago y cambio
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Efectivo: $ " + String.format("%.2f", efectivo), 10, 330);
            g.drawString("Cambio: $ " + String.format("%.2f", cambio), 10, 345);
            g.drawLine(10, 355, 210, 355);

            // Firma y fecha
            g.setFont(new Font("Arial", Font.BOLD, 9));
            g.drawString("Cajero: " + cajero, 10, 390);
            g.drawString("Fecha: " + fecha + "  Hora: " + hora, 10, 405);
            g.drawString("© Software Escobedo", 60, 420);

            g.dispose();
            document.close();

            JOptionPane.showMessageDialog(null, "Recibo generado: " + reciboFilePath);
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

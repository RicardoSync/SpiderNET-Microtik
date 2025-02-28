package Recibos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class generarRecibo {

    public void generarRecibo(String nombreWisp, String cp, String telefono, String rfc, String direccion, String concepto,
                              String mesAnio, String nombre, String id, String plan, double mensualidad, String fecha, 
                              String hora, double paquete, double streaming, double tv, double efectivo, String cajero) {
        
        // Definir tamaño del ticket (ancho: 220, alto: 700 para más espacio)
        Rectangle ticketSize = new Rectangle(220, 700);
        Document document = new Document(ticketSize);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Recibo_Ticket.pdf"));
            document.open();

            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(ticketSize.getWidth(), ticketSize.getHeight());

            // Estilo
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            
            // Datos de la empresa
            g.drawString(nombreWisp, 60, 30);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Dirección: " + direccion, 10, 45);
            g.drawString("C.P: " + cp, 10, 60);
            g.drawString("Tel: " + telefono, 10, 75);
            g.drawString("RFC: " + rfc, 10, 90);
            g.drawLine(10, 100, 210, 100); // Línea separadora

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

            // Conceptos de cobro
            g.drawString("Concepto: " + concepto, 10, 195);
            g.drawString("Internet: $ " + String.format("%.2f", paquete), 10, 210);
            g.drawString("Streaming: $ " + String.format("%.2f", streaming), 10, 225);
            g.drawString("TV: $ " + String.format("%.2f", tv), 10, 240);
            
            double total = paquete + streaming + tv;
            g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString("TOTAL: $ " + String.format("%.2f", total), 10, 260);
            g.drawLine(10, 290, 210, 290);

            // Pago y cambio
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Efectivo: $ " + String.format("%.2f", efectivo), 10, 305);
            g.drawString("Cambio: $ " + String.format("%.2f", (efectivo - total)), 10, 320);
            g.drawLine(10, 330, 210, 330);

            // Firma o copyright
            g.setFont(new Font("Arial", Font.BOLD, 9));
            g.drawString("Cajero: " + cajero, 10, 345);
            g.drawString("Fecha: " + fecha + "  Hora: " + hora, 10, 360);
            g.drawString("© Software Escobedo", 60, 385);

        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        document.close();
        JOptionPane.showMessageDialog(null, "Recibo generado: 'Recibo_Ticket.pdf'");
    }
}

package Recibos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;
import javax.swing.JOptionPane;

public class generarFactura {

    public void generarFactura(String nombreWisp, String cp, String telefono, String rfc, String direccion,
                                String cliente, String numFactura, String fecha, String hora, String concepto,
                                double mensualidad, int mesesPagados, int descuento,
                                double streaming, double tv, double paquete, double impuestos) throws IOException {

        // Configuración de la carpeta destino en el escritorio del usuario
        String userLanguage = Locale.getDefault().getLanguage();
        String userHome = System.getProperty("user.home");
        // Para documentos: "Documentos" en español o "Documents" en otros idiomas
        String documentosFolder = (userLanguage.equals("es")) ? "Documentos" : "Documents";
        String facturasFolderPath = Paths.get(userHome, documentosFolder, "SpiderNet Recibos").toString();
        File facturasFolder = new File(facturasFolderPath);
        if (!facturasFolder.exists()) {
            facturasFolder.mkdirs();
        }

        // Nombre del archivo PDF
        String facturaFileName = "Factura_" + numFactura + "_" + cliente.replace(" ", "_") + ".pdf";
        String facturaFilePath = Paths.get(facturasFolderPath, facturaFileName).toString();

        // Tamaño de la factura (puedes ajustarlo)
        Rectangle pageSize = new Rectangle(595, 842); // Tamaño carta
        Document document = new Document(pageSize);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(facturaFilePath));
            document.open();

            // Agregar borde a la página
            PdfContentByte cb = writer.getDirectContent();
            Rectangle rect = new Rectangle(document.getPageSize());
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            rect.setBorderColor(new Color(0, 0, 0));
            cb.rectangle(rect);

            // --- Encabezado de la empresa ---
            Paragraph encabezadoEmpresa = new Paragraph(nombreWisp, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            encabezadoEmpresa.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezadoEmpresa);

            Paragraph datosEmpresa = new Paragraph(
                    "Dirección: " + direccion + "\n" +
                    "C.P: " + cp + "   Tel: " + telefono + "\n" +
                    "RFC: " + rfc,
                    FontFactory.getFont(FontFactory.HELVETICA, 10)
            );
            datosEmpresa.setAlignment(Element.ALIGN_CENTER);
            document.add(datosEmpresa);

            document.add(new Paragraph("-----------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 10)));

            // --- Datos de la factura y cliente ---
            Paragraph datosFactura = new Paragraph(
                    "Factura N°: " + numFactura + "\n" +
                    "Fecha: " + fecha + "  Hora: " + hora + "\n" +
                    "Cliente: " + cliente,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)
            );
            datosFactura.setAlignment(Element.ALIGN_LEFT);
            document.add(datosFactura);

            document.add(new Paragraph("-----------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 10)));

            // --- Detalle de la factura ---
            // Cálculos:
            double totalMensualidad = mensualidad * mesesPagados;
            double totalServicios = (streaming + tv) * mesesPagados;
            double subtotal = totalMensualidad + totalServicios + paquete;
            double descuentoAplicado = (descuento > 0 && descuento <= 100) ? subtotal * (descuento / 100.0) : 0;
            double totalConDescuento = subtotal - descuentoAplicado;
            double totalAPagar = totalConDescuento + impuestos; // sumamos impuestos si aplica

            // Crear tabla de detalle (3 columnas)
            PdfPTable detalleTable = new PdfPTable(3);
            detalleTable.setLockedWidth(true);
            detalleTable.setTotalWidth(500);
            detalleTable.setWidths(new float[]{250f, 150f, 100f});
            detalleTable.setSpacingBefore(10f);
            detalleTable.getDefaultCell().setBorder(0);
            detalleTable.getDefaultCell().setPadding(5);

            // Encabezados de la tabla
            PdfPCell cellConcepto = new PdfPCell(new Phrase("Concepto", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cellConcepto.setBorder(0);
            detalleTable.addCell(cellConcepto);

            PdfPCell cellDetalle = new PdfPCell(new Phrase("Detalle", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cellDetalle.setBorder(0);
            detalleTable.addCell(cellDetalle);

            PdfPCell cellMonto = new PdfPCell(new Phrase("Monto", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cellMonto.setBorder(0);
            cellMonto.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cellMonto);

            // Fila: Mensualidad
            detalleTable.addCell(new PdfPCell(new Phrase("Mensualidad", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase("x " + mesesPagados + " mes(es)", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            PdfPCell cellMontoMensualidad = new PdfPCell(new Phrase("$" + String.format("%.2f", totalMensualidad), FontFactory.getFont(FontFactory.HELVETICA, 9)));
            cellMontoMensualidad.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellMontoMensualidad.setBorder(0);
            detalleTable.addCell(cellMontoMensualidad);

            // Fila: Servicios Adicionales (por ejemplo, Streaming + TV)
            detalleTable.addCell(new PdfPCell(new Phrase("Servicios", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase("Streaming + TV", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            PdfPCell cellMontoServicios = new PdfPCell(new Phrase("$" + String.format("%.2f", totalServicios), FontFactory.getFont(FontFactory.HELVETICA, 9)));
            cellMontoServicios.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellMontoServicios.setBorder(0);
            detalleTable.addCell(cellMontoServicios);

            // Fila: Paquete (si aplica)
            if (paquete > 0) {
                detalleTable.addCell(new PdfPCell(new Phrase("Paquete", FontFactory.getFont(FontFactory.HELVETICA, 9))));
                detalleTable.addCell(new PdfPCell(new Phrase("Detalle del paquete", FontFactory.getFont(FontFactory.HELVETICA, 9))));
                PdfPCell cellMontoPaquete = new PdfPCell(new Phrase("$" + String.format("%.2f", paquete), FontFactory.getFont(FontFactory.HELVETICA, 9)));
                cellMontoPaquete.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellMontoPaquete.setBorder(0);
                detalleTable.addCell(cellMontoPaquete);
            }

            // Fila: Descuento
            detalleTable.addCell(new PdfPCell(new Phrase("Descuento (" + descuento + "%)", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            PdfPCell cellMontoDescuento = new PdfPCell(new Phrase("-$" + String.format("%.2f", descuentoAplicado), FontFactory.getFont(FontFactory.HELVETICA, 9)));
            cellMontoDescuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellMontoDescuento.setBorder(0);
            detalleTable.addCell(cellMontoDescuento);

            // Fila: Impuestos
            detalleTable.addCell(new PdfPCell(new Phrase("Impuestos", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            PdfPCell cellImpuestos = new PdfPCell(new Phrase("$" + String.format("%.2f", impuestos), FontFactory.getFont(FontFactory.HELVETICA, 9)));
            cellImpuestos.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellImpuestos.setBorder(0);
            detalleTable.addCell(cellImpuestos);

            // Fila: Total a pagar
            PdfPCell cellTotalLabel = new PdfPCell(new Phrase("TOTAL A PAGAR", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cellTotalLabel.setBorder(0);
            detalleTable.addCell(cellTotalLabel);
            detalleTable.addCell(new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10))));
            PdfPCell cellTotalMonto = new PdfPCell(new Phrase("$" + String.format("%.2f", totalAPagar), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cellTotalMonto.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellTotalMonto.setBorder(0);
            detalleTable.addCell(cellTotalMonto);

            // Fila: Concepto adicional (descripción o notas)
            detalleTable.addCell(new PdfPCell(new Phrase("Concepto", FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase(concepto, FontFactory.getFont(FontFactory.HELVETICA, 9))));
            detalleTable.addCell(new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 9))));

            // Agregar la tabla al documento
            document.add(detalleTable);

            // --- Pie de factura: Notas y datos adicionales ---
            Paragraph notas = new Paragraph(
                    "Forma de pago: Transferencia/Depósito\n" +
                    "Términos: Esta factura se paga en un plazo de 15 días.\n" +
                    "Gracias por su preferencia.",
                    FontFactory.getFont(FontFactory.HELVETICA, 9)
            );
            notas.setAlignment(Element.ALIGN_LEFT);
            document.add(notas);

            document.close();
            writer.close();

            // Abrir el PDF automáticamente
            try {
                Desktop.getDesktop().open(new File(facturaFilePath));
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "No se pudo abrir el archivo PDF automáticamente. Ubicación: " + facturaFilePath,
                        "Error al abrir PDF",
                        JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Factura generada: " + facturaFilePath);
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

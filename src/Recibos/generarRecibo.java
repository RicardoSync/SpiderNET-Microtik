package Recibos;

import VO.ArchivosVO;
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
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import mivisorpdf.MiVisorPDF;
import morty.Vustas.Dashboard;

public class generarRecibo {
    public void generarRecibo(String nombreWisp, String cp, String telefono, String rfc, String direccion, String concepto,
            String mesAnio, String nombre, String id, String plan, double mensualidad, String fecha,
            String hora, double paquete, double streaming, double tv, double efectivo, String cajero,
            int descuento, int mesesPagados) throws IOException {

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

        // Tamaño del ticket (se mantiene el tamaño original)
        Rectangle ticketSize = new Rectangle(220, 750);
        Document document = new Document(ticketSize);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reciboFilePath));
            document.open();

            // Agregar borde a la página
            PdfContentByte cb = writer.getDirectContent();
            Rectangle rect = new Rectangle(document.getPageSize());
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            rect.setBorderColor(new Color(0, 0, 0)); // Borde negro
            cb.rectangle(rect);

            // --- Encabezado de la empresa ---
            Paragraph encabezado = new Paragraph(nombreWisp, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);

            Paragraph datosEmpresa = new Paragraph(
                    "Dirección: " + direccion + "\n"
                    + "C.P: " + cp + "   Tel: " + telefono + "\n"
                    + "RFC: " + rfc,
                    FontFactory.getFont(FontFactory.HELVETICA, 8)
            );
            datosEmpresa.setAlignment(Element.ALIGN_CENTER);
            document.add(datosEmpresa);

            document.add(new Paragraph("-----------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 8)));

            // --- Título del recibo ---
            Paragraph tituloRecibo = new Paragraph("RECIBO DE PAGO", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            tituloRecibo.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloRecibo);

            document.add(new Paragraph("-----------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 8)));

            // --- Datos del cliente ---
            Paragraph datosCliente = new Paragraph(
                    "Cliente: " + nombre + "\n"
                    + "Plan: " + plan + " ($" + String.format("%.2f", mensualidad) + ")\n"
                    + "Periodo: " + mesAnio,
                    FontFactory.getFont(FontFactory.HELVETICA, 8)
            );
            datosCliente.setAlignment(Element.ALIGN_LEFT);
            document.add(datosCliente);

            document.add(new Paragraph("-----------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 8)));

            // --- Cálculos ---
            double totalMensualidad = mensualidad * mesesPagados;
            double totalServicios = (streaming + tv) * mesesPagados;
            double totalAntesDescuento = totalMensualidad + totalServicios;
            double descuentoAplicado = (descuento > 0 && descuento <= 100) ? totalAntesDescuento * (descuento / 100.0) : 0;
            double totalAPagar = totalAntesDescuento - descuentoAplicado;
            double cambio = efectivo - totalAPagar;

            // Creamos la tabla de 3 columnas
            PdfPTable detalleTable = new PdfPTable(3);
            detalleTable.setLockedWidth(true);
            detalleTable.setTotalWidth(200);
            detalleTable.setWidths(new float[]{80f, 60f, 60f});
            detalleTable.setSpacingBefore(5f);
            detalleTable.setSpacingAfter(5f);
            detalleTable.getDefaultCell().setBorder(0);
            detalleTable.getDefaultCell().setPadding(5);

            // -------------------------------------------------------------
            // Encabezados
            // -------------------------------------------------------------
            PdfPCell c1 = new PdfPCell(new Phrase("Concepto", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9)));
            c1.setBorder(0);
            c1.setPadding(5);
            detalleTable.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Detalle", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9)));
            c2.setBorder(0);
            c2.setPadding(5);
            detalleTable.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Monto", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9)));
            c3.setBorder(0);
            c3.setPadding(5);
            c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(c3);

            // -------------------------------------------------------------
            // Fila Mensualidad
            // -------------------------------------------------------------
            PdfPCell cConcepto = new PdfPCell(new Phrase("Mensualidad", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cConcepto.setBorder(0);
            cConcepto.setPadding(5);
            detalleTable.addCell(cConcepto);

            PdfPCell cDetalle = new PdfPCell(new Phrase("x " + mesesPagados + " meses", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalle.setBorder(0);
            cDetalle.setPadding(5);
            detalleTable.addCell(cDetalle);

            PdfPCell cMonto = new PdfPCell(new Phrase("$" + String.format("%.2f", totalMensualidad), FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cMonto.setBorder(0);
            cMonto.setPadding(5);
            cMonto.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMonto);

            // -------------------------------------------------------------
            // Fila Servicios
            // -------------------------------------------------------------
            PdfPCell cConcepto2 = new PdfPCell(new Phrase("Servicios", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cConcepto2.setBorder(0);
            cConcepto2.setPadding(5);
            detalleTable.addCell(cConcepto2);

            PdfPCell cDetalle2 = new PdfPCell(new Phrase("Streaming + TV", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalle2.setBorder(0);
            cDetalle2.setPadding(5);
            detalleTable.addCell(cDetalle2);

            PdfPCell cMonto2 = new PdfPCell(new Phrase("$" + String.format("%.2f", totalServicios), FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cMonto2.setBorder(0);
            cMonto2.setPadding(5);
            cMonto2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMonto2);

            // -------------------------------------------------------------
            // Fila Descuento
            // -------------------------------------------------------------
            PdfPCell cConcepto3 = new PdfPCell(new Phrase("Descuento (" + descuento + "%)", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cConcepto3.setBorder(0);
            cConcepto3.setPadding(5);
            detalleTable.addCell(cConcepto3);

            PdfPCell cDetalle3 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalle3.setBorder(0);
            cDetalle3.setPadding(5);
            detalleTable.addCell(cDetalle3);

            PdfPCell cMonto3 = new PdfPCell(new Phrase("-$" + String.format("%.2f", descuentoAplicado), FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cMonto3.setBorder(0);
            cMonto3.setPadding(5);
            cMonto3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMonto3);

            // -------------------------------------------------------------
            // Fila TOTAL A PAGAR
            // -------------------------------------------------------------
            PdfPCell cConcepto4 = new PdfPCell(new Phrase("TOTAL A PAGAR", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9)));
            cConcepto4.setBorder(0);
            cConcepto4.setPadding(5);
            detalleTable.addCell(cConcepto4);

            PdfPCell cDetalle4 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalle4.setBorder(0);
            cDetalle4.setPadding(5);
            detalleTable.addCell(cDetalle4);

            PdfPCell cMonto4 = new PdfPCell(new Phrase("$" + String.format("%.2f", totalAPagar), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9)));
            cMonto4.setBorder(0);
            cMonto4.setPadding(5);
            cMonto4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMonto4);

            // -------------------------------------------------------------
            // Fila Concepto (mostrar el concepto recibido)
            // -------------------------------------------------------------
            PdfPCell cConceptoConcepto = new PdfPCell(new Phrase("Concepto", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cConceptoConcepto.setBorder(0);
            cConceptoConcepto.setPadding(5);
            detalleTable.addCell(cConceptoConcepto);

            PdfPCell cDetalleConcepto = new PdfPCell(new Phrase(concepto, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalleConcepto.setBorder(0);
            cDetalleConcepto.setPadding(5);
            detalleTable.addCell(cDetalleConcepto);

            PdfPCell cMontoConcepto = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cMontoConcepto.setBorder(0);
            cMontoConcepto.setPadding(5);
            cMontoConcepto.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMontoConcepto);

            // -------------------------------------------------------------
            // Fila Cambio (monto a regresar)
            // -------------------------------------------------------------
            PdfPCell cConceptoCambio = new PdfPCell(new Phrase("Cambio", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cConceptoCambio.setBorder(0);
            cConceptoCambio.setPadding(5);
            detalleTable.addCell(cConceptoCambio);

            PdfPCell cDetalleCambio = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cDetalleCambio.setBorder(0);
            cDetalleCambio.setPadding(5);
            detalleTable.addCell(cDetalleCambio);

            PdfPCell cMontoCambio = new PdfPCell(new Phrase("$" + String.format("%.2f", cambio), FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cMontoCambio.setBorder(0);
            cMontoCambio.setPadding(5);
            cMontoCambio.setHorizontalAlignment(Element.ALIGN_RIGHT);
            detalleTable.addCell(cMontoCambio);

            // -------------------------------------------------------------
            // Agregar la tabla al documento
            // -------------------------------------------------------------
            document.add(detalleTable);

            // --- Firma y fecha ---
            Paragraph firma = new Paragraph(
                    "Cajero: " + cajero + "\n"
                    + "Fecha: " + fecha + "  Hora: " + hora,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8)
            );
            firma.setAlignment(Element.ALIGN_LEFT);
            document.add(firma);

            // --- Copyright ---
            Paragraph copyright = new Paragraph("© Software Escobedo", FontFactory.getFont(FontFactory.HELVETICA, 7));
            copyright.setAlignment(Element.ALIGN_CENTER);
            document.add(copyright);

            document.close();
            writer.close();
            generarFactura f = new generarFactura();
            // Abrir el PDF con la aplicación predeterminada del sistema
            try {
                Desktop.getDesktop().open(new File(reciboFilePath));
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "No se pudo abrir el archivo PDF automáticamente. "
                        + "Ubicación: " + reciboFilePath,
                        "Error al abrir PDF",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            JOptionPane.showMessageDialog(null, "Recibo generado: " + reciboFilePath);
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

package Recibos;

import VO.ArchivosVO;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JOptionPane;
import mivisorpdf.MiVisorPDF;
import UIPrincipal.Dashboard;

public class generarRecibo {

    public void generarRecibo(String nombreWisp, String cp, String telefono, String rfc, String direccion, String concepto,
            String mesAnio, String nombre, String id, String plan, double mensualidad, String fecha,
            String hora, double paquete, double streaming, double tv, double efectivo, String cajero,
            int descuento, int mesesPagados, String codigoVerificacion) throws IOException {

        String userLanguage = Locale.getDefault().getLanguage();
        String userHome = System.getProperty("user.home");
        String documentosFolder = (userLanguage.equals("es")) ? "Documentos" : "Documents";
        String recibosFolderPath = Paths.get(userHome, documentosFolder, "AdminNET Comprobantes").toString();

        File recibosFolder = new File(recibosFolderPath);
        if (!recibosFolder.exists()) {
            recibosFolder.mkdirs();
        }

        String reciboFileName = "Recibo_" + nombreWisp.replace(" ", "_") + "_" + nombre.replace(" ", "_") + ".pdf";
        String reciboFilePath = Paths.get(recibosFolderPath, reciboFileName).toString();

        Rectangle ticketSize = new Rectangle(140f, 600f); // 50mm de ancho
        Document document = new Document(ticketSize, 5, 5, 5, 5);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reciboFilePath));
            document.open();
            PdfContentByte cb = writer.getDirectContent();

            // Cargar ruta del logo desde archivo de propiedades
            String rutaLogo = "";
            try {
                File archivoConfig = new File("logo.properties");
                if (archivoConfig.exists()) {
                    Properties props = new Properties();
                    props.load(new java.io.FileInputStream(archivoConfig));
                    rutaLogo = props.getProperty("ruta_logo", "img/logo_default.png");
                } else {
                    rutaLogo = "img/logo_default.png"; // ruta por defecto
                }
            } catch (Exception e) {
                rutaLogo = "img/logo_default.png"; // en caso de error, usar logo por defecto
            }


            // Insertar logo si existe
            try {
                if (rutaLogo != null && !rutaLogo.isEmpty()) {
                    com.lowagie.text.Image logo = com.lowagie.text.Image.getInstance(rutaLogo);
                    logo.scaleToFit(120f, 60f); // no exceder ancho
                    logo.setAlignment(Element.ALIGN_CENTER);
                    document.add(logo);
                }
            } catch (Exception e) {
                System.err.println("[⚠️] No se pudo cargar el logo: " + e.getMessage());
            }

            Paragraph encabezado = new Paragraph(nombreWisp, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9));
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);

            Paragraph datosEmpresa = new Paragraph("Dirección:\n" + direccion + "\nC.P: " + cp + "  Tel: " + telefono + "\nRFC: " + rfc,
                    FontFactory.getFont(FontFactory.HELVETICA, 6));
            datosEmpresa.setAlignment(Element.ALIGN_CENTER);
            document.add(datosEmpresa);

            document.add(new Paragraph("-----------------------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            Paragraph tituloRecibo = new Paragraph("RECIBO DE PAGO", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8));
            tituloRecibo.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloRecibo);
            document.add(new Paragraph("-----------------------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 6)));

            Paragraph datosCliente = new Paragraph("Cliente: " + nombre + "\nPlan: " + plan + " ($" + String.format("%.2f", mensualidad) + ")\nPeriodo: " + mesAnio,
                    FontFactory.getFont(FontFactory.HELVETICA, 6));
            datosCliente.setAlignment(Element.ALIGN_LEFT);
            document.add(datosCliente);
            document.add(new Paragraph("-----------------------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA, 6)));

            double totalMensualidad = mensualidad * mesesPagados;
            double totalServicios = (streaming + tv) * mesesPagados;
            double totalAntesDescuento = totalMensualidad + totalServicios;
            double descuentoAplicado = (descuento > 0 && descuento <= 100) ? totalAntesDescuento * (descuento / 100.0) : 0;
            double totalAPagar = totalAntesDescuento - descuentoAplicado;
            double cambio = efectivo - totalAPagar;

            PdfPTable detalleTable = new PdfPTable(3);
            detalleTable.setTotalWidth(125f);
            detalleTable.setWidths(new float[]{50f, 40f, 35f});
            detalleTable.setLockedWidth(true);
            detalleTable.getDefaultCell().setBorder(0);
            detalleTable.setSpacingBefore(3);
            detalleTable.setSpacingAfter(3);

            detalleTable.addCell(getCell("Concepto", true));
            detalleTable.addCell(getCell("Detalle", true));
            detalleTable.addCell(getCell("Monto", true, Element.ALIGN_RIGHT));

            detalleTable.addCell(getCell("Mensualidad", false));
            detalleTable.addCell(getCell("x " + mesesPagados + " meses", false));
            detalleTable.addCell(getCell("$" + String.format("%.2f", totalMensualidad), false, Element.ALIGN_RIGHT));

            detalleTable.addCell(getCell("Servicios", false));
            detalleTable.addCell(getCell("Streaming + TV", false));
            detalleTable.addCell(getCell("$" + String.format("%.2f", totalServicios), false, Element.ALIGN_RIGHT));

            detalleTable.addCell(getCell("Descuento (" + descuento + "%)", false));
            detalleTable.addCell(getCell("", false));
            detalleTable.addCell(getCell("-$" + String.format("%.2f", descuentoAplicado), false, Element.ALIGN_RIGHT));

            detalleTable.addCell(getCell("TOTAL A PAGAR", true));
            detalleTable.addCell(getCell("", false));
            detalleTable.addCell(getCell("$" + String.format("%.2f", totalAPagar), true, Element.ALIGN_RIGHT));

            detalleTable.addCell(getCell("Cambio", false));
            detalleTable.addCell(getCell("", false));
            detalleTable.addCell(getCell("$" + String.format("%.2f", cambio), false, Element.ALIGN_RIGHT));
            try {
                int diaCorte = Integer.parseInt(fecha.substring(0, 2)); // Asume que fecha es tipo dd/MM/yyyy
                LocalDate hoy = LocalDate.now();
                LocalDate base = hoy.getDayOfMonth() >= diaCorte
                        ? LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1).plusMonths(1).withDayOfMonth(diaCorte)
                        : LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1).withDayOfMonth(diaCorte);

                LocalDate proximoPago = base.plusMonths(mesesPagados - 1);
                String fechaFormateada = proximoPago.format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("es", "MX")));

                com.lowagie.text.Font fuenteNegrita = new com.lowagie.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 7));
                fuenteNegrita.setColor(Color.BLACK);

                Paragraph proximoPagoTxt = new Paragraph("📅 Próximo pago: " + fechaFormateada, fuenteNegrita);
                proximoPagoTxt.setAlignment(Element.ALIGN_CENTER);
                proximoPagoTxt.setSpacingBefore(6);
                proximoPagoTxt.setSpacingAfter(6);
                document.add(proximoPagoTxt);
            } catch (Exception e) {
                System.err.println("[⚠️] No se pudo calcular fecha de próximo pago: " + e.getMessage());
            }


            document.add(detalleTable);

            Barcode128 barcode = new Barcode128();
            barcode.setCode(codigoVerificacion);
            barcode.setCodeType(Barcode128.CODE128);
            com.lowagie.text.Image img = barcode.createImageWithBarcode(cb, null, null);
            img.setAlignment(Element.ALIGN_CENTER);
            img.scalePercent(80);
            document.add(img);

            Paragraph verificacion = new Paragraph("Código de Verificación:\n" + codigoVerificacion,
                    FontFactory.getFont(FontFactory.HELVETICA, 6));
            verificacion.setAlignment(Element.ALIGN_CENTER);
            document.add(verificacion);

            Paragraph firma = new Paragraph("Cajero: " + cajero + "\nFecha: " + fecha + "  Hora: " + hora,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 6));
            firma.setAlignment(Element.ALIGN_LEFT);
            document.add(firma);

            Paragraph copyright = new Paragraph("© Software Escobedo", FontFactory.getFont(FontFactory.HELVETICA, 6));
            copyright.setAlignment(Element.ALIGN_CENTER);
            document.add(copyright);

            document.close();
            writer.close();

            try {
                Desktop.getDesktop().open(new File(reciboFilePath));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo PDF automáticamente.\nUbicación: " + reciboFilePath,
                        "Error al abrir PDF", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Recibo generado: " + reciboFilePath);
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private PdfPCell getCell(String text, boolean bold) {
        return getCell(text, bold, Element.ALIGN_LEFT);
    }

    private PdfPCell getCell(String text, boolean bold, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, FontFactory.getFont(FontFactory.HELVETICA, bold ? 7 : 6)));
        cell.setBorder(0);
        cell.setPadding(3);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }
}
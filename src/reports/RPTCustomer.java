package reports;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllerpublic.HeaderFooterReport;
import database.ConnectionDB;
import env.Env;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class RPTCustomer {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    public static LocalDate todaysDate = LocalDate.now();

    public void reportCustomer() {
        HeaderFooterReport header = new HeaderFooterReport();

        Env env = new Env();
        String queryCompany = "SELECT * FROM company ";
        Document document = new Document(PageSize.A4.rotate(), 18, 18, 18, 18);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(env.URL_SERVER_FILES + "reportes/RPT CLIENTES " + todaysDate + ".pdf");

            PdfWriter write = PdfWriter.getInstance(document, fileOutputStream);
            Rectangle rect = new Rectangle(50, 50, 100, 540);

            rect.setBorderColor(BaseColor.BLACK);

            write.setBoxSize("art", rect);
            write.setPageEvent(header);

            document.open();

            Image image = null;
            image = Image.getInstance(env.URL_SERVER_FILES + "logo/logo-pdf.png");
            image.scaleAbsolute(70f, 50f);

            Font tituloTablaBOLD = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 10, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteDescripcionTablas = FontFactory.getFont(
                    FontFactory.HELVETICA, 7, Font.NORMAL,
                    BaseColor.DARK_GRAY);

            Font fuenteDescripcionTablasBOLD = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 9, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteDescripcionTablasLIGHT = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteTitulosBOLD = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 11, Font.NORMAL,
                    BaseColor.BLACK);


            Paragraph saltoLinea2 = new Paragraph();
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));

            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            float[] medidaCeldas = {2.40f, 6.70f, 7.70f};
            encabezado.setWidths(medidaCeldas);

            PdfPCell logo = new PdfPCell(image);
            logo.setRowspan(4);
            logo.setBorderColor(BaseColor.WHITE);

            PdfPCell colVacio = new PdfPCell(new Phrase());
            colVacio.setBorder(0);

            int contadorHeader = 0;
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(queryCompany);
                while (rs.next()) {
                    contadorHeader++;
                    if (contadorHeader <= 1) {
                        PdfPCell nombreEmpresa = new PdfPCell(new Phrase(rs.getString("name_company"), fuenteTitulosBOLD));
                        nombreEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombreEmpresa.setBorder(0);
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("REPORTE DE CLIENTES", fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        tipoComprobante.setBorder(0);
                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(tipoComprobante);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("adress"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        direccionEmpresa.setBorder(0);
                        PdfPCell lugarEmitido = new PdfPCell(new Phrase("", fuenteDescripcionTablasLIGHT));
                        lugarEmitido.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        lugarEmitido.setBorder(0);
                        encabezado.addCell(direccionEmpresa);
                        encabezado.addCell(lugarEmitido);

                        PdfPCell telefonoEmpresa = new PdfPCell(new Phrase(rs.getString("cellphone"), fuenteDescripcionTablasLIGHT));
                        telefonoEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        telefonoEmpresa.setBorder(0);
                        PdfPCell fehaActual = new PdfPCell(new Phrase(String.valueOf("EMITIDO EL " + todaysDate), fuenteDescripcionTablasLIGHT));
                        fehaActual.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        fehaActual.setBorder(0);
                        encabezado.addCell(telefonoEmpresa);
                        encabezado.addCell(fehaActual);

                        PdfPCell rucEmpresa = new PdfPCell(new Phrase("RUC: " + rs.getString("ruc"), fuenteDescripcionTablasLIGHT));
                        rucEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        rucEmpresa.setBorder(0);
                        encabezado.addCell(rucEmpresa);
                        encabezado.addCell(colVacio);

                        PdfPCell lema = new PdfPCell(new Phrase(rs.getString("email"), fuenteDescripcionTablas));
                        lema.setHorizontalAlignment(Element.ALIGN_LEFT);
                        lema.setBorder(0);
                        encabezado.addCell(lema);
                        encabezado.addCell(colVacio);

                    }

                }
            } catch (SQLException e) {
            }
            document.add(encabezado);
            document.add(saltoLinea2);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            float[] medidatablaVentas = {30f, 30f, 30f, 10f};
            table.setWidths(medidatablaVentas);

            PdfPCell customer = new PdfPCell(new Phrase("Nombres y Apellidos", tituloTablaBOLD));
            customer.setHorizontalAlignment(Element.ALIGN_LEFT);
            customer.setVerticalAlignment(Element.ALIGN_MIDDLE);
            customer.setMinimumHeight(25);
            customer.setBorder(0);
            customer.setBorderWidthTop(1);
            customer.setBorderWidthLeft(1);
            customer.setBorderWidthBottom(1);
            customer.setBorderColor(BaseColor.GRAY);

            PdfPCell email = new PdfPCell(new Phrase("Email", tituloTablaBOLD));
            email.setHorizontalAlignment(Element.ALIGN_LEFT);
            email.setVerticalAlignment(Element.ALIGN_MIDDLE);
            email.setMinimumHeight(25);
            email.setBorder(0);
            email.setBorderWidthTop(1);
            email.setBorderWidthBottom(1);
            email.setBorderColor(BaseColor.GRAY);

            PdfPCell adress = new PdfPCell(new Phrase("Dirección", tituloTablaBOLD));
            adress.setHorizontalAlignment(Element.ALIGN_LEFT);
            adress.setVerticalAlignment(Element.ALIGN_MIDDLE);
            adress.setMinimumHeight(25);
            adress.setBorder(0);
            adress.setBorderWidthTop(1);
            adress.setBorderWidthBottom(1);
            adress.setBorderColor(BaseColor.GRAY);

            PdfPCell numberDocument = new PdfPCell(new Phrase("N° Documento", tituloTablaBOLD));
            numberDocument.setHorizontalAlignment(Element.ALIGN_LEFT);
            numberDocument.setVerticalAlignment(Element.ALIGN_MIDDLE);
            numberDocument.setMinimumHeight(25);
            numberDocument.setBorder(0);
            numberDocument.setBorderWidthTop(1);
            numberDocument.setBorderWidthBottom(1);
            numberDocument.setBorderWidthRight(1);
            numberDocument.setBorderColor(BaseColor.GRAY);

            table.addCell(customer);
            table.addCell(email);
            table.addCell(adress);
            table.addCell(numberDocument);

            String query = "SELECT * FROM customer WHERE id != 1";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    PdfPCell customerData = new PdfPCell(new Phrase(rs.getString("full_name"), fuenteDescripcionTablas));
                    customerData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    customerData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    customerData.setMinimumHeight(15);
                    customerData.setBorderWidthTop(0);
                    customerData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell emailData = new PdfPCell(new Phrase(rs.getString("email"), fuenteDescripcionTablas));
                    emailData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    emailData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    emailData.setMinimumHeight(15);
                    emailData.setBorderWidthTop(0);
                    emailData.setBorderWidthLeft(0);
                    emailData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell adressData = new PdfPCell(new Phrase(rs.getString("adress"), fuenteDescripcionTablas));
                    adressData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    adressData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    adressData.setMinimumHeight(15);
                    adressData.setBorderWidthTop(0);
                    adressData.setBorderWidthLeft(0);
                    adressData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell numberDocumentData = new PdfPCell(new Phrase(rs.getString("type_document") + " "+rs.getString("number_document"), fuenteDescripcionTablas));
                    numberDocumentData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    numberDocumentData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    numberDocumentData.setMinimumHeight(15);
                    numberDocumentData.setBorderWidthTop(0);
                    numberDocumentData.setBorderWidthLeft(0);
                    numberDocumentData.setBorderColor(BaseColor.LIGHT_GRAY);

                    table.addCell(customerData);
                    table.addCell(emailData);
                    table.addCell(adressData);
                    table.addCell(numberDocumentData);
                }

            } catch (SQLException e) {
            }

            document.add(table);
            document.close();
            try {
                ConnectionDB cnS = new ConnectionDB();
                cnS.closeConection();
            } catch (SQLException e) {
            }

            File file = new File(env.URL_SERVER_FILES + "reportes/RPT CLIENTES " + todaysDate + ".pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }
}

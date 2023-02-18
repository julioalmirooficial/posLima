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
import controllerpublic.CurrencyFormat;
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

public class RPTShopping {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    public static LocalDate todaysDate = LocalDate.now();

    public void reportSales(String dateStart, String dateEnd) {
        HeaderFooterReport header = new HeaderFooterReport();

        Env env = new Env();
        String queryCompany = "SELECT * FROM company ";
        Document document = new Document(PageSize.A4.rotate(), 18, 18, 18, 18);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(env.URL_SERVER_FILES + "reportes/RPT COMPRAS " + todaysDate + ".pdf");

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
                    FontFactory.HELVETICA_BOLD.toString(), 11, Font.NORMAL,
                    BaseColor.BLACK);

            Paragraph saltoLinea1 = new Paragraph();
            saltoLinea1.add(new Phrase(Chunk.NEWLINE));
            Paragraph saltoLinea2 = new Paragraph();
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));
            Paragraph saltoLinea3 = new Paragraph();
            saltoLinea3.add(new Phrase(Chunk.NEWLINE));
            saltoLinea3.add(new Phrase(Chunk.NEWLINE));
            Paragraph saltoLinea4 = new Paragraph();
            saltoLinea4.add(new Phrase(Chunk.NEWLINE));
            saltoLinea4.add(new Phrase(Chunk.NEWLINE));

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
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("REPORTE DE COMPRAS", fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        tipoComprobante.setBorder(0);
                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(tipoComprobante);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("adress"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        direccionEmpresa.setBorder(0);
                        PdfPCell lugarEmitido = new PdfPCell(new Phrase("DEL "+dateStart + " / "+dateEnd, fuenteDescripcionTablasLIGHT));
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
            document.add(saltoLinea4);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            float[] medidatablaVentas = {30f, 25f, 10f, 10f, 10f, 15f};
            table.setWidths(medidatablaVentas);

            PdfPCell customer = new PdfPCell(new Phrase("Proveedores", tituloTablaBOLD));
            customer.setHorizontalAlignment(Element.ALIGN_LEFT);
            customer.setVerticalAlignment(Element.ALIGN_MIDDLE);
            customer.setMinimumHeight(25);
            customer.setBorder(0);
            customer.setBorderWidthTop(1);
            customer.setBorderWidthLeft(1);
            customer.setBorderWidthBottom(1);
            customer.setBorderColor(BaseColor.GRAY);

            PdfPCell voucher = new PdfPCell(new Phrase("Comprobante", tituloTablaBOLD));
            voucher.setHorizontalAlignment(Element.ALIGN_LEFT);
            voucher.setVerticalAlignment(Element.ALIGN_MIDDLE);
            voucher.setMinimumHeight(25);
            voucher.setBorder(0);
            voucher.setBorderWidthTop(1);
            voucher.setBorderWidthBottom(1);
            voucher.setBorderColor(BaseColor.GRAY);

            PdfPCell igv = new PdfPCell(new Phrase("IGV", tituloTablaBOLD));
            igv.setHorizontalAlignment(Element.ALIGN_LEFT);
            igv.setVerticalAlignment(Element.ALIGN_MIDDLE);
            igv.setMinimumHeight(25);
            igv.setBorder(0);
            igv.setBorderWidthTop(1);
            igv.setBorderWidthBottom(1);
            igv.setBorderColor(BaseColor.GRAY);

            PdfPCell subTotal = new PdfPCell(new Phrase("SubTotal", tituloTablaBOLD));
            subTotal.setHorizontalAlignment(Element.ALIGN_LEFT);
            subTotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
            subTotal.setMinimumHeight(25);
            subTotal.setBorder(0);
            subTotal.setBorderWidthTop(1);
            subTotal.setBorderWidthBottom(1);
            subTotal.setBorderColor(BaseColor.GRAY);

            PdfPCell total = new PdfPCell(new Phrase("Total", tituloTablaBOLD));
            total.setHorizontalAlignment(Element.ALIGN_LEFT);
            total.setVerticalAlignment(Element.ALIGN_MIDDLE);
            total.setMinimumHeight(25);
            total.setBorder(0);
            total.setBorderWidthTop(1);
            total.setBorderWidthBottom(1);
            total.setBorderColor(BaseColor.GRAY);
            
            PdfPCell dateEmit = new PdfPCell(new Phrase("Fec. Emisión", tituloTablaBOLD));
            dateEmit.setHorizontalAlignment(Element.ALIGN_LEFT);
            dateEmit.setVerticalAlignment(Element.ALIGN_MIDDLE);
            dateEmit.setMinimumHeight(25);
            dateEmit.setBorder(0);
            dateEmit.setBorderWidthTop(1);
            dateEmit.setBorderWidthBottom(1);
            dateEmit.setBorderWidthRight(1);
            dateEmit.setBorderColor(BaseColor.GRAY);

            table.addCell(customer);
            table.addCell(voucher);
            table.addCell(igv);
            table.addCell(subTotal);
            table.addCell(total);
            table.addCell(dateEmit);

            CurrencyFormat currencys = new CurrencyFormat();
            String query = "SELECT p.full_name,CONCAT('COMPRA ',s.serie, '', s.number_voucher) AS vouchersShooping, s.total, s.subtotal, "
                + "s.igv, DATE_FORMAT(s.date_shooping, '%Y/%m/%d %r') AS dates "
                + "FROM shopping s "
                + "INNER JOIN supplier p ON "
                + "p.id = s.idsupplier "
                + "WHERE DATE_FORMAT(s.date_shooping,'%Y-%m-%d') BETWEEN '" + dateStart + "' AND '" + dateEnd + "' ";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    PdfPCell customerData = new PdfPCell(new Phrase(rs.getString("p.full_name"), fuenteDescripcionTablas));
                    customerData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    customerData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    customerData.setMinimumHeight(15);
                    customerData.setBorderWidthTop(0);
                    customerData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell voucherData = new PdfPCell(new Phrase(rs.getString("vouchersShooping"), fuenteDescripcionTablas));
                    voucherData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    voucherData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    voucherData.setMinimumHeight(15);
                    voucherData.setBorderWidthTop(0);
                    voucherData.setBorderWidthLeft(0);
                    voucherData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell igvData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("s.igv"))).substring(1), fuenteDescripcionTablas));
                    igvData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    igvData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    igvData.setMinimumHeight(15);
                    igvData.setBorderWidthTop(0);
                    igvData.setBorderWidthLeft(0);
                    igvData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell subTotalData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("s.subtotal"))).substring(1), fuenteDescripcionTablas));
                    subTotalData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    subTotalData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    subTotalData.setMinimumHeight(15);
                    subTotalData.setBorderWidthTop(0);
                    subTotalData.setBorderWidthLeft(0);
                    subTotalData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell totalData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("s.total"))).substring(1), fuenteDescripcionTablas));
                    totalData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    totalData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    totalData.setMinimumHeight(15);
                    totalData.setBorderWidthTop(0);
                    totalData.setBorderWidthLeft(0);
                    totalData.setBorderColor(BaseColor.LIGHT_GRAY);


                    PdfPCell dateEmitData = new PdfPCell(new Phrase(rs.getString("dates"), fuenteDescripcionTablas));
                    dateEmitData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    dateEmitData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    dateEmitData.setMinimumHeight(15);
                    dateEmitData.setBorderWidthTop(0);
                    dateEmitData.setBorderWidthLeft(0);
                    dateEmitData.setBorderColor(BaseColor.LIGHT_GRAY);


                    table.addCell(customerData);
                    table.addCell(voucherData);
                    table.addCell(igvData);
                    table.addCell(subTotalData);
                    table.addCell(totalData);
                    table.addCell(dateEmitData);
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

            File file = new File(env.URL_SERVER_FILES + "reportes/RPT COMPRAS " + todaysDate + ".pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }
}

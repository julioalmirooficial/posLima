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

public class RPTSearchProductForDate {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    public static LocalDate todaysDate = LocalDate.now();

    public void reportShoppingDetails(String dateStart, String dateEnd) {
        HeaderFooterReport header = new HeaderFooterReport();

        Env env = new Env();
        String queryCompany = "SELECT * FROM company ";
        Document document = new Document(PageSize.A4.rotate(), 18, 18, 18, 18);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(env.URL_SERVER_FILES + "reportes/RPT COMPRAS DETALLADO " + todaysDate + ".pdf");

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
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("REPORTE DE COMPRAS POR PRODUCTO", fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        tipoComprobante.setBorder(0);
                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(tipoComprobante);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("adress"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        direccionEmpresa.setBorder(0);
                        PdfPCell lugarEmitido = new PdfPCell(new Phrase("DEL " + dateStart + " / " + dateEnd, fuenteDescripcionTablasLIGHT));
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

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            float[] medidatablaVentas = {30f, 30f, 10f,15f,15f};
            table.setWidths(medidatablaVentas);

            PdfPCell customer = new PdfPCell(new Phrase("Proveedor", tituloTablaBOLD));
            customer.setHorizontalAlignment(Element.ALIGN_LEFT);
            customer.setVerticalAlignment(Element.ALIGN_MIDDLE);
            customer.setMinimumHeight(25);
            customer.setBorder(0);
            customer.setBorderWidthTop(1);
            customer.setBorderWidthLeft(1);
            customer.setBorderWidthBottom(1);
            customer.setBorderColor(BaseColor.GRAY);

            PdfPCell product = new PdfPCell(new Phrase("Producto", tituloTablaBOLD));
            product.setHorizontalAlignment(Element.ALIGN_LEFT);
            product.setVerticalAlignment(Element.ALIGN_MIDDLE);
            product.setMinimumHeight(25);
            product.setBorder(0);
            product.setBorderWidthTop(1);
            product.setBorderWidthBottom(1);
            product.setBorderColor(BaseColor.GRAY);

            PdfPCell quantity = new PdfPCell(new Phrase("Cant. comprada", tituloTablaBOLD));
            quantity.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantity.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantity.setMinimumHeight(25);
            quantity.setBorder(0);
            quantity.setBorderWidthTop(1);
            quantity.setBorderWidthBottom(1);
            quantity.setBorderColor(BaseColor.GRAY);

            PdfPCell priceShopping = new PdfPCell(new Phrase("Precio de compra", tituloTablaBOLD));
            priceShopping.setHorizontalAlignment(Element.ALIGN_LEFT);
            priceShopping.setVerticalAlignment(Element.ALIGN_MIDDLE);
            priceShopping.setMinimumHeight(25);
            priceShopping.setBorder(0);
            priceShopping.setBorderWidthTop(1);
            priceShopping.setBorderWidthBottom(1);
            priceShopping.setBorderColor(BaseColor.GRAY);

            PdfPCell dateShopping = new PdfPCell(new Phrase("Fecha de compra", tituloTablaBOLD));
            dateShopping.setHorizontalAlignment(Element.ALIGN_LEFT);
            dateShopping.setVerticalAlignment(Element.ALIGN_MIDDLE);
            dateShopping.setMinimumHeight(25);
            dateShopping.setBorder(0);
            dateShopping.setBorderWidthTop(1);
            dateShopping.setBorderWidthBottom(1);
            dateShopping.setBorderWidthRight(1);
            dateShopping.setBorderColor(BaseColor.GRAY);

            table.addCell(customer);
            table.addCell(product);
            table.addCell(quantity);
            table.addCell(priceShopping);
            table.addCell(dateShopping);

            CurrencyFormat currencys = new CurrencyFormat();
            String query = "SELECT s.full_name,p.title, dc.quantity, dc.price_shopping, "
                    + "DATE_FORMAT(c.date_shooping, '%Y/%m/%d %r') AS dates "
                    + "FROM shopping c "
                    + "INNER JOIN details_shopping dc ON "
                    + "dc.idshopping = c.id "
                    + "INNER JOIN products p ON "
                    + "p.id = dc.idproduct "
                    + "INNER JOIN supplier s ON "
                    + "s.id = c.idsupplier "
                    + "WHERE DATE_FORMAT(c.date_shooping,'%Y-%m-%d') BETWEEN '" + dateStart + "' AND '" + dateEnd + "' ";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    PdfPCell customerData = new PdfPCell(new Phrase(rs.getString("s.full_name"), fuenteDescripcionTablas));
                    customerData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    customerData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    customerData.setMinimumHeight(15);
                    customerData.setBorderWidthTop(0);
                    customerData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell productData = new PdfPCell(new Phrase(rs.getString("p.title"), fuenteDescripcionTablas));
                    productData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    productData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    productData.setMinimumHeight(15);
                    productData.setBorderWidthTop(0);
                    productData.setBorderWidthLeft(0);
                    productData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell quantityData = new PdfPCell(new Phrase(rs.getString("dc.quantity"), fuenteDescripcionTablas));
                    quantityData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    quantityData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    quantityData.setMinimumHeight(15);
                    quantityData.setBorderWidthTop(0);
                    quantityData.setBorderWidthLeft(0);
                    quantityData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell priceShoppingData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("dc.price_shopping"))).substring(1), fuenteDescripcionTablas));
                    priceShoppingData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    priceShoppingData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    priceShoppingData.setMinimumHeight(15);
                    priceShoppingData.setBorderWidthTop(0);
                    priceShoppingData.setBorderWidthLeft(0);
                    priceShoppingData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell dateShoppingData = new PdfPCell(new Phrase(rs.getString("dates"), fuenteDescripcionTablas));
                    dateShoppingData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    dateShoppingData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    dateShoppingData.setMinimumHeight(15);
                    dateShoppingData.setBorderWidthTop(0);
                    dateShoppingData.setBorderWidthLeft(0);
                    dateShoppingData.setBorderColor(BaseColor.LIGHT_GRAY);

                    table.addCell(customerData);
                    table.addCell(productData);
                    table.addCell(quantityData);
                    table.addCell(priceShoppingData);
                    table.addCell(dateShoppingData);
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

            File file = new File(env.URL_SERVER_FILES + "reportes/RPT COMPRAS DETALLADO " + todaysDate + ".pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }
}

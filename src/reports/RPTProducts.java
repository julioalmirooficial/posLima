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

public class RPTProducts {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    public static LocalDate todaysDate = LocalDate.now();

    public void reportProducts() {
        HeaderFooterReport header = new HeaderFooterReport();

        Env env = new Env();
        String queryCompany = "SELECT * FROM company ";
        Document document = new Document(PageSize.A4.rotate(), 18, 18, 18, 18);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(env.URL_SERVER_FILES + "reportes/RPT PRODUCTOS " + todaysDate + ".pdf");

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
            
             Font fuenteDescripcionTablasDanger = FontFactory.getFont(
                    FontFactory.HELVETICA, 9, Font.NORMAL,
                    BaseColor.RED);

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
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("REPORTE DE PRODUCTOS", fuenteDescripcionTablasBOLD));
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

            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);
            float[] medidatablaVentas = {7f, 33f, 10f,10f,10f,10f,10f, 10f};
            table.setWidths(medidatablaVentas);

            PdfPCell barCode = new PdfPCell(new Phrase("#", tituloTablaBOLD));
            barCode.setHorizontalAlignment(Element.ALIGN_LEFT);
            barCode.setVerticalAlignment(Element.ALIGN_MIDDLE);
            barCode.setMinimumHeight(25);
            barCode.setBorder(0);
            barCode.setBorderWidthTop(1);
            barCode.setBorderWidthLeft(1);
            barCode.setBorderWidthBottom(1);
            barCode.setBorderColor(BaseColor.GRAY);

            PdfPCell product = new PdfPCell(new Phrase("Productos", tituloTablaBOLD));
            product.setHorizontalAlignment(Element.ALIGN_LEFT);
            product.setVerticalAlignment(Element.ALIGN_MIDDLE);
            product.setMinimumHeight(25);
            product.setBorder(0);
            product.setBorderWidthTop(1);
            product.setBorderWidthBottom(1);
            product.setBorderColor(BaseColor.GRAY);

            PdfPCell typeProduct = new PdfPCell(new Phrase("Tipo", tituloTablaBOLD));
            typeProduct.setHorizontalAlignment(Element.ALIGN_LEFT);
            typeProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
            typeProduct.setMinimumHeight(25);
            typeProduct.setBorder(0);
            typeProduct.setBorderWidthTop(1);
            typeProduct.setBorderWidthBottom(1);
            typeProduct.setBorderColor(BaseColor.GRAY);

            PdfPCell discount = new PdfPCell(new Phrase("Descuento", tituloTablaBOLD));
            discount.setHorizontalAlignment(Element.ALIGN_LEFT);
            discount.setVerticalAlignment(Element.ALIGN_MIDDLE);
            discount.setMinimumHeight(25);
            discount.setBorder(0);
            discount.setBorderWidthTop(1);
            discount.setBorderWidthBottom(1);
            discount.setBorderColor(BaseColor.GRAY);

            PdfPCell utility = new PdfPCell(new Phrase("Utilidad", tituloTablaBOLD));
            utility.setHorizontalAlignment(Element.ALIGN_LEFT);
            utility.setVerticalAlignment(Element.ALIGN_MIDDLE);
            utility.setMinimumHeight(25);
            utility.setBorder(0);
            utility.setBorderWidthTop(1);
            utility.setBorderWidthBottom(1);
            utility.setBorderColor(BaseColor.GRAY);

            PdfPCell stock = new PdfPCell(new Phrase("Stock", tituloTablaBOLD));
            stock.setHorizontalAlignment(Element.ALIGN_LEFT);
            stock.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stock.setMinimumHeight(25);
            stock.setBorder(0);
            stock.setBorderWidthTop(1);
            stock.setBorderWidthBottom(1);
            stock.setBorderColor(BaseColor.GRAY);

            PdfPCell priceSales = new PdfPCell(new Phrase("P. Venta", tituloTablaBOLD));
            priceSales.setHorizontalAlignment(Element.ALIGN_LEFT);
            priceSales.setVerticalAlignment(Element.ALIGN_MIDDLE);
            priceSales.setMinimumHeight(25);
            priceSales.setBorder(0);
            priceSales.setBorderWidthTop(1);
            priceSales.setBorderWidthBottom(1);
            priceSales.setBorderColor(BaseColor.GRAY);

            PdfPCell priceShopping = new PdfPCell(new Phrase("P. Compra", tituloTablaBOLD));
            priceShopping.setHorizontalAlignment(Element.ALIGN_LEFT);
            priceShopping.setVerticalAlignment(Element.ALIGN_MIDDLE);
            priceShopping.setMinimumHeight(25);
            priceShopping.setBorder(0);
            priceShopping.setBorderWidthTop(1);
            priceShopping.setBorderWidthBottom(1);
            priceShopping.setBorderWidthRight(1);
            priceShopping.setBorderColor(BaseColor.GRAY);

            table.addCell(barCode);
            table.addCell(product);
            table.addCell(typeProduct);
            table.addCell(discount);
            table.addCell(utility);
            table.addCell(stock);
            table.addCell(priceSales);
            table.addCell(priceShopping);

            String query = "SELECT p.title,p.bar_code, p.discount, p.utility, p.stock, "
                    + "p.price_shopping,p.price_sale, tp.description,p.stock_minimun "
                    + "FROM products p "
                    + "INNER JOIN type_product tp ON "
                    + "tp.id = p.idtype_product WHERE p.state =1 ";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    PdfPCell barCodeData = new PdfPCell(new Phrase(rs.getString("p.bar_code"), fuenteDescripcionTablas));
                    barCodeData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    barCodeData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    barCodeData.setMinimumHeight(15);
                    barCodeData.setBorderWidthTop(0);
                    barCodeData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell productData = new PdfPCell(new Phrase(rs.getString("p.title"), fuenteDescripcionTablas));
                    productData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    productData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    productData.setMinimumHeight(15);
                    productData.setBorderWidthTop(0);
                    productData.setBorderWidthLeft(0);
                    productData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell typeProductData = new PdfPCell(new Phrase(rs.getString("tp.description"), fuenteDescripcionTablas));
                    typeProductData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    typeProductData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    typeProductData.setMinimumHeight(15);
                    typeProductData.setBorderWidthTop(0);
                    typeProductData.setBorderWidthLeft(0);
                    typeProductData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell discountData = new PdfPCell(new Phrase(rs.getString("p.discount"),fuenteDescripcionTablas));
                    discountData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    discountData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    discountData.setMinimumHeight(15);
                    discountData.setBorderWidthTop(0);
                    discountData.setBorderWidthLeft(0);
                    discountData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell utilityData = new PdfPCell(new Phrase(rs.getString("p.utility"),fuenteDescripcionTablas));
                    utilityData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    utilityData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    utilityData.setMinimumHeight(15);
                    utilityData.setBorderWidthTop(0);
                    utilityData.setBorderWidthLeft(0);
                    utilityData.setBorderColor(BaseColor.LIGHT_GRAY);
                    
                    double stocks = Double.parseDouble(rs.getString("p.stock"));
                    double stocksMinimun = Double.parseDouble(rs.getString("p.stock_minimun"));
                    
                    
                    PdfPCell stockData = new PdfPCell(new Phrase(rs.getString("p.stock"),stocks < stocksMinimun ?fuenteDescripcionTablasDanger:fuenteDescripcionTablas));
                    stockData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    stockData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    stockData.setMinimumHeight(15);
                    stockData.setBorderWidthTop(0);
                    stockData.setBorderWidthLeft(0);
                    stockData.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell priceSalesData = new PdfPCell(new Phrase(rs.getString("p.price_sale"),fuenteDescripcionTablas));
                    priceSalesData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    priceSalesData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    priceSalesData.setMinimumHeight(15);
                    priceSalesData.setBorderWidthTop(0);
                    priceSalesData.setBorderWidthLeft(0);
                    priceSalesData.setBorderColor(BaseColor.LIGHT_GRAY);
                    
                    PdfPCell priceShoppingData = new PdfPCell(new Phrase(rs.getString("p.price_shopping"),fuenteDescripcionTablas));
                    priceShoppingData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    priceShoppingData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    priceShoppingData.setMinimumHeight(15);
                    priceShoppingData.setBorderWidthTop(0);
                    priceShoppingData.setBorderWidthLeft(0);
                    priceShoppingData.setBorderColor(BaseColor.LIGHT_GRAY);

                    table.addCell(barCodeData);
                    table.addCell(productData);
                    table.addCell(typeProductData);
                    table.addCell(discountData);
                    table.addCell(utilityData);
                    table.addCell(stockData);
                    table.addCell(priceSalesData);
                    table.addCell(priceShoppingData);
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

            File file = new File(env.URL_SERVER_FILES + "reportes/RPT PRODUCTOS " + todaysDate + ".pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }
}

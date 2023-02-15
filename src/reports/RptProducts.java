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
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class RptProducts {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    public static LocalDate todaysDate = LocalDate.now();

    public void reportProducts(String idStore, String nameReport) {
        HeaderFooterReport header = new HeaderFooterReport();

        String queryCompany = "SELECT e.nombre AS nombrecompany, e.direccion, e.ruc,e.lema, "
                + "CONCAT(e.telefono_uno, ' / ', e.telefono_dos) AS cellphone,  "
                + "a.nombre AS nombrealmacen, a.ubicacion "
                + "FROM almacen a "
                + "INNER JOIN empresa e ON "
                + "e.id = a.idempresa "
                + "WHERE a.id = " + idStore;
        Document document = new Document(PageSize.A4.rotate(), 18, 18, 18, 18);
        try {
            String url = System.getProperty("user.home");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\sistemapos/reportes/RPT-PRODUCTOS-" + nameReport + ".pdf");

            PdfWriter write = PdfWriter.getInstance(document, fileOutputStream);
            Rectangle rect = new Rectangle(50, 50, 100, 540);

            rect.setBorderColor(BaseColor.BLACK);

            write.setBoxSize("art", rect);
            write.setPageEvent(header);

            document.open();

            Image image = null;
            image = Image.getInstance("D:\\sistemapos/logo/logo-pdf.png");
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
                        PdfPCell nombreEmpresa = new PdfPCell(new Phrase(rs.getString("nombrecompany"), fuenteTitulosBOLD));
                        nombreEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombreEmpresa.setBorder(0);
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("REPORTE GENERAL DE PRODUCTOS", fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        tipoComprobante.setBorder(0);
                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(tipoComprobante);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("e.direccion"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        direccionEmpresa.setBorder(0);
                        PdfPCell lugarEmitido = new PdfPCell(new Phrase("Almacén: ".toUpperCase() + rs.getString("nombrealmacen").toUpperCase(), fuenteDescripcionTablasLIGHT));
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

                        PdfPCell rucEmpresa = new PdfPCell(new Phrase("RNC: " + rs.getString("e.ruc"), fuenteDescripcionTablasLIGHT));
                        rucEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        rucEmpresa.setBorder(0);
                        encabezado.addCell(rucEmpresa);
                        encabezado.addCell(colVacio);

                        PdfPCell lema = new PdfPCell(new Phrase(rs.getString("e.lema"), fuenteDescripcionTablas));
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

            PdfPTable table = new PdfPTable(12);
            table.setWidthPercentage(100);
            float[] medidatablaVentas = {9f, 30f, 7f, 6f, 6f, 6f, 8f, 8f, 4f, 4f, 6f, 6f};
            table.setWidths(medidatablaVentas);

            PdfPCell barCodeHeader = new PdfPCell(new Phrase("C/B", tituloTablaBOLD));
            barCodeHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            barCodeHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            barCodeHeader.setMinimumHeight(25);
            barCodeHeader.setBorder(0);
            barCodeHeader.setBorderWidthTop(1);
            barCodeHeader.setBorderWidthLeft(1);
            barCodeHeader.setBorderWidthBottom(1);
            barCodeHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell productoHeader = new PdfPCell(new Phrase("Producto", tituloTablaBOLD));
            productoHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            productoHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productoHeader.setMinimumHeight(25);
            productoHeader.setBorder(0);
            productoHeader.setBorderWidthTop(1);
            productoHeader.setBorderWidthBottom(1);
            productoHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell descripcionHeader = new PdfPCell(new Phrase("Descripción", tituloTablaBOLD));
            descripcionHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            descripcionHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            descripcionHeader.setMinimumHeight(25);
            descripcionHeader.setBorder(0);
            descripcionHeader.setBorderWidthTop(1);
            descripcionHeader.setBorderWidthBottom(1);
            descripcionHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell compraHeader = new PdfPCell(new Phrase("Compra", tituloTablaBOLD));
            compraHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            compraHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            compraHeader.setMinimumHeight(25);
            compraHeader.setBorder(0);
            compraHeader.setBorderWidthTop(1);
            compraHeader.setBorderWidthBottom(1);
            compraHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell ventaHeader = new PdfPCell(new Phrase("Venta", tituloTablaBOLD));
            ventaHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            ventaHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            ventaHeader.setMinimumHeight(25);
            ventaHeader.setBorder(0);
            ventaHeader.setBorderWidthTop(1);
            ventaHeader.setBorderWidthBottom(1);
            ventaHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell stockHeader = new PdfPCell(new Phrase("Stock", tituloTablaBOLD));
            stockHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            stockHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stockHeader.setMinimumHeight(25);
            stockHeader.setBorder(0);
            stockHeader.setBorderWidthTop(1);
            stockHeader.setBorderWidthBottom(1);
            stockHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell stockMinimumHeader = new PdfPCell(new Phrase("Stock Min", tituloTablaBOLD));
            stockMinimumHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            stockMinimumHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stockMinimumHeader.setMinimumHeight(25);
            stockMinimumHeader.setBorder(0);
            stockMinimumHeader.setBorderWidthTop(1);
            stockMinimumHeader.setBorderWidthBottom(1);
            stockMinimumHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell discountHeader = new PdfPCell(new Phrase("Descuento", tituloTablaBOLD));
            discountHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            discountHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            discountHeader.setMinimumHeight(25);
            discountHeader.setBorder(0);
            discountHeader.setBorderWidthTop(1);
            discountHeader.setBorderWidthBottom(1);
            discountHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell facturadoHeader = new PdfPCell(new Phrase("C/F", tituloTablaBOLD));
            facturadoHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            facturadoHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            facturadoHeader.setMinimumHeight(25);
            facturadoHeader.setBorder(0);
            facturadoHeader.setBorderWidthTop(1);
            facturadoHeader.setBorderWidthBottom(1);
            facturadoHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell freeInvoiceHeader = new PdfPCell(new Phrase("L/I", tituloTablaBOLD));
            freeInvoiceHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            freeInvoiceHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            freeInvoiceHeader.setMinimumHeight(25);
            freeInvoiceHeader.setBorder(0);
            freeInvoiceHeader.setBorderWidthTop(1);
            freeInvoiceHeader.setBorderWidthBottom(1);
            freeInvoiceHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell isstockHeader = new PdfPCell(new Phrase("V.Stock", tituloTablaBOLD));
            isstockHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            isstockHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            isstockHeader.setMinimumHeight(25);
            isstockHeader.setBorder(0);
            isstockHeader.setBorderWidthTop(1);
            isstockHeader.setBorderWidthBottom(1);
            isstockHeader.setBorderColor(BaseColor.GRAY);

            PdfPCell stateHeader = new PdfPCell(new Phrase("Estado", tituloTablaBOLD));
            stateHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
            stateHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stateHeader.setMinimumHeight(25);
            stateHeader.setBorder(0);
            stateHeader.setBorderWidthTop(1);
            stateHeader.setBorderWidthBottom(1);
            stateHeader.setBorderWidthRight(1);
            stateHeader.setBorderColor(BaseColor.GRAY);

            table.addCell(barCodeHeader);
            table.addCell(productoHeader);
            table.addCell(descripcionHeader);
            table.addCell(compraHeader);
            table.addCell(ventaHeader);
            table.addCell(stockHeader);
            table.addCell(stockMinimumHeader);
            table.addCell(discountHeader);
            table.addCell(facturadoHeader);
            table.addCell(freeInvoiceHeader);
            table.addCell(isstockHeader);
            table.addCell(stateHeader);

            CurrencyFormat currencys = new CurrencyFormat();
            int counterRows = 0;
            int counterRowsStart = 0;
            String query = "SELECT p.codigobarra,p.nombreproducto, p.descripcion AS descriptionproduct, "
                    + "pa.precio_compra, pa.precio_venta, pa.stock, pa.stock_minimo,p.descuento, p.facturado, "
                    + "p.libre_impuesto,IF(pa.constock = 1, 'SI', 'NO') AS ventaconstock , "
                    + "IF( p.estado = 1,'ACTIVO','ANULADO') AS estateproduct "
                    + "FROM productos  p "
                    + "INNER JOIN producto_en_almacen pa ON "
                    + "pa.idproducto = p.id "
                    + "INNER JOIN tipo_producto tp ON "
                    + "tp.id = p.idtipo "
                    + "WHERE p.idalmacen =  " + idStore + " AND p.estado = 1";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    counterRows++;
                    PdfPCell barCode = new PdfPCell(new Phrase(rs.getString("p.codigobarra"), fuenteDescripcionTablas));
                    barCode.setHorizontalAlignment(Element.ALIGN_LEFT);
                    barCode.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    barCode.setMinimumHeight(15);
                    barCode.setBorderWidthTop(0);
                    barCode.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell productName = new PdfPCell(new Phrase(rs.getString("p.nombreproducto"), fuenteDescripcionTablas));
                    productName.setHorizontalAlignment(Element.ALIGN_LEFT);
                    productName.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    productName.setMinimumHeight(15);
                    productName.setBorderWidthTop(0);
                    productName.setBorderWidthLeft(0);
                    productName.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell productDescription = new PdfPCell(new Phrase(rs.getString("descriptionproduct"), fuenteDescripcionTablas));
                    productDescription.setHorizontalAlignment(Element.ALIGN_LEFT);
                    productDescription.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    productDescription.setMinimumHeight(15);
                    productDescription.setBorderWidthTop(0);
                    productDescription.setBorderWidthLeft(0);
                    productDescription.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell shoppgin = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("pa.precio_compra"))).substring(1), fuenteDescripcionTablas));
                    shoppgin.setHorizontalAlignment(Element.ALIGN_LEFT);
                    shoppgin.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    shoppgin.setMinimumHeight(15);
                    shoppgin.setBorderWidthTop(0);
                    shoppgin.setBorderWidthLeft(0);
                    shoppgin.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell sale = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("pa.precio_venta"))).substring(1), fuenteDescripcionTablas));
                    sale.setHorizontalAlignment(Element.ALIGN_LEFT);
                    sale.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    sale.setMinimumHeight(15);
                    sale.setBorderWidthTop(0);
                    sale.setBorderWidthLeft(0);
                    sale.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell stock = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("pa.stock"))).substring(1), fuenteDescripcionTablas));
                    stock.setHorizontalAlignment(Element.ALIGN_LEFT);
                    stock.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    stock.setMinimumHeight(15);
                    stock.setBorderWidthTop(0);
                    stock.setBorderWidthLeft(0);
                    stock.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell stockMinimum = new PdfPCell(new Phrase(rs.getString("pa.stock_minimo"), fuenteDescripcionTablas));
                    stockMinimum.setHorizontalAlignment(Element.ALIGN_LEFT);
                    stockMinimum.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    stockMinimum.setMinimumHeight(15);
                    stockMinimum.setBorderWidthTop(0);
                    stockMinimum.setBorderWidthLeft(0);
                    stockMinimum.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell discount = new PdfPCell(new Phrase(rs.getString("p.descuento"), fuenteDescripcionTablas));
                    discount.setHorizontalAlignment(Element.ALIGN_LEFT);
                    discount.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    discount.setMinimumHeight(15);
                    discount.setBorderWidthTop(0);
                    discount.setBorderWidthLeft(0);
                    discount.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell isVoucher = new PdfPCell(new Phrase(rs.getString("p.facturado"), fuenteDescripcionTablas));
                    isVoucher.setHorizontalAlignment(Element.ALIGN_LEFT);
                    isVoucher.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    isVoucher.setMinimumHeight(15);
                    isVoucher.setBorderWidthTop(0);
                    isVoucher.setBorderWidthLeft(0);
                    isVoucher.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell freeInvoice = new PdfPCell(new Phrase(rs.getString("p.libre_impuesto"), fuenteDescripcionTablas));
                    freeInvoice.setHorizontalAlignment(Element.ALIGN_LEFT);
                    freeInvoice.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    freeInvoice.setMinimumHeight(15);
                    freeInvoice.setBorderWidthTop(0);
                    freeInvoice.setBorderWidthLeft(0);
                    freeInvoice.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell isStock = new PdfPCell(new Phrase(rs.getString("ventaconstock"), fuenteDescripcionTablas));
                    isStock.setHorizontalAlignment(Element.ALIGN_LEFT);
                    isStock.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    isStock.setMinimumHeight(15);
                    isStock.setBorderWidthTop(0);
                    isStock.setBorderWidthLeft(0);
                    isStock.setBorderColor(BaseColor.LIGHT_GRAY);

                    PdfPCell estate = new PdfPCell(new Phrase(rs.getString("estateproduct"), fuenteDescripcionTablas));
                    estate.setHorizontalAlignment(Element.ALIGN_LEFT);
                    estate.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    estate.setMinimumHeight(15);
                    estate.setBorderWidthTop(0);
                    estate.setBorderWidthLeft(0);
                    estate.setBorderColor(BaseColor.LIGHT_GRAY);

                    table.addCell(barCode);
                    table.addCell(productName);
                    table.addCell(productDescription);
                    table.addCell(shoppgin);
                    table.addCell(sale);
                    table.addCell(stock);
                    table.addCell(stockMinimum);
                    table.addCell(discount);
                    table.addCell(isVoucher);
                    table.addCell(freeInvoice);
                    table.addCell(isStock);
                    table.addCell(estate);
                    counterRowsStart++;
                    if(counterRowsStart == 30) {
                        if (counterRows == 30) {
                        counterRows = 0;
                        table.addCell(barCodeHeader);
                        table.addCell(productoHeader);
                        table.addCell(descripcionHeader);
                        table.addCell(compraHeader);
                        table.addCell(ventaHeader);
                        table.addCell(stockHeader);
                        table.addCell(stockMinimumHeader);
                        table.addCell(discountHeader);
                        table.addCell(facturadoHeader);
                        table.addCell(freeInvoiceHeader);
                        table.addCell(isstockHeader);
                        table.addCell(stateHeader);
                    }
                    } else {
                        if (counterRows == 34) {
                        counterRows = 0;
                        table.addCell(barCodeHeader);
                        table.addCell(productoHeader);
                        table.addCell(descripcionHeader);
                        table.addCell(compraHeader);
                        table.addCell(ventaHeader);
                        table.addCell(stockHeader);
                        table.addCell(stockMinimumHeader);
                        table.addCell(discountHeader);
                        table.addCell(facturadoHeader);
                        table.addCell(freeInvoiceHeader);
                        table.addCell(isstockHeader);
                        table.addCell(stateHeader);
                    }
                    }
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
            File file = new File("D:\\sistemapos/reportes/RPT-PRODUCTOS-" + nameReport + ".pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }
}

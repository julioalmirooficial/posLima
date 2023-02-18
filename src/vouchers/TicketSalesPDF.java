package vouchers;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import env.Env;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

public class TicketSalesPDF {

    private final static Logger LOGGER = Logger.getLogger("mx.hash.impresionpdf.Impresor");
    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    CurrencyFormat currencys = new CurrencyFormat();

    public void ticket(String idSale) {
        String query = "SELECT e.name_company,e.adress, e.cellphone, e.email, e.ruc,v.number_voucher, v.serie,cv.voucher, "
                + "c.full_name, c.adress, c.number_document, v.date_emit, v.type_payment, "
                + "dv.quantity, dv.unit_measure, dv.price_unit, dv.total,dv.discount, "
                + "v.subtotal, v.igv, v.iva_aplicate, v.total, u.full_name, v.amount_paid, v.amount_returned,p.title "
                + "FROM sales v "
                + "INNER JOIN details_sales dv ON "
                + "dv.idsale = v.id "
                + "INNER JOIN products p ON "
                + "p.id = dv.idproduct "
                + "INNER JOIN customer c ON "
                + "c.id = v.idcustomer "
                + "INNER JOIN users u ON "
                + "u.id = v.iduser "
                + "INNER JOIN vouchers cv ON "
                + "cv.id = v.idvoucher "
                + "INNER JOIN company e  "
                + "WHERE v.id = " + idSale;

        int countLinesHeight = 0;
        Env env = new Env();
        String nameCustomerVoucher = null;
        try {

            Statement stLainghtHeight = cn.createStatement();
            ResultSet rsLainghtHeight = stLainghtHeight.executeQuery(query);
            while (rsLainghtHeight.next()) {
                countLinesHeight += 33; 
                nameCustomerVoucher = rsLainghtHeight.getString("c.full_name") +" "+rsLainghtHeight.getString("v.serie") +" "+ rsLainghtHeight.getString("v.number_voucher") ;

            }
        } catch (SQLException e) {
        }

        Rectangle two = new Rectangle(210, 700 + countLinesHeight);
        Document document = new Document(two, 9f, 9f, 7f, 7f);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(env.URL_SERVER_FILES + "comprobantes/TICKET "+nameCustomerVoucher+".pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.open();

            Image image = null;
            image = Image.getInstance(env.URL_SERVER_FILES + "logo/logo-pdf.png");
            image.scaleAbsolute(70f, 50f);
            image.setAbsolutePosition(50f, 10f);

            Font fuenteDescripcionTablasBOLD = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 9, Font.NORMAL,
                    BaseColor.BLACK);
            Font fuenteDescripcionTablasBOLDSamll = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteDescripcionTablasLIGHT = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);
            Font fuenteDescripcionTablasLIGHTSmall = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Paragraph saltoLinea1 = new Paragraph();
            saltoLinea1.add(new Phrase(Chunk.NEWLINE));

            PdfPTable encabezado = new PdfPTable(1);
            encabezado.setWidthPercentage(100);
            float[] medidaCeldas = {100f};
            encabezado.setWidths(medidaCeldas);

            PdfPCell logo = new PdfPCell(image);
            logo.setBorderColor(BaseColor.WHITE);
            logo.setHorizontalAlignment(Element.ALIGN_CENTER);
            logo.setPaddingBottom(10);

            PdfPCell colVacio = new PdfPCell(new Phrase());
            colVacio.setBorder(0);

            int contadorHeader = 0;
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contadorHeader++;
                    if (contadorHeader <= 1) {
                        PdfPCell company = new PdfPCell(new Phrase(rs.getString("e.name_company"), fuenteDescripcionTablasBOLD));
                        company.setHorizontalAlignment(Element.ALIGN_CENTER);
                        company.setBorder(0);

                        PdfPCell adress = new PdfPCell(new Phrase(rs.getString("e.adress"), fuenteDescripcionTablasLIGHT));
                        adress.setHorizontalAlignment(Element.ALIGN_CENTER);
                        adress.setBorder(0);

                        PdfPCell cellPhone = new PdfPCell(new Phrase(rs.getString("e.cellphone"), fuenteDescripcionTablasLIGHT));
                        cellPhone.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellPhone.setBorder(0);

                        PdfPCell email = new PdfPCell(new Phrase(rs.getString("e.email"), fuenteDescripcionTablasLIGHT));
                        email.setHorizontalAlignment(Element.ALIGN_CENTER);
                        email.setBorder(0);

                        PdfPCell ruc = new PdfPCell(new Phrase("RUC " + rs.getString("e.ruc"), fuenteDescripcionTablasBOLD));
                        ruc.setHorizontalAlignment(Element.ALIGN_CENTER);
                        ruc.setBorder(0);

                        PdfPCell typeVoucher = new PdfPCell(new Phrase(rs.getString("cv.voucher"), fuenteDescripcionTablasBOLD));
                        typeVoucher.setHorizontalAlignment(Element.ALIGN_CENTER);
                        typeVoucher.setBorder(0);

                        PdfPCell numberVoucher = new PdfPCell(new Phrase(rs.getString("serie") + " " + rs.getString("v.number_voucher"), fuenteDescripcionTablasBOLD));
                        numberVoucher.setHorizontalAlignment(Element.ALIGN_CENTER);
                        numberVoucher.setBorder(0);

                        //new code 
                        company.setPadding(0);
                        adress.setPadding(0);
                        cellPhone.setPadding(0);
                        email.setPadding(0);
                        //end code

                        encabezado.addCell(logo);
                        encabezado.addCell(company);
                        encabezado.addCell(adress);
                        encabezado.addCell(cellPhone);
                        encabezado.addCell(email);
                        encabezado.addCell(ruc);
                        encabezado.addCell(typeVoucher);
                        encabezado.addCell(numberVoucher);
                       
                    }

                }
            } catch (SQLException e) {
            }
            document.add(encabezado);

            document.add(saltoLinea1);

            PdfPTable clientes = new PdfPTable(2);
            clientes.setWidthPercentage(100);
            float[] medidaTablaProveedor = {40f, 60f};
            clientes.setWidths(medidaTablaProveedor);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                int conCustomer = 0;
                while (rs.next()) {
                    conCustomer++;
                    if (conCustomer <= 1) {
                        PdfPCell nameCustomer = new PdfPCell(new Phrase("Cliente: ", fuenteDescripcionTablasBOLD));
                        nameCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nameCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nameCustomer.setBorder(0);
                        nameCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell datanameCustomer = new PdfPCell(new Phrase(rs.getString("c.full_name"), fuenteDescripcionTablasLIGHT));
                        datanameCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datanameCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datanameCustomer.setBorder(0);
                        datanameCustomer.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(nameCustomer);
                        clientes.addCell(datanameCustomer);

                        PdfPCell adresCustomer = new PdfPCell(new Phrase("Dirección: ", fuenteDescripcionTablasBOLD));
                        adresCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        adresCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        adresCustomer.setBorder(0);
                        adresCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataadresCustomer = new PdfPCell(new Phrase(rs.getString("c.adress"), fuenteDescripcionTablasLIGHT));
                        dataadresCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataadresCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataadresCustomer.setBorder(0);
                        dataadresCustomer.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(adresCustomer);
                        clientes.addCell(dataadresCustomer);

                        PdfPCell documentCustomer = new PdfPCell(new Phrase("N° Documento: ", fuenteDescripcionTablasBOLD));
                        documentCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        documentCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        documentCustomer.setBorder(0);
                        documentCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell datadocumentCustomer = new PdfPCell(new Phrase(rs.getString("c.number_document"), fuenteDescripcionTablasLIGHT));
                        datadocumentCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datadocumentCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadocumentCustomer.setBorder(0);
                        datadocumentCustomer.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(documentCustomer);
                        clientes.addCell(datadocumentCustomer);

                        PdfPCell dateSaleCustomer = new PdfPCell(new Phrase("Fec. de emición: ", fuenteDescripcionTablasBOLD));
                        dateSaleCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dateSaleCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dateSaleCustomer.setBorder(0);
                        dateSaleCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell datadateSaleCustomer = new PdfPCell(new Phrase(rs.getString("v.date_emit"), fuenteDescripcionTablasLIGHT));
                        datadateSaleCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datadateSaleCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadateSaleCustomer.setBorder(0);
                        datadateSaleCustomer.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(dateSaleCustomer);
                        clientes.addCell(datadateSaleCustomer);

                        PdfPCell typePayment = new PdfPCell(new Phrase("Tipo de pago: ", fuenteDescripcionTablasBOLD));
                        typePayment.setHorizontalAlignment(Element.ALIGN_LEFT);
                        typePayment.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        typePayment.setBorder(0);
                        typePayment.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataTypePayment = new PdfPCell(new Phrase(rs.getString("v.type_payment"), fuenteDescripcionTablasLIGHT));
                        dataTypePayment.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTypePayment.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTypePayment.setBorder(0);
                        dataTypePayment.setBorderColor(BaseColor.GRAY);

                        typePayment.setPaddingTop(0);
                        dataTypePayment.setPaddingTop(0);
                        dataTypePayment.setPaddingBottom(7);
                        typePayment.setPaddingBottom(7);
                        dateSaleCustomer.setPadding(0);
                        datadateSaleCustomer.setPadding(0);
                        documentCustomer.setPadding(0);
                        datadocumentCustomer.setPadding(0);
                        adresCustomer.setPadding(0);
                        dataadresCustomer.setPadding(0);
                        nameCustomer.setPadding(0);
                        datanameCustomer.setPadding(0);
                        clientes.addCell(typePayment);
                        clientes.addCell(dataTypePayment);

                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            document.add(clientes);
//            document.add(saltoLinea1);

            PdfPTable ventas = new PdfPTable(4);
            ventas.setWidthPercentage(100);
            float[] medidatablaVentas = {15f, 25f, 20f, 20f};
            ventas.setWidths(medidatablaVentas);

            PdfPCell quantity = new PdfPCell(new Phrase("Cant.", fuenteDescripcionTablasBOLD));
            quantity.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantity.setBackgroundColor(BaseColor.WHITE);
            quantity.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantity.setBorder(0);
            quantity.setMinimumHeight(25);
            quantity.setBorderWidthTop(1);
            quantity.setBorderWidthBottom(1);

            PdfPCell unitMeasure = new PdfPCell(new Phrase("UM", fuenteDescripcionTablasBOLD));
            unitMeasure.setHorizontalAlignment(Element.ALIGN_LEFT);
            unitMeasure.setBackgroundColor(BaseColor.WHITE);
            unitMeasure.setVerticalAlignment(Element.ALIGN_MIDDLE);
            unitMeasure.setBorder(0);
            unitMeasure.setBorderWidthTop(1);
            unitMeasure.setBorderWidthBottom(1);
            unitMeasure.setMinimumHeight(25);

            PdfPCell priceUnit = new PdfPCell(new Phrase("P.U", fuenteDescripcionTablasBOLD));
            priceUnit.setHorizontalAlignment(Element.ALIGN_LEFT);
            priceUnit.setBackgroundColor(BaseColor.WHITE);
            priceUnit.setVerticalAlignment(Element.ALIGN_MIDDLE);
            priceUnit.setMinimumHeight(25);
            priceUnit.setBorder(0);
            priceUnit.setBorderWidthTop(1);
            priceUnit.setBorderWidthBottom(1);
            //CORREGIR 
            PdfPCell discount = new PdfPCell(new Phrase("P.U", fuenteDescripcionTablasBOLD));
            discount.setHorizontalAlignment(Element.ALIGN_LEFT);
            discount.setBackgroundColor(BaseColor.WHITE);
            discount.setVerticalAlignment(Element.ALIGN_MIDDLE);
            discount.setMinimumHeight(25);
            discount.setBorder(0);
            discount.setBorderWidthTop(1);
            discount.setBorderWidthBottom(1);

            PdfPCell importSales = new PdfPCell(new Phrase("Total", fuenteDescripcionTablasBOLD));
            importSales.setHorizontalAlignment(Element.ALIGN_LEFT);
            importSales.setBackgroundColor(BaseColor.WHITE);
            importSales.setVerticalAlignment(Element.ALIGN_MIDDLE);
            importSales.setMinimumHeight(25);
            importSales.setBorder(0);
            importSales.setBorderWidthTop(1);
            importSales.setBorderWidthBottom(1);

            ventas.addCell(quantity);
            ventas.addCell(unitMeasure);
            ventas.addCell(priceUnit);
            ventas.addCell(importSales);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    PdfPCell quantityData = new PdfPCell(new Phrase(rs.getString("dv.quantity"), fuenteDescripcionTablasLIGHTSmall));
                    quantityData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    quantityData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    quantityData.setBorderColor(BaseColor.LIGHT_GRAY);
                    quantityData.setBorder(0);

                    PdfPCell descriptionProduct = new PdfPCell(new Phrase(rs.getString("p.title"), fuenteDescripcionTablasLIGHTSmall));
                    descriptionProduct.setHorizontalAlignment(Element.ALIGN_LEFT);
                    descriptionProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    descriptionProduct.setBorderColor(BaseColor.LIGHT_GRAY);
                    descriptionProduct.setBorder(0);
                    descriptionProduct.setColspan(4);
                    descriptionProduct.setPaddingBottom(7);

                    PdfPCell unitMeasureData = new PdfPCell(new Phrase(rs.getString("dv.unit_measure"), fuenteDescripcionTablasLIGHTSmall));
                    unitMeasureData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    unitMeasureData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    unitMeasureData.setBorderColor(BaseColor.LIGHT_GRAY);
                    unitMeasureData.setBorder(0);

                    PdfPCell priceUnitData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("dv.price_unit"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    priceUnitData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    priceUnitData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    priceUnitData.setBorderColor(BaseColor.LIGHT_GRAY);
                    priceUnitData.setBorder(0);

                    PdfPCell importSalesData = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("dv.total"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    importSalesData.setHorizontalAlignment(Element.ALIGN_LEFT);
                    importSalesData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    importSalesData.setBorderColor(BaseColor.LIGHT_GRAY);
                    importSalesData.setBorder(0);

                    ventas.addCell(quantityData);
                    ventas.addCell(unitMeasureData);
                    ventas.addCell(priceUnitData);
                    ventas.addCell(importSalesData);
                    ventas.addCell(descriptionProduct);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            document.add(ventas);
            PdfPTable footer = new PdfPTable(2);
            footer.setWidthPercentage(100);
            float[] sizeFooter = {50f, 50f};
            footer.setWidths(sizeFooter);

            try {
                int contFooter = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contFooter++;
                    if (contFooter <= 1) {

                        PdfPCell subtotal = new PdfPCell(new Phrase("SUB TOTAL", fuenteDescripcionTablasBOLDSamll));
                        subtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        subtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        subtotal.setMinimumHeight(15);
                        subtotal.setBorder(0);
                        subtotal.setBorderWidthTop(1);
                        PdfPCell datasubtotal = new PdfPCell(new Phrase("S/" + currencys.formatCurrency(Double.parseDouble(rs.getString("v.subtotal"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        datasubtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datasubtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datasubtotal.setMinimumHeight(15);
                        datasubtotal.setBorder(0);
                        datasubtotal.setBorderWidthTop(1);

                        PdfPCell igv = new PdfPCell(new Phrase("IGV " + rs.getString("v.iva_aplicate") + " %", fuenteDescripcionTablasBOLDSamll));
                        igv.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        igv.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        igv.setMinimumHeight(15);
                        igv.setBorder(0);
                        PdfPCell dataigvtotal = new PdfPCell(new Phrase("S/" + currencys.formatCurrency(Double.parseDouble(rs.getString("v.igv"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        dataigvtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataigvtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataigvtotal.setMinimumHeight(15);
                        dataigvtotal.setBorder(0);

                        PdfPCell ventatotal = new PdfPCell(new Phrase("TOTAL", fuenteDescripcionTablasBOLD));
                        ventatotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        ventatotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        ventatotal.setMinimumHeight(15);
                        ventatotal.setBorder(0);

                        PdfPCell dataventatotal = new PdfPCell(new Phrase("S/" + currencys.formatCurrency(Double.parseDouble(rs.getString("v.total"))).substring(1), fuenteDescripcionTablasBOLD));
                        dataventatotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataventatotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataventatotal.setMinimumHeight(15);
                        dataventatotal.setBorder(0);

                        subtotal.setPadding(0);
                        datasubtotal.setPadding(0);
                        igv.setPadding(0);
                        dataigvtotal.setPadding(0);
                        ventatotal.setPadding(0);
                        dataventatotal.setPadding(0);

                        footer.addCell(subtotal);
                        footer.addCell(datasubtotal);
                        footer.addCell(igv);
                        footer.addCell(dataigvtotal);
                        footer.addCell(ventatotal);
                        footer.addCell(dataventatotal);
                    }
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

            document.add(footer);
            document.add(saltoLinea1);

            PdfPTable footerAdicional = new PdfPTable(2);
            footerAdicional.setWidthPercentage(100);
            float[] sizefooterAdicional = {30f, 70f};
            footerAdicional.setWidths(sizefooterAdicional);

            try {
                int contFooterAdicional = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contFooterAdicional++;
                    if (contFooterAdicional <= 1) {
                        PdfPCell SELLER = new PdfPCell(new Phrase("Vendedor", fuenteDescripcionTablasBOLD));
                        SELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        SELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        SELLER.setBorder(0);
                        PdfPCell NAMESELLER = new PdfPCell(new Phrase(rs.getString("u.full_name"), fuenteDescripcionTablasBOLDSamll));
                        NAMESELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        NAMESELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        NAMESELLER.setBorder(0);

                        PdfPCell titleImport = new PdfPCell(new Phrase("Importe", fuenteDescripcionTablasBOLD));
                        titleImport.setHorizontalAlignment(Element.ALIGN_LEFT);
                        titleImport.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        titleImport.setBorder(0);
                        PdfPCell dataTitleImport = new PdfPCell(new Phrase("S/" + currencys.formatCurrency(Double.parseDouble(rs.getString("v.amount_paid"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        dataTitleImport.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTitleImport.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTitleImport.setBorder(0);

                        PdfPCell titleReturn = new PdfPCell(new Phrase("Vuelto", fuenteDescripcionTablasBOLD));
                        titleReturn.setHorizontalAlignment(Element.ALIGN_LEFT);
                        titleReturn.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        titleReturn.setBorder(0);

                        PdfPCell datatTitleReturn = new PdfPCell(new Phrase("S/" + currencys.formatCurrency(Double.parseDouble(rs.getString("v.amount_returned"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        datatTitleReturn.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datatTitleReturn.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datatTitleReturn.setBorder(0);

                        footerAdicional.addCell(SELLER);
                        footerAdicional.addCell(NAMESELLER);
                        footerAdicional.addCell(titleImport);
                        footerAdicional.addCell(dataTitleImport);
                        footerAdicional.addCell(titleReturn);
                        footerAdicional.addCell(datatTitleReturn);
                    }
                }
            } catch (NumberFormatException | SQLException e) {
                System.out.println(e);
            }

            document.add(footerAdicional);

            try {
                int contFooterAdicional = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contFooterAdicional++;
                    if (contFooterAdicional <= 1) {
                        Paragraph textoagradecimiento = new Paragraph("¡Gracias por su compra regrese pronto!", fuenteDescripcionTablasBOLD);
                        textoagradecimiento.setAlignment(Element.ALIGN_CENTER);
                        Paragraph textoinformacion = new Paragraph("¡Por favor revise sus productos antes de retirarse del establecimiento,no aceptamos reclamos posteriores!", fuenteDescripcionTablasLIGHT);
                        textoinformacion.setAlignment(Element.ALIGN_CENTER);
                        document.add(textoagradecimiento);
                        document.add(textoinformacion);

                    }
                }
            } catch (DocumentException | SQLException e) {
                System.out.println(e);
            }

            document.close();
            try {
                ConnectionDB cnS = new ConnectionDB();
                cnS.closeConection();
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                PDDocument files = PDDocument.load(new File(env.URL_SERVER_FILES + "comprobantes/TICKET "+nameCustomerVoucher+".pdf"));
                PrinterJob job = PrinterJob.getPrinterJob();
                LOGGER.log(Level.INFO, "Mostrando el dialogo de impresion");
                if (job.printDialog() == true) {
                    job.setPageable(new PDFPageable(files));

                    LOGGER.log(Level.INFO, "Imprimiendo documento");
                    job.print();
                }
            } catch (HeadlessException | PrinterException | IOException | NullPointerException e) {
                System.out.println(e);
            }

        } catch (DocumentException | IOException ex) {
            System.out.println(ex);
        }
    }

}

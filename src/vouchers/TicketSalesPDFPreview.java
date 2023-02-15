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
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class TicketSalesPDFPreview {

    private final static Logger LOGGER = Logger.getLogger("mx.hash.impresionpdf.Impresor");
    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    CurrencyFormat currencys = new CurrencyFormat();

    public void ticket(String idSale, String idStore) {
        String numberVoucher = null;
        String query = "SELECT e.nombre AS nombreempresas, e.direccion AS direccionesempresa, "
                + "CONCAT(e.telefono_uno,' ', e.telefono_dos) AS telefonosempresa, e.ruc AS empresaruc,  "
                + "e.lema, tc.descripcion AS nombrecomprobantes, CONCAT(v.serie_comprobante,' ', v.numero_comprobante) AS numerosseriecomprobante, "
                + "c.nombres AS nombresclientes, c.direccion AS direccionesclietes, c.numero_documento AS numerodocumentocliente,  "
                + "DATE_FORMAT(v.fecha_pago, '%d/%m/%Y %r') AS fechaventa,v.nombre_cliente_pedido,  "
                + "dv.cantidad AS cantidadvendida, p.nombreproducto, dv.unidad_medida AS unidadmedidaventa,dv.precio_venta AS precioventaproducto, "
                + "dv.igv AS precioigv, dv.subtotal AS preciosubtotal, dv.total AS totaldetalle,  "
                + "v.total AS totalventageneral, v.igv AS igvventageneral, v.subtotal AS subtotalventageneral, v.igv_aplicado,  "
                + "v.descripcion_moneda AS divisaventa, v.prefijo_moneda, tp.descripcion AS tipopagoventa, tpc.descripcion AS tipopacompra,"
                + "v.pago_importe, v.vuelto_importe, u.nombre AS nombrevendedor, pcv.parametro_agradecimiento, pcv.parametro_informacion, v.descuento, "
                + "v.numero_referencia, v.descuentos_otros,v.comentarios,totalncredito,diferenciancredito,"
                + "v.seller,v.numero_comprobante,v.monto_pagar_cliente_por_seguro,v.monto_pagar_empresa_por_seguro  "
                + "FROM ventas v "
                + "INNER JOIN detalle_venta dv ON "
                + "dv.idventa = v.id "
                + "INNER JOIN clientes c ON "
                + "c.id = v.idcliente "
                + "INNER JOIN productos p ON "
                + "p.id = dv.idproducto "
                + "INNER JOIN almacen a ON "
                + "a.id = v.idalmacen "
                + "INNER JOIN empresa e ON "
                + "e.id = a.idempresa "
                + "INNER JOIN comprobantes cv ON "
                + "cv.id = v.idcomprobante "
                + "INNER JOIN tipo_comprobante tc ON "
                + "tc.id = cv.idtipo_comprobante "
                + "INNER JOIN tipo_pago_venta tp ON "
                + "tp.id = v.idtipo_pago "
                + "INNER JOIN tipo_pago_compra tpc ON "
                + "tpc.id = v.idtipo_venta_compra "
                + "INNER JOIN usuarios u ON "
                + "u.id = v.idvendedor "
                + "INNER JOIN parametro_comprobantes pcv ON "
                + "pcv.idcomprobante = cv.id "
                + "WHERE v.id = " + idSale + " AND v.idalmacen = " + idStore;
        //NEW
        int countCompanyAseguradora = 0;
        String querySeguros = "SELECT ea.razon_social  "
                + "FROM cuentas_por_cobrar_seguros c "
                + "INNER JOIN empresas_aseguradoras ea ON "
                + "ea.id = c.idempresa_aseguradora WHERE c.idventa = " + idSale;
        String nameCompanies = "";
        //NEW
        try {

            Statement stLainghtHeight = cn.createStatement();
            ResultSet rsLainghtHeight = stLainghtHeight.executeQuery(querySeguros);
            while (rsLainghtHeight.next()) {
                countCompanyAseguradora++;
                if (countCompanyAseguradora > 0) {
                    nameCompanies = rsLainghtHeight.getString("ea.razon_social");
                }
            }
        } catch (SQLException e) {
        }
        int countLinesHeight = 0;
        try {

            Statement stLainghtHeight = cn.createStatement();
            ResultSet rsLainghtHeight = stLainghtHeight.executeQuery(query);
            while (rsLainghtHeight.next()) {
                countLinesHeight += 33;
            }
        } catch (SQLException e) {
        }
        Rectangle two = new Rectangle(210, 700 + countLinesHeight);
        Document document = new Document(two, 9f, 9f, 7f, 7f);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\sistemapos/comprobantes/TICKET-PREVIEW.pdf");
            PdfWriter pdf = PdfWriter.getInstance(document, fileOutputStream);
            document.open();

            Image image = null;
            image = Image.getInstance("D:\\sistemapos/logo/logo-pdf.png");
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
                        numberVoucher = rs.getString("v.numero_comprobante");
                        PdfPCell nombreEmpresa = new PdfPCell(new Phrase(rs.getString("nombreempresas"), fuenteDescripcionTablasBOLD));
                        nombreEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
                        nombreEmpresa.setBorder(0);
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("RNC " + rs.getString("empresaruc"), fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tipoComprobante.setBorder(0);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("direccionesempresa"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
                        direccionEmpresa.setBorder(0);
                        PdfPCell numeroComprobante = new PdfPCell(new Phrase(rs.getString("nombrecomprobantes"), fuenteDescripcionTablasBOLD));
                        numeroComprobante.setHorizontalAlignment(Element.ALIGN_CENTER);
                        numeroComprobante.setBorder(0);

                        PdfPCell telefonoEmpresa = new PdfPCell(new Phrase(rs.getString("telefonosempresa"), fuenteDescripcionTablasLIGHT));
                        telefonoEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
                        telefonoEmpresa.setBorder(0);
                        PdfPCell fechaEmision = new PdfPCell(new Phrase(rs.getString("numerosseriecomprobante"), fuenteDescripcionTablasBOLD));
                        fechaEmision.setHorizontalAlignment(Element.ALIGN_CENTER);
                        fechaEmision.setBorder(0);

                        PdfPCell lema = new PdfPCell(new Phrase(rs.getString("lema"), fuenteDescripcionTablasLIGHT));
                        lema.setHorizontalAlignment(Element.ALIGN_CENTER);
                        lema.setBorder(0);
                        PdfPCell colNumberReference = new PdfPCell(new Phrase("N° REF. " + rs.getString("v.numero_referencia"), fuenteDescripcionTablasBOLD));
                        colNumberReference.setHorizontalAlignment(Element.ALIGN_CENTER);
                        colNumberReference.setBorder(0);

                        //new code 
                        nombreEmpresa.setPadding(0);
                        direccionEmpresa.setPadding(0);
                        telefonoEmpresa.setPadding(0);
                        lema.setPadding(0);
                        //end code

                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(direccionEmpresa);
                        encabezado.addCell(telefonoEmpresa);
                        encabezado.addCell(lema);
                        encabezado.addCell(tipoComprobante);
                        encabezado.addCell(numeroComprobante);
                        encabezado.addCell(fechaEmision);
                        encabezado.addCell(colNumberReference);

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
                        PdfPCell datanameCustomer = new PdfPCell(new Phrase(rs.getString("v.nombre_cliente_pedido"), fuenteDescripcionTablasLIGHT));
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
                        PdfPCell dataadresCustomer = new PdfPCell(new Phrase(rs.getString("direccionesclietes"), fuenteDescripcionTablasLIGHT));
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
                        PdfPCell datadocumentCustomer = new PdfPCell(new Phrase(rs.getString("numerodocumentocliente"), fuenteDescripcionTablasLIGHT));
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
                        PdfPCell datadateSaleCustomer = new PdfPCell(new Phrase(rs.getString("fechaventa"), fuenteDescripcionTablasLIGHT));
                        datadateSaleCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datadateSaleCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadateSaleCustomer.setBorder(0);
                        datadateSaleCustomer.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(dateSaleCustomer);
                        clientes.addCell(datadateSaleCustomer);

                        PdfPCell tipopago = new PdfPCell(new Phrase("Tipo de pago: ", fuenteDescripcionTablasBOLD));
                        tipopago.setHorizontalAlignment(Element.ALIGN_LEFT);
                        tipopago.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tipopago.setBorder(0);
                        tipopago.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataTipopago = new PdfPCell(new Phrase(rs.getString("tipopagoventa"), fuenteDescripcionTablasLIGHT));
                        dataTipopago.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTipopago.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTipopago.setBorder(0);
                        dataTipopago.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(tipopago);
                        clientes.addCell(dataTipopago);

                        PdfPCell tipopagocompra = new PdfPCell(new Phrase("Tipo de venta: ", fuenteDescripcionTablasBOLD));
                        tipopagocompra.setHorizontalAlignment(Element.ALIGN_LEFT);
                        tipopagocompra.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tipopagocompra.setBorder(0);
                        tipopagocompra.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataTipopagocompra = new PdfPCell(new Phrase(rs.getString("tipopacompra"), fuenteDescripcionTablasLIGHT));
                        dataTipopagocompra.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTipopagocompra.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTipopagocompra.setBorder(0);
                        dataTipopagocompra.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(tipopagocompra);
                        clientes.addCell(dataTipopagocompra);

                        PdfPCell nameCompaniesAseguradora = new PdfPCell(new Phrase("Aseguradora: ", fuenteDescripcionTablasBOLD));
                        nameCompaniesAseguradora.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nameCompaniesAseguradora.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nameCompaniesAseguradora.setBorder(0);
                        nameCompaniesAseguradora.setBorderColor(BaseColor.GRAY);
                        PdfPCell nameCompaniesAseguradoraData = new PdfPCell(new Phrase(nameCompanies, fuenteDescripcionTablasLIGHT));
                        nameCompaniesAseguradoraData.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nameCompaniesAseguradoraData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nameCompaniesAseguradoraData.setBorder(0);
                        nameCompaniesAseguradoraData.setBorderColor(BaseColor.GRAY);
                        if (countCompanyAseguradora > 0) {
                            clientes.addCell(nameCompaniesAseguradora);
                            clientes.addCell(nameCompaniesAseguradoraData);
                        }
                        PdfPCell titlecoments = new PdfPCell(new Phrase("Nota Adicional: ", fuenteDescripcionTablasBOLD));
                        titlecoments.setHorizontalAlignment(Element.ALIGN_LEFT);
                        titlecoments.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        titlecoments.setBorder(0);
                        titlecoments.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataComents = new PdfPCell(new Phrase(rs.getString("v.comentarios"), fuenteDescripcionTablasLIGHT));
                        dataComents.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataComents.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataComents.setBorder(0);
                        dataComents.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(titlecoments);
                        clientes.addCell(dataComents);

                        //new code 
                        titlecoments.setPadding(0);
                        dataComents.setPadding(0);
                        tipopago.setPadding(0);
                        dataTipopago.setPadding(0);
                        dateSaleCustomer.setPadding(0);
                        datadateSaleCustomer.setPadding(0);
                        documentCustomer.setPadding(0);
                        datadocumentCustomer.setPadding(0);
                        adresCustomer.setPadding(0);
                        dataadresCustomer.setPadding(0);
                        nameCustomer.setPadding(0);
                        datanameCustomer.setPadding(0);
                        nameCompaniesAseguradoraData.setPadding(0);
                        nameCompaniesAseguradora.setPadding(0);
                        //end code
                    }
                }
            } catch (SQLException e) {
            }

            document.add(clientes);
//            document.add(saltoLinea1);

            PdfPTable ventas = new PdfPTable(5);
            ventas.setWidthPercentage(100);
            float[] medidatablaVentas = {15f, 25f, 20f, 20f, 25f};
            ventas.setWidths(medidatablaVentas);

            PdfPCell cantidad = new PdfPCell(new Phrase("Cant.", fuenteDescripcionTablasBOLD));
            cantidad.setHorizontalAlignment(Element.ALIGN_LEFT);
            cantidad.setBackgroundColor(BaseColor.WHITE);
            cantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cantidad.setBorder(0);
            cantidad.setMinimumHeight(25);
            cantidad.setBorderWidthTop(1);
            cantidad.setBorderWidthBottom(1);

            PdfPCell umVentas = new PdfPCell(new Phrase("UM", fuenteDescripcionTablasBOLD));
            umVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            umVentas.setBackgroundColor(BaseColor.WHITE);
            umVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            umVentas.setBorder(0);
            umVentas.setBorderWidthTop(1);
            umVentas.setBorderWidthBottom(1);
            umVentas.setMinimumHeight(25);

            PdfPCell precioDeVentas = new PdfPCell(new Phrase("Precio", fuenteDescripcionTablasBOLD));
            precioDeVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            precioDeVentas.setBackgroundColor(BaseColor.WHITE);
            precioDeVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            precioDeVentas.setMinimumHeight(25);
            precioDeVentas.setBorder(0);
            precioDeVentas.setBorderWidthTop(1);
            precioDeVentas.setBorderWidthBottom(1);
            PdfPCell igvDeVentas = new PdfPCell(new Phrase("ITBIS", fuenteDescripcionTablasBOLD));
            igvDeVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            igvDeVentas.setBackgroundColor(BaseColor.WHITE);
            igvDeVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            igvDeVentas.setMinimumHeight(25);
            igvDeVentas.setBorder(0);
            igvDeVentas.setBorderWidthTop(1);
            igvDeVentas.setBorderWidthBottom(1);
            PdfPCell importeDeVentas = new PdfPCell(new Phrase("Total", fuenteDescripcionTablasBOLD));
            importeDeVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            importeDeVentas.setBackgroundColor(BaseColor.WHITE);
            importeDeVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            importeDeVentas.setMinimumHeight(25);
            importeDeVentas.setBorder(0);
            importeDeVentas.setBorderWidthTop(1);
            importeDeVentas.setBorderWidthBottom(1);

            ventas.addCell(cantidad);
            ventas.addCell(umVentas);
            ventas.addCell(precioDeVentas);
            ventas.addCell(igvDeVentas);
            ventas.addCell(importeDeVentas);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    PdfPCell cantidadVentas = new PdfPCell(new Phrase(rs.getString("cantidadvendida"), fuenteDescripcionTablasLIGHTSmall));
                    cantidadVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cantidadVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cantidadVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    cantidadVentas.setBorder(0);

                    PdfPCell descripcionProducto = new PdfPCell(new Phrase(rs.getString("nombreproducto"), fuenteDescripcionTablasLIGHTSmall));
                    descripcionProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                    descripcionProducto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    descripcionProducto.setBorderColor(BaseColor.LIGHT_GRAY);
                    descripcionProducto.setBorder(0);
                    descripcionProducto.setColspan(5);
                    descripcionProducto.setPaddingBottom(7);

                    PdfPCell dataunidamedidaVentasProducto = new PdfPCell(new Phrase(rs.getString("unidadmedidaventa"), fuenteDescripcionTablasLIGHTSmall));
                    dataunidamedidaVentasProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                    dataunidamedidaVentasProducto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    dataunidamedidaVentasProducto.setBorderColor(BaseColor.LIGHT_GRAY);
                    dataunidamedidaVentasProducto.setBorder(0);

                    PdfPCell datapreciounitarioVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("precioventaproducto"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datapreciounitarioVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datapreciounitarioVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datapreciounitarioVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datapreciounitarioVentas.setBorder(0);

                    PdfPCell datprecioigvVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("preciosubtotal"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datprecioigvVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datprecioigvVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datprecioigvVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datprecioigvVentas.setBorder(0);

                    PdfPCell datapreciosubtotalVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("precioigv"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datapreciosubtotalVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datapreciosubtotalVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datapreciosubtotalVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datapreciosubtotalVentas.setBorder(0);

                    PdfPCell datimportVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("totaldetalle"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datimportVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datimportVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datimportVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datimportVentas.setBorder(0);

                    ventas.addCell(cantidadVentas);
                    ventas.addCell(dataunidamedidaVentasProducto);
                    ventas.addCell(datprecioigvVentas);
                    ventas.addCell(datapreciosubtotalVentas);
                    ventas.addCell(datimportVentas);
                    ventas.addCell(descripcionProducto);
                }
            } catch (SQLException e) {
            }

            document.add(ventas);
//            document.add(saltoLinea1);

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
                        PdfPCell divisa = new PdfPCell(new Phrase("DIVISA", fuenteDescripcionTablasBOLDSamll));
                        divisa.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        divisa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        divisa.setMinimumHeight(15);
                        divisa.setBorder(0);
                        divisa.setBorderWidthTop(1);
                        PdfPCell datadivisa = new PdfPCell(new Phrase(rs.getString("divisaventa"), fuenteDescripcionTablasBOLDSamll));
                        datadivisa.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datadivisa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadivisa.setMinimumHeight(15);
                        datadivisa.setBorder(0);
                        datadivisa.setBorderWidthTop(1);

                        PdfPCell descuento = new PdfPCell(new Phrase("DESCUENTO", fuenteDescripcionTablasBOLDSamll));
                        descuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        descuento.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        descuento.setMinimumHeight(15);
                        descuento.setBorder(0);
                        PdfPCell datedescuento = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("v.descuento"))) + " %".substring(1), fuenteDescripcionTablasBOLDSamll));
                        datedescuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datedescuento.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datedescuento.setMinimumHeight(15);
                        datedescuento.setBorder(0);

                        PdfPCell othersDiscounts = new PdfPCell(new Phrase("OTROS DESC.", fuenteDescripcionTablasBOLDSamll));
                        othersDiscounts.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        othersDiscounts.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        othersDiscounts.setMinimumHeight(15);
                        othersDiscounts.setBorder(0);
                        PdfPCell dateothersDiscounts = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("v.descuentos_otros"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        dateothersDiscounts.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dateothersDiscounts.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dateothersDiscounts.setMinimumHeight(15);
                        dateothersDiscounts.setBorder(0);

                        //NEW CODE 
                        PdfPCell amountNCredit = new PdfPCell(new Phrase("NOTA DE CREDITO", fuenteDescripcionTablasBOLD));
                        amountNCredit.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        amountNCredit.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        amountNCredit.setMinimumHeight(15);
                        amountNCredit.setBorder(0);
                        PdfPCell dataAmountNCredit = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("totalncredito"))).substring(1), fuenteDescripcionTablasBOLD));
                        dataAmountNCredit.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataAmountNCredit.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataAmountNCredit.setMinimumHeight(15);
                        dataAmountNCredit.setBorder(0);

                        PdfPCell amountDiferencia = new PdfPCell(new Phrase("DIFERENCIA", fuenteDescripcionTablasBOLD));
                        amountDiferencia.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        amountDiferencia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        amountDiferencia.setMinimumHeight(15);
                        amountDiferencia.setBorder(0);
                        PdfPCell dataAmountDiferencia = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("diferenciancredito"))).substring(1), fuenteDescripcionTablasBOLD));
                        dataAmountDiferencia.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataAmountDiferencia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataAmountDiferencia.setMinimumHeight(15);
                        dataAmountDiferencia.setBorder(0);
                        //END CODE
                        PdfPCell subtotal = new PdfPCell(new Phrase("SUB TOTAL", fuenteDescripcionTablasBOLDSamll));
                        subtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        subtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        subtotal.setMinimumHeight(15);
                        subtotal.setBorder(0);
                        PdfPCell datasubtotal = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("subtotalventageneral"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        datasubtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datasubtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datasubtotal.setMinimumHeight(15);
                        datasubtotal.setBorder(0);

                        PdfPCell igvtotal = new PdfPCell(new Phrase("ITBIS " + rs.getString("igv_aplicado") + " %", fuenteDescripcionTablasBOLDSamll));
                        igvtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        igvtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        igvtotal.setMinimumHeight(15);
                        igvtotal.setBorder(0);
                        PdfPCell dataigvtotal = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("igvventageneral"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        dataigvtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataigvtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataigvtotal.setMinimumHeight(15);
                        dataigvtotal.setBorder(0);

                        PdfPCell ventatotal = new PdfPCell(new Phrase("TOTAL", fuenteDescripcionTablasBOLD));
                        ventatotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        ventatotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        ventatotal.setMinimumHeight(15);
                        ventatotal.setBorder(0);

                        PdfPCell dataventatotal = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("totalventageneral"))).substring(1), fuenteDescripcionTablasBOLD));
                        dataventatotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        dataventatotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataventatotal.setMinimumHeight(15);
                        dataventatotal.setBorder(0);

                        //MONTO CON SEGURO
                        PdfPCell totalPagarPorCliente = new PdfPCell(new Phrase("CLIENTE", fuenteDescripcionTablasBOLDSamll));
                        totalPagarPorCliente.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalPagarPorCliente.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        totalPagarPorCliente.setMinimumHeight(15);
                        totalPagarPorCliente.setBorder(0);
                        totalPagarPorCliente.setBorderWidthTop(1);
                        totalPagarPorCliente.setPaddingTop(5);
                        totalPagarPorCliente.setBorderColor(BaseColor.LIGHT_GRAY);

                        PdfPCell totalPagarPorClienteData = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("v.monto_pagar_cliente_por_seguro"))).substring(1), fuenteDescripcionTablasBOLD));
                        totalPagarPorClienteData.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalPagarPorClienteData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        totalPagarPorClienteData.setMinimumHeight(15);
                        totalPagarPorClienteData.setBorder(0);
                        totalPagarPorClienteData.setBorderWidthTop(1);
                        totalPagarPorClienteData.setPaddingTop(5);
                        totalPagarPorClienteData.setBorderColor(BaseColor.LIGHT_GRAY);

                        PdfPCell totalPagarPorEmpresa = new PdfPCell(new Phrase("ASEGURADORA", fuenteDescripcionTablasBOLDSamll));
                        totalPagarPorEmpresa.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalPagarPorEmpresa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        totalPagarPorEmpresa.setMinimumHeight(15);
                        totalPagarPorEmpresa.setBorder(0);

                        PdfPCell totalPagarPorEmpresaData = new PdfPCell(new Phrase(rs.getString("prefijo_moneda") + " " + currencys.formatCurrency(Double.parseDouble(rs.getString("v.monto_pagar_empresa_por_seguro"))).substring(1), fuenteDescripcionTablasBOLD));
                        totalPagarPorEmpresaData.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalPagarPorEmpresaData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        totalPagarPorEmpresaData.setMinimumHeight(15);
                        totalPagarPorEmpresaData.setBorder(0);
                        //MONTO CON SEGURO

                        //new code
                        divisa.setPadding(0);
                        datadivisa.setPadding(0);
                        descuento.setPadding(0);
                        datedescuento.setPadding(0);
                        othersDiscounts.setPadding(0);
                        dateothersDiscounts.setPadding(0);
                        amountNCredit.setPadding(0);
                        dataAmountNCredit.setPadding(0);
                        amountDiferencia.setPadding(0);
                        dataAmountDiferencia.setPadding(0);
                        subtotal.setPadding(0);
                        datasubtotal.setPadding(0);
                        igvtotal.setPadding(0);
                        dataigvtotal.setPadding(0);
                        ventatotal.setPadding(0);
                        dataventatotal.setPadding(0);
                        // end code

                        footer.addCell(divisa);
                        footer.addCell(datadivisa);
                        footer.addCell(descuento);
                        footer.addCell(datedescuento);
                        footer.addCell(othersDiscounts);
                        footer.addCell(dateothersDiscounts);
                        if (Double.parseDouble(rs.getString("totalncredito")) > 0) {
                            footer.addCell(amountNCredit);
                            footer.addCell(dataAmountNCredit);
                            footer.addCell(amountDiferencia);
                            footer.addCell(dataAmountDiferencia);
                        }
                        footer.addCell(subtotal);
                        footer.addCell(datasubtotal);
                        footer.addCell(igvtotal);
                        footer.addCell(dataigvtotal);
                        footer.addCell(ventatotal);
                        footer.addCell(dataventatotal);
                        if (Double.parseDouble(rs.getString("v.monto_pagar_cliente_por_seguro")) > 0) {
                            footer.addCell(totalPagarPorCliente);
                            footer.addCell(totalPagarPorClienteData);
                            footer.addCell(totalPagarPorEmpresa);
                            footer.addCell(totalPagarPorEmpresaData);
                        }
                    }
                }

            } catch (SQLException e) {
            }

            document.add(footer);
//            document.add(saltoLinea1);

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
                        PdfPCell vendedor = new PdfPCell(new Phrase("Cajero", fuenteDescripcionTablasBOLD));
                        vendedor.setHorizontalAlignment(Element.ALIGN_LEFT);
                        vendedor.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        vendedor.setBorder(0);
                        vendedor.setBorderWidthTop(1);
                        PdfPCell nombrevendedor = new PdfPCell(new Phrase(rs.getString("nombrevendedor"), fuenteDescripcionTablasBOLDSamll));
                        nombrevendedor.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrevendedor.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombrevendedor.setBorder(0);
                        nombrevendedor.setBorderWidthTop(1);
                        //CHANGE
                        PdfPCell SELLER = new PdfPCell(new Phrase("Vendedor", fuenteDescripcionTablasBOLD));
                        SELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        SELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        SELLER.setBorder(0);
                        PdfPCell NAMESELLER = new PdfPCell(new Phrase(rs.getString("v.seller"), fuenteDescripcionTablasBOLDSamll));
                        NAMESELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        NAMESELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        NAMESELLER.setBorder(0);

                        PdfPCell nombreimporte = new PdfPCell(new Phrase("Importe   " + rs.getString("prefijo_moneda"), fuenteDescripcionTablasBOLD));
                        nombreimporte.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombreimporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombreimporte.setBorder(0);
                        PdfPCell montoimporte = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("pago_importe"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        montoimporte.setHorizontalAlignment(Element.ALIGN_LEFT);
                        montoimporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        montoimporte.setBorder(0);

                        PdfPCell nombrevuelto = new PdfPCell(new Phrase("Devuelta   " + rs.getString("prefijo_moneda"), fuenteDescripcionTablasBOLD));
                        nombrevuelto.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrevuelto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombrevuelto.setBorder(0);

                        PdfPCell montovuelto = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("vuelto_importe"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        montovuelto.setHorizontalAlignment(Element.ALIGN_LEFT);
                        montovuelto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        montovuelto.setBorder(0);

                        footerAdicional.addCell(vendedor);
                        footerAdicional.addCell(nombrevendedor);
                        footerAdicional.addCell(SELLER);
                        footerAdicional.addCell(NAMESELLER);
                        footerAdicional.addCell(nombreimporte);
                        footerAdicional.addCell(montoimporte);
                        footerAdicional.addCell(nombrevuelto);
                        footerAdicional.addCell(montovuelto);
                    }
                }
            } catch (NumberFormatException | SQLException e) {
            }

            document.add(footerAdicional);
            Barcode128 code = new Barcode128();
            code.setCode(numberVoucher);
            Image barCode = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            barCode.scalePercent(150f);
            barCode.setIndentationLeft(50f);
            document.add(barCode);

            try {
                int contFooterAdicional = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contFooterAdicional++;
                    if (contFooterAdicional <= 1) {
                        Paragraph textoagradecimiento = new Paragraph(rs.getString("pcv.parametro_agradecimiento"), fuenteDescripcionTablasBOLD);
                        textoagradecimiento.setAlignment(Element.ALIGN_CENTER);
                        Paragraph textoinformacion = new Paragraph(rs.getString("pcv.parametro_informacion"), fuenteDescripcionTablasLIGHT);
                        textoinformacion.setAlignment(Element.ALIGN_CENTER);
                        Paragraph textFirma = new Paragraph("----------------------------             ----------------------------\n"
                                + "ENTREGADO POR:               RECIBIDO POR:", fuenteDescripcionTablasLIGHT);
                        textFirma.setAlignment(Element.ALIGN_CENTER);

                        document.add(textoagradecimiento);
                        document.add(textoinformacion);
                        document.add(saltoLinea1);
                        document.add(textFirma);

                    }
                }
            } catch (DocumentException | SQLException e) {
            }

            document.close();
            try {
                ConnectionDB cnS = new ConnectionDB();
                cnS.closeConection();
            } catch (SQLException e) {
            }

            File file = new File("D:\\sistemapos/comprobantes/TICKET-PREVIEW.pdf");

            Desktop.getDesktop()
                    .open(file);
        } catch (DocumentException | IOException ex) {
        }
    }

}

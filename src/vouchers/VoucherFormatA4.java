package vouchers;

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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VoucherFormatA4 {

    ConnectionDB conectDB = new ConnectionDB();
    Connection cn = conectDB.conect();

    CurrencyFormat currencys = new CurrencyFormat();

    public void voucherA4(String idSale, String idStore, String nameVoucher) {

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
                + "v.seller,v.monto_pagar_cliente_por_seguro,v.monto_pagar_empresa_por_seguro   "
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
        Document document = new Document(PageSize.A4, 24, 24, 24, 24);
        try {
            String url = System.getProperty("user.home");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\sistemapos/comprobantes/CV-FormatA4-" + nameVoucher + ".pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.open();

            Image image = null;
            image = Image.getInstance("D:\\sistemapos/logo/logo-pdf.png");
            image.scaleAbsolute(70f, 50f);

            Font fuenteDescripcionTablasBOLD = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 11, Font.NORMAL,
                    BaseColor.BLACK);
            Font fuenteDescripcionTablasBOLDSamll = FontFactory.getFont(
                    FontFactory.HELVETICA, 9, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteDescripcionTablasLIGHT = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);
            Font fuenteDescripcionTablasLIGHTSmall = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Paragraph saltoLinea1 = new Paragraph();
            saltoLinea1.add(new Phrase(Chunk.NEWLINE));
            Paragraph saltoLinea2 = new Paragraph();
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));
            saltoLinea2.add(new Phrase(Chunk.NEWLINE));

            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            float[] medidaCeldas = {15f, 65f, 25};
            encabezado.setWidths(medidaCeldas);

            PdfPCell logo = new PdfPCell(image);
            logo.setRowspan(4);
            logo.setBorderColor(BaseColor.WHITE);

            PdfPCell colVacio = new PdfPCell(new Phrase());
            colVacio.setBorder(0);

            int contadorHeader = 0;
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contadorHeader++;
                    if (contadorHeader <= 1) {
                        PdfPCell nombreEmpresa = new PdfPCell(new Phrase(rs.getString("nombreempresas"), fuenteDescripcionTablasBOLD));
                        nombreEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombreEmpresa.setBorder(0);
                        PdfPCell tipoComprobante = new PdfPCell(new Phrase("RNC " + rs.getString("empresaruc"), fuenteDescripcionTablasBOLD));
                        tipoComprobante.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tipoComprobante.setBorder(0);
                        tipoComprobante.setBorderWidthTop(2);
                        tipoComprobante.setBorderWidthLeft(2);
                        tipoComprobante.setBorderWidthRight(2);
                        tipoComprobante.setPaddingTop(3);

                        encabezado.addCell(logo);
                        encabezado.addCell(nombreEmpresa);
                        encabezado.addCell(tipoComprobante);

                        PdfPCell direccionEmpresa = new PdfPCell(new Phrase(rs.getString("direccionesempresa"), fuenteDescripcionTablasLIGHT));
                        direccionEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        direccionEmpresa.setBorder(0);
                        PdfPCell numeroComprobante = new PdfPCell(new Phrase(rs.getString("nombrecomprobantes"), fuenteDescripcionTablasBOLD));
                        numeroComprobante.setHorizontalAlignment(Element.ALIGN_CENTER);
                        numeroComprobante.setBorder(0);
                        numeroComprobante.setBorderWidthLeft(2);
                        numeroComprobante.setBorderWidthRight(2);

                        encabezado.addCell(direccionEmpresa);
                        encabezado.addCell(numeroComprobante);

                        PdfPCell telefonoEmpresa = new PdfPCell(new Phrase(rs.getString("telefonosempresa"), fuenteDescripcionTablasLIGHT));
                        telefonoEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
                        telefonoEmpresa.setBorder(0);
                        PdfPCell fechaEmision = new PdfPCell(new Phrase(rs.getString("numerosseriecomprobante"), fuenteDescripcionTablasBOLD));
                        fechaEmision.setHorizontalAlignment(Element.ALIGN_CENTER);
                        fechaEmision.setBorder(0);
                        fechaEmision.setBorderWidthLeft(2);
                        fechaEmision.setBorderWidthRight(2);

                        encabezado.addCell(telefonoEmpresa);
                        encabezado.addCell(fechaEmision);

                        PdfPCell lema = new PdfPCell(new Phrase(rs.getString("lema"), fuenteDescripcionTablasLIGHT));
                        lema.setHorizontalAlignment(Element.ALIGN_LEFT);
                        lema.setBorder(0);
                        PdfPCell colNumberReference = new PdfPCell(new Phrase("N° REF. " + rs.getString("v.numero_referencia"), fuenteDescripcionTablasBOLD));
                        colNumberReference.setHorizontalAlignment(Element.ALIGN_CENTER);
                        colNumberReference.setBorder(0);
                        colNumberReference.setBorderWidthBottom(2);
                        colNumberReference.setBorderWidthLeft(2);
                        colNumberReference.setBorderWidthRight(2);
                        colNumberReference.setPaddingBottom(3);

                        encabezado.addCell(lema);
                        encabezado.addCell(colNumberReference);

                    }

                }
            } catch (SQLException e) {
            }
            document.add(encabezado);

            document.add(saltoLinea2);

            PdfPTable clientes = new PdfPTable(4);
            clientes.setWidthPercentage(100);
            float[] medidaTablaProveedor = {17f, 33f, 20f, 30f};
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
                        nameCustomer.setPaddingLeft(5);
                        nameCustomer.setBorder(0);
                        nameCustomer.setBorderColor(BaseColor.GRAY);
                        nameCustomer.setBorderWidthTop(1);
                        nameCustomer.setBorderWidthLeft(1);
                        PdfPCell datanameCustomer = new PdfPCell(new Phrase(rs.getString("v.nombre_cliente_pedido"), fuenteDescripcionTablasLIGHT));
                        datanameCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datanameCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datanameCustomer.setPaddingLeft(5);
                        datanameCustomer.setBorder(0);
                        datanameCustomer.setBorderWidthTop(1);
                        datanameCustomer.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(nameCustomer);
                        clientes.addCell(datanameCustomer);

                        PdfPCell adresCustomer = new PdfPCell(new Phrase("Dirección: ", fuenteDescripcionTablasBOLD));
                        adresCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        adresCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        adresCustomer.setPaddingLeft(5);
                        adresCustomer.setBorder(0);
                        adresCustomer.setBorderWidthTop(1);
                        adresCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataadresCustomer = new PdfPCell(new Phrase(rs.getString("direccionesclietes"), fuenteDescripcionTablasLIGHT));
                        dataadresCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataadresCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataadresCustomer.setPaddingLeft(5);
                        dataadresCustomer.setBorder(0);
                        dataadresCustomer.setBorderWidthTop(1);
                        dataadresCustomer.setBorderWidthRight(1);
                        dataadresCustomer.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(adresCustomer);
                        clientes.addCell(dataadresCustomer);

                        PdfPCell documentCustomer = new PdfPCell(new Phrase("N° Documento: ", fuenteDescripcionTablasBOLD));
                        documentCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        documentCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        documentCustomer.setPaddingLeft(5);
                        documentCustomer.setBorder(0);
                        documentCustomer.setBorderWidthLeft(1);
                        documentCustomer.setPaddingBottom(3);
                        documentCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell datadocumentCustomer = new PdfPCell(new Phrase(rs.getString("numerodocumentocliente"), fuenteDescripcionTablasLIGHT));
                        datadocumentCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datadocumentCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadocumentCustomer.setPaddingLeft(5);
                        datadocumentCustomer.setBorder(0);
                        datadocumentCustomer.setPaddingBottom(3);
                        datadocumentCustomer.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(documentCustomer);
                        clientes.addCell(datadocumentCustomer);

                        PdfPCell dateSaleCustomer = new PdfPCell(new Phrase("Fecha de emición: ", fuenteDescripcionTablasBOLD));
                        dateSaleCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dateSaleCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dateSaleCustomer.setPaddingLeft(5);
                        dateSaleCustomer.setBorder(0);
                        dateSaleCustomer.setPaddingBottom(3);
                        dateSaleCustomer.setBorderColor(BaseColor.GRAY);
                        PdfPCell datadateSaleCustomer = new PdfPCell(new Phrase(rs.getString("fechaventa"), fuenteDescripcionTablasLIGHT));
                        datadateSaleCustomer.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datadateSaleCustomer.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadateSaleCustomer.setPaddingLeft(5);
                        datadateSaleCustomer.setBorder(0);
                        datadateSaleCustomer.setBorderWidthRight(1);
                        datadateSaleCustomer.setPaddingBottom(3);
                        datadateSaleCustomer.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(dateSaleCustomer);
                        clientes.addCell(datadateSaleCustomer);

                        PdfPCell tipopago = new PdfPCell(new Phrase("Tipo de pago: ", fuenteDescripcionTablasBOLD));
                        tipopago.setHorizontalAlignment(Element.ALIGN_LEFT);
                        tipopago.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tipopago.setPaddingLeft(5);
                        tipopago.setBorder(0);
                        tipopago.setBorderWidthLeft(1);
                        tipopago.setPaddingBottom(3);
                        tipopago.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataTipopago = new PdfPCell(new Phrase(rs.getString("tipopagoventa"), fuenteDescripcionTablasLIGHT));
                        dataTipopago.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTipopago.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTipopago.setPaddingLeft(5);
                        dataTipopago.setBorder(0);
                        dataTipopago.setPaddingBottom(3);
                        dataTipopago.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(tipopago);
                        clientes.addCell(dataTipopago);

                        PdfPCell tipopagocompra = new PdfPCell(new Phrase("Tipo de venta: ", fuenteDescripcionTablasBOLD));
                        tipopagocompra.setHorizontalAlignment(Element.ALIGN_LEFT);
                        tipopagocompra.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tipopagocompra.setPaddingLeft(5);
                        tipopagocompra.setBorder(0);
                        tipopagocompra.setPaddingBottom(3);
                        tipopagocompra.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataTipopagocompra = new PdfPCell(new Phrase(rs.getString("tipopacompra"), fuenteDescripcionTablasLIGHT));
                        dataTipopagocompra.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataTipopagocompra.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataTipopagocompra.setPaddingLeft(5);
                        dataTipopagocompra.setBorder(0);
                        dataTipopagocompra.setBorderWidthRight(1);
                        dataTipopagocompra.setPaddingBottom(3);
                        dataTipopagocompra.setBorderColor(BaseColor.GRAY);

                        clientes.addCell(tipopagocompra);
                        clientes.addCell(dataTipopagocompra);

                        PdfPCell nameCompaniesAseguradora = new PdfPCell(new Phrase("Aseguradora:", fuenteDescripcionTablasBOLD));
                        nameCompaniesAseguradora.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nameCompaniesAseguradora.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nameCompaniesAseguradora.setPaddingLeft(5);
                        nameCompaniesAseguradora.setBorder(0);
                        nameCompaniesAseguradora.setBorderWidthLeft(1);
                        nameCompaniesAseguradora.setBorderColor(BaseColor.GRAY);
                        PdfPCell nameCompaniesAseguradoraData = new PdfPCell(new Phrase(nameCompanies, fuenteDescripcionTablasLIGHT));
                        nameCompaniesAseguradoraData.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nameCompaniesAseguradoraData.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nameCompaniesAseguradoraData.setPaddingLeft(5);
                        nameCompaniesAseguradoraData.setBorder(0);
                        nameCompaniesAseguradoraData.setColspan(3);
                        nameCompaniesAseguradoraData.setBorderWidthRight(1);
                        nameCompaniesAseguradoraData.setBorderColor(BaseColor.GRAY);
                        if (countCompanyAseguradora > 0) {
                            clientes.addCell(nameCompaniesAseguradora);
                            clientes.addCell(nameCompaniesAseguradoraData);
                        }
                        PdfPCell titleComents = new PdfPCell(new Phrase("Nota Adicional:", fuenteDescripcionTablasBOLD));
                        titleComents.setHorizontalAlignment(Element.ALIGN_LEFT);
                        titleComents.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        titleComents.setPaddingLeft(5);
                        titleComents.setBorder(0);
                        titleComents.setBorderWidthBottom(1);
                        titleComents.setBorderWidthLeft(1);
                        titleComents.setPaddingBottom(3);
                        titleComents.setBorderColor(BaseColor.GRAY);
                        PdfPCell dataComents = new PdfPCell(new Phrase(rs.getString("v.comentarios"), fuenteDescripcionTablasLIGHT));
                        dataComents.setHorizontalAlignment(Element.ALIGN_LEFT);
                        dataComents.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dataComents.setPaddingLeft(5);
                        dataComents.setBorder(0);
                        dataComents.setColspan(3);
                        dataComents.setBorderWidthRight(1);
                        dataComents.setBorderWidthBottom(1);
                        dataComents.setPaddingBottom(3);
                        dataComents.setBorderColor(BaseColor.GRAY);
                        clientes.addCell(titleComents);
                        clientes.addCell(dataComents);
                    }
                }
            } catch (SQLException e) {
            }

            document.add(clientes);
            document.add(saltoLinea1);

            PdfPTable ventas = new PdfPTable(7);
            ventas.setWidthPercentage(100);
            float[] medidatablaVentas = {7f, 40f, 13f, 10f, 10f, 10f, 10f};
            ventas.setWidths(medidatablaVentas);

            PdfPCell cantidad = new PdfPCell(new Phrase("Cant.", fuenteDescripcionTablasBOLD));
            cantidad.setHorizontalAlignment(Element.ALIGN_LEFT);
            cantidad.setBackgroundColor(BaseColor.WHITE);
            cantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cantidad.setBorder(0);
            cantidad.setBorderWidthLeft(1);
            cantidad.setBorderWidthTop(1);
            cantidad.setBorderWidthBottom(1);
            cantidad.setMinimumHeight(25);

            PdfPCell descripcion = new PdfPCell(new Phrase("Descripción ", fuenteDescripcionTablasBOLD));
            descripcion.setHorizontalAlignment(Element.ALIGN_LEFT);
            descripcion.setBackgroundColor(BaseColor.WHITE);
            descripcion.setVerticalAlignment(Element.ALIGN_MIDDLE);
            descripcion.setBorder(0);
            descripcion.setBorderWidthTop(1);
            descripcion.setBorderWidthBottom(1);
            descripcion.setMinimumHeight(25);

            PdfPCell umVentas = new PdfPCell(new Phrase("UM", fuenteDescripcionTablasBOLD));
            umVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            umVentas.setBackgroundColor(BaseColor.WHITE);
            umVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            umVentas.setBorder(0);
            umVentas.setBorderWidthTop(1);
            umVentas.setBorderWidthBottom(1);
            umVentas.setMinimumHeight(25);

            PdfPCell preciounitarioDeVentas = new PdfPCell(new Phrase("P. U.", fuenteDescripcionTablasBOLD));
            preciounitarioDeVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
            preciounitarioDeVentas.setBackgroundColor(BaseColor.WHITE);
            preciounitarioDeVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            preciounitarioDeVentas.setMinimumHeight(25);
            preciounitarioDeVentas.setBorder(0);
            preciounitarioDeVentas.setBorderWidthTop(1);
            preciounitarioDeVentas.setBorderWidthBottom(1);

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
            importeDeVentas.setBorderWidthRight(1);

            ventas.addCell(cantidad);
            ventas.addCell(descripcion);
            ventas.addCell(umVentas);
            ventas.addCell(preciounitarioDeVentas);
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
                    cantidadVentas.setMinimumHeight(15);
                    cantidadVentas.setBorder(0);
                    cantidadVentas.setBorderWidthLeft(1);
                    cantidadVentas.setBorderWidthBottom(1);

                    PdfPCell descripcionProducto = new PdfPCell(new Phrase(rs.getString("nombreproducto"), fuenteDescripcionTablasLIGHTSmall));
                    descripcionProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                    descripcionProducto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    descripcionProducto.setBorderColor(BaseColor.LIGHT_GRAY);
                    descripcionProducto.setMinimumHeight(15);
                    descripcionProducto.setBorder(0);
                    descripcionProducto.setBorderWidthBottom(1);

                    PdfPCell dataunidamedidaVentasProducto = new PdfPCell(new Phrase(rs.getString("unidadmedidaventa"), fuenteDescripcionTablasLIGHTSmall));
                    dataunidamedidaVentasProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                    dataunidamedidaVentasProducto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    dataunidamedidaVentasProducto.setBorderColor(BaseColor.LIGHT_GRAY);
                    dataunidamedidaVentasProducto.setMinimumHeight(15);
                    dataunidamedidaVentasProducto.setBorder(0);
                    dataunidamedidaVentasProducto.setBorderWidthBottom(1);

                    PdfPCell datapreciounitarioVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("precioventaproducto"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datapreciounitarioVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datapreciounitarioVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datapreciounitarioVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datapreciounitarioVentas.setMinimumHeight(15);
                    datapreciounitarioVentas.setBorder(0);
                    datapreciounitarioVentas.setBorderWidthBottom(1);

                    PdfPCell datprecioigvVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("preciosubtotal"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datprecioigvVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datprecioigvVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datprecioigvVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datprecioigvVentas.setMinimumHeight(15);
                    datprecioigvVentas.setBorder(0);
                    datprecioigvVentas.setBorderWidthBottom(1);

                    PdfPCell datapreciosubtotalVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("precioigv"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datapreciosubtotalVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datapreciosubtotalVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datapreciosubtotalVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datapreciosubtotalVentas.setMinimumHeight(15);
                    datapreciosubtotalVentas.setBorder(0);
                    datapreciosubtotalVentas.setBorderWidthBottom(1);

                    PdfPCell datimportVentas = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("totaldetalle"))).substring(1), fuenteDescripcionTablasLIGHTSmall));
                    datimportVentas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datimportVentas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    datimportVentas.setBorderColor(BaseColor.LIGHT_GRAY);
                    datimportVentas.setMinimumHeight(15);
                    datimportVentas.setBorder(0);
                    datimportVentas.setBorderWidthBottom(1);
                    datimportVentas.setBorderWidthRight(1);

                    ventas.addCell(cantidadVentas);
                    ventas.addCell(descripcionProducto);
                    ventas.addCell(dataunidamedidaVentasProducto);
                    ventas.addCell(datapreciounitarioVentas);
                    ventas.addCell(datprecioigvVentas);
                    ventas.addCell(datapreciosubtotalVentas);
                    ventas.addCell(datimportVentas);
                }
            } catch (SQLException e) {
            }

            document.add(ventas);

            PdfPTable footer = new PdfPTable(2);
            footer.setWidthPercentage(100);
            float[] sizeFooter = {85f, 15f};
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
                        PdfPCell datadivisa = new PdfPCell(new Phrase(rs.getString("divisaventa"), fuenteDescripcionTablasBOLDSamll));
                        datadivisa.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datadivisa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datadivisa.setMinimumHeight(15);
                        datadivisa.setBorder(0);

                        PdfPCell descuento = new PdfPCell(new Phrase("DESCUENTO", fuenteDescripcionTablasBOLDSamll));
                        descuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        descuento.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        descuento.setMinimumHeight(15);
                        descuento.setBorder(0);
                        PdfPCell datedescuento = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("v.descuento"))).substring(1) + " %", fuenteDescripcionTablasBOLDSamll));
                        datedescuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        datedescuento.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        datedescuento.setMinimumHeight(15);
                        datedescuento.setBorder(0);

                        PdfPCell othersDiscounts = new PdfPCell(new Phrase("OTROS DESCUENTOS", fuenteDescripcionTablasBOLDSamll));
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

            PdfPTable footerAdicional = new PdfPTable(8);
            footerAdicional.setWidthPercentage(100);
            float[] sizefooterAdicional = {8f, 11f, 10f, 11f, 14f, 11f, 14f, 11f};
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
                        vendedor.setBorderWidthBottom(1);
                        vendedor.setBorderColor(BaseColor.LIGHT_GRAY);
                        vendedor.setMinimumHeight(20);

                        PdfPCell nombrevendedor = new PdfPCell(new Phrase(rs.getString("nombrevendedor"), fuenteDescripcionTablasBOLDSamll));
                        nombrevendedor.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrevendedor.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombrevendedor.setBorder(0);
                        nombrevendedor.setBorderWidthTop(1);
                        nombrevendedor.setBorderWidthBottom(1);
                        nombrevendedor.setBorderColor(BaseColor.LIGHT_GRAY);
                        nombrevendedor.setMinimumHeight(20);
                        //CHANGE
                        PdfPCell SELLER = new PdfPCell(new Phrase("Vendedor", fuenteDescripcionTablasBOLD));
                        SELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        SELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        SELLER.setBorder(0);
                        SELLER.setBorderWidthTop(1);
                        SELLER.setBorderWidthBottom(1);
                        SELLER.setBorderColor(BaseColor.LIGHT_GRAY);
                        SELLER.setMinimumHeight(20);

                        PdfPCell NAMESELLER = new PdfPCell(new Phrase(rs.getString("v.seller"), fuenteDescripcionTablasBOLDSamll));
                        NAMESELLER.setHorizontalAlignment(Element.ALIGN_LEFT);
                        NAMESELLER.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        NAMESELLER.setBorder(0);
                        NAMESELLER.setBorderWidthTop(1);
                        NAMESELLER.setBorderWidthBottom(1);
                        NAMESELLER.setBorderColor(BaseColor.LIGHT_GRAY);
                        NAMESELLER.setMinimumHeight(20);

                        PdfPCell nombreimporte = new PdfPCell(new Phrase("Importe   " + rs.getString("prefijo_moneda"), fuenteDescripcionTablasBOLD));
                        nombreimporte.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombreimporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombreimporte.setBorder(0);
                        nombreimporte.setBorderWidthTop(1);
                        nombreimporte.setBorderWidthBottom(1);
                        nombreimporte.setBorderColor(BaseColor.LIGHT_GRAY);
                        nombreimporte.setMinimumHeight(20);

                        PdfPCell montoimporte = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("pago_importe"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        montoimporte.setHorizontalAlignment(Element.ALIGN_LEFT);
                        montoimporte.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        montoimporte.setBorder(0);
                        montoimporte.setBorderWidthTop(1);
                        montoimporte.setBorderWidthBottom(1);
                        montoimporte.setBorderColor(BaseColor.LIGHT_GRAY);
                        montoimporte.setMinimumHeight(20);

                        PdfPCell nombrevuelto = new PdfPCell(new Phrase("Devuelta   " + rs.getString("prefijo_moneda"), fuenteDescripcionTablasBOLD));
                        nombrevuelto.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrevuelto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        nombrevuelto.setBorder(0);
                        nombrevuelto.setBorderWidthTop(1);
                        nombrevuelto.setBorderWidthBottom(1);
                        nombrevuelto.setBorderColor(BaseColor.LIGHT_GRAY);
                        nombrevuelto.setMinimumHeight(20);

                        PdfPCell montovuelto = new PdfPCell(new Phrase(currencys.formatCurrency(Double.parseDouble(rs.getString("vuelto_importe"))).substring(1), fuenteDescripcionTablasBOLDSamll));
                        montovuelto.setHorizontalAlignment(Element.ALIGN_LEFT);
                        montovuelto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        montovuelto.setBorder(0);
                        montovuelto.setBorderColor(BaseColor.LIGHT_GRAY);
                        montovuelto.setBorderWidthTop(1);
                        montovuelto.setBorderWidthBottom(1);
                        montovuelto.setMinimumHeight(20);

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
            } catch (Exception e) {
            }

            document.add(footerAdicional);
            document.add(saltoLinea1);

            try {
                int contFooterAdicional = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contFooterAdicional++;
                    if (contFooterAdicional <= 1) {
                        Paragraph textoagradecimiento = new Paragraph(rs.getString("pcv.parametro_agradecimiento"), fuenteDescripcionTablasBOLD);
                        textoagradecimiento.setAlignment(Element.ALIGN_CENTER);
                        Paragraph textoinformacion = new Paragraph(rs.getString("pcv.parametro_informacion"), fuenteDescripcionTablasBOLD);
                        textoinformacion.setAlignment(Element.ALIGN_CENTER);
                        Paragraph textFirma = new Paragraph("----------------------------             ----------------------------\n"
                                + "ENTREGADO POR:               RECIBIDO POR:", fuenteDescripcionTablasLIGHT);
                        textFirma.setAlignment(Element.ALIGN_CENTER);

                        document.add(textoagradecimiento);
                        document.add(saltoLinea1);
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
        } catch (DocumentException | IOException ex) {
        }
    }

}

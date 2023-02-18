package controller;

import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerReportSales {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";
       CurrencyFormat currencys = new CurrencyFormat();
    public DefaultTableModel getSales(String dateStart, String dateEnd) {
        DefaultTableModel model;
        String[] headers = {"Clientes",
            "Comprobante",
            "Igv",
            "Sub Total",
            "Total",
            "Tipo de pago",
            "Fec. Emición",
            "Estado"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT c.full_name,CONCAT(cv.voucher,' ',v.serie, '-', v.number_voucher) AS voucherSales, "
                + "DATE_FORMAT(v.date_emit, '%d/%m/%Y %r') AS dates, v.total, v.subtotal, v.igv,v.state, v.type_payment "
                + "FROM sales v "
                + "INNER JOIN customer c ON "
                + "c.id = v.idcustomer "
                + "INNER JOIN vouchers cv ON "
                + "cv.id = v.idvoucher "
                + "WHERE DATE_FORMAT(v.date_emit,'%Y-%m-%d') BETWEEN '" + dateStart + "' AND '" + dateEnd + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("c.full_name");
                registers[1] = rs.getString("voucherSales");
                registers[2] = currencys.formatCurrency(Double.parseDouble(rs.getString("v.igv"))).substring(1);
                registers[3] = currencys.formatCurrency(Double.parseDouble(rs.getString("v.subtotal"))).substring(1);
                registers[4] = currencys.formatCurrency(Double.parseDouble(rs.getString("v.total"))).substring(1);
                registers[5] = rs.getString("v.type_payment");
                registers[6] = rs.getString("dates");
                registers[7] = rs.getString("v.state");
                model.addRow(registers);
            }

            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}

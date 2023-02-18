package controller;

import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerReportShopping {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";
 CurrencyFormat currencys = new CurrencyFormat();
    public DefaultTableModel getShopping(String dateStart, String dateEnd) {
        DefaultTableModel model;
        String[] headers = {"Proveedor",
            "Comprobante",
            "Igv",
            "Sub Total",
            "Total",
            "Fec. Emición"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT p.full_name,CONCAT('COMPRA ',s.serie, '', s.number_voucher) AS vouchersShooping, s.total, s.subtotal, "
                + "s.igv, DATE_FORMAT(s.date_shooping, '%Y/%m/%d %r') AS dates "
                + "FROM shopping s "
                + "INNER JOIN supplier p ON "
                + "p.id = s.idsupplier "
                + "WHERE DATE_FORMAT(s.date_shooping,'%Y-%m-%d') BETWEEN '" + dateStart + "' AND '" + dateEnd + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("p.full_name");
                registers[1] = rs.getString("vouchersShooping");
                 registers[2] = currencys.formatCurrency(Double.parseDouble(rs.getString("s.igv"))).substring(1);
                registers[3] = currencys.formatCurrency(Double.parseDouble(rs.getString("s.subtotal"))).substring(1);
                registers[4] = currencys.formatCurrency(Double.parseDouble(rs.getString("s.total"))).substring(1);
                registers[5] = rs.getString("dates");
                model.addRow(registers);
            }

            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}

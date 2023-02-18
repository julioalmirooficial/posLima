package controller;

import controllerpublic.CurrencyFormat;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerSearchProductForDate {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";
    CurrencyFormat currencys = new CurrencyFormat();

    public DefaultTableModel getShoppindDetails(String dateStart, String dateEnd) {
        DefaultTableModel model;
        String[] headers = {"Proveedor",
                            "Productos",
                            "Cantidad comprada",
                            "P. Compra",
                            "Fecha de compra"};
        
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT s.full_name,p.title, dc.quantity, dc.price_shopping, "
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
                registers[0] = rs.getString("s.full_name");
                registers[1] = rs.getString("p.title");
                registers[2] = rs.getString("dc.quantity");
                registers[3] = currencys.formatCurrency(Double.parseDouble(rs.getString("dc.price_shopping"))).substring(1);
                registers[4] = rs.getString("dates");
                model.addRow(registers);
            }

            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}

package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerReportProducts {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getproduct() {
        DefaultTableModel model;
        String[] headers = {"#",
            "Productos",
            "Tipo",
            "Descuento",
            "Utilidad",
            "Stock",
            "P. Venta",
            "p. Compra"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT p.title,p.bar_code, p.discount, p.utility, p.stock, p.price_shopping,p.price_sale, tp.description "
                + "FROM products p "
                + "INNER JOIN type_product tp ON "
                + "tp.id = p.idtype_product WHERE p.state =1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("p.bar_code");
                registers[1] = rs.getString("p.title");
                registers[2] = rs.getString("tp.description");
                registers[3] = rs.getString("p.discount");
                registers[4] = rs.getString("p.utility");
                registers[5] = rs.getString("p.stock");
                registers[6] = rs.getString("p.price_sale");
                registers[7] = rs.getString("p.price_shopping");
                model.addRow(registers);
            }

            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}

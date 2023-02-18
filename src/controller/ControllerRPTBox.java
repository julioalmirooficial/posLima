package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerRPTBox {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getBox(String search) {
        DefaultTableModel model;
        String[] headers = {"Usuario", "Fec. Apertura", "Fec. Cierre", "M. Apertura", "Efectivo", "Transferencia","Tarjeta","Cheque","Venta Total"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT u.full_name, b.opening_date, b.closing_date, "
                + "b.amount_open, b.amount_closing, b.amount_cash, b.amount_cheque,"
                + " b.amount_transfer, b.amount_visa, b.amount_closing "
                + "FROM box_sales b "
                + "INNER JOIN users u ON "
                + "u.id = b.iduser WHERE CONCAT(u.full_name)like '%" + search + "%' ORDER BY b.id DESC LIMIT 200";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("u.full_name");
                registers[1] = rs.getString("b.opening_date");
                registers[2] = rs.getString("b.closing_date");
                registers[3] = rs.getString("b.amount_open");
                registers[4] = rs.getString("b.amount_cash");
                registers[5] = rs.getString("b.amount_transfer");
                registers[6] = rs.getString("b.amount_visa");
                registers[7] = rs.getString("b.amount_cheque");
                registers[8] = rs.getString("b.amount_closing");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

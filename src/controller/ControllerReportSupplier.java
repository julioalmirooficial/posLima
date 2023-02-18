package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerReportSupplier {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getSupplier() {
        DefaultTableModel model;
        String[] headers = {"Razón social",
            "Contactos",
            "Dirección",
            "RUC"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        query = "SELECT * FROM supplier";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("full_name");
                registers[1] = rs.getString("cellphone");
                registers[2] = rs.getString("adress");
                registers[3] = rs.getString("ruc");
                model.addRow(registers);
            }

            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}

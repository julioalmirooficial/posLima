package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelTypeProduct;

public class ControllerTypeproduct {
    
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getTypeProduct(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Tipos de productos"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM type_product t "
                + "WHERE CONCAT(t.description)like '%" + search + "%' ORDER BY t.id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("id");
                registers[1] = rs.getString("description");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertTypeProduct(ModelTypeProduct dts) {
        query = "INSERT INTO type_product (description) "
                + "VALUES(?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescription());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateTypeProduct(ModelTypeProduct dts) {
        query = "UPDATE type_product SET "
                + "description=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescription());
            pst.setInt(2, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteTypeProduct(ModelTypeProduct dts) {
        query = "DELETE FROM type_product WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }
}

package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelSupplier;

public class ControllerSupplier {
    
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getSupplier(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Razón social","RUC","Dirección","Celular / telefono","Estado"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM supplier "
                + "WHERE CONCAT(full_name,' ',ruc)like '%" + search + "%' ORDER BY id DESC LIMIT 200";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("id");
                registers[1] = rs.getString("full_name");
                registers[2] = rs.getString("ruc");
                registers[3] = rs.getString("adress");
                registers[4] = rs.getString("cellphone");
                registers[5] = rs.getString("state").equals("1")?"ACTIVO":"INACTIVO";
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertSupplier(ModelSupplier dts) {
        query = "INSERT INTO supplier (full_name, ruc, adress, cellphone) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getNumberDocument());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getCellPhone());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateSupplier(ModelSupplier dts) {
        query = "UPDATE supplier SET "
                + "full_name=?, ruc=?, adress=?, cellphone=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
           pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getNumberDocument());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getCellPhone());
            pst.setInt(5, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteSupplier(ModelSupplier dts) {
        query = "DELETE FROM supplier WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean inactiveSupplier(ModelSupplier dts) {
        query = "UPDATE supplier SET state = 0 WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    //LISTA DE PROVEEDOR PARA EL MODAL
    public DefaultTableModel getSupplierModal(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Razón social","RUC"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM supplier "
                + "WHERE CONCAT(full_name,' ',ruc)like '%" + search + "%' AND state = 1 ORDER BY id DESC LIMIT 30";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("id");
                registers[1] = rs.getString("full_name");
                registers[2] = rs.getString("ruc");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

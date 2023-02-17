package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelCustomer;

public class ControllerCustomer {
    
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getCustomer(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Nombres y apellidos","Correo","Dircción","Tipo Documento","N° Documento","Estado"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM customer "
                + "WHERE CONCAT(full_name,' ',number_document)like '%" + search + "%' ORDER BY id DESC LIMIT 40";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("id");
                registers[1] = rs.getString("full_name");
                registers[2] = rs.getString("email");
                registers[3] = rs.getString("adress");
                registers[4] = rs.getString("type_document");
                registers[5] = rs.getString("number_document");
                registers[6] = rs.getString("state").equals("1")?"ACTIVO":"INACTIVO";
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertCustomer(ModelCustomer dts) {
        query = "INSERT INTO customer (full_name,email,adress,type_document,number_document) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getEmail());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getTypeDocument());
            pst.setString(5, dts.getNumberDocument());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateCustomer(ModelCustomer dts) {
        query = "UPDATE customer SET "
                + "full_name=?,email=?,adress=?,type_document=?,number_document=?,state=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getEmail());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getTypeDocument());
            pst.setString(5, dts.getNumberDocument());
            pst.setBoolean(6, dts.isState());
            pst.setInt(7, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteCustomer(ModelCustomer dts) {
        query = "DELETE FROM customer WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean inactiveCustomer(ModelCustomer dts) {
        query = "UPDATE customer SET state = 0 WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ArrayList searchCustomerSale(String rumberDocument) {

      ArrayList data = new ArrayList();

        query = "SELECT * FROM customer "
                + "WHERE number_document = '"+rumberDocument + "' AND state = 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                data.add(rs.getString("id"));
                data.add(rs.getString("full_name"));
                data.add(rs.getString("adress"));
                data.add(rs.getString("number_document"));
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

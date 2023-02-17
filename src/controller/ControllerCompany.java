package controller;

import components.WindowCompany;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ModelCompany;

public class ControllerCompany {
    
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public void getCompany() {
        query = "SELECT * FROM company ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                WindowCompany.idUpdateData.setText(rs.getString("id"));
                WindowCompany.lblNameCommpany.setText(rs.getString("name_company"));
                WindowCompany.txtNameCompany.setText(rs.getString("name_company"));
                WindowCompany.txtAdress.setText(rs.getString("adress"));
                WindowCompany.txtCellPhone.setText(rs.getString("cellphone"));
                WindowCompany.txtEmail.setText(rs.getString("email"));
                WindowCompany.txtRUC.setText(rs.getString("ruc"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public boolean existCompany() {
        query = "SELECT * FROM company ";
        boolean exist = false;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) exist = true;
            return exist;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean insertCompany(ModelCompany dts) {
        query = "INSERT INTO company (name_company,ruc,adress, email, cellphone) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getNumberDocument());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getEmail());
            pst.setString(5, dts.getCellPhone());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateCompany(ModelCompany dts) {
        query = "UPDATE company SET "
                + "name_company=?,ruc=?,adress=?, email=?, cellphone=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getNumberDocument());
            pst.setString(3, dts.getAdress());
            pst.setString(4, dts.getEmail());
            pst.setString(5, dts.getCellPhone());
            pst.setInt(6, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

}

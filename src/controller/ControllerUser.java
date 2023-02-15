package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelUser;

public class ControllerUser {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getUser(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Nombres y apellidos", "Correo","PASSOWRD", "Usuario", "N° Documento", "Tipo", "Estado"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT u.id, u.full_name, u.email, u.password, u.user_name, "
                + "u.number_document, u.type, IF(u.state = 1, 'ACTIVO', 'INACTIVO') AS stateUser "
                + "FROM users u "
                + "WHERE CONCAT(u.full_name)like '%" + search + "%' ORDER BY u.id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("u.id");
                registers[1] = rs.getString("u.full_name");
                registers[2] = rs.getString("u.email");
                registers[3] = rs.getString("u.password");
                registers[4] = rs.getString("u.user_name");
                registers[5] = rs.getString("u.number_document");
                registers[6] = rs.getString("u.type");
                registers[7] = rs.getString("stateUser");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertUser(ModelUser dts) {
        query = "INSERT INTO users (full_name, email, password, user_name, number_document, type) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getEmail());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getUserName());
            pst.setString(5, dts.getNumberDocument());
            pst.setString(6, dts.getTypeUser());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateUser(ModelUser dts) {
        query = "UPDATE users SET "
                + "full_name=?, email=?, password=?, user_name=?, number_document=?, type=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getFullName());
            pst.setString(2, dts.getEmail());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getUserName());
            pst.setString(5, dts.getNumberDocument());
            pst.setString(6, dts.getTypeUser());
            pst.setInt(7, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(ModelUser dts) {
        query = "DELETE FROM users WHERE id=?";
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

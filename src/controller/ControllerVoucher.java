package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelVoucher;

public class ControllerVoucher {
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getVoucher(String search) {

        DefaultTableModel model;
        String[] headers = {"ID", "Descripción","Serie","N° Inicio","N° Actual","N° Final","Estado"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM vouchers  "
                + "WHERE CONCAT(voucher)like '%" + search + "%' ORDER BY id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("id");
                registers[1] = rs.getString("voucher");
                registers[2] = rs.getString("serie");
                registers[3] = rs.getString("number_init");
                registers[4] = rs.getString("number_current");
                registers[5] = rs.getString("number_end");
                registers[6] = rs.getString("state").equals("1")?"ACTIVO":"INACTIVO";
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertVoucher(ModelVoucher dts) {
        query = "INSERT INTO vouchers (voucher,serie,number_init,number_current,number_end) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getVoucher());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNumberStart());
            pst.setString(4, dts.getNumberCurrent());
            pst.setString(5, dts.getNumberEnd());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateVoucher(ModelVoucher dts) {
        query = "UPDATE vouchers SET "
                + "voucher=?,serie=?,number_init=?,number_current=?,number_end=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getVoucher());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNumberStart());
            pst.setString(4, dts.getNumberCurrent());
            pst.setString(5, dts.getNumberEnd());
            pst.setInt(6, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteVoucher(ModelVoucher dts) {
        query = "UPDATE vouchers SET state = 0 WHERE id=?";
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

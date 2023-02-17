package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelVoucher;

public class ControllerGetNumberVoucher {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public ArrayList getNumberCurrent(String idVoucher) {

        ArrayList data = new ArrayList();

        query = "SELECT number_current,serie "
                + "FROM vouchers  "
                + "WHERE id = " + idVoucher;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formater = new DecimalFormat("00000000");
            String numberOrigin = "00000000";
            while (rs.next()) {
                if (rs.getString("number_current").equals("00000000")) {
                    numberOrigin = "0";
                } else {
                    numberOrigin = rs.getString("number_current").replaceAll("^0+", "");
                }

                data.add(String.valueOf(formater.format(Integer.parseInt(numberOrigin) + 1)));
                data.add(rs.getString("serie"));
            }
            rs.first();
            return data;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO " + e);
            return null;
        }
    }

    public boolean updateVouchers(ModelVoucher dts) {
        query = "UPDATE vouchers SET "
                + "number_current=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNumberCurrent());
            pst.setInt(2, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public String numberVoucherValidate(String idVoucher) {
        query = "SELECT number_end "
                + "FROM vouchers "
                + "WHERE id = " + idVoucher;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formater = new DecimalFormat("00000000");
            String numberOrigin = "00000000";
            while (rs.next()) {
                if (rs.getString("number_end").equals("00000000")) {
                    numberOrigin = "0";
                } else {
                    numberOrigin = rs.getString("number_end").replaceAll("^0+", "");
                }
            }

            rs.first();
            return formater.format(Integer.parseInt(numberOrigin) + 1);
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO " + e);
            return null;
        }
    }

}

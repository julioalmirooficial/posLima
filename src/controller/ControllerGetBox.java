package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControllerGetBox {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public String getCheque(String idUser) {
        String data = null;
        query = "SELECT SUM(total) AS ventas FROM sales "
                + "WHERE state = 'EFECTUADO' AND type_payment = 'CHEQUE'  AND DATE_FORMAT(date_emit,'%Y-%m-%d') = CURDATE()  AND iduser =  " + idUser;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                if (rs.getString("ventas") != null) {
                    data = rs.getString("ventas");
                } else {
                    data = "0.00";
                }
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "0.00";
        }
    }

    public String getVisa(String idUser) {
        String data = null;
        query = "SELECT SUM(total) AS ventas FROM sales "
                + "WHERE state = 'EFECTUADO' AND type_payment = 'TARJETA'  AND DATE_FORMAT(date_emit,'%Y-%m-%d') = CURDATE()  AND iduser =  " + idUser;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                if (rs.getString("ventas") != null) {
                    data = rs.getString("ventas");
                } else {
                    data = "0.00";
                }
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "0.00";
        }
    }

    public String getTransfer(String idUser) {
        String data = null;
        query = "SELECT SUM(total) AS ventas FROM sales "
                + "WHERE state = 'EFECTUADO' AND type_payment = 'TRANSFERENCIA'  AND DATE_FORMAT(date_emit,'%Y-%m-%d') = CURDATE()  AND iduser =  " + idUser;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                if (rs.getString("ventas") != null) {
                    data = rs.getString("ventas");
                } else {
                    data = "0.00";
                }
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "0.00";
        }
    }

    public String getCash(String idUser) {
        String data = null;
        query = "SELECT SUM(total) AS ventas FROM sales "
                + "WHERE state = 'EFECTUADO' AND type_payment = 'EFECTIVO' AND DATE_FORMAT(date_emit,'%Y-%m-%d') = CURDATE() AND iduser =  " + idUser;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                if (rs.getString("ventas") != null) {
                    data = rs.getString("ventas");
                } else {
                    data = "0.00";
                }
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "0.00";
        }
    }
}

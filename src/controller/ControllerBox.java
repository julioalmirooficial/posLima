package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelBox;

public class ControllerBox {
    
    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";
    /*
    @param idUser
    return SI EL USUARIO YA APERTURO LA CAJA
    */ 
    public boolean validateBoxOpening(String idUser) {

        boolean data = false;
        query = "SELECT * FROM box_sales WHERE iduser = "+idUser+" AND state = 0 AND DATE_FORMAT(opening_date,'%Y-%m-%d')  = CURDATE()";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next()) data = true;
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //METODO PARA OBTNER LA APERTURA DE CAJA
    public ArrayList getOpeningDate(String idUser) {

        ArrayList data = new ArrayList();
        query = "SELECT opening_date,id,amount_open  FROM box_sales WHERE iduser = "+idUser+" AND state = 0 AND DATE_FORMAT(opening_date,'%Y-%m-%d')  = CURDATE()";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {                
                data.add(rs.getString("id"));
                data.add(rs.getString("opening_date"));
                data.add(rs.getString("amount_open"));
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    //METODO PARA OBTNER LA APERTURA DE CAJA
    public ArrayList getOpeningDateClosed(String idUser) {

        ArrayList data = new ArrayList();
        query = "SELECT amount_open  FROM box_sales WHERE iduser = "+idUser+" AND state = 1 AND DATE_FORMAT(opening_date,'%Y-%m-%d')  = CURDATE()";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {                
                data.add(rs.getString("amount_open"));
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    //METODO PARA OBTNER LA APERTURA DE CAJA
    public boolean getClosedDate(String idUser) {

        boolean data = false;
        query = "SELECT opening_date,id FROM box_sales WHERE iduser = "+idUser+" AND state = 1 AND DATE_FORMAT(opening_date,'%Y-%m-%d')  = CURDATE()";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next()) data = true;
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
//METODO PARA APERTURAR LA CAJA
    public boolean insertBox(ModelBox dts) {
        query = "INSERT INTO box_sales (iduser,amount_open) "
                + "VALUES(?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdUser());
            pst.setDouble(2, dts.getAmountOPen());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //METODO PARA CERRAR LA CAJA
    public boolean updateBox(ModelBox dts) {
        query = "UPDATE box_sales SET "
                + "closing_date=?, amount_closing=?, amount_transfer=?, amount_cheque=?, amount_cash=?, amount_visa=?, state = 1 WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getClodingDate());
            pst.setDouble(2, dts.getAmountClosing());
            pst.setDouble(3, dts.getAmountTransfer());
            pst.setDouble(4, dts.getAmountCheque());
            pst.setDouble(5, dts.getAmountCash());
            pst.setDouble(6, dts.getAmountVisa());
            pst.setInt(7, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}

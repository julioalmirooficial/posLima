package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ModelDetailSales;
import model.ModelSales;

public class ControllerSales {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public boolean insertSales(ModelSales dts) {
        query = "INSERT INTO sales (iduser, idcustomer, idvoucher, "
                + "number_voucher, serie, type_payment, number_oprations, entity_bank,"
                + " total, subtotal, igv, iva_aplicate, amount_paid, amount_returned) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdUser());
            pst.setInt(2, dts.getIdCustomer());
            pst.setInt(3, dts.getIdVoucher());
            pst.setString(4, dts.getNumberVoucher());
            pst.setString(5, dts.getSerie());
            pst.setString(6, dts.getTypePayment());
            pst.setString(7, dts.getNumberOperation());
            pst.setString(8, dts.getEntityBank());
            pst.setDouble(9, dts.getTotal());
            pst.setDouble(10, dts.getSubTotal());
            pst.setDouble(11, dts.getIgv());
            pst.setDouble(12, dts.getIgvAplicate());
            pst.setDouble(13, dts.getAmountPaid());
            pst.setDouble(14, dts.getAmountReturn());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean insertDetailSales(ModelDetailSales dts) {
        query = "INSERT INTO details_sales (idsale, idproduct, price_unit, quantity, discount, igv, subtotal, total, unit_measure) "
                + "VALUES((SELECT MAX(id) FROM sales),?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdProduct());
            pst.setDouble(2, dts.getPriceUnit());
            pst.setInt(3, dts.getQuantity());
            pst.setInt(4, dts.getDiscount());
            pst.setDouble(5, dts.getIgv());
            pst.setDouble(6, dts.getSubTotal());
            pst.setDouble(7, dts.getTotal());
            pst.setString(8, dts.getUnitMeasure());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public void discountStock(String idProduct, String quantity) {
        query = "UPDATE products SET stock = stock - " + quantity + " WHERE id = " + idProduct;
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String  lastIDSales() {
        query = "SELECT MAX(id) AS id FROM sales ";
        String id = null;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                id = rs.getString("id");
            }
            return id;
        } catch (SQLException e) {
            System.out.println(e);
            return "0";
        }
    }
}

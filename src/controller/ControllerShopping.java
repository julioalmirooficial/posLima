package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ModelDetailShopping;
import model.ModelShopping;

public class ControllerShopping {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public boolean insertShopping(ModelShopping dts) {
        query = "INSERT INTO shopping (iduser, idsupplier, idvoucher, total,subtotal, igv, discount,  number_voucher, serie) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdUser());
            pst.setInt(2, dts.getIdSupplier());
            pst.setInt(3, dts.getIdVoucher());
            pst.setDouble(4, dts.getTotal());
            pst.setDouble(5, dts.getSubTotal());
            pst.setDouble(6, dts.getIgv());
            pst.setDouble(7, dts.getDiscount());
            pst.setString(8, dts.getNumberVoucher());
            pst.setString(9, dts.getSerie());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean insertDetailShopping(ModelDetailShopping dts) {
        query = "INSERT INTO details_shopping (idshopping,idproduct, quantity, price_sale, price_shopping) "
                + "VALUES((SELECT MAX(id) FROM shopping),?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdProduct());
            pst.setInt(2, dts.getQuantity());
            pst.setDouble(3, dts.getPriceSales());
            pst.setDouble(4, dts.getPriceShopping());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public void updateStock(String idProduct, String quantity, String priceShopping, String priceSale,String utility) {
        query = "UPDATE products SET stock = stock + " + quantity + ", price_shopping="+priceShopping+",price_sale="+priceSale+" , utility = "+utility+" WHERE id = " + idProduct;
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR AL ACTULIZAR EL STOCK");
        }
    }
}

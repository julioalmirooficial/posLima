package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProducts;

public class ControllerProducts {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public DefaultTableModel getProducts(String search) {

        DefaultTableModel model;
        String[] headers = {
            "ID", "IDPRODUCT",
            "COD. BARRA","PRODUCTO",
            "DESCRIPCIÓN","TIPO",
            "Desc. (%)","Utilidad (%)",
            "Stock","Stock Min.",
            "Precio de Compra","Precio de venta",
            "¿Con stock?","state"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT  p.id, p.idtype_product, tp.description AS typeProducts, "
                + "p.bar_code, p.title, p.description, p.discount, p.utility, "
                + "p.stock, p.stock_minimun, p.price_shopping, p.price_sale, "
                + "IF(p.for_stock = 1,'SI','NO') AS ventaconstock, IF(p.state = 1, 'ACTIVO','INACTIVO') AS state "
                + "FROM products p "
                + "INNER JOIN type_product tp ON "
                + "tp.id = p.idtype_product "
                + "WHERE CONCAT(p.title, ' ',p.bar_code,' ', tp.description)like '%" + search + "%' ORDER BY p.id DESC LIMIT 300";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("p.id");
                registers[1] = rs.getString("p.idtype_product");
                registers[2] = rs.getString("p.bar_code");
                registers[3] = rs.getString("p.title");
                registers[4] = rs.getString("p.description");
                registers[5] = rs.getString("typeProducts");
                registers[6] = rs.getString("p.discount");
                registers[7] = rs.getString("p.utility");
                registers[8] = rs.getString("p.stock");
                registers[9] = rs.getString("p.stock_minimun");
                registers[10] = rs.getString("p.price_shopping");
                registers[11] = rs.getString("p.price_sale");
                registers[12] = rs.getString("ventaconstock");
                registers[13] = rs.getString("state");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertProducts(ModelProducts dts) {
        query = "INSERT INTO products "
                + "(idtype_product, bar_code, title, description, discount, utility, stock, stock_minimun, price_shopping, price_sale, for_stock) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdTypeProduct());
            pst.setString(2, dts.getBarCode());
            pst.setString(3, dts.getTitle());
            pst.setString(4, dts.getDescription());
            pst.setFloat(5, dts.getDiscount());
            pst.setFloat(6, dts.getUtility());
            pst.setInt(7, dts.getStock());
            pst.setInt(8, dts.getStockMinimun());
            pst.setDouble(9, dts.getPriceShopping());
            pst.setDouble(10, dts.getPriceSale());
            pst.setBoolean(11, dts.isForStock());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateProducts(ModelProducts dts) {
        query = "UPDATE products SET "
                + "bar_code=?, title=?, description=?, discount=?, utility=?, stock=?, stock_minimun=?, price_shopping=?, price_sale=?, for_stock=?,state=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getBarCode());
            pst.setString(2, dts.getTitle());
            pst.setString(3, dts.getDescription());
            pst.setFloat(4, dts.getDiscount());
            pst.setFloat(5, dts.getUtility());
            pst.setInt(6, dts.getStock());
            pst.setInt(7, dts.getStockMinimun());
            pst.setDouble(8, dts.getPriceShopping());
            pst.setDouble(9, dts.getPriceSale());
            pst.setBoolean(10, dts.isForStock());
            pst.setBoolean(11, dts.isState());
            pst.setInt(12, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteProducts(ModelProducts dts) {
        query = "DELETE FROM products WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean verifiBarCode(String barCode){
        boolean exist = false;

        query = "SELECT  * FROM products  WHERE bar_code = '"+barCode+"'";
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
    
    // METODOS PARA EL MODAL
    public DefaultTableModel getProductsModalShopping(String search) {

        DefaultTableModel model;
        String[] headers = {
            "ID", "COD. BARRA","PRODUCTO", "Stock", "Precio de Compra","Precio de venta","utilidad"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT  p.id, p.bar_code, p.title, p.stock, p.price_shopping, p.price_sale,p.utility "
                + "FROM products p "
                + "INNER JOIN type_product tp ON "
                + "tp.id = p.idtype_product "
                + "WHERE CONCAT(p.title, ' ',p.bar_code)like '%" + search + "%' ORDER BY p.id DESC LIMIT 30";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("p.id");
                registers[1] = rs.getString("p.bar_code");
                registers[2] = rs.getString("p.title");
                registers[3] = rs.getString("p.stock");
                registers[4] = rs.getString("p.price_shopping");
                registers[5] = rs.getString("p.price_sale");
                registers[6] = rs.getString("p.utility");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel getProductsModalSales(String search) {

        DefaultTableModel model;
        String[] headers = {
            "ID", "COD. BARRA","PRODUCTO", "Stock", "Precio","Descuento","con stock"};
        String[] registers = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT  p.id, p.bar_code, p.title, p.stock, p.price_sale,p.for_stock,p.discount "
                + "FROM products p "
                + "WHERE CONCAT(p.title, ' ',p.bar_code)like '%" + search + "%' AND state = 1 ORDER BY p.id DESC LIMIT 30";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registers[0] = rs.getString("p.id");
                registers[1] = rs.getString("p.bar_code");
                registers[2] = rs.getString("p.title");
                registers[3] = rs.getString("p.stock");
                registers[4] = rs.getString("p.price_sale");
                registers[5] = rs.getString("p.discount");
                registers[6] = rs.getString("p.for_stock");
                model.addRow(registers);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

package controllerpublic;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class cbxVouchers {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    private int id;
    private String description;

    public cbxVouchers() {
    }

    public cbxVouchers(int id, String description) {
        this.id = id;
        this.description = description;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     

 
    

    public void viewVouchers(JComboBox<cbxVouchers> vouchers) {
        try {
            query = "SELECT * FROM vouchers WHERE id != 3 ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                vouchers.addItem(new cbxVouchers(
                        rs.getInt("id"),
                        rs.getString("voucher")
                )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(cbxVouchers.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR COPROBANTES " + description);
        }
    }

    @Override
    public String toString() {
        return description;
    }
}

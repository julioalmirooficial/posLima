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

public class cbxTypeProducts {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    private int id;
    private String description;

    public cbxTypeProducts() {
    }

    public cbxTypeProducts(int id, String description) {
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
     

 
    

    public void viewTypeProduct(JComboBox<cbxTypeProducts> typeProducts) {
        try {
            query = "SELECT * FROM type_product ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                typeProducts.addItem(new cbxTypeProducts(
                        rs.getInt("id"),
                        rs.getString("description")
                )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(cbxTypeProducts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR UNIDADES DE MEDIDA " + description);
        }
    }

    @Override
    public String toString() {
        return description;
    }
}

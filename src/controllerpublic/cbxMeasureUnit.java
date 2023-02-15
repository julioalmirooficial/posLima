package controllerpublic;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class cbxMeasureUnit {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    private int id;
    private String unitProduct;

    public cbxMeasureUnit() {
    }

    public cbxMeasureUnit(int id, String unitProduct) {
        this.id = id;
        this.unitProduct = unitProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitProduct() {
        return unitProduct;
    }

    public void setUnitProduct(String unitProduct) {
        this.unitProduct = unitProduct;
    }
 
    

    public void viewTypeUnits(JComboBox<cbxMeasureUnit> typeMeasureUnit) {
        try {
            query = "SELECT um.id, um.descripcion FROM unidad_medida um ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                typeMeasureUnit.addItem(new cbxMeasureUnit(
                        rs.getInt("um.id"),
                        rs.getString("um.descripcion")
                )
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(cbxMeasureUnit.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR UNIDADES DE MEDIDA " + unitProduct);
        }
    }

    @Override
    public String toString() {
        return unitProduct;
    }
}

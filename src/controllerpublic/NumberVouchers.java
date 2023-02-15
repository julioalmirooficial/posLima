package controllerpublic;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class NumberVouchers {

    private ConnectionDB conectDB = new ConnectionDB();
    private Connection cn = conectDB.conect();
    private String query = "";

    public String viewNumberVouchers(String idVoucher, String idStore) {
        query = "SELECT c.numero_actual "
                + "FROM comprobantes c "
                + "WHERE c.idtipo_comprobante = " + idVoucher + " AND c.idalmacen = " + idStore;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formateador = new DecimalFormat("00000000");
            String numeroOrig = "00000000";
            String registro[] = new String[1];
            while (rs.next()) {
                if (rs.getString("c.numero_actual").equals("00000000")) {
                    numeroOrig = "0";
                } else {
                    numeroOrig = registro[0] = rs.getString("c.numero_actual").replaceAll("^0+", "");
                }
            }

            rs.first();
            String format = formateador.format(Integer.parseInt(numeroOrig) + 1);
            return format;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO" + e);
            return null;
        }
    }
    
//    public boolean updateVouchers(ModelVouchers dts) {
//        query = "UPDATE comprobantes SET "
//                + "numero_actual=? WHERE id=?";
//        try {
//            PreparedStatement pst = cn.prepareStatement(query);
//            pst.setString(1, dts.getNumberActualVoucher());
//            pst.setInt(2, dts.getIdVoucher());
//            int n = pst.executeUpdate();
//            if (n != 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            return false;
//        }
//    }
    
    public String viewSerieVouchers(String idVoucher, String idStore) {
        query = "SELECT c.serie "
                + "FROM comprobantes c "
                + "WHERE c.idtipo_comprobante = " + idVoucher + " AND c.idalmacen = " + idStore;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String serieVoucher = null;
            while (rs.next()) {
                serieVoucher = rs.getString("c.serie");
            }
            return serieVoucher;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ENCONTRAR LA SERIE DEL COMPROBANTE" + e);
            return null;
        }
    }
    
    
    
     public String viewNumberVouchersServices() {
        query = "SELECT v.numero_entrada FROM venta_computo v";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formateador = new DecimalFormat("00000000");
            String numeroOrig = "00000000";
            String registro[] = new String[1];
            while (rs.next()) {
                if (rs.getString("v.numero_entrada").equals("00000000")) {
                    numeroOrig = "0";
                } else {
                    numeroOrig = registro[0] = rs.getString("v.numero_entrada").replaceAll("^0+", "");
                }
            }

            rs.first();
            String format = formateador.format(Integer.parseInt(numeroOrig) + 1);
            return format;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO" + e);
            return null;
        }
    }
     
     public String viewNumberVouchersReferences() {
        query = "SELECT n.numero FROM numero_referencia_comprobante n";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formateador = new DecimalFormat("00000000");
            String numeroOrig = "00000000";
            String registro[] = new String[1];
            while (rs.next()) {
                if (rs.getString("n.numero").equals("00000000")) {
                    numeroOrig = "0";
                } else {
                    numeroOrig = registro[0] = rs.getString("n.numero").replaceAll("^0+", "");
                }
            }

            rs.first();
            String format = formateador.format(Integer.parseInt(numeroOrig) + 1);
            return format;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO DE REFERENCIA" + e);
            return null;
        }
    }
//     public boolean updateVouchersNumberSerie(ModelNumberReference dts) {
//        query = "UPDATE numero_referencia_comprobante SET "
//                + "numero=? WHERE id=?";
//        try {
//            PreparedStatement pst = cn.prepareStatement(query);
//            pst.setString(1, dts.getNumberReference());
//            pst.setInt(2, dts.getId());
//            int n = pst.executeUpdate();
//            if (n != 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            return false;
//        }
//    }
     
     
     
     
     
     /// VALIDATE DATA 
     
     public String viewNumberVouchersValidate(String idVoucher, String idStore) {
        query = "SELECT c.numero_final "
                + "FROM comprobantes c "
                + "WHERE c.idtipo_comprobante = " + idVoucher + " AND c.idalmacen = " + idStore;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formateador = new DecimalFormat("00000000");
            String numeroOrig = "00000000";
            String registro[] = new String[1];
            while (rs.next()) {
                if (rs.getString("c.numero_final").equals("00000000")) {
                    numeroOrig = "0";
                } else {
                    numeroOrig = registro[0] = rs.getString("c.numero_final").replaceAll("^0+", "");
                }
            }

            rs.first();
            String format = formateador.format(Integer.parseInt(numeroOrig) + 1);
            return format;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO" + e);
            return null;
        }
    }
    
}

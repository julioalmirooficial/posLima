package controller;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerLogin {

    final ConnectionDB conectDB = new ConnectionDB();
    final Connection cn = conectDB.conect();
    private String query = "";

    public ArrayList login(String userName,String password) {

        ArrayList data = new ArrayList();

        query = "SELECT u.full_name, u.type, u.id "
                + "FROM users u "
                + "WHERE u.password = '"+password+"' AND u.user_name = '"+userName+"' AND u.state = 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                data.add(rs.getString("u.id"));
                data.add(rs.getString("u.full_name"));
                data.add(rs.getString("u.type"));
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    

}

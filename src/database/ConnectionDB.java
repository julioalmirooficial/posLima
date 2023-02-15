package database;

import env.Env;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ConnectionDB {

    public ConnectionDB() {
    }

    private static Connection conectDB = null;
    String URL_DOMAIN = "";
    String DB_NAME = "";
    String DB_USER = "";
    String DB_PASSWORD = "";
    String DB_TIME_ZONE = "";

    public Connection conect() {
        selectDataDBA();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectDB = DriverManager.getConnection(
                    "jdbc:mysql://" + URL_DOMAIN + "/" + DB_NAME + "?" + DB_TIME_ZONE, DB_USER, DB_PASSWORD
            );
            if (conectDB == null) {
                System.out.println("NO SE CONECTO A LA BASE DE DATOS");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en: " + e);
        }

        return conectDB;
    }

    public void closeConection() throws SQLException {
        try {
            conectDB.close();
        } catch (SQLException e) {
            conectDB.close();
            System.out.println("ERROR " + e);
        } finally {
            conectDB.close();
        }
    }

    int count = 0;

    private void selectDataDBA() {
        Env env = new Env();
        try {
            FileReader fr = new FileReader(env.URL_SERVER_FILES + "dba/data-connection.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                count++;
                StringTokenizer dato = new StringTokenizer(d, "|");
                ArrayList x = new ArrayList();
                if (count <= 1) {
                    while (dato.hasMoreTokens()) {
                        x.add(dato.nextToken());
                    }
                }

                URL_DOMAIN = String.valueOf(x.get(0));
                DB_TIME_ZONE = String.valueOf(x.get(1));
                DB_NAME = String.valueOf(x.get(2));
                DB_USER = String.valueOf(x.get(3));
                DB_PASSWORD = String.valueOf(x.get(4));
                break;

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

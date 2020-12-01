package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    public Conexion(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String ip = "localhost";
        String bd = "prision_vi_región";
        String user = "root";
        String passwd = "";

        String url = String.format("jdbc:mysql://%s:%d/%s",ip,3306,bd);

        try {
            con = DriverManager.getConnection(url,user,passwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}

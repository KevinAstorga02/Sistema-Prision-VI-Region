package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{

    private Connection con;

    public Conexion(String ip,String user, String password, String bd) throws SQLException{
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = String.format("jdbc:mysql://%s:%d/%s",ip,3306,bd);
        con = DriverManager.getConnection(url,user,password);
    }

    public Connection getCon() {
        return con;
    }
}

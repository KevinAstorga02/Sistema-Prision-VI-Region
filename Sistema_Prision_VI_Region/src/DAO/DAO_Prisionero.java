package DAO;

import Conexion.Conexion;
import Model.Prisionero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Prisionero{

    private Conexion new_con;

    public DAO_Prisionero(Conexion new_con){
        this.new_con = new_con;
    }

    public Prisionero IngresarPrisionero(String rut, String nom, String ape, Integer edad, Integer celda){
        String sql = ("INSERT INTO prisionero VALUES (NULL,'"+rut+"','"+nom+"','"+ape+"','"+edad+"','"+celda+"')");
        try {
            Connection con =  new_con.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}

package DAO;

import Conexion.Conexion;
import Model.Guardia;
import Model.Prisionero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DAO_Prisionero{

    private Conexion new_con;

    public DAO_Prisionero(Conexion new_con){
        this.new_con = new_con;
    }

    public Prisionero IngresarPrisionero(String rut, String nom, String ape, Integer edad, Integer celda){
        String sql = ("INSERT INTO prisionero VALUES ('"+rut+"','"+nom+"','"+ape+"','"+edad+"','"+celda+"')");
        try {
            Connection con =  new_con.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Prisionero> ListarPrisionero() {
        String sql = "SELECT * FROM prisionero";
        List<Prisionero> list = new ArrayList<>();

        try {
            Connection con = new_con.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // fila por fila
                String rut = resultSet.getString(1);
                String nom = resultSet.getString(2);
                String ape = resultSet.getString(3);
                Integer edad = resultSet.getInt(4);
                Integer celda = resultSet.getInt(5);
                Prisionero x = new Prisionero(rut,nom,ape,edad,celda);
                list.add(x);
            }
            statement.close();
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

}

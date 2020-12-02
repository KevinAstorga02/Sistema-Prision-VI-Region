package DAO;

import Conexion.Conexion;
import Model.Guardia;
import Model.Prisionero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Guardia {

    private Conexion new_con;

    public DAO_Guardia(Conexion new_con){
        this.new_con = new_con;
    }

    public Guardia IniciarSesion(String rut){
        String sql = "SELECT * FROM guardia WHERE rut = '"+ rut +"'";
        Guardia oUsu = new Guardia();
        try{
            Connection con =  new_con.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                oUsu.setRut(rs.getString("rut"));
                oUsu.setContrasena(rs.getString("contrasena"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oUsu;
    }

    public Guardia IngresarGuardia(String rut, String nom, String ape, Integer edad, String rango, String contrasena, String FK_sector){
        String sql = ("INSERT INTO guardia VALUES (NULL,'"+rut+"','"+nom+"','"+ape+"','"+edad+"','"+rango+"','"+contrasena+"','"+FK_sector+"')");
        try {
            Connection con =  new_con.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Guardia EditarGuardia(String rut, String nom, String ape, Integer edad, String rango, String contrasena, String FK_sector){
        String sql = ("UPDATE guardia SET nombre = '"+nom+"' AND apellido = '"+ape+"' AND edad = '"+edad+"' AND rango = '"+rango+"'" +
                "AND FK_p_sector = '"+FK_sector+"' WHERE rut = '"+rut+"' AND contrasena = '"+contrasena+"'");
        try {
            Connection con =  new_con.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Guardia EliminarGuardia(String rut, String contrasena){
        String sql = ("DELETE FROM guardia WHERE rut = '"+rut+"' AND contrasena = '"+contrasena+"'");

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

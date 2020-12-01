package DAO;

import Conexion.Conexion;
import Model.Guardia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Guardia {
    private Conexion new_con;

    public DAO_Guardia(Conexion new_con){
        this.new_con = new_con;
    }

    public Guardia IniciarSesion(String id){
        String sql = "SELECT * FROM guardia WHERE rut = '"+ id +"'";
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
}

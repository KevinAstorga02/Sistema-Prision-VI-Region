package DAO;

import Conexion.Conexion;
import Model.Guardia;
import Model.S_Horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Horarios {

    private Conexion new_con;

    public DAO_Horarios(Conexion new_con){
        this.new_con = new_con;
    }

    public S_Horario UltimoId() {
        String sql = "SELECT id FROM s_horario";
        S_Horario oHorario = new S_Horario();
        try {
            Connection con = new_con.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isLast()) {
                oHorario.setId(rs.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oHorario;
    }
    public S_Horario IngresarHorario(String tipo,String inicio , String fin){
        String sql = ("INSERT INTO s_horario VALUES (NULL,'"+tipo+"','"+inicio+"','"+fin+"');");
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

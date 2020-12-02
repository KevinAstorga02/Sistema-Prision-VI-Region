package DAO;

import Conexion.Conexion;
import Model.Celda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Celda {

    private Conexion new_con;

    public DAO_Celda(Conexion new_con){
        this.new_con = new_con;
    }

    public ArrayList<Celda> MostrarCelda(){
        String sql = ("SELECT celda_num FROM celda");
        ArrayList<Celda> list = new ArrayList<>();
        Celda oCelda = new Celda();

        try {
            Connection con = new_con.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               oCelda.getCelda_num(rs.getInt("celda_num"));
                list.add(oCelda);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

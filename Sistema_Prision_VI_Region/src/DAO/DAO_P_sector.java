package DAO;

import Conexion.Conexion;
import Model.P_Sector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DAO_P_sector {

    private Conexion new_con;

    public DAO_P_sector(Conexion new_con){
        this.new_con = new_con;
    }


    public P_Sector MostrarSector(){
        String sql = ("SELECT sector FROM p_sector");
        P_Sector oSector = new P_Sector();

        try {
            Connection con = new_con.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                oSector.setSector(rs.getString("sector"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oSector;
    }

}

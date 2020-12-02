package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ingresar_Guardias extends JFrame{
    private JPanel pnl_IngresarGuaridas;
    private JTextField txt_NombreIG;
    private JTextField txt_RutIG;
    private JTextField txt_ApellidoIG;
    private JTextField txt_EdadIG;
    private JComboBox cbx_SectorIG;
    private JButton btn_AgregarIG;
    private JButton btn_CancelarIG;
    private JPasswordField psw_ContraIG;
    private JTextField txt_RangoIG;

    private Conexion conect;
    private DAO_Guardia daoGuardia;

    Ingresar_Guardias(){
        super("Ingreso de Guardias");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_IngresarGuaridas);

        DefaultComboBoxModel cbx_model = new DefaultComboBoxModel();
        cbx_SectorIG.setModel(cbx_model);

        cbx_model.addElement("A");
        cbx_model.addElement("B");
        cbx_model.addElement("C");
        cbx_model.addElement("D");


        String ip = "localhost";
        String bd = "prision_vi_región";
        String user = "root";
        String psw = "";

        try {
            conect = new Conexion(ip,user,psw,bd);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error de conexión:" + e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        daoGuardia = new DAO_Guardia(conect);

        btn_AgregarIG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var rut = txt_RutIG.getText();
                var nom = txt_NombreIG.getText();
                var ape = txt_ApellidoIG.getText();
                var d = txt_EdadIG.getText();
                var rango = txt_RangoIG.getText();
                var psw = psw_ContraIG.getText();
                String sector = (String) cbx_SectorIG.getSelectedItem();

                Integer edad = Integer.valueOf(d);

                daoGuardia.IngresarGuardia(rut,nom,ape,edad,rango,psw, sector);

                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });

        //Boton Cancelar Ingresar Guardia
        btn_CancelarIG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });
    }
}

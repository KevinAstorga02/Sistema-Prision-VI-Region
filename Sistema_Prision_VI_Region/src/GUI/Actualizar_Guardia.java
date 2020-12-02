package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Actualizar_Guardia extends JFrame{
    private JPanel pnl_ActualizarGuardia;
    private JTextField txt_NombreActualizar;
    private JTextField txt_ApellidoActualizar;
    private JTextField txt_RutActualizar;
    private JTextField txt_EdadActualizar;
    private JTextField txt_RangoActualizar;
    private JComboBox cbx_SectorActualizar;
    private JButton btn_Actualizar;
    private JButton btn_CancelarActualizar;
    private JPasswordField psw_ContraActualizar;
    private JLabel Editar;
    private JLabel Indicacion;

    private Conexion conect;
    private DAO_Guardia daoGuardia;

    Actualizar_Guardia(){
        super("Actualizar Guardia");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_ActualizarGuardia);

        DefaultComboBoxModel cbx_model = new DefaultComboBoxModel();
        cbx_SectorActualizar.setModel(cbx_model);

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

        btn_Actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var rut = txt_RutActualizar.getText();
                var nom = txt_NombreActualizar.getText();
                var ape = txt_ApellidoActualizar.getText();
                var d = txt_EdadActualizar.getText();
                var psw = psw_ContraActualizar.getText();
                var rang = txt_RangoActualizar.getText();
                String sector = "";

                if(cbx_SectorActualizar.getSelectedIndex() > -1){
                    sector = (String) cbx_SectorActualizar.getSelectedItem();
                }
                Integer edad = Integer.valueOf(d);

                daoGuardia.EditarGuardia(rut, nom, ape,  edad,  rang, psw, sector);


            }
        });

        //Boton Cancelar Actualizar
        btn_CancelarActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });
    }
}

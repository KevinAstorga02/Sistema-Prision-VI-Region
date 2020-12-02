package GUI;

import Conexion.Conexion;
import DAO.DAO_Horarios;
import Model.S_Horario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ingresar_Horarios extends JFrame {
    private JPanel pnl_IngresarHorarios;
    private JTextField txt_InicioIH;
    private JTextField txt_TerminoIH;
    private JComboBox cbx_TipoIH;
    private JButton btn_IngresarHorario;
    private JComboBox cbx_SectorIH;
    private JButton btn_CancelarHorario;

    private Conexion conect;
    private DAO_Horarios daoHorario;

    Ingresar_Horarios(){
        super("Ingreso de Horario");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_IngresarHorarios);

        DefaultComboBoxModel cbx_model_tipo = new DefaultComboBoxModel();
        cbx_TipoIH.setModel(cbx_model_tipo);

        cbx_model_tipo.addElement("Diurno");
        cbx_model_tipo.addElement("Nocturno");

        DefaultComboBoxModel cbx_model_sector = new DefaultComboBoxModel();
        cbx_SectorIH.setModel(cbx_model_sector);

        cbx_model_sector.addElement("A");
        cbx_model_sector.addElement("B");
        cbx_model_sector.addElement("C");
        cbx_model_sector.addElement("D");

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
        daoHorario = new DAO_Horarios(conect);

        btn_IngresarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var h_inico = txt_InicioIH.getText();
                var h_fin = txt_TerminoIH.getText();
                var tipo = "";
                var sector = "";
                if (cbx_TipoIH.getSelectedIndex() > -1){
                    tipo = (String) cbx_TipoIH.getSelectedItem();
                }
                if (cbx_SectorIH.getSelectedIndex() > -1){
                    sector = (String) cbx_SectorIH.getSelectedItem();
                }

                daoHorario.IngresarHorario(tipo,h_inico,h_fin);
            }
        });

        //Boton Cancelar Ingeso Horario
        btn_CancelarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });
    }
}

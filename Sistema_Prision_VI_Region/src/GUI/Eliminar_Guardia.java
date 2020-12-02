package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Eliminar_Guardia extends JFrame {
    private JPanel pnl_EliminarGuardia;
    private JTextField txt_RutEG;
    private JPasswordField txt_ContraEG;
    private JButton btn_EliminarGuardia;
    private JButton btn_CancelarEG;

    private Conexion conect;
    private DAO_Guardia daoGuardia;

    Eliminar_Guardia(){
        super("Eliminar Guardias");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_EliminarGuardia);

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

        btn_EliminarGuardia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var rut = txt_RutEG.getText();
                var psw = txt_ContraEG.getText();

                daoGuardia.EliminarGuardia(rut,psw);
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });

        //Boton Cancelar Eliminar Guardia
        btn_CancelarEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });
    }
}

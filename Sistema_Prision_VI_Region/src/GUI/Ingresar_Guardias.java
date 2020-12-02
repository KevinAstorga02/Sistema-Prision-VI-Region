package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    Ingresar_Guardias(){
        super("Ingreso de Guardias");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_IngresarGuaridas);

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

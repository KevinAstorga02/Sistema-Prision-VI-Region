package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    Actualizar_Guardia(){
        super("Actualizar Guardia");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_ActualizarGuardia);

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

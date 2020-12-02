package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar_Guardia extends JFrame {
    private JPanel pnl_EliminarGuardia;
    private JTextField txt_RutEG;
    private JPasswordField txt_ContraEG;
    private JButton btn_EliminarGuardia;
    private JButton btn_CancelarEG;

    Eliminar_Guardia(){
        super("Eliminar Guardias");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_EliminarGuardia);

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

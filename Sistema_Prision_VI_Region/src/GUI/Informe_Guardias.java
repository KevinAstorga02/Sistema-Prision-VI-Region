package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informe_Guardias extends JFrame{
    private JPanel pnl_InformeGuardias;
    private JTable tbl_Guardias;
    private JButton btn_CancelarIG;

    Informe_Guardias(){
        super("Informe de Prisioneros");
        setVisible(true);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_InformeGuardias);

        //Boton Volver al Mneu
        btn_CancelarIG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });

    }
}

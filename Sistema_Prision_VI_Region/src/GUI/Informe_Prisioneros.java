package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informe_Prisioneros extends JFrame {
    private JPanel pnl_InformePrisioneros;
    private JTable tbl_Prisioneros;
    private JButton btn_VolverIP;
    private JScrollPane jsp_InformePrisioneros;

    Informe_Prisioneros(){
        super("Informe de Prisioneros");
        setVisible(true);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_InformePrisioneros);

        //Boton Volver al Menu
        btn_VolverIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Prisioneros().setVisible(true);
            }
        });
    }
}

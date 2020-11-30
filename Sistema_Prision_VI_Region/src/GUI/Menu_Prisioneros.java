package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Prisioneros extends JFrame{
    private JLabel lbl_MenuPrisioneros;
    private JButton btn_IngresarPrisionero;
    private JButton btn_VerPrisioneros;
    private JButton otroButton;
    private JPanel pnl_MenuPrisioneros;

    public Menu_Prisioneros(){
        super("sdfsdf");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        add(pnl_MenuPrisioneros);

        btn_IngresarPrisionero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ingresar_Prisioneros().setVisible(true);
            }
        });


    }
}



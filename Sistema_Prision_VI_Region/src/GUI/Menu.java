package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel pnl_Menu;
    private JButton btn_PrisionerosMenu;
    private JButton btn_GuardiasMenu;
    private JButton btn_CerrarSesionMenu;
    private JPanel pnl_ImageMenu;



    public Menu(){
        super("asds");
        this.setVisible(true);
        setSize(350, 350);
        setLocationRelativeTo(null);
        add(pnl_Menu);


        btn_PrisionerosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Prisioneros().setVisible(true);

            }
        });
    }
}

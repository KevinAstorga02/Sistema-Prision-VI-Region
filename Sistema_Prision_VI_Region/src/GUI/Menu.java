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
    private JButton btn_HorarioSector;


    public Menu(){
        super("Menu Carcel");
        this.setVisible(true);
        setSize(350, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_Menu);


        btn_PrisionerosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Prisioneros().setVisible(true);

            }
        });

        btn_CerrarSesionMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login().setVisible(true);
            }
        });
        btn_GuardiasMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });
        btn_HorarioSector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ingresar_Horarios().setVisible(true);
            }
        });
    }
}

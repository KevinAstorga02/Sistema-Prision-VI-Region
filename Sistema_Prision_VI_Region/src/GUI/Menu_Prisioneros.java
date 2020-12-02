package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Prisioneros extends JFrame{
    private JLabel lbl_MenuPrisioneros;
    private JButton btn_IngresarPrisionero;
    private JButton btn_VerPrisioneros;
    private JButton btn_EliminarPrisioneros;
    private JPanel pnl_MenuPrisioneros;
    private JButton btn_Cancelar;


    public Menu_Prisioneros(){
        super("Menu Prisioneros");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_MenuPrisioneros);



        //Boton Ingresar Prisioneros
        btn_IngresarPrisionero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ingresar_Prisioneros().setVisible(true);
            }
        });
        //Boton Eliminar Prisioneros
        btn_EliminarPrisioneros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Eliminar_Prisionero().setVisible(true);
            }
        });
        //Boton Cancelar Menu Prisioneros
        btn_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });
        //Boton Ver Prisioneros
        btn_VerPrisioneros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Informe_Prisioneros().setVisible(true);
            }
        });


    }
}



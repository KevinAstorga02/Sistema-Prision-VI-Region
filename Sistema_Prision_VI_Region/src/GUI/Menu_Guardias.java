package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Guardias extends JFrame {
    private JButton btn_IngresarGuardia;
    private JButton btn_ListadoGuardias;
    private JButton btn_EliminarGuardia;
    private JButton btn_CancelarMG;
    private JPanel pnl_MenuGuardias;
    private JButton btn_ActualizarGuardia;

    Menu_Guardias(){
        super("Menu Guardias");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_MenuGuardias);

        //Boton Cancelar Menu_Guardias
        btn_CancelarMG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });

        //Boton Ingresar Guardia
        btn_IngresarGuardia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ingresar_Guardias().setVisible(true);
            }
        });

        //Boton Listado Guardias
        btn_ListadoGuardias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Informe_Guardias().setVisible(true);
            }
        });

        //Boton Eliminar Guardias
        btn_EliminarGuardia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Eliminar_Guardia().setVisible(true);
            }
        });

        btn_ActualizarGuardia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Actualizar_Guardia().setVisible(true);
            }
        });
    }
}

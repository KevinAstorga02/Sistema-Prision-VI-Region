package com.nexo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel pnl_Login;
    private JButton btn_IngresarLogin;
    private JButton btn_SalirLogin;
    private JTextField txt_RutLogin;
    private JPasswordField psw_ContraLogin;
    private JLabel lbl_RutLogin;
    private JLabel lbl_ContraLogin;



    Login(){
        super("Login");
        setVisible(true);
        setSize(300, 175);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(pnl_Login);

        //Boton Ingresar Pantalla Login
        btn_IngresarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Boton Salir Pantalla Login
        btn_SalirLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}

package GUI;

import GUI.Menu;

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



    public Login(){
        super("Login");
        setVisible(true);
        setSize(300, 175);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(pnl_Login);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Boton Ingresar Pantalla Login
        btn_IngresarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardan la ventana con la informacion
                //setVisible(true); // Mostrar ventana
                //setVisible(false); // Ocultar ventana

                // Elimina la ventana de la RAM
                dispose(); // Pitearse ventanas

                // Llamar ventanas siempre (creo)
                new Menu().setVisible(true);
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

package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;
import GUI.Menu;
import Model.Guardia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame{
    private JPanel pnl_Login;
    private JButton btn_IngresarLogin;
    private JButton btn_SalirLogin;
    private JTextField txt_RutLogin;
    private JPasswordField psw_ContraLogin;
    private JLabel lbl_RutLogin;
    private JLabel lbl_ContraLogin;

    private DAO_Guardia dao_Guardia;
    private Conexion conect;




    public Login(){
        super("Login");
        setVisible(true);
        setSize(300, 175);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(pnl_Login);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String ip = "localhost";
        String bd = "prision_vi_región";
        String user = "root";
        String psw = "";

        try {
            conect = new Conexion(ip,user,psw,bd);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error de conexión:" + e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        dao_Guardia = new DAO_Guardia(conect);

        //Boton Ingresar Pantalla Login
        btn_IngresarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var rut = txt_RutLogin.getText();
                var psw = psw_ContraLogin.getText();
                try {
                    if (rut.isEmpty() || rut.isBlank())
                        throw new Exception();
                    Guardia oUsu;
                    oUsu = dao_Guardia.IniciarSesion(rut);

                    if (rut.equals(oUsu.getRut()) && psw.equals(oUsu.getContrasena())){
                        JOptionPane.showMessageDialog(pnl_Login,"Acceso Permitido","Acceso",JOptionPane.PLAIN_MESSAGE);
                        dispose();
                        new Menu().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(pnl_Login,"DATOS INVALIDOS\nRevisar rut y contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
                        txt_RutLogin.setText("");
                        psw_ContraLogin.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    txt_RutLogin.setText(null);
                    psw_ContraLogin.setText(null);
                    txt_RutLogin.grabFocus();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    txt_RutLogin.setText(null);
                    psw_ContraLogin.setText(null);
                    txt_RutLogin.grabFocus();
                }




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

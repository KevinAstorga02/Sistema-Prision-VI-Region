package GUI;

import Conexion.Conexion;
import DAO.DAO_Celda;
import DAO.DAO_Prisionero;
import Model.Celda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ingresar_Prisioneros extends JFrame{
    private JPanel pnl_IngresoPrisioneros;
    private JTextField txt_RutPrisioneroIP;
    private JTextField txt_NombrePrisioneroIP;
    private JTextField txt_ApellidoPrisioneroIP;
    private JTextField txt_EdadPrisioneroIP;
    private JComboBox cbx_IngresarPrisioneroCeldaIP;
    private JLabel lbl_RutPrisioneroIP;
    private JLabel lbl_NombrePrisioneroIP;
    private JLabel lbl_ApellidoPrisioneroIP;
    private JLabel lbl_EdadPrisioneroIP;
    private JLabel lbl_CeldaPrisioneroIP;
    private JButton btn_AgregarPrisioneroIP;
    private JButton btn_CancelarIP;

    private DAO_Prisionero daoPrisionero;
    private DAO_Celda daoCelda;
    private Conexion conect;

    Ingresar_Prisioneros(){
        super("Ingreso de Prisioneros");
        setVisible(true);
        setSize(500,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_IngresoPrisioneros);

        DefaultComboBoxModel cbx_model = new DefaultComboBoxModel();
        cbx_IngresarPrisioneroCeldaIP.setModel(cbx_model);


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

        daoPrisionero = new DAO_Prisionero(conect);
        daoCelda = new DAO_Celda(conect);

        ArrayList<Celda> Traerlo;

        Traerlo = daoCelda.MostrarCelda();

        for(Celda p : Traerlo){
            cbx_model.addElement(p);
        }

        btn_AgregarPrisioneroIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var rut = txt_RutPrisioneroIP.getText();
                var nom = txt_NombrePrisioneroIP.getText();
                var ape = txt_EdadPrisioneroIP.getText();
                var edad = txt_EdadPrisioneroIP.getText();
                var celda = "23";

                Integer edad_final = Integer.valueOf(edad);
                Integer celdad_final = Integer.valueOf(celda);

                daoPrisionero.IngresarPrisionero(rut, nom, ape, edad_final, celdad_final);

             /*   try {
                    if (rut.isBlank() || rut.isEmpty() || nom.isEmpty() || nom.isBlank() || ape.isEmpty() || ape.isBlank() ||
                            edad.isBlank() || edad.isEmpty() || sector == " " || celda == " " || delit.isEmpty() || delit.isBlank()) {
                        throw new Exception("Falta llenar una casilla.");
                    } else {


                    }
                } catch (Exception lol) {
                    JOptionPane.showMessageDialog(null, "Error: " + lol, "Error", JOptionPane.ERROR_MESSAGE);
                }*/
            }
            });

        btn_CancelarIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Prisioneros().setVisible(true);
            }
        });
    }
}

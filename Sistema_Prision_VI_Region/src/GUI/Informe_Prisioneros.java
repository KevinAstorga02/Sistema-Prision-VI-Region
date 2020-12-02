package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;
import DAO.DAO_Prisionero;
import Model.Guardia;
import Model.Prisionero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Informe_Prisioneros extends JFrame {
    private JPanel pnl_InformePrisioneros;
    private JTable tbl_Prisioneros;
    private JButton btn_VolverIP;
    private JScrollPane jsp_InformePrisioneros;

    private Conexion conect;
    private DAO_Prisionero daoPrisionero;

    Informe_Prisioneros(){
        super("Informe de Prisioneros");
        setVisible(true);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_InformePrisioneros);

        DefaultTableModel tbl_model = new DefaultTableModel();
        tbl_Prisioneros.setModel(tbl_model);

        tbl_model.addColumn("Rut");
        tbl_model.addColumn("Nombre");
        tbl_model.addColumn("Apellido");
        tbl_model.addColumn("Edad");
        tbl_model.addColumn("Celda");

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

        daoPrisionero= new DAO_Prisionero(conect);


        List<Prisionero> list = daoPrisionero.ListarPrisionero();

        for (int i = tbl_model.getRowCount(); i > 0; i--) {
            tbl_model.removeRow(i - 1);

        }
        String yeah = "No disponible";

        for (Prisionero t : list) {
            String[] x = new String[]{t.getRut(), t.getNombre(),t.getApellido(),String.valueOf(t.getEdad()),String.valueOf(t.getCelda())};
            tbl_model.addRow(x);
        }

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

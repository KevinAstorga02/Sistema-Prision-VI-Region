package GUI;

import Conexion.Conexion;
import DAO.DAO_Guardia;
import Model.Guardia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Informe_Guardias extends JFrame{
    private JPanel pnl_InformeGuardias;
    private JTable tbl_Guardias;
    private JButton btn_CancelarIG;
    private JButton btn_RecargarIG;

    private DAO_Guardia daoGuardia;
    private Conexion conect;

    Informe_Guardias(){
        super("Informe de Prisioneros");
        setVisible(true);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_InformeGuardias);

        DefaultTableModel tbl_model = new DefaultTableModel();
        tbl_Guardias.setModel(tbl_model);

        tbl_model.addColumn("Rut");
        tbl_model.addColumn("Nombre");
        tbl_model.addColumn("Apellido");
        tbl_model.addColumn("Edad");
        tbl_model.addColumn("Rango");
        tbl_model.addColumn("Contrasena");
        tbl_model.addColumn("Sector");

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

        daoGuardia = new DAO_Guardia(conect);


        List<Guardia> list = daoGuardia.ListarGuardias();

        for (int i = tbl_model.getRowCount(); i > 0; i--) {
                tbl_model.removeRow(i - 1);

        }
        String yeah = "No disponible";

        for (Guardia t : list) {
            String[] x = new String[]{t.getRut(), t.getNombre(),t.getApellido(),String.valueOf(t.getEdad()),t.getRango(),yeah,t.getSector()};
            tbl_model.addRow(x);
        }


        //Boton Volver al Mneu
        btn_CancelarIG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Guardias().setVisible(true);
            }
        });

    }
}

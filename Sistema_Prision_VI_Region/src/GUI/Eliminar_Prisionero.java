package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar_Prisionero extends JFrame {
    private JPanel pnl_EliminarPrisionero;
    private JTextField txt_RutEliminarPrisionero;
    private JButton btn_BuscarPrisioneroEP;
    private JButton btn_EliminarPrisionero;
    private JTable tbl_DatosPrisionero;
    private JButton btn_CancelarEP;

    Eliminar_Prisionero(){
        super("Eliminar Prisioneros");
        setVisible(true);
        setSize(500,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_EliminarPrisionero);


        //Boton Cancelar Eliminar Prisionero
        btn_CancelarEP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu_Prisioneros().setVisible(true);
            }
        });

    }
}

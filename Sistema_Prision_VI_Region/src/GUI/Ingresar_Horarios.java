package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ingresar_Horarios extends JFrame {
    private JPanel pnl_IngresarHorarios;
    private JTextField txt_InicioIH;
    private JTextField txt_TerminoIH;
    private JComboBox cbx_TipoIH;
    private JButton btn_IngresarHorario;
    private JComboBox cbx_SectorIH;
    private JButton btn_CancelarHorario;

    Ingresar_Horarios(){
        super("Ingreso de Horario");
        setVisible(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl_IngresarHorarios);

        //Boton Cancelar Ingeso Horario
        btn_CancelarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });
    }
}

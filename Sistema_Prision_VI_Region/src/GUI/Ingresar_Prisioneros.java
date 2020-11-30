package GUI;

import javax.swing.*;

public class Ingresar_Prisioneros extends JFrame{
    private JPanel pnl_IngresoPrisioneros;
    private JTextField txt_RutPrisioneroIP;
    private JTextField txt_NombrePrisioneroIP;
    private JTextField txt_ApellidoPrisioneroIP;
    private JTextField txt_EdadPrisioneroIP;
    private JComboBox cbx_IngresarPrisioneroIP;
    private JComboBox cbx_SectorPrisioneroIP;
    private JTextField txt_DelitoPrisioneroIP;
    private JButton btn_AnadirDelitoIP;
    private JButton btn_EliminarDelitoIP;
    private JList lst_DelitosIP;
    private JLabel lbl_RutPrisioneroIP;
    private JLabel lbl_NombrePrisioneroIP;
    private JLabel lbl_ApellidoPrisioneroIP;
    private JLabel lbl_EdadPrisioneroIP;
    private JLabel lbl_SectorPrisioneroIP;
    private JLabel lbl_CeldaPrisioneroIP;

    Ingresar_Prisioneros(){
        super("Ingreso de Prisioneros");
        setVisible(true);
        setSize(500,600);
        setLocationRelativeTo(null);
        add(pnl_IngresoPrisioneros);
    }
}

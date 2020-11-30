package com.nexo;

import GUI.Login;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        try {
            UIManager.setLookAndFeel( new FlatMaterialOceanicIJTheme());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );

        SwingUtilities.invokeLater(() -> new Login());

    }


}

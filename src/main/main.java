/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import morty.Vustas.Dashboard;
import morty.Vustas.Login;
import testDeveloper.testEnvios;
/**
 *
 * @author cisco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel(new FlatMacDarkLaf()); // Aplicar FlatLaf Dark
              UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
//            UIManager.put("Button.arc", 20);  // Botones redondeados
//            UIManager.put("Component.arc", 15); // Inputs redondeados
//            UIManager.put("TextComponent.arc", 15);
//            UIManager.put("ScrollBar.width", 10);
//            UIManager.put("ScrollBar.thumbArc", 12);
//            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
//            UIManager.put("TabbedPane.selectedBackground", new Color(45, 45, 45));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        
        Login l = new Login();
        l.setVisible(true);

//        Dashboard d = new Dashboard();
//        d.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Insets;
import javax.swing.*;
import java.util.Random;
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
        // Lista de todos los temas disponibles en FlatLaf IntelliJ Themes
        Class<?>[] themes = {
            FlatArcDarkIJTheme.class,
            FlatArcIJTheme.class,
            FlatArcOrangeIJTheme.class,
            FlatCarbonIJTheme.class,
            FlatCobalt2IJTheme.class,
            FlatCyanLightIJTheme.class,
            FlatDarkFlatIJTheme.class,
            FlatDarkPurpleIJTheme.class,
            FlatDraculaIJTheme.class,
            FlatGradiantoDarkFuchsiaIJTheme.class,
            FlatGradiantoDeepOceanIJTheme.class,
            FlatGradiantoMidnightBlueIJTheme.class,
            FlatGradiantoNatureGreenIJTheme.class,
            FlatGrayIJTheme.class,
            FlatGruvboxDarkHardIJTheme.class,
            FlatGruvboxDarkMediumIJTheme.class,
            FlatGruvboxDarkSoftIJTheme.class,
            FlatHiberbeeDarkIJTheme.class,
            FlatHighContrastIJTheme.class,
            FlatLightFlatIJTheme.class,
            FlatMaterialDesignDarkIJTheme.class,
            FlatMonokaiProIJTheme.class,
            FlatNordIJTheme.class,
            FlatOneDarkIJTheme.class,
            FlatSolarizedDarkIJTheme.class,
            FlatSolarizedLightIJTheme.class,
            FlatSpacegrayIJTheme.class,
            FlatVuesionIJTheme.class,
            FlatXcodeDarkIJTheme.class
        };

        // Selección aleatoria de un tema
        Random random = new Random();
        Class<?> selectedTheme = themes[random.nextInt(themes.length)];

        try {
            // Aplicar el tema usando Reflection
            UIManager.setLookAndFeel((LookAndFeel) selectedTheme.getDeclaredConstructor().newInstance());

            // Configuraciones opcionales
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.arc", 15);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("ScrollBar.width", 10);
            UIManager.put("ScrollBar.thumbArc", 12);
            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
            UIManager.put("TabbedPane.selectedBackground", new java.awt.Color(45, 45, 45));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iniciar la ventana de Login
        Login l = new Login();
        l.setVisible(true);
    }
}

package main;

import com.formdev.flatlaf.intellijthemes.*;
import javax.swing.*;
import java.time.LocalTime;
import java.util.Random;
import morty.Vustas.Login;
import sincronizacion.SyncDatabase;

public class main {

    public static void main(String[] args) {
        // Temas claros
        Class<?>[] temasClaros = {
            FlatArcIJTheme.class,
            FlatCyanLightIJTheme.class,
            FlatGrayIJTheme.class,
            FlatLightFlatIJTheme.class,
        };

        // Temas oscuros
        Class<?>[] temasOscuros = {
            FlatArcDarkIJTheme.class,
            FlatArcOrangeIJTheme.class,
            FlatCarbonIJTheme.class,
            FlatCobalt2IJTheme.class,
            FlatDarkFlatIJTheme.class,
            FlatDarkPurpleIJTheme.class,
            FlatDraculaIJTheme.class,
            FlatGradiantoDarkFuchsiaIJTheme.class,
            FlatGradiantoDeepOceanIJTheme.class,
            FlatGradiantoMidnightBlueIJTheme.class,
            FlatGradiantoNatureGreenIJTheme.class,
            FlatGruvboxDarkHardIJTheme.class,
            FlatGruvboxDarkMediumIJTheme.class,
            FlatGruvboxDarkSoftIJTheme.class,
            FlatHiberbeeDarkIJTheme.class,
            FlatHighContrastIJTheme.class,
            FlatMaterialDesignDarkIJTheme.class,
            FlatMonokaiProIJTheme.class,
            FlatNordIJTheme.class,
            FlatOneDarkIJTheme.class,
            FlatSolarizedDarkIJTheme.class,
            FlatSpacegrayIJTheme.class,
            FlatVuesionIJTheme.class,
            FlatXcodeDarkIJTheme.class
        };

        // Obtener la hora actual
        LocalTime ahora = LocalTime.now();
        int hora = ahora.getHour();

        boolean esDeDia = hora >= 6 && hora < 19;

        // Selección aleatoria según el momento del día
        Random random = new Random();
        Class<?> selectedTheme = esDeDia
                ? temasClaros[random.nextInt(temasClaros.length)]
                : temasOscuros[random.nextInt(temasOscuros.length)];

        try {
            UIManager.setLookAndFeel((LookAndFeel) selectedTheme.getDeclaredConstructor().newInstance());
            System.out.println("Tema aplicado (" + (esDeDia ? "Día" : "Noche") + "): " + selectedTheme.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iniciar sincronización automática

        // Mostrar login
        Login l = new Login();
        l.setVisible(true);
 
    }
}

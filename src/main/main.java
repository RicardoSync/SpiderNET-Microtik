package main;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import com.formdev.flatlaf.themes.*;
import javax.swing.*;
import java.time.LocalTime;
import UIPrincipal.Login;

public class main {
    public static void main(String[] args) {
        try {
            // Obtener la hora actual
            LocalTime ahora = LocalTime.now();
            int hora = ahora.getHour();

            // Día: 6am a 6:59pm -> FlatCyanLightIJTheme
            // Noche: 7pm a 5:59am -> FlatSpacegrayIJTheme
            boolean esDeDia = hora >= 6 && hora < 19;

            UIManager.setLookAndFeel(esDeDia
                    ? new FlatMacLightLaf()
                    : new FlatMacDarkLaf());

            System.out.println("Tema aplicado (" + (esDeDia ? "Día" : "Noche") + "): "
                    + (esDeDia ? "FlatCyanLightIJTheme" : "FlatSpacegrayIJTheme"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar login
        Login l = new Login();
        l.setVisible(true);
    }
}

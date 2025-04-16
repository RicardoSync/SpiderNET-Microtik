/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnlaceWeb;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author ricardo
 */
public class abrirEnlace {
    
     public static void abrirTikTok() {
        try {
            String url = "https://www.tiktok.com/@softwarescobedo?_t=ZM-8vEYzaVQXFn&_r=1";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("El escritorio no es compatible con esta función.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void abrirFacebook() {
        try {
            String url = "https://www.facebook.com/profile.php?id=61565806795567";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("El escritorio no es compatible con esta función.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testDeveloper;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author cisco
 */
public class testWhatsapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String phone = "524961048317"; // Número del cliente con código de país
            String message = "Hola, este es un mensaje automático desde Java";
            String url = "https://wa.me/" + phone + "?text=" + message.replace(" ", "%20");

            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

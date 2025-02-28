/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDeveloper;

import java.util.Calendar;

/**
 *
 * @author ricardo
 */
public class pruebasFechas {
    public void fechas(){
        int annio;
        int mes;
        
        Calendar calendar = Calendar.getInstance(); // inicamos el modulo de calendario
        annio = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        System.out.println(annio + mes);
        
    }
    
    public static void main(){
        pruebasFechas fechas = new pruebasFechas();
        fechas.fechas();
    }
}

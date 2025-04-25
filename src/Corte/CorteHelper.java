package Corte;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class CorteHelper {

    public static String getFechaCorteSiguienteMes(int diaCorte) {
        LocalDate hoy = LocalDate.now();
        int año = hoy.getYear();
        int mes = hoy.getMonthValue() + 1; // Siempre se va al siguiente mes

        // Si pasa de diciembre
        if (mes > 12) {
            mes = 1;
            año++;
        }

        // Verificar si el mes tiene ese día (por ejemplo, 30 en febrero no existe)
        int diasEnMes = LocalDate.of(año, mes, 1).lengthOfMonth();
        if (diaCorte > diasEnMes) diaCorte = diasEnMes;

        LocalDate fechaCorte = LocalDate.of(año, mes, diaCorte);
        return fechaCorte.format(DateTimeFormatter.ofPattern("MMM/dd/yyyy")).toLowerCase(); // ej: may/15/2025
    }

public static String getFechaCorteEsteMes(int diaCorte) {
    Calendar calendario = Calendar.getInstance(); // Hoy
    int anio = calendario.get(Calendar.YEAR);
    int mes = calendario.get(Calendar.MONTH); // Este mes

    // Si el día de corte ya pasó hoy, puedes decidir si se permite o no (opcional)
    calendario.set(Calendar.DAY_OF_MONTH, diaCorte);
    calendario.set(Calendar.MONTH, mes);
    calendario.set(Calendar.YEAR, anio);

    SimpleDateFormat formato = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
    return formato.format(calendario.getTime()).toLowerCase(); // Ejemplo: "apr/18/2025"
}
public static String getFechaCorte(int diaCorte, int mesesPagados) {
    LocalDate fechaBase = LocalDate.now().withDayOfMonth(diaCorte);
    if (LocalDate.now().getDayOfMonth() >= diaCorte) {
        fechaBase = fechaBase.plusMonths(1); // si ya pasó el día de corte de este mes, empezar desde el próximo
    }

    LocalDate nuevaFecha = fechaBase.plusMonths(mesesPagados - 1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/dd/yyyy", Locale.ENGLISH);
    return nuevaFecha.format(formatter);
}

}
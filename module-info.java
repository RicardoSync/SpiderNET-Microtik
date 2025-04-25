module admiNET {
    // Librerías estándar
    requires java.base;
    requires java.desktop;

    // Librerías externas
    requires javafx.controls;
    requires javafx.fxml;

    // FlatLaf (si usas el `.jar`, no necesitas declararlo si no estás en modo modular puro)

    // Abres paquetes si usas FXML o Reflection
    opens morty.Vustas to javafx.fxml;
    opens main to javafx.fxml;

    // Exporta los paquetes que serán usados por otras clases si es necesario
    exports main;
    exports morty.Vustas;
}

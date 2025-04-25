package Recibos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurarLogoWISP extends JFrame {

    private JLabel rutaLabel;

    public ConfigurarLogoWISP() {
        setTitle("Configurar Logo del WISP");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel instruccion = new JLabel("Selecciona el logotipo que aparecerá en los recibos:", SwingConstants.CENTER);
        rutaLabel = new JLabel("(Ruta no seleccionada)", SwingConstants.CENTER);

        JButton seleccionarBtn = new JButton("Seleccionar Logo");
        seleccionarBtn.addActionListener(this::seleccionarLogo);

        JPanel panelCentro = new JPanel(new GridLayout(3, 1));
        panelCentro.add(instruccion);
        panelCentro.add(rutaLabel);
        panelCentro.add(seleccionarBtn);

        add(panelCentro, BorderLayout.CENTER);
    }

    private void seleccionarLogo(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona tu logo para el recibo");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = chooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoLogo = chooser.getSelectedFile();
            rutaLabel.setText(archivoLogo.getAbsolutePath());

            try {
                Properties props = new Properties();
                props.setProperty("ruta_logo", archivoLogo.getAbsolutePath());
                props.store(new FileOutputStream("logo.properties"), "Ruta del logo del WISP");
                JOptionPane.showMessageDialog(this, "✅ Logo guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar la ruta del logo:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConfigurarLogoWISP().setVisible(true));
    }
} 

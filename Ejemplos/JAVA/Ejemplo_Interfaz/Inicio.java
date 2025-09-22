/*
 * Clase principal de inicio que muestra una ventana de bienvenida
 * con dos botones: uno para abrir la calculadora y otro para salir.
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana inicial de la aplicación.
 * @author pablo
 */
public class Inicio extends JFrame {

    // Botón que permite abrir la calculadora
    private final JButton btnAbrir = new JButton("Abrir calculadora");
    // Botón que permite salir de la aplicación
    private final JButton btnSalir  = new JButton("Salir");

    /**
     * Constructor de la clase Inicio.
     * Aquí se configuran todos los elementos gráficos de la ventana.
     */
    public Inicio() {
        // Título de la ventana
        super("Bienvenido");

        // Cuando el usuario cierre la ventana, se detiene la aplicación
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // No permitir que la ventana cambie de tamaño
        setResizable(false);

        // Etiqueta de título con fuente en negrita
        JLabel titulo = new JLabel("Calculadora", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 16f));

        // Panel central con dos botones (abrir y salir) en una cuadrícula
        JPanel centro = new JPanel(new GridLayout(2, 1, 8, 8));
        centro.add(btnAbrir);
        centro.add(btnSalir);

        // Panel raíz con bordes y distribución en BorderLayout
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(titulo, BorderLayout.NORTH); // arriba
        root.add(new JLabel("Presiona el botón para navegar a la calculadora.", SwingConstants.CENTER), BorderLayout.CENTER); // centro
        root.add(centro, BorderLayout.SOUTH); // abajo

        // Agregar panel raíz a la ventana
        setContentPane(root);
        // Ajusta el tamaño automático según el contenido
        pack();
        // Centrar ventana en la pantalla
        setLocationRelativeTo(null);

        // Acción del botón "Abrir calculadora": muestra la ventana Interfaz y cierra esta
        btnAbrir.addActionListener(e -> {
            new Interfaz().setVisible(true);
            dispose(); // cerrar ventana de inicio
        });

        // Acción del botón "Salir": cierra la aplicación
        btnSalir.addActionListener(e -> System.exit(0));

        // Permite que al presionar ENTER se active el botón "Abrir calculadora"
        getRootPane().setDefaultButton(btnAbrir);
    }

    /**
     * Método main: punto de entrada del programa.
     * Aquí se crea y muestra la ventana de inicio.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Inicio().setVisible(true));
    }
}

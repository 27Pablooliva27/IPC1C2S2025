/*
 * Ventana de la calculadora simple.
 * Permite sumar, restar, multiplicar y dividir dos números,
 * además de limpiar los campos o volver a la ventana de inicio.
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase Interfaz que representa la ventana de la calculadora.
 * Extiende de JFrame para construir la interfaz gráfica.
 * 
 * @author pablo
 */
public class Interfaz extends JFrame {
    // Campos de texto para ingresar números y mostrar el resultado
    private final JTextField txtNumero1 = new JTextField(10);
    private final JTextField txtNumero2 = new JTextField(10);
    private final JTextField txtResultado = new JTextField(12);

    // Botones de operaciones
    private final JButton btnSumar        = new JButton("Sumar");
    private final JButton btnRestar       = new JButton("Restar");
    private final JButton btnMultiplicar  = new JButton("Multiplicar");
    private final JButton btnDividir      = new JButton("Dividir");
    // Botones de acciones adicionales
    private final JButton btnLimpiar      = new JButton("Limpiar");
    private final JButton btnVolver       = new JButton("Volver");

    /**
     * Constructor de la calculadora.
     * Aquí se definen todos los elementos gráficos y sus eventos.
     */
    public Interfaz() {
        super("Calculadora (simple)");

        // Al cerrar la ventana, se termina la aplicación
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // No permitir cambiar el tamaño de la ventana
        setResizable(false);

        // Panel con los campos de texto (números y resultado)
        JPanel datos = new JPanel(new GridLayout(3, 2, 6, 6));
        datos.add(new JLabel("Número 1:"));
        datos.add(txtNumero1);
        datos.add(new JLabel("Número 2:"));
        datos.add(txtNumero2);
        datos.add(new JLabel("Resultado:"));

        txtResultado.setEditable(false);   // resultado no editable
        txtResultado.setFocusable(false);  // no puede recibir foco
        datos.add(txtResultado);

        // Panel con los botones de operaciones
        JPanel ops = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
        ops.add(btnSumar);
        ops.add(btnRestar);
        ops.add(btnMultiplicar);
        ops.add(btnDividir);

        // Panel con botones de acciones (limpiar y volver)
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
        acciones.add(btnLimpiar);
        acciones.add(btnVolver);

        // Panel principal que organiza todo
        JPanel root = new JPanel(new BorderLayout(8, 8));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        root.add(datos, BorderLayout.NORTH);     // arriba: campos de texto
        root.add(ops, BorderLayout.CENTER);      // centro: operaciones
        root.add(acciones, BorderLayout.SOUTH);  // abajo: acciones

        // Agregar el panel raíz a la ventana
        setContentPane(root);
        pack();                   // ajusta tamaño según el contenido
        setLocationRelativeTo(null); // centrar en la pantalla

        // Eventos de los botones
        btnSumar.addActionListener(e -> operar("+"));
        btnRestar.addActionListener(e -> operar("-"));
        btnMultiplicar.addActionListener(e -> operar("*"));
        btnDividir.addActionListener(e -> operar("/"));
        btnLimpiar.addActionListener(e -> limpiar());
        btnVolver.addActionListener(e -> {
            // Regresa a la ventana de inicio
            new Inicio().setVisible(true);
            dispose(); // cerrar la ventana de la calculadora
        });

        // Permitir que al presionar ENTER se ejecute la suma
        getRootPane().setDefaultButton(btnSumar);
    }

    /**
     * Realiza la operación seleccionada (+, -, *, /).
     * Valida que los datos sean correctos antes de calcular.
     */
    private void operar(String op) {
        try {
            double a = leerNumero(txtNumero1, "Número 1");
            double b = leerNumero(txtNumero2, "Número 2");
            double r = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> {
                    if (b == 0.0) throw new IllegalArgumentException("No se puede dividir entre cero.");
                    yield a / b;
                }
                default -> throw new IllegalStateException("Operación desconocida");
            };
            txtResultado.setText(String.valueOf(r));
        } catch (NumberFormatException ex) {
            mostrarError("Ingresa números válidos.");
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    /**
     * Convierte el texto de un campo en número.
     * Lanza error si el campo está vacío o contiene texto no numérico.
     */
    private double leerNumero(JTextField campo, String etiqueta) {
        String raw = campo.getText();
        if (raw == null || raw.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo \"" + etiqueta + "\" está vacío.");
        }
        return Double.parseDouble(raw.trim().replace(',', '.')); // admite coma o punto decimal
    }

    /**
     * Limpia todos los campos y coloca el cursor en el primero.
     */
    private void limpiar() {
        txtNumero1.setText("");
        txtNumero2.setText("");
        txtResultado.setText("");
        txtNumero1.requestFocus();
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de error.
     */
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

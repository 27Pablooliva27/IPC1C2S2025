/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo_clase10;
import java.util.Locale;
/**
 *
 * @author pablo
 */
interface Dibujable {
    String dibujar(); // representación "visual" en texto
}

// ---- Clase abstracta (plantilla) ----
abstract class Figura {
    private final String nombre;

    protected Figura(String nombre) { // uso de this implícito para setear estado
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    // Métodos que OBLIGAN a las hijas a definir su cálculo
    public abstract double area();
    public abstract double perimetro();
}

// ---- Implementación concreta: Rectángulo ----
class Rectangulo extends Figura implements Dibujable {
    private final double ancho;
    private final double alto;

    public Rectangulo(double ancho, double alto) {
        super("Rectángulo");
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override public double area() { return ancho * alto; }

    @Override public double perimetro() { return 2 * (ancho + alto); }

    @Override public String dibujar() {
        // “Dibujo” textual simple
        int w = Math.max(1, (int)Math.round(ancho));
        int h = Math.max(1, (int)Math.round(alto));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) sb.append('*');
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override public String toString() {
        return getNombre() + " (ancho=" + ancho + ", alto=" + alto + ")";
    }
}

// ---- Implementación concreta: Círculo ----
class Circulo extends Figura implements Dibujable {
    private final double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override public double area() { return Math.PI * radio * radio; }

    @Override public double perimetro() { return 2 * Math.PI * radio; }

    @Override public String dibujar() {
        // círculo aproximado con ASCII en una cuadrícula
        int r = Math.max(1, (int)Math.round(radio));
        int size = 2 * r + 1;
        StringBuilder sb = new StringBuilder();
        for (int y = -r; y <= r; y++) {
            for (int x = -r; x <= r; x++) {
                double dist = Math.sqrt(x*x + y*y);
                if (Math.abs(dist - r) < 0.6) sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override public String toString() {
        return getNombre() + " (radio=" + radio + ")";
    }
}

// ---- Clase principal ----
public class Ejemplo_Clase10 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // para puntos decimales

        // Arreglo lineal de figuras + contador
        Figura[] figuras = new Figura[10];
        int count = 0;

        // Agregamos algunas figuras
        figuras[count++] = new Rectangulo(4, 2);
        figuras[count++] = new Circulo(3);
        figuras[count++] = new Rectangulo(5, 1);
        figuras[count++] = new Circulo(1.5);

        // Recorrer y mostrar datos (polimorfismo)
        System.out.println("--- Figuras registradas ---");
        for (int i = 0; i < count; i++) {
            Figura f = figuras[i];
            System.out.printf("%d) %s -> area=%.2f, perimetro=%.2f%n",
                    i+1, f.toString(), f.area(), f.perimetro());
        }

        // “Dibujar” solo las que implementan la interfaz Dibujable
        System.out.println("\n--- Dibujos (interfaz Dibujable) ---");
        for (int i = 0; i < count; i++) {
            Figura f = figuras[i];
            if (f instanceof Dibujable) {
                System.out.println(f.getNombre() + " #" + (i+1));
                System.out.println(((Dibujable) f).dibujar());
            }
        }
    }
}
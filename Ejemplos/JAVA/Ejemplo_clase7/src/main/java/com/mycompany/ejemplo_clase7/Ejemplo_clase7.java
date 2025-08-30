/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo_clase7;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author pablo
 */
public class Ejemplo_clase7 {

    // =========================
    // FIBONACCI
    // =========================
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // =========================
    // ACKERMANN
    // =========================
    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

    // =========================
    // leer entero con validación
    // =========================
    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine(); // limpiar salto pendiente
                return val;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ingresa un número entero.");
                sc.nextLine(); // descartar input incorrecto
            }
        }
    }

    // =========================
    // Manejo de archivos
    // =========================
    private static void manejoDeArchivos(Scanner sc) {
        System.out.print("Ingresa el nombre del archivo (ejemplo: datos.txt): ");
        String nombreArchivo = sc.nextLine();
        File archivo = new File(nombreArchivo);

        System.out.println("== MANEJO DE ARCHIVOS ==");
        try {
            System.out.println("Creando objeto File con nombre: " + nombreArchivo);
            System.out.println("Verificando si el archivo existe...");

            if (archivo.exists()) {
                System.out.println("El archivo ya existe en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo no existe. Intentando crearlo físicamente...");
                boolean creado = archivo.createNewFile();
                if (creado) {
                    System.out.println("Archivo creado: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("ERROR: No se pudo crear el archivo (posibles permisos/ruta).");
                }
            }

            System.out.println("Abriendo FileWriter para ESCRIBIR (sobrescribe contenido)...");
            try (FileWriter escritor = new FileWriter(archivo)) {
                System.out.println("Escribiendo líneas de texto...");
                escritor.write("Primera línea escrita con FileWriter.\n");
                escritor.write("Segunda línea.\n");
                escritor.write("Tercera línea.\n");
                System.out.println("Cerrando FileWriter...");
            }

            System.out.println("Abriendo FileReader para LEER el archivo carácter por carácter...");
            try (FileReader lector = new FileReader(archivo)) {
                int c;
                System.out.println("Contenido del archivo:");
                while ((c = lector.read()) != -1) {
                    System.out.print((char) c);
                }
                System.out.println();
                System.out.println("Cerrando FileReader...");
            }

            System.out.println("Operaciones de archivo completadas con éxito.");

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrió un error durante el manejo de archivos.");
            e.printStackTrace();
        }
        System.out.println("=========================\n");
    }

    // =========================
    // Métodos recursivos
    // =========================
    private static void metodosRecursivos(Scanner sc) {
        while (true) {
            System.out.println("== MÉTODOS RECURSIVOS ==");
            System.out.println("1) Fibonacci");
            System.out.println("2) Ackermann");
            System.out.println("3) Volver al menú principal");
            int op = leerEntero(sc, "Elige una opción: ");

            switch (op) {
                case 1: {
                    int n = leerEntero(sc, "Ingresa n (>=0) para Fibonacci: ");
                    if (n < 0) {
                        System.out.println("n debe ser >= 0.\n");
                        break;
                    }
                    int resultado = fibonacci(n);
                    System.out.println("Fibonacci(" + n + ") = " + resultado + "\n");
                    break;
                }
                case 2: {
                    System.out.println("¡Advertencia! Ackermann crece muy rápido y puede causar StackOverflow con valores medianos.");
                    int m = leerEntero(sc, "Ingresa m (>=0) para Ackermann: ");
                    int n = leerEntero(sc, "Ingresa n (>=0) para Ackermann: ");
                    if (m < 0 || n < 0) {
                        System.out.println("m y n deben ser >= 0.\n");
                        break;
                    }
                    try {
                        int resultado = ackermann(m, n);
                        System.out.println("Ackermann(" + m + ", " + n + ") = " + resultado + "\n");
                    } catch (StackOverflowError err) {
                        System.out.println("ERROR: valores demasiado grandes para Ackermann.\n");
                    }
                    break;
                }
                case 3:
                    System.out.println();
                    return;
                default:
                    System.out.println("Opción no válida.\n");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== MENÚ ====");
            System.out.println("1. Manejo de archivos");
            System.out.println("2. Métodos recursivos");
            System.out.println("3. Salir");
            int opcion = leerEntero(sc, "Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    manejoDeArchivos(sc);
                    break;
                case 2:
                    metodosRecursivos(sc);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.\n");
            }
        }
    }
}

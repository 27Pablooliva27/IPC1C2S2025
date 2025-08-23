/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemplo_clase6;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Ejemplo_Clase6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arreglo (array) de 5 enteros
        int[] numeros = new int[5];

        boolean salir = false;

        // do-while: menú que se repite hasta que el usuario elija salir
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Llenar arreglo");
            System.out.println("2) Mostrar arreglo y ver si es par o impar");
            System.out.println("3) Buscar un número (usa while)");
            System.out.println("4) Dividir elemento i entre elemento j (try-catch-finally)");
            System.out.println("5) Salir");

            int opcion = leerEntero(sc, "Elige una opcion: ");

            // if: decidir según la opción
            if (opcion == 1) {
                // for: recorrer índices del arreglo para llenarlo
                for (int i = 0; i < numeros.length; i++) {
                    numeros[i] = leerEntero(sc, "Ingresa numeros[" + i + "]: ");
                }
                System.out.println("Arreglo cargado.");
            } else if (opcion == 2) {
                System.out.println("Contenido del arreglo:");
                // for: recorrer y mostrar, con if para par/impar
                for (int i = 0; i < numeros.length; i++) {
                    int n = numeros[i];
                    if (n % 2 == 0) {
                        System.out.println("numeros[" + i + "] = " + n + " -> par");
                    } else {
                        System.out.println("numeros[" + i + "] = " + n + " -> impar");
                    }
                }
            } else if (opcion == 3) {
                int objetivo = leerEntero(sc, "Numero a buscar: ");
                int i = 0;
                boolean encontrado = false;

                // while: recorrer hasta encontrar o terminar
                while (i < numeros.length) {
                    if (numeros[i] == objetivo) {
                        encontrado = true;
                        break; // salir cuando se encuentra
                    }
                    i++;
                }

                if (encontrado) {
                    System.out.println("Encontrado en la posición " + i + ".");
                } else {
                    System.out.println("No se encontro el numero en el arreglo.");
                }
            } else if (opcion == 4) {
                // Operación con try-catch-finally para mostrar manejo de excepciones comunes
                int i = leerEntero(sc, "Indice i (0 a " + (numeros.length - 1) + "): ");
                int j = leerEntero(sc, "Indice j (0 a " + (numeros.length - 1) + "): ");

                try {
                    // Posibles errores:
                    // - ArrayIndexOutOfBoundsException si i o j están fuera de rango
                    // - ArithmeticException si numeros[j] es 0 (división entre cero)
                    int resultado = numeros[i] / numeros[j];
                    System.out.println("numeros[" + i + "] / numeros[" + j + "] = " + resultado);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: indice fuera de rango. Usa valores entre 0 y " + (numeros.length - 1) + ".");
                } catch (ArithmeticException e) {
                    System.out.println("Error: no se puede dividir entre cero.");
                } finally {
                    // finally: SIEMPRE se ejecuta, ocurra o no una excepción
                    System.out.println("Bloque finally: la operación de division ha finalizado.");
                }
            } else if (opcion == 5) {
                salir = true;
            } else {
                System.out.println("Opcion invalida. Intenta de nuevo.");
            }

        } while (!salir); // do-while: repetir mientras no se elija salir

        sc.close();
        System.out.println("Programa terminado. ¡Gracias!");

    }

    static int leerEntero(Scanner sc, String mensaje) {
        while (true) { // while: repetir hasta obtener un entero válido
            System.out.print(mensaje);
            String linea = sc.nextLine();
            try {
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) { // try-catch: manejar error de formato
                System.out.println("Entrada invalida. Debe ser un numero entero. Intenta de nuevo.");
            }
        }
    }
}

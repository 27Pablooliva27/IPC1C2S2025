/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemplo_clase4;

import java.util.Vector;

/**
 *
 * @author pablo
 */
public class Ejemplo_Clase4 {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("EJEMPLO DE JAVA");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("DECLARACIÓN DE VARIABLES");
        System.out.println("------------------------------------------------------------------------------------------");
        //DECLARACIÓN DE VARIABLES
        //ENTERO
        int VariableEntero = 10;
        double VariableDouble = 10.5;
        String VariableTexto = "Hola Mundo";
        boolean VariableBoolean = true;

        System.out.println("Esta es la variable int: " + VariableEntero);
        System.out.println("Esta es la variable double: " + VariableDouble);
        System.out.println("Esta es la variable String: " + VariableTexto);
        System.out.println("Esta es la variable boolean: " + VariableBoolean);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("SENTENCIA IF");
        System.out.println("------------------------------------------------------------------------------------------");
        // SENTENCIA IF
        if (VariableEntero == 10) {
            VariableEntero = 15;
        }
        System.out.println("El valor de la variable VariableEntero es: " + VariableEntero);

        if (VariableBoolean) {
            //Condición verdadera
            System.out.println("Resultado en if");

        } else if (VariableTexto.equals("Hola Mundo")) {
            //Segunda Condición
            System.out.println("Resultado en else if");
        } else {
            System.out.println("Resultado en else de un if");
        }

        System.out.println("Esta es la variable int: " + VariableEntero);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("DECLARACIÓN DE VECTORES");
        System.out.println("------------------------------------------------------------------------------------------");
        // DECLARACION DE VECTOR
        Vector<String> Persona = new Vector<>();
        Persona.add("Juan");
        Persona.add("Luis");
        Persona.add("Alejandra");
        Persona.add("Francisco");
        System.out.println("El tamaño del vector es: " + Persona.size());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("SENTENCIA FOR");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("El valor de i es: " + i);
        }
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 10; i >= 0; i--) {
            System.out.println("El valor de i es: " + i);
        }
        System.out.println("------------------------------------------------------------------------------------------");
        for (String nombre : Persona) {
            System.out.println(nombre);
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("SENTENCIA WHILE");
        System.out.println("------------------------------------------------------------------------------------------");
        while (VariableEntero >= 0) {
            System.out.println("El valor de la variable VariableEntero es: " + VariableEntero);
            VariableEntero--;
            break;
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("LLAMADA A METODOS");
        System.out.println("------------------------------------------------------------------------------------------");
        Prueba_Metodo();
        System.out.println("------------------------------------------------------------------------------------------");
        int VariableFuncion;
        System.out.println("LLAMADA A FUNCIONES");
        System.out.println("------------------------------------------------------------------------------------------");
        VariableFuncion = Prueba_funcion();
        System.out.println("El valor de la variable VariableFuncion es: " + VariableFuncion);
    }

    public static void Prueba_Metodo() {
        System.out.println("Llamada al codigo del metodo");
        double VariableDouble = 63.75;
        System.out.println("La variable VariableDouble vale: " + VariableDouble);
    }

    public static int Prueba_funcion() {
        System.out.println("Llamada al codigo de la funcion");
        int VariableEntero = 25;
        System.out.println("La variable VariableEntero vale: " + VariableEntero);
        return VariableEntero;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo_clase10_serializacion;
import java.io.*;
/**
 *
 * @author pablo
 */
class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class Ejemplo_clase10_Serializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Serialización
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.ser"))) {
            Persona persona = new Persona("Juan", 30);
            Persona persona1 = new Persona("Prueba", 25);
            oos.writeObject(persona);
            oos.writeObject(persona1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialización
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.ser"))) {
            Persona persona = (Persona) ois.readObject();
            System.out.println("Nombre: " + persona.nombre + ", Edad: " + persona.edad);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
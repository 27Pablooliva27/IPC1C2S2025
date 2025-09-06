/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemplo_clase8;

import java.util.Scanner;
import java.util.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pablo
 */
public class Ejemplo_Clase8 {

    private static final Scanner sc = new Scanner(System.in);
    private static Producto[] inventario = new Producto[10]; 
    private static int count = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---- MENÚ ----");
            System.out.println("1) Ejemplo PDF");
            System.out.println("2) Ejemplo POO (Agregar, Mostrar, Exportar)");
            System.out.println("3) Salir");
            System.out.print("Elige opción: ");
            String op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    ejemploPdf();
                    break;
                case "2":
                    menuPOO();
                    break;
                case "3":
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no valida.");
            }
        }
    }

    private static void ejemploPdf() {
        try {
            System.out.print("Ruta/nombre del PDF a crear (por defecto 'ejemplo.pdf'): ");
            String path = sc.nextLine().trim();
            if (path.isEmpty()) {
                path = "ejemplo.pdf";
            }

            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);

            doc.add(new Paragraph("Hola, iText 7 desde Java"));
            doc.add(new Paragraph("Generado: "
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

            Table table = new Table(new float[]{4, 2});
            table.useAllAvailableWidth();
            table.addHeaderCell(new Cell().add(new Paragraph("Descripcion")));
            table.addHeaderCell(new Cell().add(new Paragraph("Valor")));
            table.addCell(new Cell().add(new Paragraph("Autor")));
            table.addCell(new Cell().add(new Paragraph(System.getProperty("user.name"))));
            table.addCell(new Cell().add(new Paragraph("SO")));
            table.addCell(new Cell().add(new Paragraph(System.getProperty("os.name"))));
            doc.add(table);

            doc.close();
            System.out.println("PDF creado: " + path);
        } catch (Exception e) {
            System.err.println("Error creando PDF: " + e.getMessage());
        }
    }

    // ----- Submenu POO -----
    private static void menuPOO() {
        while (true) {
            System.out.println("\n-- POO --");
            System.out.println("1) Agregar producto");
            System.out.println("2) Mostrar productos");
            System.out.println("3) Exportar productos a PDF");
            System.out.println("4) Volver al menú principal");
            System.out.print("Elige opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    mostrarProductos();
                    break;
                case "3":
                    exportarProductosPdf();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarProducto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Precio: ");
        double precio = leerDouble();


        if (count == inventario.length) {
            Producto[] nuevo = new Producto[inventario.length * 2];
            for (int i = 0; i < inventario.length; i++) {
                nuevo[i] = inventario[i];
            }
            inventario = nuevo;
        }

        inventario[count++] = new Producto(nombre, precio);
        System.out.println("Producto agregado.");
    }

    private static void mostrarProductos() {
        if (count == 0) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        System.out.println("\nID\t\tNombre\t\tPrecio");
        for (int i = 0; i < count; i++) {
            Producto p = inventario[i];
            System.out.printf("%s\t%s\t\t%.2f%n",
                    p.getId().substring(0, 8), p.getNombre(), p.getPrecio());
        }
    }

    // === Exporta el inventario a un PDF ===
    private static void exportarProductosPdf() {
        if (count == 0) {
            System.out.println("No hay productos para exportar.");
            return;
        }
        System.out.print("Ruta/nombre del PDF (por defecto 'productos.pdf'): ");
        String path = sc.nextLine().trim();
        if (path.isEmpty()) {
            path = "productos.pdf";
        }

        try (PdfWriter writer = new PdfWriter(path); PdfDocument pdf = new PdfDocument(writer); Document doc = new Document(pdf)) {

            doc.add(new Paragraph("Inventario de Productos (arreglos)")
                    .setBold()
                    .setFontSize(14));
            doc.add(new Paragraph("Generado: "
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

            Table table = new Table(new float[]{3, 6, 3});
            table.useAllAvailableWidth();
            table.addHeaderCell(new Cell().add(new Paragraph("ID")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nombre")));
            table.addHeaderCell(new Cell().add(new Paragraph("Precio")));

            double total = 0.0;
            for (int i = 0; i < count; i++) {
                Producto p = inventario[i];
                table.addCell(new Cell().add(new Paragraph(p.getId().substring(0, 8))));
                table.addCell(new Cell().add(new Paragraph(p.getNombre())));
                table.addCell(new Cell().add(new Paragraph(String.format("%.2f", p.getPrecio()))));
                total += p.getPrecio();
            }

            // Fila resumen
            table.addCell(new Cell(1, 2).add(new Paragraph("Total productos: " + count)));
            table.addCell(new Cell().add(new Paragraph(String.format("%.2f", total))));

            doc.add(table);
            System.out.println("PDF de productos creado: " + path);
        } catch (Exception e) {
            System.err.println("Error exportando PDF: " + e.getMessage());
        }
    }

    private static double leerDouble() {
        while (true) {
            String s = sc.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido, intenta de nuevo: ");
            }
        }
    }

    // --- Clase de dominio (POO) ---
    public static class Producto {

        private final String id = java.util.UUID.randomUUID().toString();
        private final String nombre;
        private final double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

// Package declaration
package com.mycompany.java_01.pract;

// Imports
import java.util.Scanner; // Importar la clase Scanner para leer entradas del usuario

/**
 *
 * @author administrador
 */
public class Java_01 {

    public static void main(String[] args) {
        /*
         * Se requiere calcular las horas extras devengadas por 1 empleado, en un rango
         * de meses, tomar en cuenta lo siguiente, si el empleado gana mas de 2 SMLV
         * cada hora extra que se encuentre en la primera quincena y, no sea fin de
         * semana se paga al 1% del salario devengado, si es fin de semana al 2% si en
         * caso dado es la segunda semana, se pagan por igual fines de semanas o no a
         * 3%. Si en caso dado el empleado gana menos de 2 SMLV, entonces infomarles que
         * aun no esta disponible dicho modulo para su estirpe.
         */
        // Crear un objeto Scanner para leer entradas del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine(); // Lee una línea de texto

        System.out.println("Enter your age: ");
        int age = scanner.nextInt(); // Lee un numero entero

        System.out.println("Enter your height in meters (e.g., 1.75): ");
        double height = scanner.nextDouble(); // Lee un número decimal

        System.out.println("Id number: ");
        long idNumber = scanner.nextLong(); // Lee un número largo
        scanner.close();

        // ------------------------------------------
        System.out.println("*********************************************************");
        System.out.println("Your dates: ");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("Your height is: " + height + " meters");
        System.out.println("Your ID number is: " + idNumber);
        System.out.println("*********************************************************");

        // --- Formatted output --- //
        System.out.printf("Your name is: %s%n", name);
        System.out.printf("Your age is: %d years%n", age);
        System.out.printf("Your height is: %.2f meters%n", height);
        System.out.printf("Your ID number is: %d%n", idNumber);

        System.out.println("---------------------------------------------------------");

        System.out.println("""
                Welcome to Java programming!
                Your name is: %s
                Your age is: %d years
                Your height is: %.2f meters
                Your ID number is: %d
                """.formatted(name, age, height, idNumber));
    }
}

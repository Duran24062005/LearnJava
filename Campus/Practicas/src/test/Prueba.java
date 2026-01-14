package test;

import java.util.Scanner;

import controller.UserController;

public class Prueba {

    public static void main(String[] args) {
        /*
         * Se requiere calcular las horas extras devengadas por 1 empleado,
         * en un dia, tomar en cuenta lo siguiente, si el empleado gana mas de 2 SMLV
         * cada hora extra que se encuentre en la primera quincena y, no sea fin de
         * semana
         * se paga al 1% del salario devengado, si es fin de semana al 2% si en caso
         * dado es
         * la segunda quicena, se pagan por igual fines de semanas o no a 3%. Si en caso
         * dado el empleado gana menos de 2 SMLV, entonces infomarles que aun no esta
         * disponible dicho modulo para su estirpe.
         */
        Scanner x = new Scanner(System.in);
        double salary = 0;
        double minWage = 2;
        int overTime = 0;
        String message = "";

        // Salario
        System.out.println("""
                ===================================================
                        Bienvenido a nuestro sistema
                ===================================================
                Por favor, ingrese su salario:
                """);
        salary = x.nextDouble();

        // Horas extras
        System.out.println("""
                Por favor diga cuantas horas extras:
                """);
        overTime = x.nextInt();

        if (salary < minWage) {
            System.out.println(message);
        } else {
            System.out.println(overTime);
        }

        UserController usuario = new UserController("Alexi Duran Gomez");
        usuario.great();

        x.close();
    }

    public static void Saludar() {
        System.out.println("""
                Hola
                """);
    }

}

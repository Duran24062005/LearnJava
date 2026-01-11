//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the
        // highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("""
                                            Hello and welcome!
                                    This is the Expense Manager application.
                You can use this application to track your expenses and manage your budget effectively.
                                            Enjoy using the app!
                                        """);
        boolean program = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                    =============================================
                             Simulador de Gasto Diario
                    =============================================
                    Seleccione una opción:

                        1. Registrar nuevo gasto
                        2. Listar gastos
                        3. Calcular total de gastos
                        4. Generar reporte de gastos
                        5. Salir
                    =============================================
                                    """);
            try {
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Registrar nuevo gasto seleccionado.");
                        // Lógica para registrar un nuevo gasto
                        break;
                    case 2:
                        System.out.println("Listar gastos seleccionado.");
                        // Lógica para listar gastos
                        break;
                    case 3:
                        System.out.println("Calcular total de gastos seleccionado.");
                        // Lógica para calcular total de gastos
                        break;
                    case 4:
                        System.out.println("Generar reporte de gastos seleccionado.");
                        // Lógica para generar reporte de gastos
                        break;
                    case 5:
                        System.out.println("¿Estas seguro que quieres salir? (S/N)");
                        String confirmExit = sc.next();
                        if (confirmExit.equalsIgnoreCase("N")) {
                            System.out.println("Regresando al menú principal.");
                            break;
                        }
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        program = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
                }

            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                sc.next(); // Limpiar el buffer del scanner
            }

        } while (program);
        sc.close();
    }
}
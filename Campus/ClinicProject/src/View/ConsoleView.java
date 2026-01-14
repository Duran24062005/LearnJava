package View;

import java.util.Scanner;

import interfaces.IView;

public class ConsoleView implements IView {

    private final Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("""
                *--------------------------------------------------*
                |           Bienbenido a nuestro sistema           |
                *--------------------------------------------------*
                    1. Registrar paciente.
                    2. Mostrar pacientes.
                    3. Atender paciente.
                    4. Salir.
                ----------------------------------------------------
                Opción:
                """);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public int Salir() {
        while (true) {
            System.out.println("""
                    \n¿Estás seguro que quieres salir?
                        Presiona s/n
                        S: para salir.
                        N: para cancelar.
                    """);
            String opt = scanner.nextLine();
            if (opt.equals("s")) {
                return 5;
            }
            if (opt.equals("n")) {
                return 1;
            }
            System.out.println("\nOpción invalida, intente nuevamente.\n");
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}

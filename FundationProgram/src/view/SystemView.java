package view;

import java.util.Scanner;

import interfaces.ISystemView;

public class SystemView implements ISystemView {

    private final Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("""
                *--------------------------------------------------*
                |           Bienbenido a nuestro sistema           |
                *--------------------------------------------------*
                    1. Registrar persona.
                    2. Listar personas.
                    3. Buscar persona.
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

    @Override
    public int registerCollaborator() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int registerEmployee() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int registerBeneficiary() {
        // TODO Auto-generated method stub
        return 0;
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

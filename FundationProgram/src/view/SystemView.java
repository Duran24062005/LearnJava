package view;

import java.util.Scanner;

import interfaces.ISystemView;
import model.PersonaModel;
import model.EmpleadoModel;
import model.ColaboradorModel;
import model.BeneficiciarioModel;

public class SystemView implements ISystemView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int menu() {
        System.out.println("""

                ╔═══════════════════════════════════════════════════════╗
                ║        FUNDACIÓN DE AYUDAS COMUNITARIAS               ║
                ║              Sistema de Registro                      ║
                ╚═══════════════════════════════════════════════════════╝

                    1. Registrar Empleado
                    2. Registrar Colaborador Voluntario
                    3. Registrar Beneficiario
                    4. Listar todas las personas
                    5. Buscar persona por documento
                    6. Ver estadísticas
                    7. Salir
                ────────────────────────────────────────────────────────
                Opción: """);

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public PersonaModel registerEmployee() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("           REGISTRO DE EMPLEADO");
        System.out.println("═".repeat(60));

        try {
            // Datos comunes
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Apellido: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Documento: ");
            String document = scanner.nextLine().trim();

            System.out.print("Edad: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Dirección: ");
            String address = scanner.nextLine().trim();

            // Datos específicos de empleado
            System.out.print("Salario: $");
            double salario = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Cargo: ");
            String cargo = scanner.nextLine().trim();

            System.out.println("\nHorarios disponibles:");
            System.out.println("  1. 8-5 pm");
            System.out.println("  2. 2-11 pm");
            System.out.print("Seleccione horario (1 o 2): ");
            int opcionHorario = Integer.parseInt(scanner.nextLine().trim());

            String horario = (opcionHorario == 1) ? "8-5 pm" : "2-11 pm";

            return new EmpleadoModel(firstName, lastName, age, document, address,
                    salario, cargo, horario);

        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar un número válido");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
            return null;
        }
    }

    @Override
    public PersonaModel registerCollaborator() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("       REGISTRO DE COLABORADOR VOLUNTARIO");
        System.out.println("═".repeat(60));

        try {
            // Datos comunes
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Apellido: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Documento: ");
            String document = scanner.nextLine().trim();

            System.out.print("Edad: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Dirección: ");
            String address = scanner.nextLine().trim();

            // Datos específicos de colaborador
            System.out.print("Horas por mes (máximo 25): ");
            int horas = Integer.parseInt(scanner.nextLine().trim());

            ColaboradorModel colaborador = new ColaboradorModel(
                    firstName, lastName, age, document, address, horas);

            System.out.println("\n💰 Bonificación mensual: $" + colaborador.calculateBonus());

            return colaborador;

        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar un número válido");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
            return null;
        }
    }

    @Override
    public PersonaModel registerBeneficiary() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("           REGISTRO DE BENEFICIARIO");
        System.out.println("═".repeat(60));

        try {
            // Datos comunes
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Apellido: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Documento: ");
            String document = scanner.nextLine().trim();

            System.out.print("Edad: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Dirección: ");
            String address = scanner.nextLine().trim();

            // Datos específicos de beneficiario
            System.out.print("Cantidad de ayudas por mes (máximo 5): ");
            int ayudas = Integer.parseInt(scanner.nextLine().trim());

            return new BeneficiciarioModel(firstName, lastName, age, document, address, ayudas);

        } catch (NumberFormatException e) {
            System.out.println("✗ Error: Debe ingresar un número válido");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String requestDocument() {
        System.out.print("\nIngrese el número de documento: ");
        return scanner.nextLine().trim();
    }

    public boolean confirmExit() {
        while (true) {
            System.out.println("""

                    ¿Está seguro que desea salir?
                        S: para salir
                        N: para cancelar
                    """);
            System.out.print("Opción: ");
            String opt = scanner.nextLine().trim().toLowerCase();

            if (opt.equals("s")) {
                return true;
            }
            if (opt.equals("n")) {
                return false;
            }
            System.out.println("\n✗ Opción inválida. Intente nuevamente.\n");
        }
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.out.println("✗ ERROR: " + error);
    }

    public void showSuccess(String message) {
        System.out.println("✓ " + message);
    }
}
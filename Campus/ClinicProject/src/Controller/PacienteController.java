package Controller;

import Model.Paciente;
import View.ConsoleView;
import interfaces.IPacienteController;
import services.PacienteService;

public class PacienteController implements IPacienteController {

    private final PacienteService service;
    private final ConsoleView view;

    public PacienteController(PacienteService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = view.menu();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> service.mostrar();
                case 3 -> atender();
                case 4 -> {
                    opcion = view.Salir();
                }
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public void registrar() {
        try {
            var sc = view.getScanner();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Documento: ");
            String documento = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Motivo: ");
            String motivo = sc.nextLine();

            System.out.print("Teléfonos (separados por coma): ");
            String telefonos = sc.nextLine();

            Paciente paciente = new Paciente(
                    nombre, documento, edad, motivo, telefonos);

            if (!service.registrar(paciente)) {
                System.out.println("No hay cupos disponibles");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void atender() {
        if (!service.atenderPaciente()) {
            System.out.println("No hay pacientes para atender");
        }
        System.out.println("antendiendo paciente...\n\t");
    }
}
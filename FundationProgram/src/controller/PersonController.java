package controller;

import interfaces.IController;
import model.PersonaModel;
import service.PersonService;
import view.SystemView;

/**
 * Controlador que maneja el flujo de la aplicación
 * Sigue el principio de Responsabilidad Única (SRP):
 * - Solo coordina entre la vista y el servicio
 * - No contiene lógica de negocio
 * - No maneja directamente los datos
 */
public class PersonController implements IController {

    private final PersonService service;
    private final SystemView view;

    public PersonController(PersonService service, SystemView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void init() {
        System.out.println("\n¡Bienvenido al Sistema de Gestión de la Fundación!\n");

        int option;
        do {
            option = view.menu();
            processOption(option);
        } while (option != 7);

        System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.\n");
    }

    /**
     * Procesa la opción seleccionada por el usuario
     * Principio Open/Closed: Si necesitamos añadir opciones,
     * podemos extender sin modificar el código existente
     */
    private void processOption(int option) {
        switch (option) {
            case 1 -> registerEmployee();
            case 2 -> registerCollaborator();
            case 3 -> registerBeneficiary();
            case 4 -> listAllPersons();
            case 5 -> searchPerson();
            case 6 -> showStatistics();
            case 7 -> exitSystem();
            default -> view.showError("Opción inválida. Intente nuevamente.");
        }
    }

    /**
     * Registra un empleado
     */
    private void registerEmployee() {
        PersonaModel employee = view.registerEmployee();
        if (employee != null) {
            service.regiterPerson(employee);
        }
    }

    /**
     * Registra un colaborador
     */
    private void registerCollaborator() {
        PersonaModel collaborator = view.registerCollaborator();
        if (collaborator != null) {
            service.regiterPerson(collaborator);
        }
    }

    /**
     * Registra un beneficiario
     */
    private void registerBeneficiary() {
        PersonaModel beneficiary = view.registerBeneficiary();
        if (beneficiary != null) {
            service.regiterPerson(beneficiary);
        }
    }

    /**
     * Lista todas las personas registradas
     */
    private void listAllPersons() {
        service.showPerson();
    }

    /**
     * Busca una persona por documento
     */
    private void searchPerson() {
        String document = view.requestDocument();
        if (document != null && !document.isEmpty()) {
            service.showOneByDocument(document);
        } else {
            view.showError("Debe ingresar un documento válido");
        }
    }

    /**
     * Muestra las estadísticas del sistema
     */
    private void showStatistics() {
        service.showStatistics();
    }

    /**
     * Maneja la salida del sistema
     */
    private void exitSystem() {
        if (view.confirmExit()) {
            view.showMessage("\n👋 Cerrando el sistema...");
        }
    }

    @Override
    public void register() {
        // Método de la interfaz, pero usamos los métodos específicos
        view.showMessage("Use las opciones del menú para registrar personas");
    }
}

/*
 * try {
 * var sc = view.getScanner();
 * 
 * System.out.print("Nombre: ");
 * String fisrtName = sc.nextLine();
 * 
 * System.out.print("Apellido: ");
 * String lastName = sc.nextLine();
 * 
 * System.out.print("Documento: ");
 * String document = sc.nextLine();
 * 
 * System.out.print("Edad: ");
 * int age = Integer.parseInt(sc.nextLine());
 * 
 * System.out.print("Documento: ");
 * String address = sc.nextLine();
 * 
 * PersonaModel paciente = new PersonaModel(
 * fisrtName, lastName, age, document, address);
 * 
 * if (!service.registrar(paciente)) {
 * System.out.println("No hay cupos disponibles");
 * }
 * 
 * } catch (Exception e) {
 * System.out.println("Error: " + e.getMessage());
 * }
 */
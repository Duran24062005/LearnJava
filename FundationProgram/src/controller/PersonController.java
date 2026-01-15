package controller;

import interfaces.IController;
import model.PersonaModel;
import service.PersonService;
import view.SystemView;

public class PersonController implements IController {
    private final PersonService service;
    private final SystemView view;

    public PersonController(PersonService service, SystemView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void init() {
        int option;
        do {
            option = view.menu();

            switch (option) {
                case 1:
                    register();
                case 2:
                    register();
                case 3:
                    register();
                case 4:
                    register();
                default:
                    break;
            }
        } while (option != 5);
    }

    @Override
    public void register() {
        view.
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
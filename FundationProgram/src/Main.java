//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import controller.PersonController;
import repository.PersonaRepository;
import service.PersonService;
import view.SystemView;

/**
 * Clase principal que inicia la aplicación
 * 
 * Arquitectura en capas:
 * - View: Maneja la interacción con el usuario
 * - Controller: Coordina el flujo de la aplicación
 * - Service: Contiene la lógica de negocio
 * - Repository: Maneja el acceso a datos
 * - Model: Define las entidades del sistema
 */

public class Main {
    public static void main(String[] args) {
        PersonaRepository repo = new PersonaRepository();
        PersonService service = new PersonService(repo);
        SystemView view = new SystemView();
        PersonController controller = new PersonController(service, view);

        controller.init();
    }
}
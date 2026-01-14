import Controller.PacienteController;
import View.ConsoleView;
import repository.PacienteRepository;
import services.PacienteService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PacienteRepository repo = new PacienteRepository();
        PacienteService service = new PacienteService(repo);
        ConsoleView view = new ConsoleView();
        PacienteController controller = new PacienteController(service, view);

        controller.iniciar();
    }
}

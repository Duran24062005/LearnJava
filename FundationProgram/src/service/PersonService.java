package service;

import java.util.List;

import interfaces.IPersonService;
import model.BeneficiciarioModel;
import model.ColaboradorModel;
import model.EmpleadoModel;
import model.PersonaModel;
import repository.PersonaRepository;

public class PersonService implements IPersonService {

    private final PersonaRepository repository;

    public PersonService(PersonaRepository repository) {
        this.repository = repository;
    }

    // Getter
    public PersonaRepository getRepository() {
        return repository;
    }

    @Override
    public boolean regiterPerson(PersonaModel person) {
        if (person == null) {
            System.out.println("Error: The person cannot be null");
            return false;
        }

        boolean saved = repository.save(person);
        if (saved) {
            System.out.println("\n Person resgistered successfully!");
            return true;
        } else {
            System.out.println("\n The person could not be registered.");
            return false;
        }

    }

    @Override
    public void showPerson() {
        List<PersonaModel> allPersons = repository.showAll();

        if (allPersons.isEmpty()) {
            System.out.println("\n There are no people registered in the system.\n");
            return;
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("           LISTADO DE PERSONAS REGISTRADAS");
        System.out.println("=".repeat(60));

        // Separar por tipo
        List<EmpleadoModel> employees = allPersons.stream()
                .filter(p -> p instanceof EmpleadoModel)
                .map(p -> (EmpleadoModel) p)
                .toList();

        List<BeneficiciarioModel> beneficiarys = allPersons.stream()
                .filter(p -> p instanceof BeneficiciarioModel)
                .map(p -> (BeneficiciarioModel) p)
                .toList();

        List<ColaboradorModel> colaborators = allPersons.stream()
                .filter(p -> p instanceof ColaboradorModel)
                .map(p -> (ColaboradorModel) p)
                .toList();

        // Mostramos empleados
        if (!employees.isEmpty()) {
            System.out.println("\n📋 EMPLEADOS (" + employees.size() + "):");
            System.out.println("-".repeat(60));
            employees.forEach(e -> System.out.println(e.toString()));
        }

        // Mostramos colaboradores
        if (!colaborators.isEmpty()) {
            System.out.println("\n🤝 COLABORADORES (" + colaborators.size() + "):");
            System.out.println("-".repeat(60));
            colaborators.forEach(c -> System.out.println("  • " + c.toString()));
        }

        // Mostramos beneficiarios
        if (!beneficiarys.isEmpty()) {
            System.out.println("\n💙 BENEFICIARIOS (" + beneficiarys.size() + "):");
            System.out.println("-".repeat(60));
            beneficiarys.forEach(b -> System.out.println("  • " + b.toString()));
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("Total de personas: " + allPersons.size());
        System.out.println("=".repeat(60) + "\n");

    }

    @Override
    public void showOneByDocument() {
        // TODO Auto-generated method stub

    }

    @Override
    public void searchByName() {
    }

    @Override
    public void showStatics() {
        // TODO Auto-generated method stub

    }

}

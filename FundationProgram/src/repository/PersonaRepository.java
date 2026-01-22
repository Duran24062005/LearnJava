package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.IPersonRepository;
import model.PersonaModel;

public class PersonaRepository implements IPersonRepository {
    private List<PersonaModel> persons;

    public PersonaRepository() {
        this.persons = new ArrayList<>();
    }

    @Override
    public boolean save(PersonaModel person) {
        if (person == null) {
            return false;
        }

        // Verificar si ya existe una persona con ese documento
        if (existByDocument(person.getDocument())) {
            System.out.println("There is already exist a person with this document: " + person.getDocument());
            return false;
        }

        persons.add(person);
        return true;
    }

    @Override
    public List<PersonaModel> showAll() {
        if (persons.size() < 1) {
            return new ArrayList<>();
        }
        return new ArrayList<>(persons); // Retornamos una copia para proteger la lista original
    }

    @Override
    public PersonaModel showOne(String document) {
        if (document == null || document.trim().isEmpty())
            System.out.println("This argument is not valid, the document cannot be empty.");

        return persons.stream().filter(p -> p.getDocument().equals(document)).findFirst().orElse(null); // Si no
                                                                                                        // encuentra
                                                                                                        // nada, retorna
                                                                                                        // null
    }

    // Verifica si existe una persona con el documento dado
    private boolean existByDocument(String document) {
        return persons.stream().anyMatch(p -> p.getDocument().equals(document));
    }

    // retorna la cantidad de personas registradas
    public int count() {
        return persons.size();
    }

    // Elimina una persona por su documento
    public boolean deleteByDocument(String document) {
        return persons.removeIf(p -> p.getDocument().equals(document));
    }

    // Buscar personas por nombre
    public List<PersonaModel> findPersonByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String searchTerm = name.toLowerCase();
        return persons.stream().filter(p -> p.getFirstName().toLowerCase().contains(searchTerm)
                || p.getLastName().toLowerCase().contains(searchTerm)).toList();
    }
}

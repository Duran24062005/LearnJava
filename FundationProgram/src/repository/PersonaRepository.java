package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.IPersonRepository;
import model.PersonaModel;

public class PersonaRepository implements IPersonRepository {
    private List<PersonaModel> persons = new ArrayList<PersonaModel>();

    @Override
    public boolean save(PersonaModel person) {
        if (person != null) {
            persons.add(person);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<PersonaModel> showAll() {
        return persons;
    }

    @Override
    public PersonaModel showOne(String parameter) {
        if (parameter == null)
            System.out.println("This argument is not valid");

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }

        return persons.get(1);
    }
}

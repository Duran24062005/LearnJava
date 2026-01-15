package interfaces;

import java.util.List;

import model.PersonaModel;

public interface IPersonRepository {
    boolean save(PersonaModel person);

    List<PersonaModel> showAll();

    PersonaModel showOne(String parameter);
}

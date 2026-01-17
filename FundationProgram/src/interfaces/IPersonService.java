package interfaces;

import model.PersonaModel;

public interface IPersonService {
    boolean regiterPerson(PersonaModel person);

    void showPerson();

    void showOneByDocument(String document);

    void searchByName(String name);

    void showStatistics();
}

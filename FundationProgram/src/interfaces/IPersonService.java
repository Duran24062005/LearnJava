package interfaces;

import model.PersonaModel;

public interface IPersonService {
    boolean regiterPerson(PersonaModel person);

    void showPerson();

    void showOneByDocument();

    void searchByName();

    void showStatics();
}

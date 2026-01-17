package interfaces;

import java.util.Scanner;

import model.PersonaModel;

public interface ISystemView {
    int menu();

    PersonaModel registerEmployee();

    PersonaModel registerCollaborator();

    PersonaModel registerBeneficiary();

    String requestDocument();

    Scanner getScanner();
}

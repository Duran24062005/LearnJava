package interfaces;

import java.util.Scanner;

public interface ISystemView {
    int menu();

    int registerCollaborator();

    int registerEmployee();

    int registerBeneficiary();

    int Salir();

    Scanner getScanner();
}

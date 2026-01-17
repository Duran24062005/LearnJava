package model;

import interfaces.IPersona;

public class BeneficiciarioModel extends PersonaModel implements IPersona {

    private static int MAX_BENEFITS = 5;

    private final int number_benefits_per_month;

    public BeneficiciarioModel(String firstName,
            String lastName,
            int age,
            String document,
            String address,
            int number_benefits_per_month) {
        // Llamada al constructor del padre
        super(firstName, lastName, age, document, address);

        // Validaciones propias de la clase beneficiario
        if (number_benefits_per_month < 0) {
            throw new IllegalArgumentException("The allowances cannot be negatives.");
        }
        if (number_benefits_per_month > MAX_BENEFITS) {
            throw new IllegalArgumentException(
                    "The beneficiary cannot have ");
        }
        this.number_benefits_per_month = number_benefits_per_month;
    }

    // Getters
    public int getNumber_benefits_per_month() {
        return number_benefits_per_month;
    }

    public static int getMAX_BENEFITS() {
        return MAX_BENEFITS;
    }

    // Sobrescribimos el método introduceOneself (Polimorfismo)
    @Override
    public void introduceOneself() {
        System.out.println("""
                ====================================
                BENEFICIARIO
                ====================================
                Nombre: %s %s
                Edad: %d años
                Documento: %s
                Dirección: %s
                Ayudas recibidas por mes: %d
                ====================================
                """.formatted(
                getFirstName(),
                getLastName(),
                getAge(),
                getDocument(),
                getAddress(),
                number_benefits_per_month));
    }

    @Override
    public String toString() {
        return "Beneficiario: " + getFirstName() + " " + getLastName() +
                " - Ayudas por mes: " + number_benefits_per_month;
    }
}

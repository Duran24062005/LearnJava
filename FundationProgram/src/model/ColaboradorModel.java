package model;

import interfaces.IPersona;

public class ColaboradorModel extends PersonaModel implements IPersona {

    private static final int MAX_HOURS = 25;
    private static final double HOURLY_PAY = 55000.0;

    private final int hours_per_month;

    public ColaboradorModel(
            String firstName,
            String lastName,
            int age,
            String document,
            String address,
            int hours_for_month) {
        // Llamado a constructor de la clase padre
        super(firstName, lastName, age, document, address);

        // Validaciones especificas del Colaborador
        if (hours_for_month < 0) {
            throw new IllegalArgumentException("The number of hours must be greater than 0.");
        }
        if (hours_for_month > MAX_HOURS) {
            throw new IllegalArgumentException(
                    "The employee cannot have more than " + MAX_HOURS + " per month.");
        }
        this.hours_per_month = hours_for_month;
    }

    // Getters
    public static int getMaxHours() {
        return MAX_HOURS;
    }

    public static double getHourlyPay() {
        return HOURLY_PAY;
    }

    public int getHours_per_month() {
        return hours_per_month;
    }

    public double calculateBonus() {
        return hours_per_month * HOURLY_PAY;
    }

    // Sobrescribimos el método introduceOneself (Polimorfismo)
    @Override
    public void introduceOneself() {
        System.out.println("""
                ====================================
                COLABORADOR VOLUNTARIO
                ====================================
                Nombre: %s %s
                Edad: %d años
                Documento: %s
                Dirección: %s
                Horas por mes: %d horas
                Bonificación mensual: $%.2f
                ====================================
                """.formatted(
                getFirstName(),
                getLastName(),
                getAge(),
                getDocument(),
                getAddress(),
                hours_per_month,
                calculateBonus()));
    }

    @Override
    public String toString() {
        return "Colaborador: " + getFirstName() + " " + getLastName() +
                " - Horas: " + hours_per_month + " - Bonificación: $" + calculateBonus();
    }

}

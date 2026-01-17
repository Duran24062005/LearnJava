package model;

import interfaces.IPersona;

public class EmpleadoModel extends PersonaModel implements IPersona {
    private final double salary; // salario
    private final String position; // cargo
    private final String schedule; // horario

    public EmpleadoModel(
            String firstName,
            String lastName,
            int age,
            String document,
            String address,
            double salary,
            String position,
            String schedule) {
        // Llamado al constructor de la clase padre (PerosnaModel)
        super(firstName, lastName, age, document, address);

        // Validaciones especificas de Empleado
        if (salary <= 0) {
            throw new IllegalArgumentException("The salary must be greater than 0.");
        }
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("The position cannot be empty.");
        }
        if (!schedule.equals("8-5 pm") && !schedule.equals("2-11 pm")) {
            throw new IllegalArgumentException("Invalid schedule. Must be '8 am to 5 pm' or '2 pm to 11 pm'");
        }

        this.salary = salary;
        this.position = position;
        this.schedule = schedule;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getSchedule() {
        return schedule;
    }

    // Sobrescritura del método introduceOneself (Polimorfismo)
    @Override
    public void introduceOneself() {
        System.out.println("""
                ====================================
                EMPLEADO
                ====================================
                Nombre: %s %s
                Edad: %d años
                Documento: %s
                Dirección: %s
                Cargo: %s
                Salario: $%.2f
                Horario: %s
                ====================================
                """.formatted(
                super.getFirstName(),
                getLastName(),
                getAge(),
                getDocument(),
                getAddress(),
                position,
                salary,
                schedule));
    }

    @Override
    public String toString() {
        return """
                ====================================
                EMPLEADO
                ====================================
                Nombre: %s %s
                Edad: %d años
                Documento: %s
                Dirección: %s
                Cargo: %s
                Salario: $%.2f
                Horario: %s
                ====================================
                """.formatted(
                super.getFirstName(),
                getLastName(),
                getAge(),
                getDocument(),
                getAddress(),
                position,
                salary,
                schedule);
    }
}
package model;

import interfaces.IPersona;

public class PersonaModel implements IPersona {

    private final String FirstName;
    private final String LastName;
    private final int Age;
    private final String Document;
    private final String Address;

    public PersonaModel(
            String firstName,
            String lastName,
            int age,
            String document,
            String address) {
        // Validación de los datos a recibir
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (document == null || document.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid document");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
        this.Document = document;
        this.Address = address;
    }

    public String getDocument() {
        return Document;
    }

    @Override
    public void introduceOneself() {
        System.out.println("""
                Hola, %s %S tengo %s años y vivo en %s
                """.formatted(FirstName, LastName, Age, Address));
    }
}
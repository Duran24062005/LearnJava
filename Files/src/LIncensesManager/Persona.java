package LIncensesManager;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre, cedula;
    private int edad;

    public Persona(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        String text = """
                Cedula: %s
                Nombre: %s
                Edad: %S
                """.formatted(cedula, nombre, edad);
        return text;
    }

}

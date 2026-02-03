package org.example.model;

public class Persona {
    private String nombre, apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null o estar vacio");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser null o estar vacio");
        }
        if (edad > 0) {
            throw new IllegalArgumentException("El nombre no puede ser menor 0");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null o estar vacio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser null o estar vacio");
        }
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("El nombre no puede ser menor  o igual a 0");
        }
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return """
                Hola, %s %S tengo %s años
                """.formatted(nombre, apellido, edad);
    }
}

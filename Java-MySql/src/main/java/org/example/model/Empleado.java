package org.example.model;

public class Empleado extends Persona {

    private int horas_de_trabajo;
    private double salario;

    public Empleado(String nombre, String Apellido, int edad, double salario, int horas) {
        super(nombre, Apellido, edad);
        this.salario = salario;
        this.horas_de_trabajo = horas;
    }

    public Empleado() {
    }

    public void setHoras_de_trabajo(int horas_de_trabajo) {
        this.horas_de_trabajo = horas_de_trabajo;
    }

    public int getHoras_de_trabajo() {
        return horas_de_trabajo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
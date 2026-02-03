package org.example.interfaces;

import java.util.List;

import org.example.model.Persona;

public interface IEmpleadoRepository {
    public boolean crearEmpleado(Persona persona);

    public List<Persona> listarEmpleado();

    public Persona buscarEmpleadoPorId(int id);

    public boolean actualizarEmpleado(Persona persona, int id);

    public boolean eliminarEmpleado(int id);
}

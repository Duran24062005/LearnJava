package org.example.interfaces;

import java.util.List;

import org.example.model.Persona;

public interface IPersonaRepository {
    public boolean crearPersona(Persona persona);

    public List<Persona> listarPersona();

    public Persona buscarPersonaPorId(int id);

    public boolean actualizarPersona(Persona persona, int id);

    public boolean eliminarPersona(int id);
}

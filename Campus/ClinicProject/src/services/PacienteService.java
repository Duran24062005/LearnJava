package services;

import Model.Paciente;
import repository.PacienteRepository;

public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public boolean registrar(Paciente paciente) {
        return repository.guardar(paciente);
    }

    public void mostrar() {
        repository.mostrarTodos();
    }

    public boolean atenderPaciente() {
        Paciente p = repository.obtenerPrimeroRegistrado();
        if (p == null)
            return false;
        p.atender();
        return true;
    }
}

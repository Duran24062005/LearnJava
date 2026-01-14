package interfaces;

import Model.Paciente;

public interface IPacienteRepository {
    boolean guardar(Paciente paciente);

    void mostrarTodos();

    Paciente obtenerPrimeroRegistrado();
}

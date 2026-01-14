package interfaces;

import Model.Paciente;

public interface IPacienteService {
    boolean registrar(Paciente paciente);

    void mostrar();

    boolean atenderPaciente();
}

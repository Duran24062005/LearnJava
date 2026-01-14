package repository;

import Model.EstadoPaciente;
import Model.Paciente;
import interfaces.IPacienteRepository;

public class PacienteRepository implements IPacienteRepository {

    private Paciente p1;
    private Paciente p2;
    private Paciente p3;
    private Paciente p4;

    public boolean guardar(Paciente paciente) {
        if (p1 == null) {
            p1 = paciente;
            return true;
        }
        if (p2 == null) {
            p2 = paciente;
            return true;
        }
        if (p3 == null) {
            p3 = paciente;
            return true;
        }
        if (p4 == null) {
            p4 = paciente;
            return true;
        }
        return false;
    }

    public void mostrarTodos() {
        if (p1 != null)
            p1.mostrar();
        if (p2 != null)
            p2.mostrar();
        if (p3 != null)
            p3.mostrar();
        if (p4 != null)
            p4.mostrar();
    }

    public Paciente obtenerPrimeroRegistrado() {
        if (p1 != null && p1.getEstado() == EstadoPaciente.REGISTRADO)
            return p1;
        if (p2 != null && p2.getEstado() == EstadoPaciente.REGISTRADO)
            return p2;
        if (p3 != null && p3.getEstado() == EstadoPaciente.REGISTRADO)
            return p3;
        if (p4 != null && p4.getEstado() == EstadoPaciente.REGISTRADO)
            return p4;
        return null;
    }
}

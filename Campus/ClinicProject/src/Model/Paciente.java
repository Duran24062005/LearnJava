package Model;

public class Paciente {

    private final String nombre;
    private final String documento;
    private final int edad;
    private final String motivoConsulta;
    private final String telefonos;
    private final TipoPaciente tipo;
    private EstadoPaciente estado;

    public Paciente(
            String nombre,
            String documento,
            int edad,
            String motivoConsulta,
            String telefonos) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre inválido");

        if (documento == null || documento.trim().isEmpty())
            throw new IllegalArgumentException("Documento inválido");

        if (edad < 0)
            throw new IllegalArgumentException("Edad inválida");

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.motivoConsulta = motivoConsulta;
        this.telefonos = telefonos;
        this.tipo = edad < 18 ? TipoPaciente.MENOR : TipoPaciente.ADULTO;
        this.estado = EstadoPaciente.REGISTRADO;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public void atender() {
        this.estado = EstadoPaciente.ATENDIDO;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Edad: " + edad);
        System.out.println("Tipo: " + tipo);
        System.out.println("Motivo: " + motivoConsulta);

        String[] tel = telefonos.split(",");
        for (int i = 0; i < tel.length; i++) {
            System.out.println("Teléfono " + (i + 1) + ": " + tel[i].trim());
        }

        System.out.println("Estado: " + estado);
        System.out.println("----------------------");
    }
}

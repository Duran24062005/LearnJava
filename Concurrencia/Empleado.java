package concurrencia;

public class Empleado implements Runnable {
    private String nombre;
    private Banco banco;

    public Empleado(String nombre, Banco banco) {
        this.nombre = nombre;
        this.banco = banco;
    }

    double calcularSalario() {
        return Math.round(Math.random() * 3000000 + 2000000);
    }

    @Override
    public void run() {
        double salario = calcularSalario();
        banco.transfeir(this.nombre, salario);
        System.out.println("Transferencia realizada correctamente...");
    }
}

package concurrencia;

public class Banco {
    public synchronized void transfeir(String nombre, double monto){
        System.out.println("Iniciando proceso...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + "-> Pago $" + monto + " enviado al banco.");
    }
}

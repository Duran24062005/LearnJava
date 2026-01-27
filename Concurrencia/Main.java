public class Main {
    public static void main(String[] args) throws InterruptedException {
        Banco b = new Banco();

        // Creación de hilos
        Thread e1 = new Thread(new Empleado("Alexi", b));
        Thread e2 = new Thread(new Empleado("Camilo", b));
        Thread e3 = new Thread(new Empleado("Andres", b));
        Thread e4 = new Thread(new Empleado("David", b));
        Thread e5 = new Thread(new Empleado("Jose", b));

        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();

        e1.join();
        e2.join();
        e3.join();
        e4.join();
        e5.join();

        System.out.println("Transferenciás correctas.");
    }
}
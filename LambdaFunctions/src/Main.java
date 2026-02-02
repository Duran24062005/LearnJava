public class Main {
    public static void main(String[] args) {
        @FunctionalInterface
        interface Saludo {
            void saludar(String nombre);
        }

        Saludo saludo = nombre -> System.out.println("Bienvenido al sistema, " + nombre);

    }
}
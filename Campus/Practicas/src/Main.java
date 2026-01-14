import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        int option = 0;
        boolean App = true;

        while (App) {
            System.out.println("""
                    ***************************************************
                    ------- Bienvenido a nuestro sistema --------------
                    ***************************************************
                        Por favor, elija una opción:
                            1. Comprar.
                            2. Ver carrito.
                            3. Pagar.
                            4. Salir
                    """);

            option = x.nextInt();

            try {

                switch (option) {
                    case 1:
                        System.out.println("""
                                ***************************************************
                                Lista de productos
                                ***************************************************
                                        """);
                        break;

                    case 2:
                        System.out.println("""
                                ***************************************************
                                Lista de productos escogidos
                                ***************************************************
                                        """);
                        break;

                    case 3:
                        System.out.println("""
                                ***************************************************
                                Portal Pago
                                ***************************************************
                                        """);
                        break;

                    case 4:
                        System.out.println("""
                                ***************************************************
                                Portal Pago
                                ***************************************************
                                        """);
                        App = false;
                        break;

                    default:
                        System.out.println("""
                                ***************************************************
                                Opción in valida.1
                                ***************************************************
                                        """);
                        break;
                }

            } catch (Exception e) {
                // TODO: handle exception
                x.nextLine();
                System.out.println("Error el valor ingresado no es un número: " + e);
            }

        }
    }
}
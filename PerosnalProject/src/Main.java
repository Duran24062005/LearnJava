import controllers.OrderController;
import models.*;
import patterns.*;
import views.OrderView;

import java.util.*;
// import java.util.concurrent.TimeUnit;

/**
 * CLASE PRINCIPAL
 * Ejecuta el sistema de procesamiento de órdenes
 */
public class Main {

    public static void main(String[] args) {
        // Crear vista
        OrderView view = new OrderView();
        view.displayHeader();

        // Crear controlador MVC
        OrderController controller = new OrderController(view);

        // Elegir estrategia de pricing (puedes cambiarla)
        PricingStrategy strategy = new BlackFridayPricing(); // O new RegularPricing()

        // Iniciar procesamiento con threads
        controller.startProcessing(strategy);

        // Crear clientes de prueba
        List<Customer> customers = createTestCustomers();

        // Obtener instancia única del inventario (Singleton)
        InventoryManager inventory = InventoryManager.getInstance();

        view.displayMessage("🏪 Inventario inicial:");
        inventory.getAllProducts().values()
                .forEach(p -> view.displayMessage("  " + p.getName() + " - Stock: " + p.getStockQuantity()));
        view.displayMessage("");

        // Generar y someter 20 órdenes aleatorias
        view.displayMessage("🚀 Generando 20 órdenes concurrentes...\n");

        for (int i = 0; i < 20; i++) {
            // Seleccionar cliente aleatorio
            Customer customer = customers.get(new Random().nextInt(customers.size()));

            // Crear productos aleatorios para la orden
            Map<Product, Integer> products = createRandomProducts(inventory);

            // Crear orden usando Factory (alterna entre tipos)
            Order order;
            if (i % 3 == 0) {
                order = OrderFactory.createExpressOrder(customer, products);
            } else if (i % 3 == 1) {
                order = OrderFactory.createInternationalOrder(customer, products);
            } else {
                order = OrderFactory.createStandardOrder(customer, products);
            }

            // Someter orden al controlador
            controller.submitOrder(order);

            // Pequeña pausa entre órdenes
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que todas las órdenes se procesen
        view.displayMessage("\n⏳ Esperando que todas las órdenes se procesen...\n");

        try {
            Thread.sleep(5000); // Esperar 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener controlador
        controller.shutdown();

        // Mostrar estadísticas finales
        controller.showStatistics();

        // Mostrar inventario final
        view.displayMessage("🏪 Inventario final:");
        inventory.getAllProducts().values()
                .forEach(p -> view.displayMessage("  " + p.getName() + " - Stock: " + p.getStockQuantity()));

        view.displayMessage("\n✅ Sistema finalizado correctamente");
    }

    /**
     * Crea clientes de prueba con diferentes tiers
     */
    private static List<Customer> createTestCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("C001", "Juan Pérez", "juan@email.com", CustomerTier.BRONZE));
        customers.add(new Customer("C002", "María García", "maria@email.com", CustomerTier.SILVER));
        customers.add(new Customer("C003", "Carlos López", "carlos@email.com", CustomerTier.GOLD));
        customers.add(new Customer("C004", "Ana Martínez", "ana@email.com", CustomerTier.SILVER));
        customers.add(new Customer("C005", "Pedro Sánchez", "pedro@email.com", CustomerTier.BRONZE));
        return customers;
    }

    /**
     * Crea productos aleatorios para una orden
     */
    private static Map<Product, Integer> createRandomProducts(InventoryManager inventory) {
        Map<Product, Integer> products = new HashMap<>();
        Random random = new Random();

        // Obtener lista de productos disponibles
        List<Product> availableProducts = new ArrayList<>(inventory.getAllProducts().values());

        // Agregar 1-3 productos aleatorios
        int numProducts = random.nextInt(3) + 1;

        for (int i = 0; i < numProducts; i++) {
            Product product = availableProducts.get(random.nextInt(availableProducts.size()));
            int quantity = random.nextInt(3) + 1; // 1-3 unidades
            products.put(product, quantity);
        }

        return products;
    }
}

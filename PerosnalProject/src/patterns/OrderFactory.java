package patterns;

import models.Customer;
import models.Order;
import models.Product;
import java.util.Map;
import java.util.UUID;

/**
 * PATRÓN FACTORY
 * Crea órdenes con configuraciones específicas
 */
public class OrderFactory {

    /**
     * Crea una orden estándar
     */
    public static Order createStandardOrder(Customer customer, Map<Product, Integer> products) {
        String orderId = "ORD-STD-" + UUID.randomUUID().toString().substring(0, 8);
        Order order = new Order(orderId, customer, products);

        // Agregar observadores estándar
        order.addObserver(new EmailNotifier());

        System.out.println("📦 Orden ESTÁNDAR creada: " + orderId);
        return order;
    }

    /**
     * Crea una orden express (con notificaciones adicionales)
     */
    public static Order createExpressOrder(Customer customer, Map<Product, Integer> products) {
        String orderId = "ORD-EXP-" + UUID.randomUUID().toString().substring(0, 8);
        Order order = new Order(orderId, customer, products);

        // Agregar más observadores para express
        order.addObserver(new EmailNotifier());
        order.addObserver(new SMSNotifier());

        System.out.println("⚡ Orden EXPRESS creada: " + orderId);
        return order;
    }

    /**
     * Crea una orden internacional
     */
    public static Order createInternationalOrder(Customer customer, Map<Product, Integer> products) {
        String orderId = "ORD-INT-" + UUID.randomUUID().toString().substring(0, 8);
        Order order = new Order(orderId, customer, products);

        // Observadores para internacional
        order.addObserver(new EmailNotifier());
        order.addObserver(new SMSNotifier());

        System.out.println("🌍 Orden INTERNACIONAL creada: " + orderId);
        return order;
    }
}

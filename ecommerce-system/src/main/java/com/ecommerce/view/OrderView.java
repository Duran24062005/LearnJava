package ;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderStatus;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * VISTA MVC
 * Muestra información al usuario por consola
 */
public class OrderView {

    /**
     * Muestra un mensaje general
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Muestra el estado de una orden
     */
    public void displayOrderStatus(Order order) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📋 ORDEN: " + order.getId());
        System.out.println("👤 Cliente: " + order.getCustomer().getName());
        System.out.println("📊 Estado: " + order.getStatus());
        System.out.println("💵 Total: $" + String.format("%.2f", order.getTotalAmount()));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }

    /**
     * Muestra estadísticas de todas las órdenes procesadas
     */
    public void displayStatistics(List<Order> orders) {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("📊 ESTADÍSTICAS FINALES");
        System.out.println("═══════════════════════════════════");

        // Contar órdenes por estado usando Streams
        Map<OrderStatus, Long> statusCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));

        System.out.println("📦 Total de órdenes: " + orders.size());
        System.out.println("\nPor estado:");
        statusCount.forEach((status, count) -> System.out.println("  " + status + ": " + count));

        // Calcular total de ventas de órdenes completadas
        double totalSales = orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.COMPLETED)
                .mapToDouble(Order::getTotalAmount)
                .sum();

        System.out.println("\n💰 Total de ventas: $" + String.format("%.2f", totalSales));

        // Orden promedio
        double avgOrder = orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.COMPLETED)
                .mapToDouble(Order::getTotalAmount)
                .average()
                .orElse(0.0);

        System.out.println("📈 Orden promedio: $" + String.format("%.2f", avgOrder));
        System.out.println("═══════════════════════════════════\n");
    }

    /**
     * Muestra encabezado del programa
     */
    public void displayHeader() {
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║   🛒 SISTEMA DE PROCESAMIENTO DE ÓRDENES 🛒      ║");
        System.out.println("║          E-Commerce Processing System             ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();
    }
}

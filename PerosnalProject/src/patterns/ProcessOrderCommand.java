package patterns;

import models.Order;
import models.OrderStatus;
import models.Product;
import java.util.Map;

/**
 * Comando concreto que procesa una orden
 */
public class ProcessOrderCommand implements OrderCommand {

    private Order order;
    private PricingStrategy pricingStrategy;

    public ProcessOrderCommand(Order order, PricingStrategy pricingStrategy) {
        this.order = order;
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public void execute() {
        System.out.println("\n🔄 Procesando orden: " + order.getId());

        // 1. Cambiar estado a PROCESSING
        order.setStatus(OrderStatus.PROCESSING);

        // 2. Validar y reservar inventario
        InventoryManager inventory = InventoryManager.getInstance();
        boolean allReserved = true;

        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (!inventory.reserveStock(product.getId(), quantity)) {
                allReserved = false;
                // Liberar lo que ya se había reservado
                releaseAllStock();
                break;
            }
        }

        if (!allReserved) {
            order.setStatus(OrderStatus.FAILED);
            System.out.println("❌ Orden fallida: Stock insuficiente");
            return;
        }

        // 3. Calcular total con la estrategia de pricing
        double total = pricingStrategy.calculateTotal(order);
        order.setTotalAmount(total);

        // 4. Simular procesamiento de pago
        try {
            Thread.sleep(100); // Simula tiempo de procesamiento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Completar orden
        order.setStatus(OrderStatus.COMPLETED);
        System.out.println("✅ Orden completada: " + order.getId() + " - Total: $" + String.format("%.2f", total));
    }

    private void releaseAllStock() {
        InventoryManager inventory = InventoryManager.getInstance();
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            inventory.releaseStock(entry.getKey().getId(), entry.getValue());
        }
    }
}

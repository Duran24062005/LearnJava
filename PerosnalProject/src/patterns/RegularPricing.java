package patterns;

import models.Order;
import models.Product;
import java.util.Map;

/**
 * Estrategia de precio regular (sin descuentos especiales)
 */
public class RegularPricing implements PricingStrategy {

    @Override
    public double calculateTotal(Order order) {
        double subtotal = 0.0;

        // Calcular subtotal
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;
        }

        // Aplicar descuento por tier de cliente
        double discount = order.getCustomer().getTier().getDiscount();
        double total = subtotal * (1 - discount);

        System.out.println("💰 Precio Regular: $" + String.format("%.2f", subtotal) +
                " - Descuento " + order.getCustomer().getTier() +
                ": $" + String.format("%.2f", total));

        return total;
    }
}

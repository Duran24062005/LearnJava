package patterns;

import models.Order;
import models.Product;
import java.util.Map;

/**
 * Estrategia de precio para Black Friday (30% descuento adicional)
 */
public class BlackFridayPricing implements PricingStrategy {

    private static final double BLACK_FRIDAY_DISCOUNT = 0.30; // 30% descuento

    @Override
    public double calculateTotal(Order order) {
        double subtotal = 0.0;

        // Calcular subtotal
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;
        }

        // Aplicar descuento Black Friday
        double afterBlackFriday = subtotal * (1 - BLACK_FRIDAY_DISCOUNT);

        // Aplicar descuento adicional por tier de cliente
        double tierDiscount = order.getCustomer().getTier().getDiscount();
        double total = afterBlackFriday * (1 - tierDiscount);

        System.out.println("🎉 BLACK FRIDAY: $" + String.format("%.2f", subtotal) +
                " → $" + String.format("%.2f", afterBlackFriday) +
                " → Total: $" + String.format("%.2f", total));

        return total;
    }
}

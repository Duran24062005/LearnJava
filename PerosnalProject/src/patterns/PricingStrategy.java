package patterns;

import models.Order;

/**
 * PATRÓN STRATEGY
 * Define diferentes estrategias de cálculo de precios
 */
public interface PricingStrategy {
    double calculateTotal(Order order);
}

package patterns;

import models.Order;

/**
 * PATRÓN OBSERVER
 * Interface que deben implementar todos los observadores de órdenes
 */
public interface OrderObserver {
    void onOrderStatusChanged(Order order);
}
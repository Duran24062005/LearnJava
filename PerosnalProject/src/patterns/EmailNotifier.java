package patterns;

import models.Order;

/**
 * Observador concreto que envía emails cuando cambia el estado de una orden
 */
public class EmailNotifier implements OrderObserver {

    @Override
    public void onOrderStatusChanged(Order order) {
        // Simula envío de email
        System.out.println("📧 EMAIL enviado a " + order.getCustomer().getEmail() +
                " - Orden " + order.getId() + " ahora está: " + order.getStatus());
    }
}

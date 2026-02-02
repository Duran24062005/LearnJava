package patterns;

import models.Order;

/**
 * Observador concreto que envía SMS cuando cambia el estado de una orden
 */
public class SMSNotifier implements OrderObserver {

    @Override
    public void onOrderStatusChanged(Order order) {
        // Simula envío de SMS
        System.out.println("📱 SMS enviado - Orden " + order.getId() + ": " + order.getStatus());
    }
}

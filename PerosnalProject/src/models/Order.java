package models;

import patterns.OrderObserver;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa una orden de compra
 * Implementa el patrón Observer para notificar cambios de estado
 */
public class Order {
    private String id;
    private Customer customer;
    private Map<Product, Integer> products; // Producto y cantidad
    private OrderStatus status;
    private LocalDateTime timestamp;
    private double totalAmount;
    private List<OrderObserver> observers; // Lista de observadores

    public Order(String id, Customer customer, Map<Product, Integer> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = OrderStatus.PENDING;
        this.timestamp = LocalDateTime.now();
        this.observers = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Método para agregar observadores
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    // Método para notificar a todos los observadores
    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.onOrderStatusChanged(this);
        }
    }

    // Cambiar estado y notificar
    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    // Getters
    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getName() +
                ", status=" + status +
                ", total=" + totalAmount +
                '}';
    }
}

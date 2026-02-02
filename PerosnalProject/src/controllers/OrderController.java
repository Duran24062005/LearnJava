package controllers;

import models.Order;
import patterns.OrderCommand;
import patterns.ProcessOrderCommand;
import patterns.PricingStrategy;
import views.OrderView;
import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

/**
 * CONTROLADOR MVC
 * Coordina el procesamiento de órdenes usando threads
 */
public class OrderController {

    private OrderView view;
    private ExecutorService executorService;
    private BlockingQueue<Order> orderQueue;
    private List<Order> processedOrders;
    private volatile boolean running;

    public OrderController(OrderView view) {
        this.view = view;
        this.executorService = Executors.newFixedThreadPool(5); // Pool de 5 threads
        this.orderQueue = new LinkedBlockingQueue<>(100); // Cola de máximo 100 órdenes
        this.processedOrders = new CopyOnWriteArrayList<>(); // Thread-safe list
        this.running = true;
    }

    /**
     * Inicia workers que procesan órdenes de la cola
     */
    public void startProcessing(PricingStrategy strategy) {
        // Crear 5 threads consumidores
        for (int i = 0; i < 5; i++) {
            final int workerId = i + 1;
            executorService.submit(() -> {
                while (running) {
                    try {
                        // Tomar orden de la cola (bloquea si está vacía)
                        Order order = orderQueue.poll(1, TimeUnit.SECONDS);

                        if (order != null) {
                            view.displayMessage("🔧 Worker #" + workerId + " procesando: " + order.getId());

                            // Crear y ejecutar comando
                            OrderCommand command = new ProcessOrderCommand(order, strategy);
                            command.execute();

                            // Guardar orden procesada
                            processedOrders.add(order);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
        }
    }

    /**
     * Agrega una orden a la cola para procesamiento
     */
    public void submitOrder(Order order) {
        try {
            orderQueue.put(order);
            view.displayMessage("📥 Orden agregada a la cola: " + order.getId());
        } catch (InterruptedException e) {
            view.displayMessage("❌ Error al agregar orden a la cola");
            e.printStackTrace();
        }
    }

    /**
     * Detiene el procesamiento
     */
    public void shutdown() {
        running = false;
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    /**
     * Obtiene estadísticas de las órdenes procesadas
     */
    public void showStatistics() {
        view.displayStatistics(processedOrders);
    }

    public List<Order> getProcessedOrders() {
        return new ArrayList<>(processedOrders);
    }
}

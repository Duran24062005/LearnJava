package patterns;

import models.Product;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * PATRÓN SINGLETON
 * Gestiona el inventario de productos de forma centralizada
 * Thread-safe para uso concurrente
 */
public class InventoryManager {

    // La única instancia del InventoryManager
    private static InventoryManager instance;

    // Mapa de productos por ID
    private Map<String, Product> inventory;

    // Constructor privado (nadie puede crear instancias desde fuera)
    private InventoryManager() {
        inventory = new ConcurrentHashMap<>();
        initializeInventory();
    }

    // Método para obtener la única instancia (thread-safe)
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Inicializa algunos productos de prueba
    private void initializeInventory() {
        addProduct(new Product("P001", "Laptop HP", 800.0, 10));
        addProduct(new Product("P002", "Mouse Logitech", 25.0, 50));
        addProduct(new Product("P003", "Teclado Mecánico", 100.0, 30));
        addProduct(new Product("P004", "Monitor Samsung", 250.0, 15));
        addProduct(new Product("P005", "Auriculares Sony", 150.0, 20));
    }

    // Agregar producto al inventario
    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    // Obtener producto por ID
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    // Verificar disponibilidad
    public synchronized boolean checkAvailability(String productId, int quantity) {
        Product product = inventory.get(productId);
        return product != null && product.getStockQuantity() >= quantity;
    }

    // Reservar stock (thread-safe)
    public synchronized boolean reserveStock(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null && product.getStockQuantity() >= quantity) {
            product.setStockQuantity(product.getStockQuantity() - quantity);
            System.out.println("✅ Stock reservado: " + quantity + " x " + product.getName());
            return true;
        }
        System.out.println("❌ Stock insuficiente para: " + productId);
        return false;
    }

    // Liberar stock (en caso de cancelación)
    public synchronized void releaseStock(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setStockQuantity(product.getStockQuantity() + quantity);
            System.out.println("♻️ Stock liberado: " + quantity + " x " + product.getName());
        }
    }

    // Obtener todos los productos
    public Map<String, Product> getAllProducts() {
        return inventory;
    }
}

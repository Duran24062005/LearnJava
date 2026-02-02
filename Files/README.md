# Proyecto Java Profesional: Sistema de Procesamiento Paralelo de Órdenes de Comercio Electrónico

## 📋 Problemática General

Imagina que trabajas para una empresa de comercio electrónico que recibe miles de órdenes diariamente. El sistema actual procesa las órdenes de forma secuencial, lo que genera cuellos de botella durante las horas pico (Black Friday, Cyber Monday, etc.).

**Tu misión:** Diseñar un sistema robusto que procese órdenes de manera concurrente, valide inventarios, calcule precios con descuentos, y notifique a los clientes - todo mientras mantiene la integridad de los datos.

---

## 🎯 Objetivos del Proyecto

Desarrollarás un sistema que integre:

1. **MVC (Model-View-Controller)**: Separación clara de responsabilidades
2. **Threads**: Procesamiento concurrente de órdenes
3. **Design Patterns**: Al menos 5 patrones de diseño profesionales
4. **Conceptos Java avanzados**: Streams, Optional, Exceptions personalizadas, Generics

---

## 🏗️ Arquitectura del Sistema

### **Modelo MVC**

**Model (Modelo de Negocio)**

- `Order`: Representa una orden de compra
- `Product`: Representa productos con precio e inventario
- `Customer`: Información del cliente
- `Inventory`: Gestión de stock

**View (Interfaz)**

- Consola de texto (puede ser simple)
- Muestra órdenes procesadas, errores, estadísticas

**Controller (Controlador)**

- `OrderController`: Coordina el procesamiento de órdenes
- `InventoryController`: Gestiona validaciones de inventario
- Orquesta la comunicación entre Model y View

---

## 🧵 Implementación de Threads

### **Escenarios de Concurrencia**

1. **Pool de Workers**: Usa `ExecutorService` con un pool de threads para procesar múltiples órdenes simultáneamente

2. **Producer-Consumer**:
   - Producer: Genera órdenes (simula llegada de clientes)
   - Consumer: Procesa órdenes del queue
   - Usa `BlockingQueue` para comunicación segura

3. **Sincronización de Inventario**:
   - Múltiples threads intentan reservar el mismo producto
   - Debes prevenir overselling (vender más de lo disponible)

**Conceptos clave a aplicar:**

- `synchronized` methods o blocks
- `ReentrantLock` para control fino
- `CountDownLatch` para esperar que todas las órdenes terminen
- `CompletableFuture` para operaciones asíncronas

---

## 🎨 Design Patterns a Implementar

### **1. Singleton**

**Dónde:** `InventoryManager`, `ConfigurationManager`
**Por qué:** Solo debe existir una instancia que gestione el inventario global

```
InventoryManager.getInstance().reserveProduct(productId, quantity)
```

### **2. Factory**

**Dónde:** `OrderFactory`, `NotificationFactory`
**Por qué:** Crear diferentes tipos de órdenes (Standard, Express, International)

```
Order order = OrderFactory.createOrder(OrderType.EXPRESS, customer, products);
```

### **3. Observer**

**Dónde:** Sistema de notificaciones
**Por qué:** Cuando una orden cambia de estado, múltiples observers reaccionan (email, SMS, log)

```
order.addObserver(new EmailNotifier());
order.addObserver(new SMSNotifier());
order.setStatus(OrderStatus.SHIPPED); // Notifica a todos
```

### **4. Strategy**

**Dónde:** Cálculo de descuentos y envíos
**Por qué:** Diferentes estrategias de pricing según cliente/temporada

```
PricingStrategy blackFriday = new BlackFridayPricing();
PricingStrategy regular = new RegularPricing();
order.calculateTotal(blackFriday);
```

### **5. Command**

**Dónde:** Procesamiento de órdenes
**Por qué:** Encapsular cada operación (validar, procesar, enviar) como comando ejecutable

```
Command processCommand = new ProcessOrderCommand(order);
commandQueue.execute(processCommand);
```

### **6. Builder (Bonus)**

**Dónde:** Construcción de órdenes complejas
**Por qué:** Crear objetos con muchos parámetros opcionales de forma legible

```
Order order = new Order.Builder()
    .withCustomer(customer)
    .withProducts(products)
    .withShippingAddress(address)
    .withExpressDelivery()
    .build();
```

---

## 🛠️ Guía de Implementación Paso a Paso

### **Fase 1: Estructura Base (Día 1-2)**

1. **Crea el proyecto Maven/Gradle**
   - Estructura de paquetes: `model`, `view`, `controller`, `patterns`, `services`, `utils`

2. **Define las entidades del Model**

   ```
   - Order (id, customer, products, status, timestamp)
   - Product (id, name, price, stockQuantity)
   - Customer (id, name, email, tier)
   ```

3. **Implementa enums y constantes**
   ```
   - OrderStatus (PENDING, PROCESSING, COMPLETED, FAILED)
   - CustomerTier (BRONZE, SILVER, GOLD)
   ```

### **Fase 2: Patterns Fundamentales (Día 3-4)**

4. **Singleton para InventoryManager**
   - Thread-safe (double-checked locking o enum)
   - Métodos: `checkAvailability()`, `reserveStock()`, `releaseStock()`

5. **Factory para órdenes**
   - `StandardOrder`, `ExpressOrder`, `InternationalOrder`
   - Cada tipo con comportamiento específico

6. **Strategy para pricing**
   - Interface `PricingStrategy`
   - Implementaciones: `RegularPricing`, `SeasonalPricing`, `TierBasedPricing`

### **Fase 3: Concurrencia (Día 5-6)**

7. **Producer-Consumer con BlockingQueue**

   ```java
   BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(100);

   // Producer thread
   while(running) {
       Order order = generateRandomOrder();
       orderQueue.put(order);
   }

   // Consumer threads (pool)
   ExecutorService executor = Executors.newFixedThreadPool(5);
   for(int i = 0; i < 5; i++) {
       executor.submit(() -> {
           while(running) {
               Order order = orderQueue.take();
               processOrder(order);
           }
       });
   }
   ```

8. **Sincronización del inventario**
   ```java
   public synchronized boolean reserveStock(String productId, int qty) {
       if(inventory.get(productId) >= qty) {
           inventory.put(productId, inventory.get(productId) - qty);
           return true;
       }
       return false;
   }
   ```

### **Fase 4: Observer y Command (Día 7)**

9. **Observer para notificaciones**

   ```java
   interface OrderObserver {
       void onOrderStatusChanged(Order order);
   }

   class Order {
       private List<OrderObserver> observers = new ArrayList<>();

       public void setStatus(OrderStatus status) {
           this.status = status;
           notifyObservers();
       }
   }
   ```

10. **Command para procesamiento**

    ```java
    interface OrderCommand {
        void execute();
    }

    class ValidateOrderCommand implements OrderCommand {
        private Order order;
        public void execute() { /* validación */ }
    }
    ```

### **Fase 5: MVC y Vista (Día 8)**

11. **Controller**

    ```java
    class OrderController {
        private InventoryController inventoryCtrl;
        private OrderView view;

        public void processOrder(Order order) {
            // Coordina validación, procesamiento, actualización de vista
        }
    }
    ```

12. **View (consola simple)**
    ```java
    class OrderView {
        public void displayOrderStatus(Order order) {
            System.out.println("Order #" + order.getId() + ": " + order.getStatus());
        }

        public void displayStatistics(Map<OrderStatus, Integer> stats) {
            // Muestra estadísticas
        }
    }
    ```

### **Fase 6: Conceptos Avanzados Java (Día 9)**

13. **Streams API**

    ```java
    // Obtener órdenes completadas del último mes
    List<Order> recentCompleted = orders.stream()
        .filter(o -> o.getStatus() == OrderStatus.COMPLETED)
        .filter(o -> o.getTimestamp().isAfter(LocalDateTime.now().minusMonths(1)))
        .collect(Collectors.toList());
    ```

14. **Optional para manejo seguro**

    ```java
    Optional<Product> product = findProductById(id);
    product.ifPresent(p -> cart.add(p));
    ```

15. **Custom Exceptions**
    ```java
    class InsufficientStockException extends Exception { }
    class InvalidOrderException extends RuntimeException { }
    ```

### **Fase 7: Testing y Refinamiento (Día 10)**

16. **Crea escenarios de prueba**
    - 100 órdenes simultáneas
    - Productos con stock limitado
    - Verifica no hay overselling

17. **Logging profesional**
    ```java
    private static final Logger logger = Logger.getLogger(OrderProcessor.class.getName());
    logger.info("Processing order #" + orderId);
    ```

---

## 🎯 Casos de Uso para Probar

1. **Escenario Normal**: 50 órdenes, inventario suficiente
2. **Black Friday**: 200 órdenes concurrentes, productos populares se agotan
3. **Clientes VIP**: Clientes Gold tienen prioridad en el processing
4. **Rollback**: Si falla el pago, liberar inventario reservado

---

## 📊 Criterios de Éxito

✅ **MVC**: Separación clara, controller no tiene lógica de negocio  
✅ **Threads**: Al menos 5 threads concurrentes sin race conditions  
✅ **Patterns**: 5+ patrones implementados correctamente  
✅ **Java Pro**: Streams, Optional, Generics, Custom Exceptions  
✅ **Sin errores**: No overselling, no deadlocks, manejo de errores robusto

---

## 💡 Tips Profesionales

1. **Usa interfaces**: Programa contra abstracciones, no implementaciones
2. **SOLID principles**: Especialmente Single Responsibility
3. **Thread safety**: Siempre pregunta "¿qué pasa si 2 threads hacen esto?"
4. **Immutability**: Objetos inmutables donde sea posible
5. **Fail-fast**: Valida parámetros al inicio de métodos

---

## 🚀 Extensiones Opcionales (Si quieres más desafío)

- Base de datos H2 en memoria
- API REST con Spring Boot
- Métricas de rendimiento (tiempo de procesamiento promedio)
- Dashboard en tiempo real (JavaFX o web)
- Persistencia de órdenes en JSON/XML

---

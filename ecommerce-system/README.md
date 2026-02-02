# Sistema de Procesamiento de Órdenes E-Commerce

## 📚 EXPLICACIÓN DEL PROYECTO

Este proyecto implementa un sistema completo de procesamiento de órdenes para comercio electrónico usando conceptos avanzados de Java.

---

## 🎯 CONCEPTOS IMPLEMENTADOS

### 1. MVC (Model-View-Controller)

**Model (Modelo):**

- `Order.java`: Representa una orden de compra
- `Product.java`: Representa productos
- `Customer.java`: Representa clientes
- Contienen la lógica de negocio y datos

**View (Vista):**

- `OrderView.java`: Muestra información en consola
- NO contiene lógica de negocio
- Solo presenta datos al usuario

**Controller (Controlador):**

- `OrderController.java`: Coordina entre Model y View
- Gestiona threads y cola de órdenes
- Orquesta el procesamiento

---

### 2. THREADS (Hilos de Ejecución)

**¿Qué es un Thread?**
Un thread es como un "trabajador" que puede ejecutar tareas en paralelo.

**En este proyecto:**

- **ExecutorService**: Pool de 5 threads trabajadores
- **BlockingQueue**: Cola thread-safe para comunicar órdenes
- **Producer-Consumer**: Main genera órdenes (producer), workers las procesan (consumers)

**Código clave:**

```java
ExecutorService executorService = Executors.newFixedThreadPool(5); // 5 workers
BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(100); // Cola
```

**Sincronización:**

```java
public synchronized boolean reserveStock(...) {
    // Solo un thread puede ejecutar esto a la vez
}
```

---

### 3. DESIGN PATTERNS (Patrones de Diseño)

#### a) **SINGLETON** - Una sola instancia

- **Clase**: `InventoryManager`
- **Propósito**: Solo una instancia gestiona el inventario global
- **Cómo funciona**:

```java
private static InventoryManager instance; // Variable estática
private InventoryManager() {} // Constructor privado

public static synchronized InventoryManager getInstance() {
    if (instance == null) {
        instance = new InventoryManager();
    }
    return instance;
}
```

#### b) **OBSERVER** - Notificaciones automáticas

- **Clases**: `OrderObserver`, `EmailNotifier`, `SMSNotifier`
- **Propósito**: Cuando una orden cambia de estado, notifica automáticamente
- **Cómo funciona**:

```java
// Agregar observadores a una orden
order.addObserver(new EmailNotifier());
order.addObserver(new SMSNotifier());

// Al cambiar estado, todos son notificados
order.setStatus(OrderStatus.COMPLETED); // ¡Envía email y SMS automáticamente!
```

#### c) **STRATEGY** - Diferentes algoritmos intercambiables

- **Clases**: `PricingStrategy`, `RegularPricing`, `BlackFridayPricing`
- **Propósito**: Calcular precios de diferentes formas
- **Cómo funciona**:

```java
PricingStrategy regular = new RegularPricing();
PricingStrategy blackFriday = new BlackFridayPricing();

// Puedes cambiar la estrategia en cualquier momento
double total = strategy.calculateTotal(order);
```

#### d) **COMMAND** - Encapsular acciones como objetos

- **Clases**: `OrderCommand`, `ProcessOrderCommand`
- **Propósito**: Convertir "procesar orden" en un objeto ejecutable
- **Cómo funciona**:

```java
OrderCommand command = new ProcessOrderCommand(order, strategy);
command.execute(); // Ejecuta toda la lógica de procesamiento
```

#### e) **FACTORY** - Crear objetos de forma flexible

- **Clase**: `OrderFactory`
- **Propósito**: Crear diferentes tipos de órdenes fácilmente
- **Cómo funciona**:

```java
Order express = OrderFactory.createExpressOrder(customer, products);
Order international = OrderFactory.createInternationalOrder(customer, products);
```

---

### 4. CONCEPTOS PROFESIONALES DE JAVA

#### a) **Streams API**

Procesar colecciones de forma funcional:

```java
// Filtrar órdenes completadas
List<Order> completed = orders.stream()
    .filter(o -> o.getStatus() == OrderStatus.COMPLETED)
    .collect(Collectors.toList());

// Calcular total de ventas
double total = orders.stream()
    .mapToDouble(Order::getTotalAmount)
    .sum();
```

#### b) **ConcurrentHashMap**

Mapa thread-safe para múltiples threads:

```java
private Map<String, Product> inventory = new ConcurrentHashMap<>();
```

#### c) **Enums**

Constantes con comportamiento:

```java
public enum CustomerTier {
    BRONZE(0.0),
    SILVER(0.05),
    GOLD(0.10);

    private final double discount;
    // ...
}
```

#### d) **Generic Types**

Tipado flexible:

```java
Map<Product, Integer> products = new HashMap<>();
BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
```

---

## 🚀 CÓMO EJECUTAR

### Opción 1: Desde línea de comandos

```bash
# Compilar
javac -d bin src/main/java/com/ecommerce/**/*.java

# Ejecutar
java -cp bin com.ecommerce.Main
```

### Opción 2: Usando un IDE

1. Importar el proyecto en IntelliJ IDEA o Eclipse
2. Ejecutar la clase `Main.java`

---

## 📊 QUÉ HACE EL PROGRAMA

1. **Inicia** el sistema con 5 threads trabajadores
2. **Genera** 20 órdenes aleatorias concurrentemente
3. **Procesa** cada orden:
   - Valida inventario
   - Reserva productos
   - Calcula precio con descuentos
   - Envía notificaciones
4. **Muestra** estadísticas finales

---

## 🔍 FLUJO DE UNA ORDEN

```
1. Main crea orden → OrderFactory
2. Orden se agrega a BlockingQueue
3. Thread worker toma la orden
4. Crea ProcessOrderCommand
5. Command ejecuta:
   - Cambia estado a PROCESSING (notifica observers)
   - Reserva stock en InventoryManager (synchronized)
   - Calcula total con PricingStrategy
   - Cambia estado a COMPLETED (notifica observers)
6. Estadísticas finales con Streams
```

---

## 💡 CONCEPTOS CLAVE A ENTENDER

### Thread Safety (Seguridad de Hilos)

**Problema**: Dos threads intentan reservar el mismo producto simultáneamente
**Solución**: `synchronized` en `reserveStock()`

### Producer-Consumer Pattern

**Producer**: Main genera órdenes y las pone en la cola
**Consumer**: Workers sacan órdenes de la cola y las procesan

### Separation of Concerns (Separación de Responsabilidades)

- **Model**: Datos y lógica de negocio
- **View**: Presentación
- **Controller**: Coordinación

---

## 🎓 EJERCICIOS PARA PRACTICAR

1. **Agregar nuevo Observer**: Crea `LogNotifier` que escriba en archivo
2. **Nueva Strategy**: Crea `CyberMondayPricing` con 40% descuento
3. **Manejo de errores**: Agrega excepciones personalizadas
4. **Más threads**: Cambia de 5 a 10 workers
5. **Priority Queue**: Clientes GOLD tienen prioridad

---

## 📝 PATRONES USADOS - RESUMEN

| Patrón    | Clase Principal  | Propósito                         |
| --------- | ---------------- | --------------------------------- |
| Singleton | InventoryManager | Una sola instancia del inventario |
| Observer  | OrderObserver    | Notificaciones automáticas        |
| Strategy  | PricingStrategy  | Diferentes algoritmos de precio   |
| Command   | OrderCommand     | Encapsular acciones               |
| Factory   | OrderFactory     | Crear objetos flexiblemente       |

---

## 🛠️ ESTRUCTURA DE ARCHIVOS

```
src/main/java/com/ecommerce/
├── Main.java                      # Clase principal
├── model/                         # MODELO
│   ├── Customer.java
│   ├── CustomerTier.java
│   ├── Order.java
│   ├── OrderStatus.java
│   └── Product.java
├── view/                          # VISTA
│   └── OrderView.java
├── controller/                    # CONTROLADOR
│   └── OrderController.java
└── patterns/                      # PATRONES
    ├── BlackFridayPricing.java
    ├── EmailNotifier.java
    ├── InventoryManager.java
    ├── OrderCommand.java
    ├── OrderFactory.java
    ├── OrderObserver.java
    ├── PricingStrategy.java
    ├── ProcessOrderCommand.java
    ├── RegularPricing.java
    └── SMSNotifier.java
```

---

## ✅ CHECKLIST DE CONCEPTOS

- [x] MVC (Model-View-Controller)
- [x] Threads (ExecutorService, BlockingQueue)
- [x] Singleton Pattern
- [x] Observer Pattern
- [x] Strategy Pattern
- [x] Command Pattern
- [x] Factory Pattern
- [x] Streams API
- [x] Thread Synchronization
- [x] Enums
- [x] Generics
- [x] ConcurrentHashMap

---

¡Proyecto completo listo para aprender Java profesional! 🎉

# Funciones Lambda

---

## 1. ¿Qué es una lambda en Java?

Es una **función anónima** que implementa una **interfaz funcional**
(una interfaz con **un solo método abstracto**).

**Sintaxis general:**

```
(parámetros) -> { cuerpo }
```

---

## 2. Ejemplo básico

Antes (clásico):

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hola");
    }
};
```

Con lambda:

```java
Runnable r = () -> System.out.println("Hola");
```

---

## 3. Interfaz funcional (clave)

Ejemplo:

```java
@FunctionalInterface
interface Operacion {
    int operar(int a, int b);
}
```

Uso con lambda:

```java
Operacion suma = (a, b) -> a + b;
Operacion resta = (a, b) -> a - b;

System.out.println(suma.operar(5, 3));   // 8
System.out.println(resta.operar(5, 3));  // 2
```

---

## 4. Lambdas con colecciones (MUY común)

```java
List<String> nombres = List.of("Ana", "Luis", "Pedro");

nombres.forEach(nombre -> System.out.println(nombre));
```

Más corto aún:

```java
nombres.forEach(System.out::println);
```

---

## 5. Lambdas con `Stream`

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);

numeros.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

---

## 6. Interfaces funcionales más usadas (ya vienen en Java)

| Interfaz        | Firma               |
| --------------- | ------------------- |
| `Predicate<T>`  | `boolean test(T t)` |
| `Function<T,R>` | `R apply(T t)`      |
| `Consumer<T>`   | `void accept(T t)`  |
| `Supplier<T>`   | `T get()`           |

Ejemplo:

```java
Predicate<Integer> esPar = n -> n % 2 == 0;
System.out.println(esPar.test(4)); // true
```

---

## 7. Lambdas con varios statements

```java
Operacion multiplicar = (a, b) -> {
    int resultado = a * b;
    return resultado;
};
```

---

## 8. Reglas importantes (examen + vida real)

- Solo funcionan con **interfaces funcionales**
- No reemplazan **clases completas**
- Pueden acceder a variables **final o efectivamente final**
- Mejoran legibilidad cuando el código es corto

---

## 9. Cuándo usarlas (criterio profesional)

Usa lambda cuando:

- La lógica es **corta**
- Se usa **una sola vez**
- Trabajas con **colecciones / streams / callbacks**

NO usar lambda cuando:

- La lógica es larga
- Necesitas estado complejo
- Pierde legibilidad

---

## Proyecto

Un desarrollador esta cansado de tener que realizar todoo de forma manual, para ello decide empezar
a usar interfaces funcionales, actualemente se encuentra trabajando en un software para un arquitecto,
existen varias cosas que actualemente le llevan mucho codigo y desea implementarlas solo cuando sea
necesario y sin tantas lineas;

1. Saludo de bienvenida recibiendo el nombre del empleado de la base de datos;
2. Caclular el tipo de cliente con base a su edad;
3. Una funcion que permita saber cuanto dinero cobrar con base al tiempo que demora el proyecto;
4. Consultar cuantos registros existen actualmente en base de datos.

<div align="center">
    <h1>JavA</h1>
    <p>Fundamentos del Lenguaje.</p>
</div>

# Java_S1_DuranAlexi

## 📋 Descripción

Este repositorio contiene una colección de ejercicios, prácticas y proyectos desarrollados durante mis primeros pasos de aprendizaje de Java. El objetivo principal es documentar el progreso en la comprensión de los conceptos fundamentales de la programación orientada a objetos y las características básicas del lenguaje Java.

Cada ejercicio ha sido diseñado para reforzar conceptos específicos, desde la sintaxis básica hasta estructuras de datos y programación orientada a objetos, proporcionando una base sólida para el desarrollo de aplicaciones Java.

---

## 🔧 Requisitos Previos

Antes de comenzar a trabajar con este repositorio, asegúrate de tener instalado lo siguiente:

### Software Necesario

- **Java Development Kit (JDK)**: Versión 11 o superior
  - Recomendado: JDK 17 LTS o JDK 21 LTS
  - Descarga: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) o [OpenJDK](https://openjdk.org/)

- **IDE (Entorno de Desarrollo Integrado)**: Cualquiera de los siguientes
  - [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) (Recomendado)
  - [Eclipse IDE](https://www.eclipse.org/downloads/)
  - [Visual Studio Code](https://code.visualstudio.com/) con Extension Pack for Java
  - [NetBeans](https://netbeans.apache.org/)

### Herramientas Opcionales

- **Git**: Para clonar y gestionar el repositorio
- **Maven** o **Gradle**: Para proyectos más avanzados (si aplica)

### Verificar la Instalación

Para verificar que Java está correctamente instalado, ejecuta en la terminal:

```bash
java -version
javac -version
```

Deberías ver la versión de Java instalada en tu sistema.

---

## 📁 Estructura del Proyecto

El repositorio está organizado de la siguiente manera:

```
Java_S1_DuranAlexi/
│
├── README.md
├── src/
│   ├── fundamentos/
│   │   ├── HolaMundo.java
│   │   ├── TiposDatos.java
│   │   └── OperadoresBasicos.java
│   │
│   ├── control_flujo/
│   │   ├── Condicionales.java
│   │   ├── Bucles.java
│   │   └── Switch.java
│   │
│   ├── estructuras_datos/
│   │   ├── Arrays.java
│   │   ├── ArrayLists.java
│   │   └── Matrices.java
│   │
│   ├── poo/
│   │   ├── Clases.java
│   │   ├── Herencia.java
│   │   ├── Polimorfismo.java
│   │   └── Encapsulamiento.java
│   │
│   ├── excepciones/
│   │   └── ManejoExcepciones.java
│   │
│   └── proyectos/
│       ├── CalculadoraBasica/
│       ├── GestorTareas/
│       └── SistemaNotas/
│
└── docs/
    ├── notas.md
    └── recursos.md
```

### Descripción de Carpetas

- **`src/fundamentos/`**: Ejercicios sobre sintaxis básica, variables, tipos de datos y operadores
- **`src/control_flujo/`**: Ejemplos de estructuras condicionales y bucles
- **`src/estructuras_datos/`**: Trabajo con arrays, listas y otras estructuras
- **`src/poo/`**: Implementación de conceptos de Programación Orientada a Objetos
- **`src/excepciones/`**: Manejo de errores y excepciones
- **`src/proyectos/`**: Proyectos integradores que combinan múltiples conceptos
- **`docs/`**: Documentación adicional y recursos de estudio

---

## ⚙️ Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/tuusuario/Java_S1_DuranAlexi.git
cd Java_S1_DuranAlexi
```

### 2. Configurar el Entorno

#### Usando IntelliJ IDEA

1. Abre IntelliJ IDEA
2. Selecciona **File > Open** y elige la carpeta del repositorio
3. Espera a que el IDE indexe el proyecto
4. Configura el JDK: **File > Project Structure > Project** y selecciona tu JDK instalado

#### Usando Eclipse

1. Abre Eclipse
2. Selecciona **File > Import > General > Existing Projects into Workspace**
3. Selecciona la carpeta del repositorio
4. Configura el JDK: **Window > Preferences > Java > Installed JREs**

#### Usando Visual Studio Code

1. Abre VS Code
2. Instala la extensión "Extension Pack for Java"
3. Abre la carpeta del repositorio
4. VS Code detectará automáticamente el proyecto Java

### 3. Compilar y Ejecutar desde Terminal (Opcional)

Para compilar un archivo Java:

```bash
javac src/fundamentos/HolaMundo.java
```

Para ejecutar:

```bash
java -cp src fundamentos.HolaMundo
```

---

## 📚 Temas Cubiertos

Este repositorio abarca los siguientes conceptos fundamentales de Java:

### Fundamentos Básicos

- ✅ Sintaxis básica y estructura de un programa Java
- ✅ Variables y tipos de datos primitivos
- ✅ Operadores aritméticos, lógicos y relacionales
- ✅ Entrada y salida de datos (Scanner, System.out)

### Control de Flujo

- ✅ Estructuras condicionales (if, else, else if)
- ✅ Switch-case statements
- ✅ Bucles (for, while, do-while)
- ✅ Break y continue

### Estructuras de Datos

- ✅ Arrays unidimensionales y multidimensionales
- ✅ ArrayList y Collections Framework
- ✅ Manipulación y recorrido de estructuras

### Programación Orientada a Objetos (POO)

- ✅ Clases y objetos
- ✅ Constructores y métodos
- ✅ Encapsulamiento (getters y setters)
- ✅ Herencia y polimorfismo
- ✅ Clases abstractas e interfaces
- ✅ Modificadores de acceso

### Manejo de Excepciones

- ✅ Try-catch-finally
- ✅ Tipos de excepciones
- ✅ Creación de excepciones personalizadas

### Conceptos Adicionales

- ✅ Métodos estáticos vs. métodos de instancia
- ✅ Sobrecarga de métodos
- ✅ Palabras clave (this, super, static, final)

---

## 🚀 Cómo Usar Este Repositorio

### Para Estudiantes

1. **Navega por las carpetas**: Comienza con `fundamentos/` y avanza progresivamente
2. **Lee el código**: Cada archivo incluye comentarios explicativos
3. **Ejecuta los ejemplos**: Prueba cada programa para ver su funcionamiento
4. **Modifica y experimenta**: Cambia valores y lógica para aprender haciendo
5. **Completa los desafíos**: Algunos archivos incluyen ejercicios propuestos

### Para Profesores

- Este repositorio puede servir como material de referencia o base para ejercicios
- Los proyectos en `src/proyectos/` pueden usarse como evaluaciones prácticas
- La estructura permite añadir nuevos ejercicios fácilmente

### Ejecutar un Programa

#### Desde el IDE

1. Abre el archivo `.java` que deseas ejecutar
2. Haz clic derecho y selecciona **Run** o presiona el botón de ejecución
3. Observa la salida en la consola del IDE

#### Desde la Terminal

```bash
# Compilar
javac src/fundamentos/HolaMundo.java

# Ejecutar
java -cp src fundamentos.HolaMundo
```

---

## 📖 Recursos Adicionales

### Documentación Oficial

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java SE API Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/)
- [Java Tutorials by Oracle](https://docs.oracle.com/javase/tutorial/)

### Tutoriales y Guías

- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [GeeksforGeeks Java Programming](https://www.geeksforgeeks.org/java/)
- [Codecademy Learn Java](https://www.codecademy.com/learn/learn-java)

### Libros Recomendados

- "Effective Java" - Joshua Bloch
- "Head First Java" - Kathy Sierra & Bert Bates
- "Java: The Complete Reference" - Herbert Schildt

### Plataformas de Práctica

- [HackerRank Java](https://www.hackerrank.com/domains/java)
- [LeetCode](https://leetcode.com/)
- [Codewars](https://www.codewars.com/)

---

## 👤 Autor

**Alexi Duran**

- Repositorio: Java_S1_DuranAlexi
- Fecha de creación: 19 de noviembre de 2025
- Propósito: Documentación de aprendizaje - Primer Semestre de Java

---

## 📝 Notas

Este repositorio está en constante actualización conforme se avanza en el aprendizaje. Los ejercicios y proyectos reflejan el nivel de conocimiento adquirido durante el primer semestre de estudio del lenguaje Java.

---

## 🤝 Contribuciones

Si encuentras errores o tienes sugerencias para mejorar los ejemplos, siéntete libre de:

- Abrir un issue
- Proponer mejoras mediante pull requests

---

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la [Licencia MIT](LICENSE).

---

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

# Fundamentos de Java ☕

## 📋 Descripción

Esta sección contiene ejercicios y ejemplos prácticos sobre los **fundamentos básicos de Java**. Aquí aprenderás la sintaxis esencial del lenguaje, tipos de datos, operadores, y las estructuras básicas necesarias para comenzar a programar en Java.

Cada archivo está documentado con comentarios detallados para facilitar la comprensión de los conceptos fundamentales.

---

## 📂 Contenido de la Carpeta

```
fundamentos/
│
├── README.md
├── HolaMundo.java
├── Variables.java
├── TiposDatos.java
├── Constantes.java
├── OperadoresAritmeticos.java
├── OperadoresLogicos.java
├── OperadoresRelacionales.java
├── EntradaSalida.java
├── ConversionTipos.java
└── Comentarios.java
```

---

## 🎯 Objetivos de Aprendizaje

Al completar los ejercicios de esta sección, serás capaz de:

- ✅ Escribir y ejecutar tu primer programa en Java
- ✅ Declarar y utilizar variables de diferentes tipos
- ✅ Comprender los tipos de datos primitivos y de referencia
- ✅ Usar operadores aritméticos, lógicos y relacionales
- ✅ Manejar entrada y salida de datos
- ✅ Realizar conversiones entre tipos de datos
- ✅ Aplicar buenas prácticas de nomenclatura y documentación

---

## 📚 Temas Cubiertos

### 1. Hola Mundo (`HolaMundo.java`)

Tu primer programa en Java. Aprenderás:

- Estructura básica de un programa Java
- El método `main()`
- La instrucción `System.out.println()`
- Compilación y ejecución

**Conceptos clave:**

```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("¡Hola, Mundo!");
    }
}
```

### 2. Variables (`Variables.java`)

Declaración y uso de variables:

- Sintaxis de declaración
- Inicialización de variables
- Alcance de variables (scope)
- Convenciones de nomenclatura (camelCase)

**Ejemplo:**

```java
int edad = 25;
String nombre = "Alexi";
double salario = 1500.50;
```

### 3. Tipos de Datos (`TiposDatos.java`)

#### Tipos Primitivos

| Tipo      | Tamaño  | Rango              | Ejemplo               |
| --------- | ------- | ------------------ | --------------------- |
| `byte`    | 8 bits  | -128 a 127         | `byte b = 100;`       |
| `short`   | 16 bits | -32,768 a 32,767   | `short s = 1000;`     |
| `int`     | 32 bits | -2³¹ a 2³¹-1       | `int i = 50000;`      |
| `long`    | 64 bits | -2⁶³ a 2⁶³-1       | `long l = 100000L;`   |
| `float`   | 32 bits | ~6-7 decimales     | `float f = 3.14f;`    |
| `double`  | 64 bits | ~15 decimales      | `double d = 3.14159;` |
| `char`    | 16 bits | Unicode 0 a 65,535 | `char c = 'A';`       |
| `boolean` | 1 bit   | true o false       | `boolean b = true;`   |

#### Tipos de Referencia

- String
- Arrays
- Clases (Objects)

### 4. Constantes (`Constantes.java`)

Uso de la palabra clave `final`:

```java
final double PI = 3.14159;
final int MAX_USUARIOS = 100;
```

Convenciones:

- Nombres en MAYÚSCULAS
- Separar palabras con guion bajo (\_)

### 5. Operadores Aritméticos (`OperadoresAritmeticos.java`)

| Operador | Descripción      | Ejemplo      |
| -------- | ---------------- | ------------ |
| `+`      | Suma             | `5 + 3 = 8`  |
| `-`      | Resta            | `5 - 3 = 2`  |
| `*`      | Multiplicación   | `5 * 3 = 15` |
| `/`      | División         | `10 / 2 = 5` |
| `%`      | Módulo (residuo) | `10 % 3 = 1` |
| `++`     | Incremento       | `i++`        |
| `--`     | Decremento       | `i--`        |

**Operadores de asignación compuestos:**

```java
x += 5;  // equivale a: x = x + 5
x -= 3;  // equivale a: x = x - 3
x *= 2;  // equivale a: x = x * 2
```

### 6. Operadores Relacionales (`OperadoresRelacionales.java`)

| Operador | Descripción   | Ejemplo         |
| -------- | ------------- | --------------- |
| `==`     | Igual a       | `5 == 5` → true |
| `!=`     | Diferente de  | `5 != 3` → true |
| `>`      | Mayor que     | `5 > 3` → true  |
| `<`      | Menor que     | `3 < 5` → true  |
| `>=`     | Mayor o igual | `5 >= 5` → true |
| `<=`     | Menor o igual | `3 <= 5` → true |

### 7. Operadores Lógicos (`OperadoresLogicos.java`)

| Operador | Descripción    | Ejemplo                  |
| -------- | -------------- | ------------------------ |
| `&&`     | AND (Y lógico) | `true && false` → false  |
| `\|\|`   | OR (O lógico)  | `true \|\| false` → true |
| `!`      | NOT (Negación) | `!true` → false          |

**Tabla de verdad:**

```java
// AND (&&) - Ambos deben ser true
true && true   → true
true && false  → false
false && false → false

// OR (||) - Al menos uno debe ser true
true || false  → true
false || false → false
```

### 8. Entrada y Salida (`EntradaSalida.java`)

#### Salida de datos

```java
System.out.println("Con salto de línea");
System.out.print("Sin salto de línea");
System.out.printf("Formato: %d %s %.2f", 10, "texto", 3.14);
```

#### Entrada de datos con Scanner

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextLine();

System.out.print("Ingresa tu edad: ");
int edad = scanner.nextInt();

scanner.close();
```

### 9. Conversión de Tipos (`ConversionTipos.java`)

#### Conversión Implícita (Widening)

```java
int entero = 100;
double decimal = entero;  // Automático
```

#### Conversión Explícita (Casting)

```java
double decimal = 9.78;
int entero = (int) decimal;  // entero = 9
```

#### Conversión con String

```java
// String a número
String texto = "123";
int numero = Integer.parseInt(texto);
double decimal = Double.parseDouble("3.14");

// Número a String
int num = 456;
String str = String.valueOf(num);
String str2 = "" + num;  // Concatenación
```

### 10. Comentarios (`Comentarios.java`)

```java
// Comentario de una línea

/* Comentario
   de múltiples
   líneas */

/**
 * Comentario de documentación (Javadoc)
 * @author Alexi Duran
 * @version 1.0
 */
```

---

## 🚀 Cómo Usar Esta Sección

### Orden Recomendado de Estudio

1. **HolaMundo.java** - Comienza aquí
2. **Variables.java** - Aprende sobre variables
3. **TiposDatos.java** - Entiende los tipos de datos
4. **Constantes.java** - Valores inmutables
5. **OperadoresAritmeticos.java** - Operaciones matemáticas
6. **OperadoresRelacionales.java** - Comparaciones
7. **OperadoresLogicos.java** - Lógica booleana
8. **EntradaSalida.java** - Interacción con el usuario
9. **ConversionTipos.java** - Transformar datos
10. **Comentarios.java** - Documentar código

### Ejecutar los Ejemplos

#### Desde la Terminal

```bash
# Navegar a la carpeta fundamentos
cd src/fundamentos

# Compilar un archivo
javac HolaMundo.java

# Ejecutar el programa
java HolaMundo
```

#### Desde el IDE

1. Abre el archivo `.java` que deseas ejecutar
2. Haz clic derecho sobre el archivo
3. Selecciona **Run 'NombreDelArchivo.main()'**
4. Observa la salida en la consola

---

## 💡 Ejercicios Propuestos

Después de revisar los ejemplos, intenta resolver estos desafíos:

### Ejercicio 1: Calculadora Básica

Crea un programa que:

- Solicite dos números al usuario
- Realice las 4 operaciones básicas (+, -, \*, /)
- Muestre los resultados formateados

### Ejercicio 2: Conversor de Temperatura

Convierte grados Celsius a Fahrenheit y viceversa.

- Fórmula: `F = (C * 9/5) + 32`
- Fórmula: `C = (F - 32) * 5/9`

### Ejercicio 3: Verificador de Edad

Solicita la edad del usuario y determina:

- Si es menor de edad (< 18)
- Si es adulto (18-65)
- Si es adulto mayor (> 65)

### Ejercicio 4: Calculadora de Área

Calcula el área de:

- Círculo: `A = π * r²`
- Rectángulo: `A = base * altura`
- Triángulo: `A = (base * altura) / 2`

### Ejercicio 5: Conversor de Unidades

Convierte entre:

- Metros ↔ Kilómetros
- Kilogramos ↔ Libras
- Litros ↔ Galones

---

## 🎓 Mejores Prácticas

### Nomenclatura

```java
// Variables y métodos: camelCase
int miEdad;
String nombreCompleto;

// Constantes: UPPER_CASE
final double PI = 3.14159;
final int MAX_INTENTOS = 3;

// Clases: PascalCase
public class MiClase { }
```

### Convenciones de Código

- Usa nombres descriptivos para variables
- Evita nombres de una sola letra (excepto en bucles)
- Añade espacios para mejorar la legibilidad
- Comenta código complejo
- Mantén líneas de código menores a 80 caracteres

### Ejemplo de Código Limpio

```java
// ❌ Mal
int x=5;int y=10;int z=x+y;

// ✅ Bien
int primerNumero = 5;
int segundoNumero = 10;
int suma = primerNumero + segundoNumero;
```

---

## 📖 Recursos Adicionales

### Documentación Oficial

- [Java Tutorials - Learning the Java Language](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
- [Java SE API - java.lang Package](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/package-summary.html)

### Tutoriales Interactivos

- [W3Schools Java Syntax](https://www.w3schools.com/java/java_syntax.asp)
- [Codecademy Learn Java](https://www.codecademy.com/learn/learn-java)

### Videos Recomendados

- Java Programming for Beginners (YouTube)
- Java Fundamentals Course (Udemy/Coursera)

---

## 🐛 Errores Comunes y Soluciones

### Error 1: "Cannot find symbol"

**Causa:** Variable no declarada o mal escrita

```java
// ❌ Error
System.out.println(edad);  // edad no fue declarada

// ✅ Solución
int edad = 25;
System.out.println(edad);
```

### Error 2: "Incompatible types"

**Causa:** Asignación de tipo incorrecto

```java
// ❌ Error
int numero = "123";  // String no se puede asignar a int

// ✅ Solución
int numero = Integer.parseInt("123");
```

### Error 3: División por cero

```java
// ❌ Error potencial
int resultado = 10 / 0;  // ArithmeticException

// ✅ Solución
int divisor = 0;
if (divisor != 0) {
    int resultado = 10 / divisor;
} else {
    System.out.println("No se puede dividir por cero");
}
```

---

## ✅ Checklist de Aprendizaje

Marca lo que ya dominas:

- [ ] Puedo escribir y ejecutar un programa "Hola Mundo"
- [ ] Entiendo la diferencia entre tipos primitivos y de referencia
- [ ] Sé declarar variables con nombres descriptivos
- [ ] Puedo usar operadores aritméticos correctamente
- [ ] Comprendo operadores lógicos y relacionales
- [ ] Sé solicitar datos al usuario con Scanner
- [ ] Puedo convertir entre diferentes tipos de datos
- [ ] Entiendo cuándo usar casting explícito
- [ ] Sé usar constantes con `final`
- [ ] Puedo documentar mi código con comentarios

---

## 🔄 Siguientes Pasos

Una vez que domines estos fundamentos, estarás listo para avanzar a:

1. **Control de Flujo** - Condicionales y bucles
2. **Métodos** - Creación de funciones reutilizables
3. **Arrays** - Manejo de colecciones de datos
4. **Programación Orientada a Objetos** - Clases y objetos

---

## 👤 Autor

**Alexi Duran**

- Sección: Fundamentos de Java
- Última actualización: 19 de noviembre de 2025

---

**¡Sigue practicando y nunca dejes de aprender! 🚀**

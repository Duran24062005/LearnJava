# Structural Design Patterns

## Introduction

Structural design patterns are concerned with how classes and objects are composed to form larger structures. These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.

## Main Structural Patterns

### 1. Adapter Pattern

**Purpose**: Allows incompatible interfaces to work together by converting the interface of a class into another interface that clients expect.

**Use Cases**:

- Integrating legacy code with new systems
- Working with third-party libraries that have incompatible interfaces
- Reusing existing classes that don't match required interfaces

**Example Scenario**: Converting XML data to JSON format for a modern API that only accepts JSON.

**Key Benefits**:

- Promotes code reusability
- Increases flexibility
- Adheres to the Single Responsibility Principle

---

### 2. Bridge Pattern

**Purpose**: Separates an abstraction from its implementation so that both can vary independently.

**Use Cases**:

- When you want to avoid permanent binding between abstraction and implementation
- When changes in implementation should not affect clients
- Sharing implementation among multiple objects

**Example Scenario**: A remote control (abstraction) that can work with different devices like TV, radio, or speakers (implementations).

**Key Benefits**:

- Decouples interface from implementation
- Improves extensibility
- Hides implementation details from clients

---

### 3. Composite Pattern

**Purpose**: Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.

**Use Cases**:

- Representing hierarchical structures (file systems, organizational charts)
- When clients should treat all objects in the composition uniformly
- Building complex objects from simpler ones

**Example Scenario**: A file system where both files and folders can be treated as the same type of object, where folders can contain files or other folders.

**Key Benefits**:

- Simplifies client code
- Makes it easier to add new component types
- Provides flexibility in structure composition

---

### 4. Decorator Pattern

**Purpose**: Attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality.

**Use Cases**:

- Adding responsibilities to individual objects without affecting other objects
- When extension by subclassing is impractical
- Adding features that can be withdrawn

**Example Scenario**: Adding toppings to a coffee order (milk, sugar, whipped cream) where each addition wraps the base coffee object.

**Key Benefits**:

- More flexible than static inheritance
- Avoids feature-laden classes high up in the hierarchy
- Allows behavior modification at runtime

---

### 5. Facade Pattern

**Purpose**: Provides a simplified interface to a complex subsystem, making it easier to use.

**Use Cases**:

- Simplifying complex libraries or frameworks
- Providing a simple default view of a subsystem
- Decoupling client code from subsystem components

**Example Scenario**: A home theater system facade that simplifies the operation of multiple components (DVD player, amplifier, projector, lights) with simple methods like `watchMovie()` and `endMovie()`.

**Key Benefits**:

- Reduces complexity for clients
- Promotes weak coupling between subsystems and clients
- Provides a layer of abstraction

---

### 6. Flyweight Pattern

**Purpose**: Reduces memory usage by sharing common data among multiple objects instead of keeping all data in each object.

**Use Cases**:

- Applications that use a large number of similar objects
- When storage costs are high
- When most object state can be made extrinsic

**Example Scenario**: A text editor where each character is an object, but common properties like font and style are shared among many character instances.

**Key Benefits**:

- Significantly reduces memory consumption
- Improves performance when dealing with large numbers of objects
- Centralizes state management

---

### 7. Proxy Pattern

**Purpose**: Provides a surrogate or placeholder for another object to control access to it.

**Types of Proxies**:

- **Virtual Proxy**: Controls access to expensive-to-create objects
- **Protection Proxy**: Controls access based on permissions
- **Remote Proxy**: Represents objects in different address spaces
- **Smart Proxy**: Adds additional functionality when accessing objects

**Use Cases**:

- Lazy initialization of expensive objects
- Access control and authentication
- Logging and monitoring object access
- Caching results

**Example Scenario**: An image viewer that uses proxy objects to represent large images, only loading the actual image data when needed for display.

**Key Benefits**:

- Controls access to the original object
- Can add additional functionality transparently
- Manages object lifecycle and resource usage

---

## Comparison and Selection Guide

### When to Use Each Pattern

**Adapter**: Use when you need to make existing incompatible interfaces work together.

**Bridge**: Use when you want to separate interface from implementation to allow both to vary.

**Composite**: Use when you need to represent part-whole hierarchies and treat objects uniformly.

**Decorator**: Use when you need to add responsibilities to objects dynamically and transparently.

**Facade**: Use when you need to provide a simple interface to a complex subsystem.

**Flyweight**: Use when you need to efficiently support large numbers of similar objects.

**Proxy**: Use when you need to control access to an object or add functionality without changing the object itself.

---

## Best Practices

1. **Choose the right pattern**: Understand the problem thoroughly before selecting a pattern.

2. **Don't over-engineer**: Apply patterns only when they provide clear benefits.

3. **Combine patterns**: Structural patterns can be combined with each other and with other pattern types.

4. **Keep it simple**: Patterns should simplify your code, not complicate it.

5. **Consider trade-offs**: Each pattern has benefits and costs in terms of complexity, performance, and maintainability.

---

## Conclusion

Structural design patterns are essential tools for creating flexible, maintainable, and scalable software architectures. By understanding when and how to apply these patterns, developers can build systems that are easier to modify, extend, and maintain over time. The key is to recognize the specific structural problem you're facing and select the pattern that best addresses that challenge.

- [Refactoring Guru](https://refactoring.guru/design-patterns/structural-patterns)

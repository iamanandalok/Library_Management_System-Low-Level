# Library_Management_System-Low-Level
This assignment focuses on demonstrating your understanding of Java and OOP concepts. Don't worry about persistence, databases, or external APIs at this stage.

# Library Management System

This project is a Library Management System implemented in Java, demonstrating the use of Object-Oriented Programming (OOP) concepts, SOLID principles, and relevant design patterns.

## Table of Contents

- [Project Structure](#project-structure)
- [Design Overview](#design-overview)
    - [Model Layer](#model-layer)
    - [Factory Pattern](#factory-pattern)
    - [Observer Pattern](#observer-pattern)
    - [Management Layer](#management-layer)
- [SOLID Principles](#solid-principles)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)

## Project Structure

```sh
LibraryManagementSystem/
├── build.gradle
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── com/
│ │ │ │ ├── anandalok/
│ │ │ │ │ ├── Main.java
│ │ │ │ │ ├── model/
│ │ │ │ │ │ ├── Book.java
│ │ │ │ │ │ ├── EBook.java
│ │ │ │ │ │ ├── AudioBook.java
│ │ │ │ │ ├── factory/
│ │ │ │ │ │ ├── BookFactory.java
│ │ │ │ │ ├── observer/
│ │ │ │ │ │ ├── Observer.java
│ │ │ │ │ │ ├── Subject.java
│ │ │ │ │ │ ├── ReservationManager.java
│ │ │ │ │ │ ├── Patron.java
│ │ │ │ │ ├── management/
│ │ │ │ │ │ ├── BookInventory.java
│ │ │ │ │ │ ├── PatronManager.java
│ │ │ │ │ │ ├── LendingManager.java
│ │ │ │ │ │ ├── InventoryManager.java
│ │ │ │ │ │ ├── LibraryInventoryManager.java
│ │ ├── resources/
│ │ │ ├── logback.xml

```


## Design Overview

### Model Layer

The model layer contains the data structures representing different types of books in the library.

- `Book.java`: Represents a general book with common attributes.
- `EBook.java`: Extends `Book` to include a download link.
- `AudioBook.java`: Extends `Book` to include an audio sample link.

### Factory Pattern

The factory pattern is used to create different types of books.

- `BookFactory.java`: Contains a static method to create `Book`, `EBook`, and `AudioBook` instances based on the provided type.

**Thought Process:**
The Factory Pattern is used here to handle the creation of different types of books (`Book`, `EBook`, `AudioBook`). This approach ensures that the creation logic is centralized, making it easier to manage and extend in the future. If we need to add more types of books, we can simply extend the factory without modifying the client code, adhering to the Open/Closed Principle.

### Observer Pattern

The observer pattern is used to manage notifications for book reservations.

- `Observer.java`: Interface for observers that need to be notified.
- `Subject.java`: Interface for the subject that maintains a list of observers.
- `ReservationManager.java`: Implements `Subject` to manage book reservations and notify patrons.
- `Patron.java`: Implements `Observer` to receive notifications about reserved books.

**Thought Process:**
The Observer Pattern is utilized to implement a reservation notification system. When a book becomes available, all patrons who reserved the book are notified. This decouples the notification mechanism from the reservation logic, making the system more modular and adhering to the Single Responsibility Principle.

### Management Layer

The management layer contains classes responsible for managing books, patrons, and lending processes.

- `BookInventory.java`: Manages the inventory of books, allowing addition, removal, searching, and updating of books.
- `PatronManager.java`: Manages patrons, including their borrowing history.
- `LendingManager.java`: Manages the lending and returning of books, as well as checking availability.
- `InventoryManager.java`: Interface defining the operations for managing the inventory.
- `LibraryInventoryManager.java`: Implements `InventoryManager` to provide the actual functionality for managing the library's inventory.

**Thought Process:**
The management layer adheres to the Single Responsibility Principle by ensuring each class has one responsibility (e.g., `BookInventory` for managing books, `PatronManager` for managing patrons). The `InventoryManager` interface defines the contract for inventory operations, promoting the Open/Closed Principle by allowing the addition of new functionalities without modifying existing code.

## SOLID Principles

1. **Single Responsibility Principle (SRP)**: Each class has a single responsibility. For example, `BookInventory` is responsible solely for managing book inventory, and `PatronManager` is responsible for managing patron information.

2. **Open/Closed Principle (OCP)**: Classes are open for extension but closed for modification. For instance, by using the factory pattern in `BookFactory`, we can add new types of books without modifying existing code.

3. **Liskov Substitution Principle (LSP)**: Subtypes must be substitutable for their base types. For example, `EBook` and `AudioBook` can be used wherever `Book` is expected.

4. **Interface Segregation Principle (ISP)**: Interfaces are designed to be client-specific rather than general-purpose. For instance, `InventoryManager` and `Subject` interfaces provide specific functionalities that are implemented by `LibraryInventoryManager` and `ReservationManager`, respectively.

5. **Dependency Inversion Principle (DIP)**: High-level modules depend on abstractions rather than low-level modules. For example, `LendingManager` depends on `BookInventory` and `PatronManager` abstractions.


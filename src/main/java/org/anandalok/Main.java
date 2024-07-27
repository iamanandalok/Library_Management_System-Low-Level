package org.anandalok;

import org.anandalok.management.InventoryManager;
import org.anandalok.management.LendingManager;
import org.anandalok.management.LibraryInventoryManager;
import org.anandalok.observer.Patron;
import org.anandalok.management.PatronManager;
import org.anandalok.factory.BookFactory;
import org.anandalok.model.Book;
import org.anandalok.management.BookInventory;
import org.anandalok.observer.ReservationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    logger.info("Library Management System started");

    // Create instances of BookInventory, PatronManager, and LendingManager
    BookInventory bookInventory = new BookInventory();
    PatronManager patronManager = new PatronManager();
    LendingManager lendingManager = new LendingManager(bookInventory, patronManager);
    InventoryManager inventoryManager = new LibraryInventoryManager(bookInventory, lendingManager);
    ReservationManager reservationManager = new ReservationManager();

    // Sample usage of the factory pattern
    Book book1 =
        BookFactory.createBook(
            "EBook",
            "Effective Java",
            "Joshua Bloch",
            "978-0134685991",
            2018,
            "http://download.link");
    Book book2 =
        BookFactory.createBook(
            "AudioBook",
            "Clean Code",
            "Robert C. Martin",
            "978-0132350884",
            2008,
            "http://audio.sample");
    Book book3 =
        BookFactory.createBook(
            "Book", "Design Patterns", "Erich Gamma", "978-0201633610", 1994, null);

    inventoryManager.addBook(book1);
    inventoryManager.addBook(book2);
    inventoryManager.addBook(book3);

    // Add sample patrons and observe the reservation system
    Patron patron1 = new Patron("P001", "Alice Johnson", "alice@example.com");
    Patron patron2 = new Patron("P002", "Bob Smith", "bob@example.com");

    patronManager.addPatron(patron1);
    patronManager.addPatron(patron2);

    reservationManager.addObserver(patron1);
    reservationManager.addObserver(patron2);

    // Perform book search
    logger.info("Search book by ISBN:");
    Book foundBook = inventoryManager.searchByISBN("978-0134685991");
    logger.info("Found book: " + foundBook.getTitle());

    logger.info("Search books by title:");
    List<Book> booksByTitle = inventoryManager.searchByTitle("Clean Code");
    for (Book book : booksByTitle) {
      logger.info("Found book: " + book.getTitle());
    }

    logger.info("Search books by author:");
    List<Book> booksByAuthor = inventoryManager.searchByAuthor("Robert C. Martin");
    for (Book book : booksByAuthor) {
      logger.info("Found book: " + book.getTitle());
    }

    // Perform book checkout and return
    logger.info("Checking out a book");
    if (lendingManager.checkoutBook("P001", "978-0134685991")) {
      logger.info("Book checked out successfully.");
    } else {
      logger.warn("Failed to check out book.");
    }

    reservationManager.reserveBook("P002", "978-0134685991");
    reservationManager.notifyAvailability("978-0134685991");

    logger.info("Returning a book");
    if (lendingManager.returnBook("P001", "978-0134685991")) {
      logger.info("Book returned successfully.");
    } else {
      logger.warn("Failed to return book.");
    }

    // Update book details
    logger.info("Updating a book");
    Book updatedBook =
        BookFactory.createBook(
            "EBook",
            "Effective Java (3rd Edition)",
            "Joshua Bloch",
            "978-0134685991",
            2018,
            "http://updated.download.link");
    inventoryManager.updateBook("978-0134685991", updatedBook);
    Book updatedFoundBook = inventoryManager.searchByISBN("978-0134685991");
    logger.info("Updated book title: " + updatedFoundBook.getTitle());

    // Display patron borrowing history
    logger.info("Patron borrowing history:");
    List<String> borrowingHistory = patronManager.getBorrowingHistory("P001");
    logger.info("Patron P001 borrowed books: " + borrowingHistory);

    logger.info("Library Management System ended");
  }
}

package org.anandalok.management;

import org.anandalok.model.Book;

import java.util.List;

public class LibraryInventoryManager implements InventoryManager {
    private BookInventory bookInventory;
    private LendingManager lendingManager;

    public LibraryInventoryManager(BookInventory bookInventory, LendingManager lendingManager) {
        this.bookInventory = bookInventory;
        this.lendingManager = lendingManager;
    }

    public void addBook(Book book) {
        bookInventory.addBook(book);
    }

    public void removeBook(String ISBN) {
        bookInventory.removeBook(ISBN);
    }

    public Book searchByISBN(String ISBN) {
        return bookInventory.searchByISBN(ISBN);
    }

    public List<Book> searchByTitle(String title) {
        return bookInventory.searchByTitle(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookInventory.searchByAuthor(author);
    }

    public void updateBook(String ISBN, Book updatedBook) {
        bookInventory.updateBook(ISBN, updatedBook);
    }

    public boolean isBookAvailable(String ISBN) {
        return !lendingManager.isBookBorrowed(ISBN);
    }
}


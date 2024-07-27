package org.anandalok.management;

import org.anandalok.model.Book;

import java.util.List;

public interface InventoryManager {
    void addBook(Book book);
    void removeBook(String ISBN);
    Book searchByISBN(String ISBN);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    void updateBook(String ISBN, Book updatedBook);
    boolean isBookAvailable(String ISBN);
}


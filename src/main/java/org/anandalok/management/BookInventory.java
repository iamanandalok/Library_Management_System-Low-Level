package org.anandalok.management;

import org.anandalok.model.Book;

import java.util.*;

public class BookInventory {
  private Map<String, Book> booksByISBN = new HashMap<>();
  private Map<String, List<Book>> booksByTitle = new HashMap<>();
  private Map<String, List<Book>> booksByAuthor = new HashMap<>();

  public void addBook(Book book) {
    booksByISBN.put(book.getISBN(), book);
    booksByTitle.computeIfAbsent(book.getTitle(), k -> new ArrayList<>()).add(book);
    booksByAuthor.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(book);
  }

  public void removeBook(String ISBN) {
    Book book = booksByISBN.remove(ISBN);
    if (book != null) {
      booksByTitle.get(book.getTitle()).remove(book);
      booksByAuthor.get(book.getAuthor()).remove(book);
    }
  }

  public Book searchByISBN(String ISBN) {
    return booksByISBN.get(ISBN);
  }

  public List<Book> searchByTitle(String title) {
    return booksByTitle.getOrDefault(title, Collections.emptyList());
  }

  public List<Book> searchByAuthor(String author) {
    return booksByAuthor.getOrDefault(author, Collections.emptyList());
  }

  public void updateBook(String ISBN, Book updatedBook) {
    removeBook(ISBN);
    addBook(updatedBook);
  }
}

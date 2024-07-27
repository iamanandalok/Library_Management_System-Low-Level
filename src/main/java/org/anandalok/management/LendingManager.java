package org.anandalok.management;

import java.util.*;

public class LendingManager {
    private BookInventory bookInventory;
    private PatronManager patronManager;
    private Map<String, String> borrowedBooks; // Map<BookISBN, PatronId>

    public LendingManager(BookInventory bookInventory, PatronManager patronManager) {
        this.bookInventory = bookInventory;
        this.patronManager = patronManager;
        this.borrowedBooks = new HashMap<>();
    }

    public boolean checkoutBook(String patronId, String bookISBN) {
        if (bookInventory.searchByISBN(bookISBN) != null && !borrowedBooks.containsKey(bookISBN)) {
            borrowedBooks.put(bookISBN, patronId);
            patronManager.addBorrowedBook(patronId, bookISBN);
            return true;
        }
        return false;
    }

    public boolean returnBook(String patronId, String bookISBN) {
        if (borrowedBooks.containsKey(bookISBN) && borrowedBooks.get(bookISBN).equals(patronId)) {
            borrowedBooks.remove(bookISBN);
            return true;
        }
        return false;
    }

    public boolean isBookBorrowed(String bookISBN) {
        return borrowedBooks.containsKey(bookISBN);
    }
}


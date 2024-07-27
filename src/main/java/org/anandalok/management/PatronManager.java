package org.anandalok.management;
import org.anandalok.observer.Patron;

import java.util.*;

public class PatronManager {
  private Map<String, Patron> patrons = new HashMap<>();

  public void addPatron(Patron patron) {
    patrons.put(patron.getId(), patron);
  }

  public void updatePatron(String id, Patron updatedPatron) {
    patrons.put(id, updatedPatron);
  }

  public Patron getPatron(String id) {
    return patrons.get(id);
  }

  public void addBorrowedBook(String patronId, String bookISBN) {
    Patron patron = patrons.get(patronId);
    if (patron != null) {
      patron.getBorrowedBooks().add(bookISBN);
    }
  }

  public List<String> getBorrowingHistory(String patronId) {
    Patron patron = patrons.get(patronId);
    return (patron != null) ? patron.getBorrowedBooks() : Collections.emptyList();
  }
}

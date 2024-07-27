package org.anandalok.observer;

import java.util.ArrayList;
import java.util.List;

public class Patron implements Observer {
  private String id;
  private String name;
  private String email;
  private List<String> borrowedBooks;

  public Patron(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void setBorrowedBooks(List<String> borrowedBooks) {
    this.borrowedBooks = borrowedBooks;
  }
// Other methods as previously defined

  @Override
  public void update(String message) {
    System.out.println("Notification for " + name + ": " + message);
  }
}

package org.anandalok.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationManager implements Subject {
  private Map<String, String> reservations = new HashMap<>(); // Map<BookISBN, PatronId>
  private List<Observer> observers = new ArrayList<>();

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public void reserveBook(String patronId, String bookISBN) {
    reservations.put(bookISBN, patronId);
    notifyObservers("Book with ISBN " + bookISBN + " reserved by Patron " + patronId);
  }

  public void notifyAvailability(String bookISBN) {
    if (reservations.containsKey(bookISBN)) {
      String patronId = reservations.get(bookISBN);
      notifyObservers("Book with ISBN " + bookISBN + " is now available for Patron " + patronId);
      reservations.remove(bookISBN);
    }
  }
}



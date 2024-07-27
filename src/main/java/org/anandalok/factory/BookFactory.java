package org.anandalok.factory;

import org.anandalok.model.AudioBook;
import org.anandalok.model.Book;
import org.anandalok.model.EBook;

public class BookFactory {
    public static Book createBook(String type, String title, String author, String ISBN, int publicationYear, String extra) {
        switch (type) {
            case "EBook":
                return new EBook(title, author, ISBN, publicationYear, extra);
            case "AudioBook":
                return new AudioBook(title, author, ISBN, publicationYear, extra);
            default:
                return new Book(title, author, ISBN, publicationYear);
        }
    }
}


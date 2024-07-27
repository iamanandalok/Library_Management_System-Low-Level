package org.anandalok.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {

    //Implement a Book class with attributes such as title, author, ISBN, and publication year.
    private String title;
    private String author;
    private String ISBN;
    private Date publicationYear;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        try {
            this.publicationYear = dateFormat.parse(String.valueOf(publicationYear));
        } catch (ParseException e) {
            e.printStackTrace();
            this.publicationYear = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        try {
            this.publicationYear = dateFormat.parse(String.valueOf(publicationYear));
        } catch (ParseException e) {
            e.printStackTrace();
            this.publicationYear = null;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publicationYear=" + dateFormat.format(publicationYear) +
                '}';
    }
}

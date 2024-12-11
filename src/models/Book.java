package models;

import enams.Genre;

import java.util.Arrays;

public class Book {
    private Long id;
    private String name;
    private String author;
    private Genre genre;
    private static long generateId = 0;

    public Book() {
        this.id = generateId++;
    }

    public Book(String name, String author, Genre genre) {
        this.id = generateId++;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}'+"\n";
    }
}

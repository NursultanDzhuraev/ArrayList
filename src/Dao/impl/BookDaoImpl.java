package Dao.impl;

import Dao.BookDao;
import models.Book;
import models.Library;

import java.util.List;

import static models.Database.books;
import static models.Database.libraries;

public class BookDaoImpl implements BookDao {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId))
                books.add(book);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId))
                for (Book book : books) {
                    if (book.getId().equals(bookId))
                        return book;
                }
        }
       return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId))
                for (Book book : books) {
                    if (book.getId().equals(bookId))
                        books.remove(book);
        }

    }

    return "Successful delete";
}

    @Override
    public void clearBooksByLibraryId(Long libraryId) {

    }
}

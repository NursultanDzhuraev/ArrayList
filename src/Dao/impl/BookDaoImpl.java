package Dao.impl;

import Dao.BookDao;
import models.Book;
import models.Library;

import java.util.ArrayList;
import java.util.List;

import static models.Database.booksBase;
import static models.Database.libraries;

public class BookDaoImpl implements BookDao {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                if (library.getBooks() == null) {
                    library.setBooks(new ArrayList<>());
                }
                library.getBooks().add(book);
                System.out.println("Successful save book");
            }
        }

        booksBase.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {

        List<Book> bookList = new ArrayList<>();
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                bookList = library.getBooks();
                System.out.println(bookList);
            }
        }
        return bookList;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Book findBook = null;
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                if (library.getBooks() != null) {
                    for (Book book : library.getBooks()) {
                        if (book.getId().equals(bookId)) {
                            findBook = book;
                            System.out.println(book);
                            break;
                        }
                    }
                }
            }else {
                System.out.println("nod found");
            }
        }
        return findBook;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        int index = -1;

        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                for (int i = 0; i < library.getBooks().size(); i++) {
                    if (library.getBooks() != null) {
                        if (library.getBooks().get(i).getId() == bookId) {
                            index = i;
                            break;
                        }
                    }
                }
                Book remove = library.getBooks().remove(index);
                System.out.println(remove);

            }

        }

        return index >= 0 ? "Successful delete" : "Error on deleted!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().clear();
            }
        }

    }
}

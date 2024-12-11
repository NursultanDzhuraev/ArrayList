package service.impl;

import Dao.impl.BookDaoImpl;
import models.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDaoImpl bookDaoImpl;

    public BookServiceImpl(BookDaoImpl bookDao) {
        this.bookDaoImpl = bookDao;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        return bookDaoImpl.saveBook(libraryId, book);
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return bookDaoImpl.getAllBooks(libraryId);
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return bookDaoImpl.getBookById(libraryId, bookId);
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        bookDaoImpl.deleteBook(libraryId, bookId);
        return "Successful delete";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        bookDaoImpl.clearBooksByLibraryId(libraryId);
    }
}

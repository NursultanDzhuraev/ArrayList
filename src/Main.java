import Dao.impl.BookDaoImpl;
import Dao.impl.LibraryDaoImpl;
import Dao.impl.ReaderDaoImpl;
import enams.Gender;
import enams.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.impl.BookServiceImpl;
import service.impl.LibraryServiceImpl;
import service.impl.ReaderServiceImpl;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Library library = new Library();
    static Scanner scanForStr = new Scanner(System.in);
    static Scanner scanForNumber = new Scanner(System.in);

    public static void main(String[] args) {

        LibraryDaoImpl libraryDao = new LibraryDaoImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl(libraryDao);

        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl(readerDao);

        BookDaoImpl bookDao = new BookDaoImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookDao);
        List<Library> libraryList = new ArrayList<>(Arrays.asList(
                new Library("Республиканская Библиотека имени К. Баялинова", "242 ул. Атая Огонбаева"),
                new Library("Библиотека №2 им. Турусбекова Дж.", "252 ул. Киевская "),
                new Library("Библиотека KNU", "56 ул. Чуй"),
                new Library("Республиканская Библиотека ", "24 ул. Киевский"),
                new Library("Библиотека ", "42 ул. Манас")
        ));
//        List<Library> libraryList = new ArrayList<>(Arrays.asList(
//                addLibrary(new Library())
//        ));

        while (true) {
            System.out.println("""
                    0 Exit
                    1 saveLibrary
                    2 getAllLibraries
                    3 getLibraryById
                    4 updateLibrary
                    5 deleteLibrary
                    6 saveBook
                    7 getAllBooks
                    8 getBookById
                    9 deleteBook
                    10 clearBooksByLibraryId
                    11 saveReader
                    12 getAllReaders
                    13 getReaderById
                    14 updateReader
                    15 assignReaderToLibrary
                    """);
            switch (checkValidCommand()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    libraryService.saveLibrary(libraryList);

                }
                case 2 -> {
                    System.out.println(libraryService.getAllLibraries());
                }
                case 3 -> {
                    System.out.print("Enter Library id: ");
                    Library libraryById = libraryService.getLibraryById(scanForNumber.nextLong());
                    System.out.println(libraryById);
                }
                case 4 -> {
                    System.out.print("Enter Library id: ");
                    Long idLibrary = scanForNumber.nextLong();
                    libraryService.updateLibrary(idLibrary, addLibrary(new Library()));
                }
                case 5 -> {
                    System.out.print("Enter Library id: ");
                    Long idLibrary = scanForNumber.nextLong();
                    libraryService.deleteLibrary(idLibrary);
                }
                case 6 -> {
                    System.out.print("Enter book id: ");
                    Long bookId = scanForNumber.nextLong();
                    bookService.saveBook(bookId, addBook(new Book()));
                }
                case 7 -> {
                    System.out.print("Enter Library id: ");
                    Long libraryId = scanForNumber.nextLong();
                    bookService.getAllBooks(libraryId);
                }
                case 8 -> {
                    System.out.print("Enter book id: ");
                    Long bookId = scanForNumber.nextLong();
                    System.out.print("Enter Library id: ");
                    Long libraryId = scanForNumber.nextLong();
                    bookService.getBookById(libraryId, bookId);
                }
                case 9 -> {
                    System.out.print("Enter Library id: ");
                    Long libraryId = scanForNumber.nextLong();
                    bookService.saveBook(libraryId, addBook(new Book()));
                }
                case 10 -> {
                    System.out.print("Enter Library id: ");
                    Long libraryId = scanForNumber.nextLong();
                    bookService.clearBooksByLibraryId(libraryId);
                }
                case 11 -> {
                    readerService.saveReader(addReader(new Reader()));
                }
                case 12 -> {
                    System.out.println(readerService.getAllReaders());
                }
                case 13 -> {
                    System.out.print("Enter reader id: ");
                    Long readerId = scanForNumber.nextLong();
                    readerService.getReaderById(readerId);
                }
                case 14 -> {
                    System.out.print("Enter reader id: ");
                    Long readerId = scanForNumber.nextLong();
                   readerService.updateReader(readerId,addReader(new Reader()));
                }
                case 15 -> {
                    System.out.print("Enter reader id: ");
                    Long readerId = scanForNumber.nextLong();
                    System.out.print("Enter Library id: ");
                    Long libraryId = scanForNumber.nextLong();
                    readerService.assignReaderToLibrary(readerId, libraryId);
                }
            }
        }


    }

    public static int checkValidCommand() {
        int command = 0;
        boolean invalidCommand;
        System.out.print("write command: ");
        do {
            try {
                command = new Scanner(System.in).nextInt();
                invalidCommand = false;
            } catch (InputMismatchException e) {
                invalidCommand = true;
                System.out.print("invalid command. Enter valid command: ");
            }
        } while (invalidCommand);
        return command;
    }

    public static Library addLibrary(Library library) {
        System.out.print("Enter library name: ");
        library.setName(scanForStr.nextLine());
        System.out.print("Enter library address: ");
        library.setAddress(scanForStr.nextLine());
        System.out.println("Enter ");

        return library;
    }

    public static Book addBook(Book book) {
        System.out.print("Enter book name: ");
        book.setName(scanForStr.nextLine());
        System.out.print("Enter book author: ");
        book.setAuthor(scanForStr.nextLine());
        System.out.print("Enter book Genre(ROMANCE,FANTASY,HISTORICAL): ");
        book.setGenre(Genre.valueOf(scanForStr.nextLine()));
        return book;
    }
    public static Reader addReader(Reader reader){
        System.out.print("Enter reader full name: ");
        reader.setFullName(scanForStr.nextLine());
        System.out.print("Enter reader email: ");
        reader.setEmail(scanForStr.nextLine());
        System.out.print("Enter reader phone number: ");
        reader.setPhoneNumber(scanForStr.nextLine());
        System.out.print("Enter reader gender (MAN,WOMAN): ");
        reader.setGender(Gender.valueOf(scanForStr.nextLine()));
        return reader;
    }


}
package Dao.impl;

import Dao.LibraryDao;
import models.Database;
import models.Library;

import java.util.List;


public class LibraryDaoImpl implements LibraryDao {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        System.out.println("Successfully");
        return null;

    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(id))
                return library;
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library library1 : Database.libraries) {
            if (library1.getId().equals(id)) {
                library1.setName(library.getName());
                library1.setAddress(library.getAddress());
                library1.setBooks(library.getBooks());
                library1.setReaders(library.getReaders());
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(id)) {
                Database.libraries.remove(library);
            }
        }
        return "Successful delete";
    }
}

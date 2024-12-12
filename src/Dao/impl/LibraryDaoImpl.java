package Dao.impl;

import Dao.LibraryDao;
import models.Database;
import models.Library;

import java.util.List;


public class LibraryDaoImpl implements LibraryDao {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        System.out.println("Successfully saved libraries");
        return null;

    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        try {
            for (Library library : Database.libraries) {
                if (library.getId().equals(id)) {
                    return library;

                }
            }
            throw new IllegalArgumentException("Library not found  ID: " + id);
        } catch (Exception e) {
            System.err.println("Error fetching library: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        try {
            for (Library library1 : Database.libraries) {
                if (library1.getId().equals(id)) {
                    library1.setName(library.getName());
                    library1.setAddress(library.getAddress());
                    library1.setBooks(library.getBooks());
                    library1.setReaders(library.getReaders());
                    return library1;

                }
            }
            throw new IllegalArgumentException("Library not found ID: " + id);
        } catch (Exception e) {
            System.err.println("Error updating library: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteLibrary(Long id) {
        try {
            for (int i = 0; i < Database.libraries.size(); i++) {
                if (Database.libraries.get(i).getId().equals(id)) {
                    Database.libraries.remove(i);
                    System.out.println("deleted");
                    return "deleted";
                }

            }
            throw new IllegalArgumentException("Library not found  ID: " + id);
        } catch (Exception e) {
            System.err.println("Error deleting library: " + e.getMessage());
            return "Failed to delete library.";
        }

    }
}

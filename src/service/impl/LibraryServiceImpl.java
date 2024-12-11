package service.impl;

import Dao.LibraryDao;
import Dao.impl.LibraryDaoImpl;
import models.Library;
import service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    private final LibraryDaoImpl libraryDaoImpl;

    public LibraryServiceImpl(LibraryDaoImpl libraryDaoImpl) {
        this.libraryDaoImpl = libraryDaoImpl;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        return libraryDaoImpl.saveLibrary(libraries);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryDaoImpl.getAllLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        return libraryDaoImpl.getLibraryById(id);
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        return libraryDaoImpl.updateLibrary(id,library);
    }

    @Override
    public String deleteLibrary(Long id) {
        libraryDaoImpl.deleteLibrary(id);
        return "Successful delete";
    }
}

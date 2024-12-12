package Dao.impl;

import Dao.ReaderDao;
import models.Database;
import models.Library;
import models.Reader;

import java.util.ArrayList;
import java.util.List;

import static models.Database.libraries;
import static models.Database.readersBase;


public class ReaderDaoImpl implements ReaderDao {

    @Override
    public void saveReader(Reader reader) {
        readersBase.add(reader);


        System.out.println("Successful save: ");
    }

    @Override
    public List<Reader> getAllReaders() {
        return readersBase;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : readersBase) {
            if (reader.getId().equals(id)){
                System.out.println(reader);}
            else{ System.err.println("not found " + id);}
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader1 : readersBase) {
            if (reader1.getId().equals(id))
                reader1.setEmail(reader.getEmail());
            reader1.setGender(reader.getGender());
            reader1.setFullName(reader.getFullName());
            reader1.setPhoneNumber(reader.getPhoneNumber());
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader reader : readersBase) {
            if (reader.getId().equals(readerId)){
                for (Library library : libraries) {
                    if (library.getId().equals(libraryId)){
                        if (library.getReaders() == null) {
                            library.setReaders(new ArrayList<>());
                        }
                        library.getReaders().add(reader);
                    }
                }
            }
        }
    }
}

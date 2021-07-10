package controller;

import model.Writer;
import service.WriterService;
import service.impl.WriterServiceImpl;

import java.util.List;

public class WriterController {

   private final WriterService writerService = new WriterServiceImpl();


    public Writer getById(Long id) {
        return writerService.getById(id);
    }

    public Writer create(String firstName, String lastName) {
        return writerService.create(firstName, lastName);
    }

    public Writer update(Long id, String firstName, String lastName) {
        return writerService.update(id, firstName, lastName);
    }

    public void deleteById(Long id) {
        writerService.delete(id);
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }
}

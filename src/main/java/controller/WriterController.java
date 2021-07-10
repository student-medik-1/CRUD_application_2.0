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

    public Writer create(Writer writer) {
        return writerService.create(writer);
    }

    public Writer update(Writer writer) {
        return writerService.update(writer);
    }

    public void deleteById(Long id) {
        writerService.delete(id);
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }
}

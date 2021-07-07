package controller;

import model.Post;
import model.Region;
import model.Writer;
import service.WriterService;

import java.time.LocalDateTime;
import java.util.List;

public class WriterController {

    private WriterService writerService;

    public Writer getById(Long id) {
        return writerService.getById(id);
    }

    public Writer create(String firstName, String lastName, Region regionName) {
        return writerService.create(firstName, lastName, regionName);
    }

    public Writer update(Long id, String firstName, String lastName, Region regionName) {
        return writerService.update(id, firstName, lastName, regionName);
    }

    public void deleteById(Long id) {
        writerService.delete(id);
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }
}

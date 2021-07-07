package service;

import model.Post;
import model.Region;
import model.Writer;

import java.util.List;

public interface WriterService extends GenericService<Writer, Long> {

    Writer create(String firstName, String lastName, Region regionName);
    Writer update(Long id, String firstName, String lastName, Region regionName);
}

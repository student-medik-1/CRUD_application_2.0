package service;

import model.Writer;


public interface WriterService extends GenericService<Writer, Long> {

    Writer create(String firstName, String lastName);
    Writer update(Long id, String firstName, String lastName);
}

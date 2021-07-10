package service;

import model.Writer;


public interface WriterService extends GenericService<Writer, Long> {

    Writer create (String regionName, String lastName);
    Writer update (Long id, String regionName, String lastName);
}

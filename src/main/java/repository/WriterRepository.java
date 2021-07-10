package repository;

import model.Writer;

public interface WriterRepository extends GenericRepository <Writer, Long> {

    Writer create (String regionName, String lastName);
    Writer update (Long id, String regionName, String lastName);
}

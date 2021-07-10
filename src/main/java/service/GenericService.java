package service;

import java.util.List;

public interface GenericService<T,ID> {

    T getById(ID id);
    void delete(ID id);
    List<T> getAll();

}

package service;

import java.util.List;

public interface GenericService<T,ID> {

    T getById(ID id);
    T create(T t);
    T update (T t);
    void delete(ID id);
    List<T> getAll();

}

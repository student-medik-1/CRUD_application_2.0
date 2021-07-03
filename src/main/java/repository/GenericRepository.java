package repository;

import java.util.List;

public interface GenericRepository <T,ID>{

    T getById(ID id);
    T save (T t);
    T update (T t);
    void deleteById (ID id);
    List<T> getAll();
}

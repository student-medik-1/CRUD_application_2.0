package repository;

import java.util.List;

public interface GenericRepository <T,ID>{

    T getById(ID id);
    void create(T t);
    void update (T t);
    void deleteById (ID id);
    List<T> getAll();
}

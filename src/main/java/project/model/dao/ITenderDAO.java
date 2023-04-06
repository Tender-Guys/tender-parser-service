package project.model.dao;

import java.util.List;
import java.util.Optional;

public interface ITenderDAO<T> {
    Optional<T> getTenderByID(String id);
    List<T> getAll();

    void save(T t);
    void update(T t);
    void remove(T t);
}
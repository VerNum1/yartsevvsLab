package tech.reliab.course.toropchinda.bank.DAO;

import java.util.List;
import java.util.Optional;

// Database interface template
public interface DAO<T, K> {
    Optional<T> get(K id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(K id);
}

package ecommerce.spring.service;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService<T> {

    Collection<T> getAll();

    Optional<T> findById(Long id);

    T save(T t);

    T edit(Long id, T t);

    void remove(Long id);

    // Collection<T> findPaginated(int pageNo, int pageSize);
}

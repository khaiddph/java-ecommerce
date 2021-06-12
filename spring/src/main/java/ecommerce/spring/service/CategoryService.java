package ecommerce.spring.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService<T> {

    Collection<T> getAll();

    T findById(Long id);

    T save(T t);

    T edit(Long id, T t);

    void remove(Long id);

    // Collection<T> findPaginated(int pageNo, int pageSize);
}

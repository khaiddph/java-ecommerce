package ecommerce.spring.service;

import java.util.Collection;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface OrdersService<T> {

    // Page<T> getAll(Pageable pageable);

    // Optional<T> findById(Long id);

    // T saveOrder(String user_name, T t);
    T saveOrder(T t);

    T editOrder(Long orders_id, T t);

    void remove(Long orders_id);

    void removeAll();
}

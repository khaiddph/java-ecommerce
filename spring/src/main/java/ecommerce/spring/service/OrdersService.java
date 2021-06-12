package ecommerce.spring.service;

import java.util.Collection;

public interface OrdersService<T> {

    Collection<T> getAll();

    // Optional<T> findById(Long id);

    T saveOrder(String user_name, T t);

    T editOrder(Long orders_id, T t);

    void remove(Long orders_id);
}

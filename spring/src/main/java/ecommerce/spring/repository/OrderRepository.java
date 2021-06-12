package ecommerce.spring.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.spring.enties.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT p FROM Orders p WHERE CONCAT(p.title, p.price, p.totalPrice, p.status) LIKE %?1%")
    Collection<Orders> searchOrders(String keyword);

    Page<Orders> findOrderByAccount(final String user_name, Pageable pageable);

}

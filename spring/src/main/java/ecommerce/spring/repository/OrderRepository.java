package ecommerce.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ecommerce.spring.enties.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    // @Query("SELECT p FROM Orders p WHERE CONCAT(p.title, p.price, p.totalPrice)
    // LIKE %?1%")
    // Page<Orders> getOrders(@Param(value = "keyword") String keyword, Pageable
    // pageable);

    // Page<Orders> findOrderByAccount(final String user_name, Pageable pageable);

}

package ecommerce.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.spring.enties.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // @Query("SELECT p FROM Product p WHERE CONCAT(p.title, p.price,p.quantity)
    // Collection<Product> searchProducts(String keyword);
    // LIKE %?1%")
    Page<Product> findByCategoryId(Long category_Id, Pageable pageable);

    // Optional<Product> findByIdAndCategoryId(Long product_id, Long category_id);

}

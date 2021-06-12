package ecommerce.spring.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ecommerce.spring.enties.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT p FROM Category p WHERE p.title LIKE %?1%")
    Collection<Category> searchCategory(String title);

    Category findCategoryById(Long id);

}

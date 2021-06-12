package ecommerce.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService<T> {

    Page<T> getAll(Pageable pageable);

    // Collection<T> getProductToCategory(Long id);

    T saveProduct(Long categoryId, T t);

    T editProduct(Long product_id, T t);

    void remove(Long product_id);

    // Collection<T> paginationProduct(int pageNo, int pageSize);
}

package ecommerce.spring.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ecommerce.spring.enties.Product;
import ecommerce.spring.repository.CategoryRepository;
import ecommerce.spring.repository.ProductRepository;
import ecommerce.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    // @Override
    // public Collection<Product> getProductToCategory(Long id) {
    // return this.productRepository.findByCategoryId(id);
    // }

    @Override
    public Product saveProduct(Long categoryId, Product product) {
        return this.categoryRepository.findById(categoryId).map(category -> {
            product.setCategory(category);
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("product not found"));
    }

    @Override
    public Product editProduct(Long product_id, Product product) {
        return productRepository.findById(product_id).map(currentProduct -> {
            currentProduct.setTitle(currentProduct.getTitle());
            currentProduct.setImagePath(currentProduct.getImagePath());
            currentProduct.setPrice(currentProduct.getPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("product not found"));
    }

    @Override
    public void remove(Long product_id) {
        // Product product = productRepository.findById(product_id)
        // .orElseThrow(() -> new RuntimeException("product not found"));
        this.productRepository.deleteById(product_id);
    }

    // @Override
    // public Collection<Product> paginationProduct(int pageNo, int pageSize) {
    // Pageable pageable = PageRequest.of(pageNo, pageSize);
    // Page<Product> pageResult = this.productRepository.findAll(pageable);
    // return pageResult.toList();
    // }

}

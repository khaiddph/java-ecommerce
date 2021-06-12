package ecommerce.spring.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.spring.enties.Product;
import ecommerce.spring.repository.ProductRepository;
import ecommerce.spring.service.Impl.ProductServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public Page<Product> getAll(Pageable pageable) {
        return this.productServiceImpl.getAll(pageable);
    }

    @GetMapping("/product/search")
    public Collection<Product> searchProducts(@RequestParam("keyword") String keyword) {

        return this.productRepository.searchProducts(keyword);
    }

    @GetMapping("/category/{category_id}/product")
    public Page<Product> getProductToCategory(@PathVariable(value = "category_id") Long category_id,
            Pageable pageable) {
        return productRepository.findByCategoryId(category_id, pageable);
    }

    @PostMapping("/category/{category_id}/product")
    public Product createProductToCategory(@PathVariable Long category_id, @Valid @RequestBody Product product) {
        return this.productServiceImpl.saveProduct(category_id, product);
    }

    @PutMapping("/category/{category_id}/product/{product_id}")
    public Product updateProductToCategory(@PathVariable Long product_id, @RequestBody Product product) {

        return this.productServiceImpl.editProduct(product_id, product);
    }

    @DeleteMapping("/product/{id}")
    public void remove(@PathVariable Long id, @RequestBody Product product) {
        this.productServiceImpl.remove(id);
    }

}

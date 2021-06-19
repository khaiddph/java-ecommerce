package ecommerce.spring.service.Impl;

import java.nio.file.Path;
import java.nio.file.Paths;

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

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

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

    // @Override
    public Product saveProduct(Long categoryId, Product product) {
        return this.categoryRepository.findById(categoryId).map(category -> {
            product.setCategory(category);
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("product not found"));

        // Product product = new Product();
        // Path staticPath = Paths.get("static");
        // Path imagePath = Paths.get("images");

        // if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
        // Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        // }
        // Path file =
        // CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(image.getOriginalFilename());
        // try (OutputStream os = Files.newOutputStream(file)) {
        // os.write(image.getBytes());
        // }
        // return this.categoryRepository.findById(categoryId).map(category -> {

        // product.setCategory(category);
        // product.setTitle(title);
        // product.setImagePath(imagePath.resolve(image.getOriginalFilename()).toString());
        // product.setPrice(price);
        // product.setQuantity(quantity);
        // return productRepository.save(product);
        // }).orElseThrow(() -> new RuntimeException("product not found"));

    }

    @Override
    public Product editProduct(Long category_id, Long product_id, Product product) {
        return categoryRepository.findById(category_id).map(category -> {
            return productRepository.findById(product_id).map(currentProduct -> {
                currentProduct.setTitle(currentProduct.getTitle());
                currentProduct.setImagePath(currentProduct.getImagePath());
                currentProduct.setPrice(currentProduct.getPrice());
                currentProduct.setCategory(category);
                return productRepository.save(product);
            }).orElseThrow(() -> new RuntimeException("product not found"));
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

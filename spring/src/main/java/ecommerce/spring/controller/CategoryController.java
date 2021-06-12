package ecommerce.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

import ecommerce.spring.enties.Category;
import ecommerce.spring.repository.CategoryRepository;
import ecommerce.spring.service.Impl.CategoryServiceImpl;

// @CrossOrigin(origins = "http://localhost:8080")
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CategoryController {

  @Autowired
  private CategoryServiceImpl categoryServiceImpl;

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/category")
  public Page<Category> findAll(Pageable pageable) {
    return this.categoryRepository.findAll(pageable);
  }

  @GetMapping("/category/search")
  public Collection<Category> searchCategorys(@RequestParam String title) {
    return this.categoryRepository.searchCategory(title);
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    Category category = this.categoryServiceImpl.findById(id);
    return ResponseEntity.ok(category);
  }

  @PostMapping("/category")
  public Category createCategory(@RequestBody Category category) {
    return this.categoryServiceImpl.save(category);
  }

  @PutMapping("/category/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
    return ResponseEntity.ok(categoryServiceImpl.edit(id, category));
  }

  @DeleteMapping("/category/{id}")
  public void deleteCategory(@PathVariable Long id) {
    this.categoryServiceImpl.remove(id);
  }

  // @GetMapping("/category/{pageNo}/{pageSize}")
  // public List<Category> pagination(@PathVariable int pageNo, @PathVariable int
  // pageSize) {
  // return this.categoryServiceImpl.findPaginated(pageNo, pageSize);
  // }

}

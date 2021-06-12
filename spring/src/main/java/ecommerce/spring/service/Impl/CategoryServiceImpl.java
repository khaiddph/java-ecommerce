package ecommerce.spring.service.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.spring.enties.Category;
import ecommerce.spring.repository.CategoryRepository;
import ecommerce.spring.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    // @Override
    // public Page<Category> getCategory(Pageable pageable) {
    // return this.categoryRepository.findAll(pageable);
    // }

    @Override
    public Collection<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category edit(Long id, Category category) {
        Category currentCategory = this.categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found"));
        currentCategory.setTitle(category.getTitle());
        return this.categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        this.categoryRepository.deleteById(id);
    }

    // @Override
    // public Collection<Category> findPaginated(int pageNo, int pageSize) {
    // Pageable pageable = PageRequest.of(pageNo, pageSize);
    // Page<Category> pageResult = categoryRepository.findAll(pageable);
    // return pageResult.toList();
    // }

}

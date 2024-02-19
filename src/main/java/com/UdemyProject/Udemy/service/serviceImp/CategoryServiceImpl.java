package com.UdemyProject.Udemy.service.serviceImp;

import com.UdemyProject.Udemy.entity.Category;
import com.UdemyProject.Udemy.repository.CategoryRepository;
import com.UdemyProject.Udemy.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return (Category) categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category add(Category category) {
        log.info("A new category has been created");
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        log.info("The category is deleted");

    }
}

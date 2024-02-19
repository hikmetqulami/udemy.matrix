package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    List<Category> getAll();

    Category add(Category category);

    Category update(Category category);

    void delete(Long id);
}

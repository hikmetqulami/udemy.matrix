package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.entity.Category;
import com.UdemyProject.Udemy.service.serviceImp.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/category")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryServiceImpl.findById(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryServiceImpl.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Category add(@RequestBody Category category) {
        log.info("The course was added successfully");
        return categoryServiceImpl.add(category);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryServiceImpl.delete(id);
    }
}

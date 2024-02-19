package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.entity.Category;
import com.UdemyProject.Udemy.entity.Course;
import com.UdemyProject.Udemy.service.serviceImp.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    @GetMapping("/{id}")
        public Course findById(@PathVariable Long id) {
            return courseServiceImpl.findById(id);
        }

    @GetMapping
    public List<Course> getAll() {
        return courseServiceImpl.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Course add(@RequestBody Course course) {
        return courseServiceImpl.add(course);
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseServiceImpl.update(course);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        courseServiceImpl.delete(id);
    }
}

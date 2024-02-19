package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.entity.Course;

import java.util.List;

public interface CourseService {
    Course findById(Long id);

    List<Course> getAll();

    Course add(Course course);

    Course update(Course course);

    void delete(Long id);
}

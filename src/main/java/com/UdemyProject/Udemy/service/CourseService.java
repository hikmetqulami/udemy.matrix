package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.entity.Course;

import java.util.List;

public interface CourseService {
    Course findById(Long id);

    List<Course> getAll();

    Course add(Course course);

    Course update(Course course);

    void delete(Long id);

    List<Course> getAllCourses();
    List<Course> filterCoursesByLevel(String level);
    List<Course> filterCoursesByRating(int minRating);
    List<Course> filterCoursesByLanguage(String language);
    List<Course> filterCoursesByPrice(double maxPrice);

}

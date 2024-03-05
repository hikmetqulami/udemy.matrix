package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFilterService {
    public List<Course> filterCoursesByLevel(String level, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }

    public List<Course> filterCoursesByRating(int minRating, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    public List<Course> filterCoursesByLanguage(String language, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }

    public List<Course> filterCoursesByPrice(double maxPrice, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}

package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.entity.Category;
import com.UdemyProject.Udemy.entity.Course;
import com.UdemyProject.Udemy.service.serviceImp.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
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
        LocalDateTime currentTime = LocalDateTime.now();
        course.setLoadingTime(currentTime);
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

    //--------------------------------------------------------------------------

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseServiceImpl.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/filterByLevel")
    public ResponseEntity<List<Course>> filterCoursesByLevel(@RequestParam("level") String level) {
        List<Course> filteredCourses = courseServiceImpl.filterCoursesByLevel(level);
        return ResponseEntity.ok(filteredCourses);
    }

    @GetMapping("/courses/filterByRating")
    public ResponseEntity<List<Course>> filterCoursesByRating(@RequestParam("rating") int minRating) {
        List<Course> filteredCourses = courseServiceImpl.filterCoursesByRating(minRating);
        return ResponseEntity.ok(filteredCourses);
    }

    @GetMapping("/courses/filterByLanguage")
    public ResponseEntity<List<Course>> filterCoursesByLanguage(@RequestParam("language") String language) {
        List<Course> filteredCourses = courseServiceImpl.filterCoursesByLanguage(language);
        return ResponseEntity.ok(filteredCourses);
    }

}

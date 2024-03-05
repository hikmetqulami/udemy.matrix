package com.UdemyProject.Udemy.service.serviceImp;

import com.UdemyProject.Udemy.entity.Course;
import com.UdemyProject.Udemy.repository.CourseRepository;
import com.UdemyProject.Udemy.service.CourseFilterService;
import com.UdemyProject.Udemy.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseFilterService courseFilterService;


    @Override
    public Course findById(Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        log.info("The course is updated");
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        log.info("The course deleted successfully");
    }

    //------------------------------------------------------------


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> filterCoursesByLevel(String level) {
        List<Course> courses = courseRepository.findAll();
        return courseFilterService.filterCoursesByLevel(level, courses);
    }

    @Override
    public List<Course> filterCoursesByRating(int minRating) {
        List<Course> courses = courseRepository.findAll();
        return courseFilterService.filterCoursesByRating(minRating, courses);
    }

    @Override
    public List<Course> filterCoursesByLanguage(String language) {
        List<Course> courses = courseRepository.findAll();
        return courseFilterService.filterCoursesByLanguage(language, courses);
    }
    @Override
    public List<Course> filterCoursesByPrice(double maxPrice) {
        List<Course> courses = getAllCourses();
        return courseFilterService.filterCoursesByPrice(maxPrice, courses);
    }
}

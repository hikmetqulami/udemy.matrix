package com.UdemyProject.Udemy.service.serviceImp;

import com.UdemyProject.Udemy.entity.Course;
import com.UdemyProject.Udemy.repository.CourseRepository;
import com.UdemyProject.Udemy.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

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
}

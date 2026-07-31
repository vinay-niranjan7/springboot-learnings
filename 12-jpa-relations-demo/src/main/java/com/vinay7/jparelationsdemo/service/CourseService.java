package com.vinay7.jparelationsdemo.service;

import com.vinay7.jparelationsdemo.model.Course;
import com.vinay7.jparelationsdemo.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void createCourse(Course course){
        courseRepository.save(course);
    }
}

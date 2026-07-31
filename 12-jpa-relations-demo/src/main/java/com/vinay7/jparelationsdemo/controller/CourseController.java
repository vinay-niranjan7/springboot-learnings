package com.vinay7.jparelationsdemo.controller;

import com.vinay7.jparelationsdemo.model.Course;
import com.vinay7.jparelationsdemo.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        courseService.createCourse(course);
        return ResponseEntity.ok("DONE");
    }
}

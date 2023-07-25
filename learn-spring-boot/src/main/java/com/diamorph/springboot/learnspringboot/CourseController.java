package com.diamorph.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1L, "Learn Spring Boot", "Vladyslav Tymoshenko"),
                new Course(2L, "Learn Angular", "Peter Jackson"),
                new Course(3L, "Learn Vue", "Peter Jackson")
        );
    }
}

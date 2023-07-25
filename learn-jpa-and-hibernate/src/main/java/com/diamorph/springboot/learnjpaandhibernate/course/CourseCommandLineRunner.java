package com.diamorph.springboot.learnjpaandhibernate.course;

import com.diamorph.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1L, "Learn Java", "In28Minutes"));
//        repository.insert(new Course(2L, "Learn Java Spring", "In28Minutes"));
//        repository.insert(new Course(3L, "Learn Java Boot", "In28Minutes"));

        repository.save(new Course(1L, "Learn Java", "In28Minutes"));
        repository.save(new Course(2L, "Learn Java Spring", "In28Minutes"));
        repository.save(new Course(3L, "Learn Java Boot", "In28Minutes"));

        repository.deleteById(2L);
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("In28Minutes"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Learn Java"));
        System.out.println(repository.findByName(""));

    }
}

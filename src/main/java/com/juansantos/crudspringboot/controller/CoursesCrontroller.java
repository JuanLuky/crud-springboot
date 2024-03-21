package com.juansantos.crudspringboot.controller;

import com.juansantos.crudspringboot.model.Courses;
import com.juansantos.crudspringboot.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesCrontroller {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Courses> list() {
        return courseRepository.findAll();
    }
}

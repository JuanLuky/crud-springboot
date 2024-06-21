package com.juansantos.crudspringboot.service;

import com.juansantos.crudspringboot.model.Courses;
import com.juansantos.crudspringboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Courses> buscarPorCategoria(String category) {
        return courseRepository.findByCategory(category, Sort.by(Sort.Direction.ASC, "orderIndex"));
    }
}

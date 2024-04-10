package com.juansantos.crudspringboot.controller;

import com.juansantos.crudspringboot.model.Courses;
import com.juansantos.crudspringboot.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesCrontroller {

    private final CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Courses> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> findById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Courses create(@RequestBody Courses course) {
        return courseRepository.save( course );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Courses> update(@PathVariable Long id, @RequestBody Courses course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    recordFound.setLanguage(course.getLanguage());

                    Courses updated = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

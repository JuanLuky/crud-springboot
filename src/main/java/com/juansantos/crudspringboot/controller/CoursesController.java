package com.juansantos.crudspringboot.controller;

import com.juansantos.crudspringboot.model.Courses;
import com.juansantos.crudspringboot.repository.CourseRepository;
import com.juansantos.crudspringboot.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/lojas")
@AllArgsConstructor
public class CoursesController {

    private final CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public @ResponseBody List<Courses> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/time")
    public List<Courses> getProdutosPorCategoria(@RequestParam String category) {
        return courseService.buscarPorCategoria(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Courses create(@RequestBody @Valid Courses course) {
        return courseRepository.save( course );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses> update(@PathVariable @NotNull @Positive Long id, @RequestBody Courses course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());

                    Courses updated = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive  Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    courseRepository.deleteById(id);

                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

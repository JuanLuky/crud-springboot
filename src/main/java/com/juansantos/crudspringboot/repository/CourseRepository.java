package com.juansantos.crudspringboot.repository;

import com.juansantos.crudspringboot.model.Courses;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
    List<Courses> findByCategory(String category, Sort sort);

}

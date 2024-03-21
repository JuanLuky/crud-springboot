package com.juansantos.crudspringboot.repository;

import com.juansantos.crudspringboot.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {

}

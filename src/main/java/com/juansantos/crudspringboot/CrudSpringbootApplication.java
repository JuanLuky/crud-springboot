package com.juansantos.crudspringboot;

import com.juansantos.crudspringboot.model.Courses;
import com.juansantos.crudspringboot.repository.CourseRepository;
import com.juansantos.crudspringboot.shared.CorsConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class CrudSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);
	}

	@Bean
	CommandLineRunner initDB(CourseRepository courseRepository) {

        return args -> {
			courseRepository.deleteAll();

			Courses c = new Courses();
			c.setName("Angular");
			c.setCategory("Front-end");
			c.setLanguage("JavaScript");

			courseRepository.save(c);
		};

    }

}

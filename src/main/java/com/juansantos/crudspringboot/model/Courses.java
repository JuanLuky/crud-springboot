package com.juansantos.crudspringboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Courses {
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private  String category;

    @Column(length = 200, nullable = false)
    private String language;

}
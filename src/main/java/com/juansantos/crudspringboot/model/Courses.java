package com.juansantos.crudspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Courses {
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private  String category;

    @Column(length = 200, nullable = false)
    private String language;

}

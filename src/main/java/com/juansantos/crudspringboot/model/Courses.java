package com.juansantos.crudspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_filiais")
public class Courses {
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    private String name;

    private  String category;

}

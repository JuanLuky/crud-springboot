package com.juansantos.crudspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "tb_filiais")
@SQLDelete(sql = "UPDATE tb_filiais SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Courses {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotNull
    @Length(min = 3, max = 200)
    @Column(length = 200, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String category;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";

}

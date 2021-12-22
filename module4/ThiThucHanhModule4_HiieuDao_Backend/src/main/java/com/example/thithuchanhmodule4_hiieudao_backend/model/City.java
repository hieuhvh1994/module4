package com.example.thithuchanhmodule4_hiieudao_backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name= "cities")
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @NotBlank(message = "invalid input")
    private String name;

    @Positive
    private double area;

    @ManyToOne(targetEntity = Nation.class)
    private Nation nation;

    @Positive
    private int population;

    @Positive
    private double gdp;

    @Size(min = 1, max = 1000)
    private String description;




}

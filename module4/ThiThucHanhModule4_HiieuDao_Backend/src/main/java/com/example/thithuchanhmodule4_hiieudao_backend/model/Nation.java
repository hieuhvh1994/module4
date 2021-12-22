package com.example.thithuchanhmodule4_hiieudao_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "nations")
@Data
@NoArgsConstructor
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = City.class, mappedBy = "nation")
    @JsonIgnore
    private List<City> city;
}

package com.firatyildiz.VetClinicManagementSystem.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "species", length = 30)
    private String species;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Owner owner;
}


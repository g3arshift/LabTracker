package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class MotherboardFormFactor {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

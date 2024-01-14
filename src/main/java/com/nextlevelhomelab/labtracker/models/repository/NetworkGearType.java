package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NetworkGearType {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

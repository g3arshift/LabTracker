package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "psu_form_factor")
public class PsuFormFactor {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

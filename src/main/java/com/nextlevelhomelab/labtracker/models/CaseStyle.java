package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CaseStyle {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

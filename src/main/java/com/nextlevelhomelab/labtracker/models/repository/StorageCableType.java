package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StorageCableType {

    /**
     * This is the actual type of cable used, such as SAS3 to SFF-8643.
     */
    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

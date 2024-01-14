package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FanSize {

    @Id
    @Column(name = "size", nullable = false)
    private Integer size;
}

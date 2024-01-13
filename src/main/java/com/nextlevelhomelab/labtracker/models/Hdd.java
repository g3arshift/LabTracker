package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hdd extends Storage{

    @Column(name = "workload_limit_rating")
    private Integer workloadLimitRating;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "cache")
    private Float cache;
}

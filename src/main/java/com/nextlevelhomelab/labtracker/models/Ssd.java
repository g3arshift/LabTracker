package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ssd extends Storage{

    @Column(name = "endurance")
    private Integer endurance;

    @Column(name = "drive_writes_per_day")
    private Integer driveWritesPerDay;
}

package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;

@Getter
@Setter
@Entity
@Table(name = "distribution_plate")
public class DistributionPlate extends CustomWaterLoop {

    public DistributionPlate() throws IOException {
    }

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;

    @Column(name = "material", length = 100)
    private String Material;

    @Column(name = "mounts_pump")
    private Boolean mountsPump;

    @Column(name = "num_fitting_holes")
    private Integer numFittingHoles;
}

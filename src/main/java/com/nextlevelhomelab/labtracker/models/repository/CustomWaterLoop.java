package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CustomWaterLoop extends Cooler {

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private Cooler cooler;

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<WaterPump> waterPumps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<WaterFitting> waterFittings = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "customWaterLoops")
    private Set<Tubing> tubing = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<Radiator> radiators = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<WaterBlock> waterBlocks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<DistributionPlate> distributionPlates = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customWaterLoop", orphanRemoval = true)
    private Set<Resevoir> resevoirs = new LinkedHashSet<>();

}

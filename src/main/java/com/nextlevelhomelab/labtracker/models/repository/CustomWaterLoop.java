package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "custom_water_loop")
public class CustomWaterLoop extends Cooler {

    public CustomWaterLoop() throws IOException {
    }

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
    private Set<Reservoir> reservoirs = new LinkedHashSet<>();
}

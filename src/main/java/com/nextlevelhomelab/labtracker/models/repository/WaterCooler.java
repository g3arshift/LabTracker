package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class WaterCooler extends Cooler{

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private Cooler cooler;

    @ManyToMany
    @JoinTable(name = "watercooler_fan", joinColumns = {@JoinColumn(name = "fan_id")}, inverseJoinColumns = {@JoinColumn(name = "watercooler_id")})
    private Set<Fan> fans= new LinkedHashSet<>();

    @Comment("Meaured in fins per inch")
    @Column(name = "fin_density")
    private Float finDensity;

    @Comment("Thickness of the radiator itself, measured in mm")
    @Column(name = "thickness")
    private Float thickness;

    @Column(name = "socket_compatibility", length = 10)
    private String socketCompatibility;

    @Column(name = "brand", length = 100)
    private String brand;
}

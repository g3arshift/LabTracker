package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "radiator")
public class Radiator extends CustomWaterLoop {

    public Radiator() throws IOException {
    }

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;

    @ManyToMany
    @JoinTable(name = "radiator_fan", joinColumns = {@JoinColumn(name = "fan_id")}, inverseJoinColumns = {@JoinColumn(name = "radiator_id")})
    private Set<Fan> fans = new LinkedHashSet<>();

    @Comment("Meaured in fins per inch")
    @Column(name = "fin_density")
    private Float finDensity;

    @Comment("Thickness of the radiator itself, measured in mm")
    @Column(name = "thickness")
    private Float thickness;

    @Column(name = "material", length = 100)
    private String Material;

    @Column(name = "brand", length = 100)
    private String brand;
}

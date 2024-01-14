package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class Resevoir extends CustomWaterLoop{

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;


    @Column(name = "material", length = 100)
    private String material;

    @Column(name = "num_fitting_holes")
    private Integer numFittingHoles;

    @Comment("Measured in mL")
    @Column(name = "water_capacity")
    private Integer waterCapacity;

    @Column(name = "length")
    private Float length;

    @Column(name = "brand", length = 100)
    private String brand;
}

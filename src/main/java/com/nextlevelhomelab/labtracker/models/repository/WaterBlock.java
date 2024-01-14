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
public class WaterBlock extends CustomWaterLoop{

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;

    @Column(name = "socket", length = 10)
    private String socket;

    @Comment("The material of the parts of the block that DO contact the water")
    @Column(name = "coldplate_material", length = 25)
    private String coldPlateMaterial;

    @Comment("The material of the parts of the block that DON'T contact the water")
    @Column(name = "block_material", length = 25)
    private String blockMaterial;
}

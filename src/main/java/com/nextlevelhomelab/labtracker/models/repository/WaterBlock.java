package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;

@Getter
@Setter
@Entity
@Table(name = "water_block")
public class WaterBlock extends CustomWaterLoop {

    public WaterBlock() throws IOException {
    }

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

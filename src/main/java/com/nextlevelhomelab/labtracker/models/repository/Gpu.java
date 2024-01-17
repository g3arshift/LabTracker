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
@Table(name = "gpu")
public class Gpu extends PcieCard {

    public Gpu() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private PcieCard pcieCard;

    @Column(name = "brand", length = 25)
    private String brand;

    @Comment("Measured in Mhz")
    @Column(name = "core_speed")
    private Integer coreSpeed;

    @Comment("Measured in Mhz")
    @Column(name = "memory_speed")
    private Integer memorySpeed;

    @Comment("Measured in gigabytes")
    @Column(name = "vram")
    private Integer vram;

    @Comment("Measured in mm")
    @Column(name = "length")
    private Integer length;

    @Comment("Measured in mm")
    @Column(name = "height")
    private Integer height;
}

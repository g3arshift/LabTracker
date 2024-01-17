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
@Table(name = "water_pump")
public class WaterPump extends CustomWaterLoop {

    public WaterPump() throws IOException {
    }

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "water_pump_type")
    private WaterPumpType waterPumpType;

    @Column(name = "power_type")
    private WaterPumpPowerType powerType;

    @Comment("Measured in RPM")
    @Column(name = "speed")
    private Integer speed;
}

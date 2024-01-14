package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Fan extends InventoryItem{

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "size")
    private FanSize size;

    @Column(name = "thickness")
    private Integer thickness;

    @Comment("Measured in RPM")
    @Column(name = "speed")
    private Integer speed;

    @Comment("Measured in CFM")
    @Column(name = "airflow")
    private Float airflow;

    @Comment("Measured in mm/h20")
    @Column(name = "static_pressure")
    private Float staticPressure;

    @Column(name = "connector_type")
    private FanConnectorType connectorType;

    @Column(name = "voltage")
    private Integer voltage;

    @Column(name = "brand", length = 100)
    private String brand;
}

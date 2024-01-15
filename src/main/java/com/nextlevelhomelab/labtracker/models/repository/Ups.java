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
public class Ups extends InventoryItem {

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "watt_capacity")
    private Integer wattCapacity;

    @Column(name = "voltage")
    private Integer voltage;

    @Comment("The NEMA configuration name for the plug coming from the unit")
    @Column(name = "plug_type", columnDefinition = "character varying(10) default '5-15P'")
    private String plugType;

    @Comment("The NEMA configuration name for the ports on the rear of the unit")
    @Column(name = "port_type", columnDefinition = "character varying(10) default '5-15R'")
    private String portType;

    @Comment("The number of available ports on the rear of the UPS you can plug into")
    @Column(name = "num_ports")
    private Integer numPorts;

    @Comment("Measured in rack units")
    @Column(name = "size")
    private Integer size;
}

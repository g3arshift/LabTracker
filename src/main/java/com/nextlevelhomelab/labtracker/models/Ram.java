package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ram extends InventoryItem {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "generation", length = 6)
    private String generation;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "buffered")
    private Boolean buffered;

    @Column(name = "ecc")
    private Boolean ecc;

    @Column(name = "num_sticks")
    private Integer numSticks;
}

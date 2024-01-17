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
@Table(name = "ram")
public class Ram extends InventoryItem {

    public Ram() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "generation")
    private RamGeneration generation;

    @Column(name = "capacity")
    private Integer capacity;

    @Comment("Measured in Mhz")
    @Column(name = "speed")
    private Integer speed;

    @Column(name = "ram_type", length = 10)
    private RamType ramType;

    @Column(name = "buffered")
    private Boolean buffered;

    @Column(name = "ecc")
    private Boolean ecc;

    @Comment("RAM is done in kits, so this is the number of sticks in this kit")
    @Column(name = "num_sticks")
    private Integer numSticks;
}

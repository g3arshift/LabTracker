package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.IOException;

@Entity
public class Ram extends InventoryItem {
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

    public Ram() throws IOException {
    }
}

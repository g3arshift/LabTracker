package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;

@Getter
@Setter
@Entity
@Table(name = "motherboard")
public class Motherboard extends InventoryItem {

    public Motherboard() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "cpu_brand")
    private CpuBrand cpuBrand;

    @Column(name = "chipset", length = 30)
    private String chipset;

    @Column(name = "socket", length = 10)
    private String socket;

    @Column(name = "socket_count")
    private Integer socketCount;

    @Column(name = "memory_channel_count")
    private Integer memoryChannelCount;

    @Column(name = "memory_slot_count")
    private Integer memorySlotCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "form_factor")
    private MotherboardFormFactor motherboardFormFactor;
}

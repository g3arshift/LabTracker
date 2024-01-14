package com.nextlevelhomelab.labtracker.models.repository;

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
public class Motherboard extends InventoryItem{

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

    @Column(name = "socketCount")
    private Integer socketCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "form_factor")
    private MotherboardFormFactor motherboardFormFactor;
}

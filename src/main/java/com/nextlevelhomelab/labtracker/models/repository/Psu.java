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
@Table(name = "psu")
public class Psu extends InventoryItem {

    public Psu() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "wattage")
    private Integer wattage;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "form_factor")
    private PsuFormFactor formFactor;

    @Column(name = "efficiency")
    private PsuEfficiencyType efficiency;
}

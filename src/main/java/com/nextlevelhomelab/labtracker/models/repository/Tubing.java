package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tubing")
public class Tubing extends InventoryItem {

    public Tubing() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Comment("Represented in InnerDiameter / OuterDiameter")
    @Column(name = "size", length = 30)
    private String size;

    @Column(name = "material", length = 30)
    private String material;

    @ManyToMany
    @JoinTable(name = "tubing_customwaterloop", joinColumns = {@JoinColumn(name = "tubing_id")}, inverseJoinColumns = {@JoinColumn(name = "customwaterloop_id")})
    private Set<CustomWaterLoop> customWaterLoops;
}

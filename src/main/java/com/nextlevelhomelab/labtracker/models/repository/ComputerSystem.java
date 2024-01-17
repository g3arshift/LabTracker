package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "computer_system")
public class ComputerSystem extends InventoryItem {

    public ComputerSystem() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "computer_system_type")
    private ComputerSystemType computerSystemType;

    @OneToMany(mappedBy = "computerSystem", orphanRemoval = true)
    private Set<InventoryItem> computerSystemComponents = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "computer_system_extra_part", joinColumns = {@JoinColumn(name = "system_id")}, inverseJoinColumns = {@JoinColumn(name = "inventory_item_id")})
    private Set<InventoryItem> extraParts;

    @OneToMany(mappedBy = "computerSystem", orphanRemoval = true)
    private Set<VirtualSystem> virtualSystems = new LinkedHashSet<>();

    @Column(name = "whitebox")
    private Boolean whitebox;
}

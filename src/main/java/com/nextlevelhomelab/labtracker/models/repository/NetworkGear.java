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
@Table(name = "network_gear")
public class NetworkGear extends InventoryItem {

    public NetworkGear() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "network_gear_type")
    private NetworkGearType networkGearType;

    @Column(name = "management_ip_address", length = 128)
    private String managementIpAddress;

    @OneToMany(mappedBy = "networkGear", orphanRemoval = true)
    private Set<NetworkGearPort> networkGearPorts = new LinkedHashSet<>();
}

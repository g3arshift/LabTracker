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
@Table(name = "storage")
public class Storage extends InventoryItem {

    public Storage() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "connector")
    private StorageInterfaceType storageInterfaceType;
}

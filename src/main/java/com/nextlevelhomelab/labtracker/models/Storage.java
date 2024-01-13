package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Storage extends InventoryItem{

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "connector", length = 15)
    private StorageInterfaceType storageInterfaceType;
}

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
public class Cpu extends InventoryItem{

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Column(name = "brand", length = 25)
    private CpuBrand brand;

    @Column(name = "base_clock")
    private Float baseClock;

    @Column(name = "boost_clock")
    private Float boostClock;

    /**
     * This is the physical core count of the CPU, but if eCoreCount != 0 then this represents P-Cores.
     */
    @Column(name = "core_count")
    private Integer coreCount;

    @Column(name = "thread_count")
    private Integer threadCount;

    @Column(name = "e_core_count")
    private Integer eCoreCount;

    @Column(name = "cache")
    private Float cache;
}

package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PcieCard extends InventoryItem {

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @Comment("Measured in the number of lanes it uses electrically. So an x8 card would appear here as 8.")
    @Column(name = "pcie_slot_size")
    private PcieSlotSize pcieSlotSize;

    @Comment("The number of case slots the card occupies ")
    @Column(name = "num_case_slots")
    private Integer numCaseSlots;
}

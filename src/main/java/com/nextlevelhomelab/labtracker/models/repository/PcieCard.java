package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.IOException;

@Getter
@Setter
@Entity
@Table(name = "pcie_card")
public class PcieCard extends InventoryItem {

    public PcieCard() throws IOException {
    }

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

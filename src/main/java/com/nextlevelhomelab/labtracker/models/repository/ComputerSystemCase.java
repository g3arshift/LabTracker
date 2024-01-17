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
@Table(name = "computer_system_case")
public class ComputerSystemCase extends InventoryItem {

    public ComputerSystemCase() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private InventoryItem inventoryItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "style")
    private CaseStyle caseStyle;

    @Comment("Measured in rack units")
    @Column(name = "size")
    private Integer size;

    @Column(name = "num_three_half_slots")
    private Integer numThreeHalfSlots;

    @Column(name = "num_two_half_slots")
    private Integer numTwoHalfSlots;

    @Column(name = "rackmount")
    private Boolean rackmount;
}

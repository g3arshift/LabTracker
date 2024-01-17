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
@Table(name = "virtual_machine")
public class VirtualMachine extends VirtualSystem {

    public VirtualMachine() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private VirtualSystem virtualSystem;

    @Comment("Amount of RAM allocated to VM, measured in MB")
    @Column(name = "ram")
    private Integer ram;

    @Column(name = "core_count")
    private Integer coreCount;
}

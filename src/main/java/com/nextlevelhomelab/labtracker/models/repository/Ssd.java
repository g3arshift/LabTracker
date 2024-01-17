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
@Table(name = "ssd")
public class Ssd extends Storage {

    public Ssd() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private Storage storage;

    @Comment("Measured in gigabytes")
    @Column(name = "endurance")
    private Integer endurance;

    @Column(name = "drive_writes_per_day")
    private Integer driveWritesPerDay;
}

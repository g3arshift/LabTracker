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
@Table(name ="hdd")
        public class Hdd extends Storage {

    public Hdd() throws IOException {
    }

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private Storage storage;

    @Column(name = "workload_limit_rating")
    private Integer workloadLimitRating;

    @Comment("Measured in RPM")
    @Column(name = "speed")
    private Integer speed;

    @Column(name = "cache")
    private Float cache;
}

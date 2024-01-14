package com.nextlevelhomelab.labtracker.models.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class Hdd extends Storage{

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
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

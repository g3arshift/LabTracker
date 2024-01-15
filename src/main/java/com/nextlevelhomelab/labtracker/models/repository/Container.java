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
public class Container extends VirtualSystem {

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private VirtualSystem virtualSystem;

    @Comment("The port of the host machine that the container communicates on")
    @Column(name = "host_port")
    private Integer hostPort;

    @Comment("The port of the container that it internally communicates on")
    @Column(name = "container_port")
    private Integer containerPort;
}

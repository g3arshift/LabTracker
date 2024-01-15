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
public class NetworkGearPort {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private NetworkGear networkGear;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "port_type")
    private NetworkPortType portType;

    @Comment("The physical number of the port on the device")
    @Column(name = "port_number")
    private Integer portNumber;

    @Column(name = "ip_address", length = 15)
    private String ipAddress;

    @Comment("Denotes if a port is a virtual port or not")
    @Column(name = "virtual")
    private Boolean virtual;
}

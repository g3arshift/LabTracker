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
public class WaterFitting extends CustomWaterLoop{

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private CustomWaterLoop customWaterLoop;

    @Comment("Represented in InnerDiameter / OuterDiameter")
    @Column(name = "size", length = 30)
    private String size;

    @Column(name = "brand")
    private String brand;

}

package com.nextlevelhomelab.labtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    /**
     * The base image of an inventory item that appears
     */
    //TODO: Set default to a default image
    @Transient
    private BufferedImage baseImage;

    /**
     * The optional gallery of an inventory item that does NOT contain the base image.
     */
    @Transient
    private List<BufferedImage> gallery;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "location_id")
    private InventoryItem location;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "buy_price", precision = 20, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "sell_price", precision = 20, scale = 2)
    private BigDecimal sellPrice;

    @Column(name = "item_url", length = 2048)
    private String itemUrl;

    @Lob
    @Column(name = "notes", columnDefinition = "CHARACTER LARGE OBJECT")
    private Clob notes;

    @Column(name = "user_item", nullable = false)
    private Boolean userItem = false;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "last_updated_by", nullable = false)
    private User lastUpdatedBy;
}

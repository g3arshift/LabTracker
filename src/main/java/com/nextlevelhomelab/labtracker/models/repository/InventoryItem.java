package com.nextlevelhomelab.labtracker.models.repository;

import com.nextlevelhomelab.labtracker.config.LabTrackerProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InventoryItem {

    public InventoryItem() throws IOException {
        //Load the base image for a file, or if not found, load the default.
        try {
            File imageFile = new File(String.format("%s/%s/%s_image.png", labTrackerProperties.getImageDirectory(), id, name));
            if (imageFile.exists()) {
                baseImage = ImageIO.read(imageFile);
            } else
                baseImage = labTrackerProperties.getDefaultImage();
        } catch (IOException e) {
            throw new IOException(e);
        }

        //Load all gallery images
        //Get list of files for all files in a given directory and make sure they are regular files.
        try (Stream<Path> paths = Files.walk(Paths.get(String.format("%s/%s/%s/gallery", labTrackerProperties.getImageDirectory(), id, name)), 1)) {
            List<File> filesInFolder = paths
                    .map(Path::toFile)
                    .toList();

            //Make sure our files are an accepted image format, and load them into the gallery.
            for(File f : filesInFolder) {
                if(labTrackerProperties.getAcceptedImageTypes().contains(Files.probeContentType(f.toPath()))) {
                    gallery.add(ImageIO.read(f));
                }
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Transient
    private LabTrackerProperties labTrackerProperties;

    /**
     * The base image of an inventory item that appears
     */
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

    @Comment("A link to where an item was purchased, or can be purchased")
    @Column(name = "item_url", length = 2048)
    private String itemUrl;

    @Lob
    @Column(name = "notes", columnDefinition = "CHARACTER LARGE OBJECT")
    private Clob notes;

    @Column(name = "user_item", nullable = false)
    private Boolean userItem = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "status", nullable = false)
    private InventoryItemStatus status;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "last_updated_by", nullable = false)
    private User lastUpdatedBy;

    /**
     * The required permission level to EDIT this object.
     */
    @Column(name = "permission_level_required", nullable = false)
    private PermissionLevel permissionLevelRequired;
}

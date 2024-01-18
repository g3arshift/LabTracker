package com.nextlevelhomelab.labtracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@ConfigurationProperties("labtracker.properties")
public class LabTrackerProperties {

    public LabTrackerProperties() {
        try {
            File defaultImageFile = new File("./images/default/inventoryitem.png");
            if (defaultImageFile.exists()) {
                defaultImage = ImageIO.read(defaultImageFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ACCEPTED_IMAGE_TYPES = new ArrayList<>();

        ACCEPTED_IMAGE_TYPES.add("image/avif");
        ACCEPTED_IMAGE_TYPES.add("image/jpeg");
        ACCEPTED_IMAGE_TYPES.add("image/png");
        ACCEPTED_IMAGE_TYPES.add("image/webp");
    }

    @Setter
    private String databaseDirectory = "./data";

    @Setter
    private String imageDirectory = "./images";

    @Setter
    private BufferedImage defaultImage;

    private final List<String> ACCEPTED_IMAGE_TYPES;

}

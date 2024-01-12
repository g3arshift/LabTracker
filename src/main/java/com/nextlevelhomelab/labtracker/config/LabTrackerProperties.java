package com.nextlevelhomelab.labtracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties("labtracker.properties")
public class LabTrackerProperties {

    public LabTrackerProperties() {
        try {
            defaultImage = ImageIO.read(new File("./images/default/inventoryitem.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        acceptedImageTypes = new ArrayList<>();

        acceptedImageTypes.add("image/avif");
        acceptedImageTypes.add("image/jpeg");
        acceptedImageTypes.add("image/png");
        acceptedImageTypes.add("image/webp");
    }

    private String databaseDirectory = "./data";

    private String imageDirectory = "./images";

    private BufferedImage defaultImage;

    private List<String> acceptedImageTypes;
}

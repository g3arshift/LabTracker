package com.nextlevelhomelab.labtracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    }

    private String databaseDirectory = "./data";

    private String imageDirectory = "./images";

    private BufferedImage defaultImage;
}

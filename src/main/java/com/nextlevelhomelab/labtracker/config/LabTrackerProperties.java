package com.nextlevelhomelab.labtracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("labtracker.properties")
public class LabTrackerProperties {

    private String databaseDirectory = "./data";

    private String imageDirectory = "./images";
}

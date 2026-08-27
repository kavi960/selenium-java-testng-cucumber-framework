package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private static final String CONFIG_PATH =
            "src/test/resources/config/config.properties";

    public static void loadProperties() {

        properties = new Properties();

        try (FileInputStream fis =
                     new FileInputStream(CONFIG_PATH)) {

            properties.load(fis);

            System.out.println("Config file loaded successfully");

        } catch (FileNotFoundException e) {

            throw new RuntimeException(
                    "Configuration file not found at "
                            + CONFIG_PATH, e);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read configuration file", e);
        }
    }

    public static String getProperty(String key) {

        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key);
    }
}
package org.example;

import java.io.InputStream;
import java.util.Properties;
;

public class configuration {

    private Properties properties;

    public configuration() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config.properties: " + e.getMessage());
        }
    }

    public String getWebsiteUrl() {
        return properties.getProperty("Amazon");
    }
    public String getUserName() {
        return properties.getProperty("username");
    }
    public String getPassWord() {
        return properties.getProperty("password");

    }
}


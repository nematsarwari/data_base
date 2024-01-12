package com.solvd.laba.configuration;

import java.io.InputStream;
import java.util.Properties;

public enum Configuration {
    DRIVER("driver"),
    URL("url"),
    USER("user"),
    PASSWORD("password"),
    POOL_SIZE("poolSize"),
    IMPL("impl");

    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            // load properties from class path
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String key;

    Configuration(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return properties.getProperty(key);
    }
}

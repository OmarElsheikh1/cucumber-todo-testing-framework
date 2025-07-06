package com.qacart.todo.utils;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class EnvUtils {

    public Properties properties;
    public static EnvUtils envUtil;

    /**
     * Private constructor to initialize the environment properties based on the system property "env".
     * The properties are loaded from different files based on the environment.
     *
     * @throws IOException if there is an error reading the properties file
     */
    private EnvUtils() throws IOException {
        // Private constructor to prevent instantiation, as we're using a Singleton pattern
        String env = System.getProperty("env", "STAGING");
        switch (env) {
            case "PRODUCTION" -> {
                properties = ConfigUtil.readConfig("src/test/resources/properties/production.properties");
            }
            case "STAGING" -> {
                properties = ConfigUtil.readConfig("src/test/resources/properties/staging.properties");
            }
            case "LOCAL" -> {
                properties = ConfigUtil.readConfig("src/test/resources/properties/local.properties");
            }
            default -> {
                throw new RuntimeException("Environment isn't supported: " + env);
            }
        }
    }


    /**
     * Static method to get the singleton instance of EnvUtils.
     * This method initializes the instance if it is not already created.
     *
     * @return the singleton instance of EnvUtils
     * @throws IOException if there is an error reading the properties file
     */
    public static EnvUtils getInstance() throws IOException {
        envUtil = new EnvUtils();
        return envUtil;
    }

    public String getUrl() {
        return properties.get("URL").toString();
    }

    public String getEmail() {
        return properties.get("EMAIL").toString();
    }

    public String getPassword() {
        return properties.get("PASSWORD").toString();
    }
}
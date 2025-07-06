package com.qacart.todo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration files.
 * Loads key-value pairs from a properties file.
 */

public class ConfigUtil {

    /**
     * Reads a configuration file from the given file path.
     * Loads all key-value pairs into a {@link java.util.Properties} object.
     *
     * @param filePath the absolute or relative path to the .properties file
     * @return a Properties object containing the configuration data
     * @throws IOException if the file does not exist or cannot be read
     */

    public static Properties readConfig(String filePath) throws IOException {

        // Create a File object for the given path
        File file = new File(filePath);

        // Open a stream to read from the file
        FileInputStream fileInputStream = new FileInputStream(file);

        // Create a Properties object and load data from the file stream
        Properties properties = new Properties();
        properties.load(fileInputStream);

        // Close the file input stream to release resources
        fileInputStream.close();

        // Return the loaded properties
        return properties;
    }
}
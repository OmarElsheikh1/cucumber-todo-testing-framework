package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.time.Duration;

/**
 * Factory class responsible for creating and managing the WebDriver instance.
 * Currently, it supports ChromeDriver with default configuration (maximized window and implicit wait).
 * It Can be extended to support multiple browsers or advanced configurations.
 */


public class DriverFactory {

    // Holds a single WebDriver instance for use throughout the test session.
    // Declared as private to restrict direct access and ensure controlled initialization.
    // Using ThreadLocal to ensure that each thread has its own instance of WebDriver.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeWebDriver() {

        WebDriver driver;

        // The browser type can be set via system properties, defaulting to "chrome" if not specified.
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
//            I've commented out Safari as it requires macOS'
//            case "safari" -> {
//                driver = new SafariDriver();
//            }
            default -> {
                throw new RuntimeException("Browser not supported: " + browser);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Set the created WebDriver instance to the ThreadLocal variable.
        DriverFactory.driver.set(driver);

        return driver;
    }

    // This method returns the WebDriver instance.
    public static WebDriver getDriver() {
        // Used .get() method to retrieve the WebDriver instance from the ThreadLocal variable.
        return driver.get();
    }
}
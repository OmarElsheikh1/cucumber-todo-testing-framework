package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;

/**
 * Base class for all page objects.
 * Provides shared access to the WebDriver instance.
 */

public class BasePage {

    // WebDriver instance shared across all page classes
    protected WebDriver driver;

    // Constructor to initialize the WebDriver instance
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void load(String url) {
        // Method to load a specific URL in the browser
        driver.get(url);
    }
}
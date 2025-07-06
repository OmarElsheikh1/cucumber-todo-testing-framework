package com.qacart.todo.hooks;

import com.qacart.todo.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // WebDriver instance to interact with the browser
    WebDriver driver;

    @Before
    public void setup() {

        // Initialize the WebDriver using the DriverFactory
        driver = DriverFactory.initializeWebDriver();
    }

    @After
    public void tearDown() {

        // Close the browser and quit the WebDriver instance
        driver.quit();
    }
}
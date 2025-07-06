package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    // Initializes the LoginPage by passing the WebDriver to the BasePage constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locating elements on the login page
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By submitButton = By.id("submit");


    public void login(String email, String password) {
        // Method to perform login by filling in the email and password fields and clicking the submit button
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
package com.qacart.todo.steps;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class UserSteps {

    // WebDriver instance to interact with the browser
    WebDriver driver;

    @Given("User is at the login page")
    public void userIsAtTheLoginPage() throws IOException {

        // Initialize the WebDriver using the DriverFactory
        driver = DriverFactory.getDriver();

        // Navigate to the login page of the application
        new LoginPage(driver).load(EnvUtils.getInstance().getUrl() + "/login");
    }

    @When("User fill the email and password and login")
    public void userFillTheEmailAndPassword() throws IOException {

        // Log in to the application by using the LoginPage class
        new LoginPage(driver).login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }

    @Then("Welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed() {

        // Verify that the welcome message is displayed after login
        boolean isWelcomeDisplayed = new TodoPage(driver).isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed, "Welcome message is not displayed");
    }
}
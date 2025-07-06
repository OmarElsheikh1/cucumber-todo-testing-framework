package com.qacart.todo.steps;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

/**
 * UserSteps class contains step definitions for user-related actions in the Cucumber tests.
 * It includes methods for navigating to the login page, logging in, and verifying the welcome message.
 */

public class TodoSteps {

    // WebDriver instance to interact with the browser
    WebDriver driver;

    @Given("User is in the todos page")
    public void userIsAtTheTodoPage() throws IOException {

        // Initialize the WebDriver using the DriverFactory, initializeDriver method creates a ChromeDriver instance/Object
        driver = DriverFactory.getDriver();

        // Create an instance of the LoginPage class to interact with the login page
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to the login page of the application
        loginPage.load(EnvUtils.getInstance().getUrl() + "/login");
        // Log in to the application by using the LoginPage class
        loginPage.login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }

    @When("User adds a new todo")
    public void userAddsANewTodo() {
        // Click the plus button to add a new todo
        new TodoPage(driver).clickPlusButton();
        // Add a new todo item by using the NewTodoPage class
        new NewTodoPage(driver).addNewTodo("Learn Cucumber 1st");
    }

    @Then("Todo should be added correctly")
    public void todoShouldBeAddedCorrectly() {
        // Verify that the todo item was added
        String text = new TodoPage(driver).getLastTodoText();
        Assert.assertEquals(text, "Learn Cucumber 1st");
//        driver.quit();
    }
}
package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage {

    // Initializes the TodoPage by passing the WebDriver to the BasePage constructor
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    // Locating welcome message element on the Todo page
    private final By welcomeMessage = By.cssSelector("h2[data-testid=welcome]");
    // Locating the add todo button
    private final By plusButton = By.cssSelector("[data-testid = \"add\"]");
    // Locating the todo items
    private final By todoItems = By.cssSelector("[data-testid=\"todo-item\"]");

    public boolean isWelcomeMessageDisplayed() {
        // Method to check if the welcome message is displayed
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void clickPlusButton() {
        // Method to click the plus button to add a new todo item
        driver.findElement(plusButton).click();
    }

    public String getLastTodoText() {
        // Method to check if a specific todo item is displayed
        return driver.findElements(todoItems).getFirst().getText();
    }
}
package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage extends BasePage {

    // Initializes the NewTodoPage by passing the WebDriver to the BasePage constructor
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    // Locating the input field for a new todo item
    private final By newTodoInputField = By.cssSelector("input[data-testid=\"new-todo\"]");
    // Locating the button to create a new todo item
    private final By CreateNewTodoButton = By.cssSelector("button[data-testid=\"submit-newTask\"]");

    public void addNewTodo(String todoText) {
        // Method to add a new todo item by entering text and clicking the create button
        driver.findElement(newTodoInputField).sendKeys(todoText);
        driver.findElement(CreateNewTodoButton).click();
    }
}
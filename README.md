# 🥒 Cucumber Todo Testing Framework

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://docs.oracle.com/en/java/javase/21/)
[![Selenium](https://img.shields.io/badge/Selenium-4.0-green?logo=selenium)](https://www.selenium.dev/documentation/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen?logo=cucumber)](https://cucumber.io/docs)
[![TestNG](https://img.shields.io/badge/TestNG-Testing-red)](https://testng.org/)

A robust UI automation framework for the [QACart Todo App](https://todo.qacart.com) using Java, Selenium WebDriver, Cucumber, and TestNG. Follows the Page Object Model (POM), supports multi-browser execution, and is optimized for maintainability and CI/CD pipelines.

---

## ✨ Key Features

- ✅ **BDD Approach**: Gherkin scenarios for business-readable tests
- 🌐 **Cross-Browser**: Chrome/Firefox/Edge support
- ⚙️ **Environment Configs**: Local/Staging/Production setups
- 🧵 **Thread-Safe**: Parallel execution ready
- 📊 **CI/CD**: GitHub Actions integration
- 📄 **Logging**: Detailed execution logs

---

## 🧩 Project Structure

```bash
📁 src/test
├── 📁 java
│   └── 📁 com.qacart.todo
│       ├── 📁 base        # Core WebDriver setup
│       ├── 📁 factory     # Browser instantiation
│       ├── 📁 hooks       # Test lifecycle management
│       ├── 📁 pages       # POM classes (LoginPage, TodoPage)
│       ├── 📁 runners     # TestNG cucumber runners
│       ├── 📁 steps       # Gherkin step implementations
│       └── 📁 utils       # Config helpers
└── 📁 resources
    ├── 📁 features       # Business scenarios
    └── 📁 properties     # Environment configs
```

## ⚡ Quick Start

### ✅ Prerequisites

- Java 21+
- Maven 3.8+

### ▶️ Run Tests
```bash
# Default: Chrome + STAGING
mvn clean test

# Custom environment and browser
mvn test -Dbrowser=firefox -Denv=PRODUCTION
```

---

## 🔧 Configuration

### 1. Environment Setup

Edit properties in:
```text
src/test/resources/properties/
├── local.properties
├── staging.properties
└── production.properties
```

### 2. Browser Management

Supported browsers via `-Dbrowser` flag:
```bash
chrome | firefox | edge 
```

---

## 🧪 Sample Test
Feature File `(user.feature)`:

```gherkin
Feature: User Features

  Scenario: User should be able to login
    Given User is at the login page
    When User fill the email and password and login
    Then Welcome message should be displayed
```

Step Definition:

```  java
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
```

---

## 🚦 CI/CD Pipeline
Runs on push to `master` branch (`.github/workflows/test.yml`):

```yaml
on:
  push:
    branches: ["main"]

jobs:
  test:
    runs-on: windows-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
      - uses: browser-actions/setup-chrome@latest
      - run: mvn clean test
```

---

## 📈 Reporting & Logging

- HTML Reports: target/cucumber-reports/
- Logs: logs/ via Log4j2

``` properties
# Sample log output
[DEBUG] Initializing ChromeDriver...
[INFO] Loading PRODUCTION environment
```

---

## 💡 Best Practices

1. Page Object Model (POM): Each page = single class
2. Environment abstraction via EnvUtils
3. Reusable steps: Modular, easy to maintain
4. Parallel execution with ThreadLocal WebDriver

--- 

## 📜 License
Distributed under the MIT License. See the LICENSE file for more details.

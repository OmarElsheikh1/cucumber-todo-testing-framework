package com.qacart.todo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/*
 * This class serves as a Cucumber test runner for TestNG.
 * It uses the CucumberOptions annotation to specify the location of feature files and step definitions.
 * The AbstractTestNGCucumberTests class provides the necessary integration with TestNG.
 */


@CucumberOptions(
        // Specify the path to the feature files, we need to put the path from content root
        features = "src/test/resources/features",
        // Specify the path to the step definitions; Cucumber expects a Java package name, not a folder path
        glue = "com/qacart/todo"
)
public class RunnerTest extends AbstractTestNGCucumberTests {

    // This class is intentionally left empty. It serves as a runner for Cucumber tests.
    // The @CucumberOptions annotation specifies the location of feature files and step definitions.
    // The AbstractTestNGCucumberTests class provides the necessary integration with TestNG.

    // The scenarios method is overridden to enable parallel execution of tests.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
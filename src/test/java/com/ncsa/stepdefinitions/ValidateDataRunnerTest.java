package com.ncsa.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources/EndtoEndFunctionalTests.feature"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue={"com.ncsa.stepdefinitions.datatests"},
        monochrome = true
        )
public class ValidateDataRunnerTest {
}

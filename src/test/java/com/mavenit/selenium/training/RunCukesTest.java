package com.mavenit.selenium.training;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        tags= "@regression",
        strict = true, plugin = "json:target/cucumbner.json",dryRun = true)
public class RunCukesTest {
}

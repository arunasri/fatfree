package com.cucumber.runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        dryRun = false,
        format = "pretty",
        glue = "com.cucumber.steps",
        plugin = { "pretty", "html:target/cucumber" },
        features = "classpath:features"
)
public class RunnerTest {}

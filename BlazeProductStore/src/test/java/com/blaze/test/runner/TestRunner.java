package com.blaze.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber class to read the feature file to be executed
@CucumberOptions(tags = "", features = "src/test/java/features/SignUpAndPurchase.feature", glue = "com.blaze.test.steps")

public class TestRunner extends AbstractTestNGCucumberTests  {
	 // To be added for extra features
}

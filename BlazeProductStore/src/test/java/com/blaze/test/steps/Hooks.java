package com.blaze.test.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.blaze.setup.Setup;
import com.blaze.setup.Utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;

/* 
 * Cucumber framework reads Hooks class to setup and tear down the environment
 * before and after each scenario. Define the action in Before and After code block.
 * Date created : 31-01-2021
 */ 
public class Hooks extends Setup {	
	PickleStepTestStep currentStep;
	//private int counter = 0;
	public Hooks() throws IOException {
		super();
	}

	@Before
	public  void setup(Scenario scenario) throws IOException {
		//Call readExcel function and initialize driver for different browsers before execution
		initialization();
		//Create logger for result extend reports and read each scenario name
		logger = extent.createTest(scenario.getName(), "");
		testCaseName = scenario.getName();		
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		Utils.takeSnapshot(scenario.getName());
		//if (scenario.isFailed()) {
		if (!scenarioStatus) {
			//logger.log(Status.FAIL, "Test Case Is Failed");
			logger.log(Status.FAIL, scenario.getName() + " Scenario Failed");
			logger.log(Status.INFO, "<a href='"+scenario.getName() + ".png" +"'><span class='label info'>Download Snapshot</span></a>");
		}
		else {
			//logger.log(Status.PASS, "Test Case Is Passed");
			logger.log(Status.PASS, scenario.getName() + " Scenario Passed");
			logger.log(Status.INFO, "<a href='"+scenario.getName() + ".png" +"'><span class='label info'>Download Snapshot</span></a>");
		}
		driver.quit();
	}
	
	@BeforeAll
	public static void initiate() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../BlazeProductStore/src/test/java/config/config.properties");
		prop.load(fis);		
		htmlReporter = new ExtentHtmlReporter(prop.getProperty("ResultsReportPath"));
		System.out.println(prop.getProperty("ResultsReportPath"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);    	
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Owner","Anu Karthik");
		extent.setSystemInfo("Test Name","AutomationFramework");
		extent.setSystemInfo("Tools","Selenium with JAVA");
		extent.setSystemInfo("Framework Design","Maven , TestNG and Cucumber");
	}
	
	@AfterAll
	public static void turnOff() {
		extent.flush();
		driver.quit();
	}
}

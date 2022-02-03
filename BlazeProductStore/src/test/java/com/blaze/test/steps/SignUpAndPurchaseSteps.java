package com.blaze.test.steps;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.blaze.core.BusinessFunctions;
import com.blaze.core.CommonFunctions;
import com.blaze.core.CommonVariables;
import com.blaze.setup.Setup;
import com.blaze.setup.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/* SignUpAndPurchaseSteps Class is created to handle the respective feature file step functions 
 * with Given,When and Then commands
 * Date created : 31-01-2021
 */
public class SignUpAndPurchaseSteps extends Setup{
	public SignUpAndPurchaseSteps() throws IOException {
		super();
		commonVariables = new CommonVariables();
		businessFunctions = new BusinessFunctions();
		commonFunctions = new CommonFunctions();
	}
	
	@Given("User Opens Blaze Site And Click SignUp Link")
	public void userOpensBlazeSiteAndClickSignUpLink() {
		commonFunctions.clickOnElement(commonVariables.lnkHomePageSignUp);
	}
	
	@When("User Fills UserName And Password And Click On SignUp")
	public void newUserSignUpInBlaze() {
		Random random = new Random();
		testData =  Utils.getTestCaseRowData(testCaseName);
		userName = prop.getProperty("Username") + random.nextInt(1000);  
		password = prop.getProperty("Password");
		businessFunctions.signUp(userName, password);
	}
	
	@Then("NewUser Should Be Created And Login To Blaze Application")
	public void loginBlazeApplication() throws InterruptedException {
		commonFunctions.clickOnElement(commonVariables.lnkHomePageLogin);
		businessFunctions.login(userName, password);
	}
	
	@Given("User Selects Samsung Galaxy S6 From Blaze Home Screen And Add To Cart")
	public void selectMobileFromBlazeAndAddToCart() {
		businessFunctions.selectMobileAndAddToCart();
	}
	
	@When("User Opens Cart Menu And Place The Order And Purchase")
	public void userOpensCartMenuAndPlaceTheOrder() {
		testData =  Utils.getTestCaseRowData(testCaseName);		
		businessFunctions.openCartPlaceOrderAndPurchase(userName, testData.get(excelColumnMap.get("country")), 
				testData.get(excelColumnMap.get("city")), testData.get(excelColumnMap.get("creditcard")), testData.get(excelColumnMap.get("month")), testData.get(excelColumnMap.get("year")));
	}
	
	@Then("Samsung Galaxy S6 Should Be Purchased")
	public void validateNewMobilePurchased() {
		businessFunctions.validateNewMobilePurchased();
	}
	
	//Invalid User Login Starts
	@Given("User Click LogIn Link From Home Screen")
	public void clickLogInMenu() {
		commonFunctions.clickOnElement(commonVariables.lnkHomePageLogin);
		logger.log(Status.PASS, "Login Link Is Clicked");
	}
	
	@When("User Fills UserName And Password And Click On LogIn")
	public void loginBlazeApplicationInvalidUser() throws InterruptedException {
		password = prop.getProperty("Password");
		businessFunctions.loginInvalidUser(prop.getProperty("invalidUsername"), password);
	}
	
	@Then("User ShouldNot Be Able To Login And Receive Error Message")
	public void invalidUserLoginValidation() throws InterruptedException {
		businessFunctions.verifyErrorMessageAndCloseWindow();
		Assert.assertFalse(commonFunctions.isElementDisplayed(commonVariables.lblHomePageWelcomeUserMessage), "scenario failed");
	}
	//Invalid User Login Ends
}

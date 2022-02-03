package com.blaze.core;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.blaze.setup.Setup;

/* Business Class contains functions which handles with application business flow
 * Date created : 31-01-2021
 */

public class BusinessFunctions extends Setup{
	
	public BusinessFunctions() throws IOException {
		PageFactory.initElements(driver, this);		
	}
		
	/* Function Name : signUp
	 * Purpose : Sign up to application with New Username and password
	 * param : newusername, password
	 */
	public void signUp(String newUserName, String password) {
		try {
			commonFunctions.sendElementsValue(commonVariables.txtSignUpWindowUsername, newUserName);
			if(isCommonActionDone) {				
				logger.log(Status.PASS, "New Username " + newUserName + " Entered Successfully");
			}
			commonFunctions.sendElementsValue(commonVariables.txtSignUpWindowPassword, password);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "Password Entered Successfully");
			}
			commonFunctions.clickOnElement(commonVariables.btnSignUpWindowSignUp);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "SignUp Button Clicked Successfully");
			}		
			Thread.sleep(5000);
			// Validate Success Message
			String successMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			logger.log(Status.PASS, "Popup Window With Message " +successMessage+ " Is Displayed");			
		} catch (InterruptedException e) {
			logger.error("Exception while sign-up process "+e.getMessage());
		}
	}	
	
	/* Function Name : login
	 * Purpose : Login to application with  Username and password
	 * param : username, password
	 */
	public void login(String userName , String password) {
		try	{
			commonFunctions.sendElementsValue(commonVariables.txtLoginWindowUsername, userName);
			logger.log(Status.PASS, "Login Link Is Clicked");
			if(isCommonActionDone) {
				
				logger.log(Status.PASS, "Username " + userName + " Entered Successfully");
			}
			commonFunctions.sendElementsValue(commonVariables.txtLoginWindowPassword, password);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "Password Entered Successfully");
			}
			commonFunctions.clickOnElement(commonVariables.btnLoginWindowLogin);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "Login Button Clicked Successfully");
			}
			Thread.sleep(10000);
			//Validate welcome user message
			if(commonFunctions.isElementDisplayed(commonVariables.lblHomePageWelcomeUserMessage)) {
				logger.log(Status.PASS, "User Logged In Successfully. Welcome User Message Is Displayed In Home Screen");
			}
		} catch (InterruptedException e) {
			logger.error("Exception while login test "+e.getMessage());
		}
	}
	
	/* Function Name : loginInvalidUser
	 * Purpose : Function to login and validate applicationusing invalid user
	 * param : username, password
	 */
	public void loginInvalidUser(String userName , String password) {
		try 
		{
			Thread.sleep(2000);
			commonFunctions.sendElementsValue(commonVariables.txtLoginWindowUsername, userName);			
			if(isCommonActionDone) {				
				logger.log(Status.PASS, "Username " + userName + " Entered Successfully");
			}
			Thread.sleep(2000);
			commonFunctions.sendElementsValue(commonVariables.txtLoginWindowPassword, password);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "Password Entered Successfully");
			}
			commonFunctions.clickOnElement(commonVariables.btnLoginWindowLogin);
			if(isCommonActionDone) {
				logger.log(Status.PASS, "Login Button Clicked Successfully");
			}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.error("Exception while loginInvalidUser test "+e.getMessage());
		}
	}
	
	/* Function Name : verifyErrorMessageAndCloseWindow
	 * Purpose : Function to verify error message window and close
	 * param : na
	 */
	public void verifyErrorMessageAndCloseWindow() {
		try {
			//Validate "User does not accept" error message for invalid username and close popup.
			Thread.sleep(3000);
			String errorMessage = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.log(Status.FAIL, "Error Popup Window With Message " +errorMessage+ " Is Displayed.");
			scenarioStatus = false;
			
			//Click on CLOSE button
			commonFunctions.clickOnElement(commonVariables.btnLoginWindowClose);
			if(isCommonActionDone) {
				logger.log(Status.INFO, "Close Button Is Clicked");
			}
		} catch (InterruptedException e) {	
			logger.error("Exception while verifyErrorMessageAndCloseWindow test "+e.getMessage());
		}
	}
	
	//Select Mobile From Site And Add To Cart
	public void selectMobileAndAddToCart() {	
		try {
		//Select Mobile
			commonFunctions.clickOnElement(commonVariables.lnkBlazeMobileWindowMobileName);
			if(isCommonActionDone) {			
				logger.log(Status.PASS, "Samsung Galaxy S6 Mobile Is Selected");
			}
			Thread.sleep(3000);
			//Click On Add To Cart Link
			commonFunctions.clickOnElement(commonVariables.lnkBlazeMobileWindowAddToCart);
			if(isCommonActionDone) {			
				logger.log(Status.PASS, "Add To Cart Link Clicked Successfuly");
								
			}
			Thread.sleep(3000);
			//ALert window - Product Added
			driver.switchTo().alert().accept();	
			logger.log(Status.PASS, "Product Added Message Is Displayed");
		} catch (InterruptedException e) {
			logger.error("Exception while selectMobileAndAddToCart test "+e.getMessage());
		}
	}
	
	//Open Cart Menu From Home Screen, Place Order And Purchase
	public void openCartPlaceOrderAndPurchase(String userName, String country, String city, String creditCard, String month, String year) {	
		try {
		//Select Cart Menu 
		commonFunctions.clickOnElement(commonVariables.lnkBlazeHomePageCartMenu);
		if(isCommonActionDone) {			
			logger.log(Status.PASS, "User Opened The Cart Menu");
		}
		Thread.sleep(3000);
		//Click On Place Order 
		commonFunctions.clickOnElement(commonVariables.btnBlazeHomePagePlaceOrder);
		if(isCommonActionDone) {			
			logger.log(Status.PASS, "Place Order Button Is Clicked Successfuly");
		}
		Thread.sleep(3000);
		//Verify Place Order Window Is Opened. 
		if(commonFunctions.isElementDisplayed(commonVariables.lblBlazeHomePagePlaceOrder)) {
			logger.log(Status.PASS, "Place Order Window Is Opened");
		}
		//Enter all required fields and Purchase. Enter Name
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowName, userName);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "Name Entered Successfully");
		}
		Thread.sleep(3000);
		//Enter Country
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowCountry, country);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "Country Entered Successfully");
		}
		Thread.sleep(3000);
		//Enter City
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowCity, city);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "City Entered Successfully");
		}
		Thread.sleep(3000);
		//Enter Credit Card
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowCreditCard, creditCard);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "Credit Card Entered Successfully");
		}
		Thread.sleep(3000);
		//Enter Month
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowMonth, month);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "Month Entered Successfully");
		}
		Thread.sleep(3000);
		//Enter Year
		commonFunctions.sendElementsValue(commonVariables.txtPlaceOrderWindowYear, year);
		if(isCommonActionDone) {
			logger.log(Status.PASS, "Year Entered Successfully");
		}
		Thread.sleep(3000);
		//Click On Purchase Button 
		commonFunctions.clickOnElement(commonVariables.btnPlaceOrderWindowPurchase);
		if(isCommonActionDone) {			
			logger.log(Status.PASS, "Purchase Button Is Clicked Successfuly");
		}
		Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.error("Exception while openCartPlaceOrderAndPurchase test "+e.getMessage());
		}		
	}
	
	//Verify the purchase order is successful
	public void validateNewMobilePurchased() {	
		try {
		//Verify Purchase Success Thankyou Message And Click OK Button
		if(commonFunctions.isElementDisplayed(commonVariables.lblPlaceOrderWindowThankyouForPurchaseMessage)) {
			//Click on OK Button
			commonFunctions.clickOnElement(commonVariables.btnThankyouMessageWindowOK);
			if(isCommonActionDone) {			
				logger.log(Status.PASS, "Purchase Is Successfull And OK Button Is Clicked");
			}
		}
		Thread.sleep(1000);
		//driver.quit(); 
		} catch (InterruptedException e) {
			logger.error("Exception while validateNewMobilePurchased test "+e.getMessage());
		}
	}
}
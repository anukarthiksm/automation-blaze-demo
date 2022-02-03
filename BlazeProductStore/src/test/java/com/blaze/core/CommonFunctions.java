package com.blaze.core;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.blaze.setup.Setup;

/* CommonFunctions Class contains functions at unt level to deal with UI object actions
 * Date created : 31-01-2021
 */
public class CommonFunctions extends Setup{
	public CommonFunctions() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Function to click on UI element
	public void clickOnElement(WebElement webElement) {
		try {
		if(isElementDisplayed(webElement)) {
			Thread.sleep(2000);			
			webElement.click();
			isCommonActionDone = true;
		}else {
			isCommonActionDone = false;
		}
		} catch (InterruptedException e1) {
			logger.error("Error while processing the clickOnElement test "+e1.getMessage());
		}
	}
	
	// Function to type values on text fields
	public void sendElementsValue(WebElement webElement, String value) {
		if(isElementDisplayed(webElement)) {
			webElement.sendKeys(value);
			isCommonActionDone = true;
		}else {
			isCommonActionDone = false;
		}		
	}	
	
	// Function to read values from text fields
	public String getElementText(WebElement webElement) {
		if(isElementDisplayed(webElement)) {
			return webElement.getText();
		}
		return null;
	}
	
	// Function to compare two strings
	public boolean compareTextString(String expected, String actual) {
		if(actual.equals(expected)) {
			return true;
		}
		return false;
	}
	
	// Function to check whether an object is displayed or not in UI
	public boolean isElementDisplayed(WebElement webElement) {
		if(webElement.isDisplayed()) {			
			return true;
		}
		return false;
	}
}

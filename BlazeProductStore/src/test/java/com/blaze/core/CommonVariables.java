package com.blaze.core;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blaze.setup.Setup;

/* CommonVariables Class created to contain all UI object identifiers 
 * and any common variable which can be used by multiple test cases
 * Date created : 31-01-2021
 */
public class CommonVariables extends Setup{

	public CommonVariables() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//UI Objects For SignUp Screen 
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	public WebElement lnkHomePageSignUp;
	
	@FindBy(xpath = "//input[@id='sign-username']")
	public WebElement txtSignUpWindowUsername;
	
	@FindBy(xpath = "//input[@id='sign-password']")
	public WebElement txtSignUpWindowPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	public WebElement btnSignUpWindowSignUp;
	
	//UI Objects For Login Screen
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	public WebElement lnkHomePageLogin;
	
	@FindBy(xpath = "//input[@id='loginusername']")
	public WebElement txtLoginWindowUsername;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	public WebElement txtLoginWindowPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	public WebElement btnLoginWindowLogin;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]/..//button[contains(text(),'Close')]")
	public WebElement btnLoginWindowClose;
	
	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	public WebElement lblHomePageWelcomeUserMessage; 
	
	//UI Objects For Mobile Selection
	@FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
	public WebElement lnkBlazeMobileWindowMobileName;
	
	//UI Objects For Adding To Cart
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	public WebElement lnkBlazeMobileWindowAddToCart;
	
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	public WebElement lnkBlazeHomePageCartMenu;
	
	//UI Objects For Placing Order
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	public WebElement btnBlazeHomePagePlaceOrder;	
	
	@FindBy(xpath = "//h5[contains(text(),'Place order')]")
	public WebElement lblBlazeHomePagePlaceOrder;	
	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement txtPlaceOrderWindowName;
	
	@FindBy(xpath = "//input[@id='country']")
	public WebElement txtPlaceOrderWindowCountry;
	
	@FindBy(xpath = "//input[@id='city']")
	public WebElement txtPlaceOrderWindowCity;
	
	@FindBy(xpath = "//input[@id='card']")
	public WebElement txtPlaceOrderWindowCreditCard;
	
	@FindBy(xpath = "//input[@id='month']")
	public WebElement txtPlaceOrderWindowMonth;
	
	@FindBy(xpath = "//input[@id='year']")
	public WebElement txtPlaceOrderWindowYear;
	
	@FindBy(xpath = "//button[contains(text(),'Purchase')]")
	public WebElement btnPlaceOrderWindowPurchase;
	
	@FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase')]")
	public WebElement lblPlaceOrderWindowThankyouForPurchaseMessage;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement btnThankyouMessageWindowOK;		

	//Common Variables For Blaze Login Page-OLD
	@FindBy(name = "login")
	public WebElement txtLoginModelUsername;
	
	@FindBy(name = "password")
	public WebElement txtLoginModelPassword;
	
	@FindBy(name = "commit")
	public WebElement btnLoginModelSignin;
}

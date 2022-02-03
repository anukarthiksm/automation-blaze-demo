#Author: Anu Karthik
#Keywords Summary : feature file
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

Feature: Test The Blaze SignUp And Purchase Functionality With Positive And Negative Scenarios
	Scenario: SignUp With New UserName&Password And Purchase Samsung Galaxy S6
		Given User Opens Blaze Site And Click SignUp Link
		When User Fills UserName And Password And Click On SignUp
		Then NewUser Should Be Created And Login To Blaze Application		 
		Given User Selects Samsung Galaxy S6 From Blaze Home Screen And Add To Cart
		When User Opens Cart Menu And Place The Order And Purchase 
		Then Samsung Galaxy S6 Should Be Purchased
	
	Scenario: SignIn With Invalid User For Negative Test
		Given User Click LogIn Link From Home Screen
		When User Fills UserName And Password And Click On LogIn
		Then User ShouldNot Be Able To Login And Receive Error Message
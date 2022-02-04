# automation-blaze-demo
A project to automate test cases of Blaze Product Store demo application using Selenium-Cucumber-Maven-TestNG.
To execute the project, Install Java, eclipe and JAVA-HOME, MAVEN-HOME variables need to be setup in environment variables.Install testNG from eclipse market place.
After clone git project, do Maven-build on pom.xml.
testng.xml-->RunAs-->TestNG Suite. This will run the project.
# Project File Details
Cucumber feature file path --> projectdirectory\src\test\java\features\SignUpAndPurchase.feature. Feature file defines the scenarios to be executed. Scenario names are given in result extend report.
Scenario 1 (Positive) - Scenario: SignUp With New UserName&Password And Purchase Samsung Galaxy S6
Scenario 2 (Negative) - Scenario: SignIn With Invalid User For Negative Test
Scenario functiona are defined in --> projectdirectory\src\test\java\com\blaze\test\steps\SignUpAndPurchaseSteps.java. This internally calls BusinessFunctions.java and CommonFunctions.java in following path-->src\test\java\com\blaze\core\.
UI objects are added in -->src\test\java\com\blaze\core\CommonVariables.java.
Input data sheet is added in -->projectdirectory\test-data\TestData.xlsx
Cucumber hooks file in -->projectdirectory\src\test\java\com\blaze\test\steps\Hooks.java extends Setup.java, which read input excel sheet from test-data folder. Also initiates webdriver for the browser before exery scenario execution.
After each scenario execution, the driver will be closed.
After project run, first scenario will be passed and second will be failed. 
Execution result path --> projectdirectory\test-report folder - generated after every execution with detailed html result report and screenshots. In report, Scenario name is displayed as test case name.

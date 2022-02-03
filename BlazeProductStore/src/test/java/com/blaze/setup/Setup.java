package com.blaze.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.blaze.core.BusinessFunctions;
import com.blaze.core.CommonFunctions;
import com.blaze.core.CommonVariables;

/* Setup Class is created to handle the pre-requisites before starting TC execution.
 * Date created : 31-01-2021
 */ 
public class Setup {	
	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static XSSFWorkbook excelWorkbook;
	public static Sheet sheet ;
	public static String excelData[][];
	public static int rows;
	public static int columns;
	public static Map<String, Integer> excelColumnMap = new HashMap<String,Integer>();
	public static List<String> testData = new ArrayList<String>();
	public static String testCaseName;
	public static CommonFunctions commonFunctions;
	public static BusinessFunctions businessFunctions;
	public static CommonVariables commonVariables;
	public static boolean isCommonActionDone;
	public static boolean scenarioStatus;
	public String userName;
	public String password;	
	
	/* Function to read config property data
	 * param : NA
	 */
	public Setup() throws IOException {		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../BlazeProductStore/src/test/java/config/config.properties");
		prop.load(fis);		
	}
	
	/* Function to call readExcel function and initialize driver for different browsers
	 * param : NA
	 */
	public static void initialization () throws FileNotFoundException, IOException {
		try {	
			scenarioStatus = true;
			//Read input test data sheet
			excelData = Utils.getExcelData(prop.getProperty("ExcelSheetName"));
			//Read browser name passed in config properties
			browser = prop.getProperty("Browser");			
			switch (browser) {
				case "Firefox": 
					System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxWebdriverPath"));
					driver = new FirefoxDriver();
					break;
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeWebdriverPath"));
					driver = new ChromeDriver();
					break;
				default:
					System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxWebdriverPath"));
					driver = new FirefoxDriver();
					break;
			}			
			Thread.sleep(30000);				
			//Open application URL in browser and maximize the window
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		} catch (InterruptedException e) {
			logger.error("Exception while initializing the driver "+e.getMessage());
		}
	}
}
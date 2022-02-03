package com.blaze.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/* Utils Class is created to handle re-usable utility functions 
 * to be used across multiple test cases
 * Date created : 31-01-2021
 */

public class Utils extends Setup{
	
	public Utils() throws IOException {
		super();
	}
	
	/* Function to get UI screenshot to be used in test cases
	 * param : screenshot name
	 */
	public static void takeSnapshot(String name) throws IOException {		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(prop.getProperty("SnapchatAndVideosPath")+ name + ".png"));		
	}
	
	/* Function to read excel for input test data
	 * param : inputsheet name
	 */
	public static String[][] getExcelData(String sheetName) throws IOException ,FileNotFoundException {    	
    	File excelFile = new File(prop.getProperty("ExcelPath"));
		FileInputStream excle = new FileInputStream(excelFile);
		excelWorkbook = new XSSFWorkbook(excle);
		sheet = excelWorkbook.getSheet(sheetName);
		rows = sheet.getPhysicalNumberOfRows();
		columns = sheet.getRow(0).getLastCellNum();
		System.out.println("Reading rows and columns from test data sheet");
		String data[][] = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if( sheet.getRow(i).getCell(j).toString()!= null) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
		}	
		//System.out.println("Excel data is :" + data);
		for (int i = 0; i < columns; i++) {
			if(sheet.getRow(0).getCell(i).toString()!=null) {
				excelColumnMap.put(sheet.getRow(0).getCell(i).toString(), i);
			}
		}
		return data;
    }
  
	/* Function to get the data from excel row
	 * param : test case/scenario name
	 */
	public static List<String> getTestCaseRowData(String testCaseName) {
	   List<String> excellRowdata = new ArrayList<String>();
	   for (int row = 0; row < excelData.length; row++)	{
			 if(testCaseName.equals(excelData[row][0].trim())) {
				  for (int col = 0; col < columns; col++){
					  excellRowdata.add(excelData[row][col]);
				  }
				  break;
			 }
		}
	   return excellRowdata;
   	}
}
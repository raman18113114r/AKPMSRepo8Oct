package com.testwebsite.scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class QAManager_General_WC_Script extends NBaseClass
{
	
	ExtentTest QAManagerTest;
	/*
	// DataProvider to fetch data from Excel sheet
   // @DataProvider(name = "qaManagerData")
    //public Object[][] getQAManagerData() throws IOException, InvalidFormatException {
       // String filePath = "C:\\Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Data.xlsx";  // Update with the correct path
       // String sheetName = "Sheet1";  // Update with the actual sheet name

        // Assuming you have a method in NBaseClass to read data from Excel
       // Object[][] data = readDataForQAManager(filePath, sheetName);
      //  return data;
    }

  

 // Test method without parameters but using Excel data for further actions
    @Test(priority = 1, dataProvider = "qaManagerData")
		public void worksheetWithoutParameters(String department, String subDepartment, String productivityType, 
				String billingMonth, String billingYear, String postedDateFrom, 
				String postedDateTo, String generalPercentage) throws InterruptedException 
	{
    	qamanagerobject_general.createWorkSheetWithoutParameters(department, subDepartment, productivityType,billingMonth, billingYear, postedDateFrom, postedDateTo, generalPercentage);
	}
    */
    @Test(priority = 1)
	public void worksheetWithParameters() throws InterruptedException 
{
    	qamanagerobject_general.createWorkSheetWithParameters();
}

}

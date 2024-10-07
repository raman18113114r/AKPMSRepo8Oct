package com.testwebsite.scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testwebsite.utilites.NBaseClass;

public class LoginProcessScript extends NBaseClass 
{

  

  /*  @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException, InvalidFormatException, InterruptedException {
        String filePath = "C:\\Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Credentials.xlsx";  // Update this path
        String sheetName = "Sheet1";  // Update with your actual sheet name
        Object[][] data = readCredentialsFromExcel(filePath, sheetName);
        return data;  
    } */

    @Test(priority = 1) //@Test(priority = 1, dataProvider = "loginCredentials")
    public void loginToAKPMS() throws InterruptedException, IOException 
    {
        
     /*   loginpagehelperobject.enterUsername("rahul.jawa@idsil.com");
        loginpagehelperobject.enterPassword("Password@123");
        loginpagehelperobject.clickLoginButton();
        loginpagehelperobject.getErrorMessage(); */
        
}
}

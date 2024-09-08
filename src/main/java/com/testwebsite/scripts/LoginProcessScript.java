package com.testwebsite.scripts;

import java.io.IOException;
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

public class LoginProcessScript extends NBaseClass {

    ExtentTest loginTest;

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException, InvalidFormatException, InterruptedException {
        String filePath = "C:\\Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Credentials.xlsx";  // Update this path
        String sheetName = "Sheet1";  // Update with your actual sheet name
        Object[][] data = readCredentialsFromExcel(filePath, sheetName);
        return data; 
    } 

    @Test(priority = 1, dataProvider = "loginCredentials")
    public void loginToAKPMS(String username, String password) throws InterruptedException, IOException {
        loginTest = extent.createTest("LOGIN PROCESS");
        SoftAssert softAssert = new SoftAssert();
        
        try {
            loginpagehelperobject.CheckLoginFunctionality();
            
            driver.navigate().refresh();
            
            // Enter username and password from data provider
            driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);  // Ensure username is being used
            driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);  // Ensure password is being used
            
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            Thread.sleep(2000); 

            String expectedURL = "https://st3.idsil.com/akpmsui/#/user/dashboard"; // Adjust this URL
            String actualURL = driver.getCurrentUrl();

            if (actualURL.equals(expectedURL)) {
                loginTest.log(Status.PASS, "Login successful");
            } else {
                // Capture the error message for invalid credentials
                String errorMessage = driver.findElement(By.xpath("//b[text()='Invalid Credentials']")).getText();
                loginTest.log(Status.FAIL, "Login failed. Error: " + errorMessage);
                softAssert.fail("Login failed with error: " + errorMessage);
            }
        } catch (Exception e) {
            loginTest.log(Status.FAIL, "Test encountered an exception: " + e.getMessage());
            softAssert.fail("Exception occurred: " + e.getMessage());
        }

        // Perform soft assertion to continue even if this test fails
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (loginTest != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                loginTest.log(Status.FAIL, "Test Case Failed: " + result.getName());
                loginTest.log(Status.FAIL, "Reason for Failure: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                loginTest.log(Status.PASS, "Test Case Passed: " + result.getName());
            } else if (result.getStatus() == ITestResult.SKIP) {
                loginTest.log(Status.SKIP, "Test Case Skipped: " + result.getName());
            }
        }
    }
}

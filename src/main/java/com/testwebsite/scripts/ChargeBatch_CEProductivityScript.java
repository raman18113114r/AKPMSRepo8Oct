package com.testwebsite.scripts;

//Import TestNG's @Test annotation
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testwebsite.utilites.NBaseClass;

public class ChargeBatch_CEProductivityScript extends NBaseClass
{

	 ExtentTest ChargeBatch_CEProductivityTest;
	
	@Test(priority = 1)
	public void clickOnTheChargeBatchingSystem() throws InterruptedException 
	{
		
		ChargeBatch_CEProductivityTest = extent.createTest("ChargeBatch CE Productivity Process");

        try
        {
            // Perform the login functionality
        	chargebatchsystemobject.ClickOnChargeBatchingSystem();

            // Expected and actual URLs
            String expectedChargeBatchURL = "https://st3.idsil.com/akpmsui/#/user/chargebatch";
            String actualChargeBatchURL = driver.getCurrentUrl();

            // Check and log the result
            
            Assert.assertEquals(actualChargeBatchURL, expectedChargeBatchURL);
           
        } 
        catch (Exception e) 
        {
            // Log the exception in case of a failure
        	ChargeBatch_CEProductivityTest.log(Status.FAIL, "Test encountered an exception: " + e.getMessage());
            throw e; // Re-throw the exception to ensure the test is marked as failed
        }
    }

   	@Test(priority = 2)
	public void addBatchFunctionality() throws InterruptedException 
	{
   		try
        {
		chargebatchsystemobject.addAndVerfiyBatch();
		String oldTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		String newTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		
		Assert.assertEquals(oldTicketID, newTicketID);
		
        }
		catch (Exception e) 
        {
            // Log the exception in case of a failure
        	ChargeBatch_CEProductivityTest.log(Status.FAIL, "Test encountered an exception: " + e.getMessage());
            throw e; // Re-throw the exception to ensure the test is marked as failed
        }
        
		
	}
	
	@Test(priority = 3)
	
	public void addAndVerifyReceiveBatchFunctionality() throws InterruptedException 
	{
		chargebatchsystemobject.addAndVerifyReceiveBatch();
	}
	
	
	@Test(priority = 4)
	public void chargeBatch_CEProductivity () throws InterruptedException 
	{
		
		chargebatchsystemobject.chargeBatch_CEProductivity(); 
		String ActualticketAlreadyPostedCE =	"Ticket has already been posted for CE Productivity type";
		String ExpectedticketAlreadyPostedCE= driver.findElement(By.xpath("//p[text()='Ticket has already been posted for CE Productivity type']")).getText();
		Assert.assertEquals(ActualticketAlreadyPostedCE, ExpectedticketAlreadyPostedCE)	;
		System.out.println("This is the error message after posting ticket id = " +ExpectedticketAlreadyPostedCE);
			

	}
	
	
	
	 @AfterMethod
	    public void tearDown(ITestResult result) 
	    {
	        // Log the result using @AfterMethod to ensure it's captured
	        if (result.getStatus() == ITestResult.FAILURE) 
	        {
	        	ChargeBatch_CEProductivityTest.log(Status.FAIL, "Test Case Failed: " + result.getName());
	        	ChargeBatch_CEProductivityTest.log(Status.FAIL, "Reason for Failure: " + result.getThrowable());
	        } 
	        else if (result.getStatus() == ITestResult.SUCCESS)
	        {
	        	ChargeBatch_CEProductivityTest.log(Status.PASS, "Test Case Passed: " + result.getName());
	        } 
	        else if (result.getStatus() == ITestResult.SKIP)
	        {
	        	ChargeBatch_CEProductivityTest.log(Status.SKIP, "Test Case Skipped: " + result.getName());
	        }
	    }
	}
	


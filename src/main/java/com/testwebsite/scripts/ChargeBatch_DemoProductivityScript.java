package com.testwebsite.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testwebsite.utilites.NBaseClass;

public class ChargeBatch_DemoProductivityScript extends NBaseClass
{
	

		 ExtentTest ChargeBatch_DemoProductivityTest;
		
		@Test(priority = 1)
		public void clickOnTheChargeBatchingSystemForDemo() throws InterruptedException 
		{
			
			ChargeBatch_DemoProductivityTest = extent.createTest("ChargeBatch Demo Productivity Process");

	        try
	        {
	            // Perform the login functionality
	        	demobatchsystemobject.ClickOnChargeBatchingSystemForDemo();
	        	//chargebatchsystemobject.ClickOnChargeBatchingSystem();

	            // Expected and actual URLs
	            String expectedChargeBatchURL = "https://st3.idsil.com/akpmsui/#/user/chargebatch";
	            String actualChargeBatchURL = driver.getCurrentUrl();

	            // Check and log the result
	            
	            Assert.assertEquals(actualChargeBatchURL, expectedChargeBatchURL);
	           
	        } 
	        catch (Exception e) 
	        {
	            // Log the exception in case of a failure
	        	ChargeBatch_DemoProductivityTest.log(Status.FAIL, "Test encountered an exception: " + e.getMessage());
	            throw e; // Re-throw the exception to ensure the test is marked as failed
	        }
	    }

	   	@Test(priority = 2)
		public void addBatchFunctionalityForDemo() throws InterruptedException 
		{
	   		try
	        {
	   			demobatchsystemobject.addAndVerfiyBatchForDemo();
	   			//demobatchsystemobject.addAndVerifyReceiveBatchForDemo();
			String oldTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
			String newTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
			
			Assert.assertEquals(oldTicketID, newTicketID);
			
	        }
			catch (Exception e) 
	        {
	            // Log the exception in case of a failure
				ChargeBatch_DemoProductivityTest.log(Status.FAIL, "Test encountered an exception: " + e.getMessage());
	            throw e; // Re-throw the exception to ensure the test is marked as failed
	        }
	        
			
		}
		
		@Test(priority = 3)
		
		public void addVerifyReceiveBatchFunctionalityForDemo() throws InterruptedException 
		{
			demobatchsystemobject.addAndVerifyReceiveBatchForDemo();
		}
		
		
		@Test(priority = 4)
		public void chargeBatch_DemoProductivityForDemo() throws InterruptedException 
		{
			
			demobatchsystemobject.chargeBatch_DemoProductivityForDemo(); 
			
		String ActualticketAlreadyPostedCE = "Ticket has already been posted for Demo Productivity type";
		String ExpectedticketAlreadyPostedCE= driver.findElement(By.xpath("//p[text()='Ticket has already been posted for Demo Productivity type']")).getText();
		Assert.assertEquals(ActualticketAlreadyPostedCE, ExpectedticketAlreadyPostedCE)	;
		System.out.println("This is the error message after posting ticket id = " +ExpectedticketAlreadyPostedCE);
				
		}
		
		
		
		 @AfterMethod
		    public void tearDown(ITestResult result) 
		    {
		        // Log the result using @AfterMethod to ensure it's captured
		        if (result.getStatus() == ITestResult.FAILURE) 
		        {
		        	ChargeBatch_DemoProductivityTest.log(Status.FAIL, "Test Case Failed: " + result.getName());
		        	ChargeBatch_DemoProductivityTest.log(Status.FAIL, "Reason for Failure: " + result.getThrowable());
		        } 
		        else if (result.getStatus() == ITestResult.SUCCESS)
		        {
		        	ChargeBatch_DemoProductivityTest.log(Status.PASS, "Test Case Passed: " + result.getName());
		        } 
		        else if (result.getStatus() == ITestResult.SKIP)
		        {
		        	ChargeBatch_DemoProductivityTest.log(Status.SKIP, "Test Case Skipped: " + result.getName());
		        }
		    }
		}
		



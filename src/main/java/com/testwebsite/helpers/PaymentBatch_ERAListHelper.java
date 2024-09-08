package com.testwebsite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.identifiers.PaymentBatch_ERAListIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class PaymentBatch_ERAListHelper extends NSeleniumMethods
{
	
	public PaymentBatch_ERAListHelper(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void ClickOnPaymentBatch() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(2000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickPaymentBatchSystem);
		Thread.sleep(1000);
	   
	}
	
	public void AddAndVerifyPaymentBatch() throws InterruptedException 
	{
		clickOn(PaymentBatch_ERAListIdentifiers.clickCancelButton);
		Thread.sleep(5000);
		String oldTicketIDForPaymentBatch = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketIDForPaymentBatch);
	
		clickOn(PaymentBatch_ERAListIdentifiers.clickAddNewPaymentBatchButton);	
		selectCurrentDate(PaymentBatch_ERAListIdentifiers.enterDepositDateFromTexfield);
		clickOn(PaymentBatch_ERAListIdentifiers.clickCompanyDatabasedropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.selectFromCompanyDatabasedropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.clickPaymentTypeDropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.selectFromPaymentTypedropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.clickGroupDropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.selectFromGroupdropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.clickDoctorDropdown);
		clickOn(PaymentBatch_ERAListIdentifiers.selectFromDoctorDropdown);
		Thread.sleep(5000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickAddButton);
		Thread.sleep(3000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickCompanyDatabasedropdownFilter);
		clickOn(PaymentBatch_ERAListIdentifiers.selectFromCompanyDatabasedropdownFilter);
		Thread.sleep(5000);
		// Scroll within the first scrollable element
		WebElement scrollableElemen = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElemen).click().sendKeys(scrollableElemen, Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickSearchButtonFilter);
		String newTicketIDForPaymentBatch = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("Newly created ticket id = " + newTicketIDForPaymentBatch);
		Thread.sleep(1000);
		{
		if (oldTicketIDForPaymentBatch!=newTicketIDForPaymentBatch)	
		{
	    Thread.sleep(1000);
		System.out.println("New ticket id successfully created as = "+newTicketIDForPaymentBatch);
		} 
	    else
		{
		System.out.println("New ticket id did not get create and remains as = "+oldTicketIDForPaymentBatch);
		}
		}
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickViewButtonForPaymentBatch);
		Thread.sleep(1000);
		 if (newTicketIDForPaymentBatch.equals(oldTicketIDForPaymentBatch))	
			{
			System.out.println("PASSED = New record can be viewed , ID = " +newTicketIDForPaymentBatch );
			} 
			else
			{
			System.out.println("FAILED = New record could not be found");
			}
		    Thread.sleep(1000);
		    doubleClickAndCopyText(PaymentBatch_ERAListIdentifiers.copyticketnumberForPaymentBatch);
            Thread.sleep(3000);
			clickOn(PaymentBatch_ERAListIdentifiers.clickCancelButtonForPaymentBatch);
			Thread.sleep(1000);
	}
	
	public void PaymentBatch_ERAProductivity() throws InterruptedException 
	{
		clickOn(PaymentBatch_ERAListIdentifiers.clickPaymentProductivity);
		clickOn(PaymentBatch_ERAListIdentifiers.redirectionToERAList);
		clickOn(PaymentBatch_ERAListIdentifiers.clickNewERAButton);
		Thread.sleep(1000);
		pasteCopiedText(PaymentBatch_ERAListIdentifiers.enterTicketNumberERAList);
		Thread.sleep(1000);
		
		try 
		{
			
			WebElement element = driver.findElement(By.xpath("//span[text()='Get Detail']"));
			if (element.isEnabled()) 
			{
			    element.click();
			}

			//clickOn(PaymentBatch_ERAListIdentifiers.clickGetDetailButtonERAList);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		sendKeys(PaymentBatch_ERAListIdentifiers.enterCKNumberERAList, "1");
		Thread.sleep(1000);
		scrollInDropdown(PaymentBatch_ERAListIdentifiers.enterDatePostedERAList);
		Thread.sleep(1000);
		selectCurrentDate(PaymentBatch_ERAListIdentifiers.enterDatePostedERAList);
		Thread.sleep(2000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickAddButtonERAList);
	}
	
	
	
}

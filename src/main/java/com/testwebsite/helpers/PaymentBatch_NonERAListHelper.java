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
import com.testwebsite.identifiers.PaymentBatch_NonERAListIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class PaymentBatch_NonERAListHelper extends NSeleniumMethods
{
	
	public PaymentBatch_NonERAListHelper(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void ClickOnPaymentBatchNonERA() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(2000);
		clickOn(PaymentBatch_ERAListIdentifiers.clickPaymentBatchSystem);
		Thread.sleep(1000);
	   
	}
	
	public void AddAndVerifyPaymentBatchNonERA() throws InterruptedException 
	{
		clickOn(PaymentBatch_NonERAListIdentifiers.clickCancelButtonNonERA);
		Thread.sleep(5000);
		String oldTicketIDForPaymentBatch = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketIDForPaymentBatch);
	
		clickOn(PaymentBatch_NonERAListIdentifiers.clickAddNewPaymentBatchButtonNonERA);	
		selectCurrentDate(PaymentBatch_NonERAListIdentifiers.enterDepositDateFromTexfieldNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickCompanyDatabasedropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.selectFromCompanyDatabasedropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickPaymentTypeDropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.selectFromPaymentTypedropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickGroupDropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.selectFromGroupdropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickDoctorDropdownNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.selectFromDoctorDropdownNonERA);
		Thread.sleep(5000);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickAddButtonNonERA);
		Thread.sleep(3000);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickCompanyDatabasedropdownFilterNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.selectFromCompanyDatabasedropdownFilterNonERA);
		Thread.sleep(5000);
		// Scroll within the first scrollable element
		WebElement scrollableElemen = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElemen).click().sendKeys(scrollableElemen, Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickSearchButtonFilterNonERA);
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
		clickOn(PaymentBatch_NonERAListIdentifiers.clickViewButtonForPaymentBatchNonERA);
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
			clickOn(PaymentBatch_NonERAListIdentifiers.clickCancelButtonForPaymentBatchNonERA);
			Thread.sleep(1000);
	}
	
	public void PaymentBatch_ERAProductivityNonERA() throws InterruptedException 
	{
		clickOn(PaymentBatch_NonERAListIdentifiers.clickPaymentProductivityNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.redirectionToERAListNonERA);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickNewERAButtonNonERA);
		Thread.sleep(1000);
		pasteCopiedText(PaymentBatch_NonERAListIdentifiers.enterTicketNumberERAListNonERA);
		Thread.sleep(1000);
		
		try 
		{
			
			WebElement element = driver.findElement(By.xpath("//span[text()='Get Detail']"));
			if (element.isEnabled()) 
			{
			    element.click();
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		sendKeys(PaymentBatch_NonERAListIdentifiers.enterCKNumberERAListNonERA, "1");
		Thread.sleep(1000);
		scrollInDropdown(PaymentBatch_NonERAListIdentifiers.enterDatePostedERAListNonERA);
		Thread.sleep(1000);
		selectCurrentDate(PaymentBatch_NonERAListIdentifiers.enterDatePostedERAListNonERA);
		Thread.sleep(2000);
		clickOn(PaymentBatch_NonERAListIdentifiers.clickAddButtonNonERA);
	}
	
	
	
}

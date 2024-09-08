package com.testwebsite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.identifiers.PaymentBatch_CAPListIdentifiers;
import com.testwebsite.identifiers.PaymentBatch_ERAListIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class PaymentBatch_CAPListHelper extends NSeleniumMethods
{
	
	public PaymentBatch_CAPListHelper(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void ClickOnPaymentBatch() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		clickOn(PaymentBatch_ERAListIdentifiers.clickPaymentBatchSystem);
	   
	}
	
	public void AddAndVerifyPaymentBatch() throws InterruptedException 
	{
		clickOn(PaymentBatch_ERAListIdentifiers.clickCancelButton);
		Thread.sleep(2000);
		String oldTicketIDForPaymentBatch = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketIDForPaymentBatch);
	
		clickOn(PaymentBatch_CAPListIdentifiers.clickAddNewPaymentBatchButton);	
		selectCurrentDate(PaymentBatch_CAPListIdentifiers.enterDepositDateFromTexfield);
		clickOn(PaymentBatch_CAPListIdentifiers.clickCompanyDatabasedropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.selectFromCompanyDatabasedropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.clickPaymentTypeDropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.selectFromPaymentTypedropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.clickGroupDropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.selectFromGroupdropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.clickDoctorDropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.selectFromDoctorDropdown);
		clickOn(PaymentBatch_CAPListIdentifiers.clickAddButton);
		Thread.sleep(2000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickCompanyDatabasedropdownFilter);
		clickOn(PaymentBatch_CAPListIdentifiers.selectFromCompanyDatabasedropdownFilter);
		Thread.sleep(2000);
		// Scroll within the first scrollable element
		WebElement scrollableElemen = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElemen).click().sendKeys(scrollableElemen, Keys.PAGE_DOWN).perform();
		//Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickSearchButtonFilter);
		String newTicketIDForPaymentBatch = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("Newly created ticket id = " + newTicketIDForPaymentBatch);
		//Thread.sleep(1000);
		{
		if (oldTicketIDForPaymentBatch!=newTicketIDForPaymentBatch)	
		{
	   // Thread.sleep(1000);
		System.out.println("New ticket id successfully created as = "+newTicketIDForPaymentBatch);
		} 
	    else
		{
		System.out.println("New ticket id did not get create and remains as = "+oldTicketIDForPaymentBatch);
		}
		}
	//	Thread.sleep(1000);
		driver.navigate().refresh();
	//	Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickViewButtonForPaymentBatch);
		//Thread.sleep(1000);
		 if (newTicketIDForPaymentBatch.equals(oldTicketIDForPaymentBatch))	
			{
			System.out.println("PASSED = New record can be viewed , ID = " +newTicketIDForPaymentBatch );
			} 
			else
			{
			System.out.println("FAILED = New record could not be found");
			}
		 //   Thread.sleep(1000);
		    doubleClickAndCopyText(PaymentBatch_CAPListIdentifiers.copyticketnumberForPaymentBatch);
           // Thread.sleep(3000);
			clickOn(PaymentBatch_CAPListIdentifiers.clickCancelButtonForPaymentBatch);
		Thread.sleep(1000);
	}
	
	public void PaymentBatch_CAPProductivity() throws InterruptedException 
	{
		clickOn(PaymentBatch_CAPListIdentifiers.clickPaymentProductivity);
		//Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.redirectionToCAPList);
		//Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickNewCAPButton);
		//Thread.sleep(1000);
		pasteCopiedText(PaymentBatch_CAPListIdentifiers.enterTicketNumberCAPList);
		//Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickGetDetailButtonCAPList);
		
		/*try 
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
		} */
		sendKeys(PaymentBatch_CAPListIdentifiers.enterCKNumberCAPList, "1");
		//Thread.sleep(1000);
		clickOn(PaymentBatch_CAPListIdentifiers.clickAddButtonCAPList);
	}
	
	
	
}

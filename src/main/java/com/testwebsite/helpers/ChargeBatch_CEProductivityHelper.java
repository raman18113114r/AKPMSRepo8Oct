package com.testwebsite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import com.amazon.identifiers.NewLoginPageIdentifiers;

import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;


public class ChargeBatch_CEProductivityHelper extends NSeleniumMethods
{

	public ChargeBatch_CEProductivityHelper(WebDriver driver) 
	{
		super(driver);

	}

	public void ClickOnChargeBatchingSystem() throws InterruptedException 
	{
		//Login Process
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		
		//ClickCancelButtonBeforeCreatingBatches
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickChargeBatchingSystem);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCancelButton);
		System.out.println("Clicked on Cancel button before creating a batch"); 
	}

	public void addAndVerfiyBatch() throws InterruptedException
	{
		//Verify the Old Ticket Id before creating a new one
		Thread.sleep(2000);
		String oldTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketID);
		
		//CREATE BATCH
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddNewButton);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnTypeDropdown);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.selectFromTypeDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromTypeDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnCompanyDropdown);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnGroupDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromGroupDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnDoctorDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromDoctorDropdown);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.dateOfServiceCalenderfrom);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.dateOfServiceCalenderTo);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddButton_1);
		
		//Clicking Cancel Button after creating a Batch
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCancelButton);
		Thread.sleep(1000);
		
		//Search the created Batch
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCompanyDatabaseDropdown);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		// Scroll within the first scrollable element
		WebElement scrollableElement1 = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElement1).click().sendKeys(scrollableElement1, Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
        clickOn(ChargeBatch_CEProductivityIdentifiers.clickSearchButton);
        Thread.sleep(1000);
        
        //Find a new ticket id got created after creating a batch
		String newTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("Newly created ticket id = " + newTicketID);
			Thread.sleep(1000);
			{
			if (oldTicketID!=newTicketID)	
			{
			Thread.sleep(1000);
			System.out.println("New ticket id successfully created as = "+newTicketID);
			} 
			else
			{
			System.out.println("New ticket id did not get create and remains as = "+oldTicketID);
			}
		}
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			//Checking View button functionality
			clickOn(ChargeBatch_CEProductivityIdentifiers.clickViewButton);	        
            if (newTicketID.equals(oldTicketID))	
			{
			System.out.println("PASSED = New record can be viewed , ID = " +newTicketID );
			} 
			else
			{
			System.out.println("FAILED = New record could not be found");
			}
            Thread.sleep(1000);
		    doubleClickAndCopyText(ChargeBatch_CEProductivityIdentifiers.copyTicketNumber);
            Thread.sleep(2000);
			clickOn(ChargeBatch_CEProductivityIdentifiers.clickViewCancelButton);
			Thread.sleep(1000);
	}
	
	public void addAndVerifyReceiveBatch() throws InterruptedException 
	{
		//Verifiying Edit/Update button functionality
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickEditButton);
		String getTextForEditWindow = getText(ChargeBatch_CEProductivityIdentifiers.getTextForEditWindow);
		System.out.println("Name of the edit window is = " +getTextForEditWindow);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickTypeDropdownEdit);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectOtherFromEdit);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickTypeDropdownEdit);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectSNFFromEdit);	
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickUpdateButtonEdit);
		
		//Verifying Receive Button functionality
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickReceiveButton);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.enterDateReceive);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickReceivedByDropdown);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectReceivedByDropdown);
		sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfSuperBills, "1");
		sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfAttachments, "1");
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickUpdateButton);
		
		//Verifying Download Excel functionality
        scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.clickExcelbutton);
        clickOn(ChargeBatch_CEProductivityIdentifiers.clickExcelbutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", ""); 
	}
	
	
	public void chargeBatch_CEProductivity() throws InterruptedException 
	{
		//Verifying CE Productivity
        Thread.sleep(3000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.redirectionToDemoCECodingProdPage);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivity);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivityButton);
		pasteCopiedText(ChargeBatch_CEProductivityIdentifiers.pasteTicketNumber);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickGetDetailButton);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.inputCTPostedDate);
	    sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfAccounts, "2");
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.identifyInputScanDate);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.inputScanDate);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddButton_2);
		
		//Verifying Productivity with the same ticket number
		driver.navigate().refresh();
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivityButton);
		pasteCopiedText(ChargeBatch_CEProductivityIdentifiers.pasteTicketNumber);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickGetDetailButton);
	}
}
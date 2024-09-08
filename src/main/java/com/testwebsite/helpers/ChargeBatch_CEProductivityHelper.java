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
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickChargeBatchingSystem);
		
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCancelButton);
		
		System.out.println("Clicked on Cancel button before creating a batch"); 
        
	}

	public void addAndVerfiyBatch() throws InterruptedException
	{
		Thread.sleep(5000);
		String oldTicketID = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketID);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddNewButton);
		
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnTypeDropdown);
		// clickOn(ChargeBatchingSystemIdentifiers.selectCompanyDatabase);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.selectFromTypeDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromTypeDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnCompanyDropdown);
		//Thread.sleep(1000);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromCompanyDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnGroupDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromGroupDropdown);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickOnDoctorDropdown);
	//	Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectFromDoctorDropdown);
		//Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.dateOfServiceCalenderfrom);
		//Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.dateOfServiceCalenderTo);
		//Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddButton_1);
		//Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCancelButton);
		Thread.sleep(1000);
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
      //  clickOn(ChargeBatch_CEProductivityIdentifiers.clickCancelButton);
		Thread.sleep(1000);
        
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
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
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
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickEditButton);
		String getTextForEditWindow = getText(ChargeBatch_CEProductivityIdentifiers.getTextForEditWindow);
		System.out.println("Name of the edit window is = " +getTextForEditWindow);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickTypeDropdownEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectOtherFromEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickTypeDropdownEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectSNFFromEdit);
		Thread.sleep(2000);	
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickUpdateButtonEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickReceiveButton);
		Thread.sleep(3000);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.enterDateReceive);
		Thread.sleep(3000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickReceivedByDropdown);
		Thread.sleep(3000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.selectReceivedByDropdown);
		Thread.sleep(3000);
		sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfSuperBills, "1");
		Thread.sleep(3000);
		sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfAttachments, "1");
		Thread.sleep(3000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickUpdateButton);
		Thread.sleep(1000);
        scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.clickExcelbutton);
        clickOn(ChargeBatch_CEProductivityIdentifiers.clickExcelbutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(7000);
        
	}
	
	
	public void chargeBatch_CEProductivity() throws InterruptedException 
	{
		clickOn(ChargeBatch_CEProductivityIdentifiers.redirectionToDemoCECodingProdPage);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivity);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivityButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_CEProductivityIdentifiers.pasteTicketNumber);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickGetDetailButton);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.inputCTPostedDate);
		Thread.sleep(1000);
	    sendKeys(ChargeBatch_CEProductivityIdentifiers.enterNumberOfAccounts, "2");
		Thread.sleep(1000);
		scrollInDropdown(ChargeBatch_CEProductivityIdentifiers.identifyInputScanDate);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CEProductivityIdentifiers.inputScanDate);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickAddButton_2);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickCEProductivityButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_CEProductivityIdentifiers.pasteTicketNumber);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CEProductivityIdentifiers.clickGetDetailButton);
		Thread.sleep(1000);	
		
	}
}
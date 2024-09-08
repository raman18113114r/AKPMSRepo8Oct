package com.testwebsite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;
import com.testwebsite.identifiers.ChargeBatch_DemoProductivityIdentifiers;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class ChargeBatch_DemoProductivityHelper extends NSeleniumMethods
{
	
	public ChargeBatch_DemoProductivityHelper(WebDriver driver) 
	{
		super(driver);

	}

	
	public void ClickOnChargeBatchingSystemForDemo() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickChargeBatchingSystem);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickCancelButton);
		Thread.sleep(1000);
		System.out.println("Clicked on Cancel button before creating a batch");  
	}

	public void addAndVerfiyBatchForDemo() throws InterruptedException
	{
		String oldTicketID1 = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketID1);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickAddNewButton);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickOnTypeDropdown);
		// clickOn(ChargeBatchingSystemIdentifiers.selectCompanyDatabase);
		scrollInDropdown(ChargeBatch_DemoProductivityIdentifiers.selectFromTypeDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectFromTypeDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickOnCompanyDropdown);
		Thread.sleep(1000);
		scrollInDropdown(ChargeBatch_DemoProductivityIdentifiers.selectFromCompanyDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectFromCompanyDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickOnGroupDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectFromGroupDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickOnDoctorDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectFromDoctorDropdown);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_DemoProductivityIdentifiers.dateOfServiceCalenderfrom);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_DemoProductivityIdentifiers.dateOfServiceCalenderTo);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickAddButton_1);
		Thread.sleep(1000);
		
		
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickCompanyDatabaseDropdown);
		scrollInDropdown(ChargeBatch_DemoProductivityIdentifiers.selectFromCompanyDropdown);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectFromCompanyDropdown);
        
		// Scroll within the first scrollable element
		WebElement scrollableElement1 = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElement1).click().sendKeys(scrollableElement1, Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
        clickOn(ChargeBatch_DemoProductivityIdentifiers.clickSearchButton);
		String newTicketID1 = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("Newly created ticket id = " + newTicketID1);
			Thread.sleep(2000);
			{
			if (oldTicketID1!=newTicketID1)
				
			{
			Thread.sleep(2000);
			System.out.println("New ticket id successfully created as = "+newTicketID1);
			} 
			else
			{
			System.out.println("New ticket id did not get create and remains as = "+oldTicketID1);
			}
		}
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			clickOn(ChargeBatch_DemoProductivityIdentifiers.clickViewButton);
				        
            if (oldTicketID1==newTicketID1)	
			{
			System.out.println("PASSED = New record can be viewed , ID = " +newTicketID1 );
			} 
			else
			{
			System.out.println("FAILED = New record could not be found");
			}
            
            Thread.sleep(1000);
		    doubleClickAndCopyText(ChargeBatch_DemoProductivityIdentifiers.copyTicketNumber);
            Thread.sleep(2000);
			clickOn(ChargeBatch_DemoProductivityIdentifiers.clickViewCancelButton);
			Thread.sleep(2000);
	}
	
	public void addAndVerifyReceiveBatchForDemo() throws InterruptedException 
	{
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickEditButton);
		String getTextForEditWindow = getText(ChargeBatch_CEProductivityIdentifiers.getTextForEditWindow);
		System.out.println("Name of the edit window is = " +getTextForEditWindow);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickTypeDropdownEdit);
		Thread.sleep(3000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectOtherFromEdit);
		Thread.sleep(3000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickUpdateButtonEdit);
		Thread.sleep(2000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickReceiveButton);
		Thread.sleep(2000);
		selectCurrentDate(ChargeBatch_DemoProductivityIdentifiers.enterDateReceive);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickReceivedByDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.selectReceivedByDropdown);
		Thread.sleep(1000);
		sendKeys(ChargeBatch_DemoProductivityIdentifiers.enterNumberOfSuperBills, "1");
		Thread.sleep(1000);
		sendKeys(ChargeBatch_DemoProductivityIdentifiers.enterNumberOfAttachments, "1");
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickUpdateButton);
		Thread.sleep(1000);
        scrollInDropdown(ChargeBatch_DemoProductivityIdentifiers.clickExcelbutton);
        clickOn(ChargeBatch_CEProductivityIdentifiers.clickExcelbutton);
        Thread.sleep(7000);
	}
	
	
	public void chargeBatch_DemoProductivityForDemo() throws InterruptedException 
	{
		clickOn(ChargeBatch_DemoProductivityIdentifiers.redirectionToDemoCECodingProdPage);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickDemoProductivity);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickAddNewDemoButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_DemoProductivityIdentifiers.enterTicketNumberDemo);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickGetDetailButtonDemo);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_DemoProductivityIdentifiers.inputScanDateDemo);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickAddButton_2Demo);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickAddNewDemoButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_DemoProductivityIdentifiers.enterTicketNumberDemo);
		Thread.sleep(1000);
		clickOn(ChargeBatch_DemoProductivityIdentifiers.clickGetDetailButtonDemo);
		Thread.sleep(1000);
		
	}

	
	

}

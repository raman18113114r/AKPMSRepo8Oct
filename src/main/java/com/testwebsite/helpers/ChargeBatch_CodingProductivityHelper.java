package com.testwebsite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;
import com.testwebsite.identifiers.ChargeBatch_CodingProductivityIdentifiers;
import com.testwebsite.identifiers.ChargeBatch_DemoProductivityIdentifiers;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class ChargeBatch_CodingProductivityHelper extends NSeleniumMethods
{


	public ChargeBatch_CodingProductivityHelper(WebDriver driver) 
	{
		super(driver);

	}

	
	public void ClickOnChargeBatchingSystemForCoding() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickChargeBatchingSystem);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickCancelButton);
		Thread.sleep(1000);
		System.out.println("Clicked on Cancel button before creating a batch");  
	}

	public void addAndVerfiyBatchForCoding() throws InterruptedException
	{
		String oldTicketID1 = driver.findElement(By.xpath("(//td[@role='gridcell'])[2]")).getText();
		System.out.println("old created ticket id = " + oldTicketID1);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickAddNewButton);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickOnTypeDropdown);
		// clickOn(ChargeBatchingSystemIdentifiers.selectCompanyDatabase);
		scrollInDropdown(ChargeBatch_CodingProductivityIdentifiers.selectFromTypeDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectFromTypeDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickOnCompanyDropdown);
		Thread.sleep(1000);
		scrollInDropdown(ChargeBatch_CodingProductivityIdentifiers.selectFromCompanyDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectFromCompanyDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickOnGroupDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectFromGroupDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickOnDoctorDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectFromDoctorDropdown);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CodingProductivityIdentifiers.dateOfServiceCalenderfrom);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CodingProductivityIdentifiers.dateOfServiceCalenderTo);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickAddButton_1);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickCompanyDatabaseDropdown);
		scrollInDropdown(ChargeBatch_CodingProductivityIdentifiers.selectFromCompanyDropdown);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectFromCompanyDropdown);
        
		// Scroll within the first scrollable element
		WebElement scrollableElement1 = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollableElement1).click().sendKeys(scrollableElement1, Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
        clickOn(ChargeBatch_CodingProductivityIdentifiers.clickSearchButton);
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
			//driver.navigate().refresh();
			Thread.sleep(1000);
			clickOn(ChargeBatch_CodingProductivityIdentifiers.clickViewButton);
				        
            if (oldTicketID1==newTicketID1)	
			{
			System.out.println("PASSED = New record can be viewed , ID = " +newTicketID1 );
			} 
			else
			{
			System.out.println("FAILED = New record could not be found");
			}
            
            Thread.sleep(1000);
		    doubleClickAndCopyText(ChargeBatch_CodingProductivityIdentifiers.copyTicketNumber);
            Thread.sleep(2000);
			clickOn(ChargeBatch_CodingProductivityIdentifiers.clickViewCancelButton);
			Thread.sleep(2000);
	}
	
	public void addAndVerifyReceiveBatchForCoding() throws InterruptedException 
	{
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickEditButton);
		String getTextForEditWindow = getText(ChargeBatch_CEProductivityIdentifiers.getTextForEditWindow);
		System.out.println("Name of the edit window is = " +getTextForEditWindow);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickTypeDropdownEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectOtherFromEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickTypeDropdownEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectSNFFromEdit);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickUpdateButtonEdit);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickReceiveButton);
		Thread.sleep(1000);
		selectCurrentDate(ChargeBatch_CodingProductivityIdentifiers.enterDateReceive);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickReceivedByDropdown);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectReceivedByDropdown);
		Thread.sleep(1000);
		sendKeys(ChargeBatch_CodingProductivityIdentifiers.enterNumberOfSuperBills, "1");
		Thread.sleep(1000);
		sendKeys(ChargeBatch_CodingProductivityIdentifiers.enterNumberOfAttachments, "1");
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickUpdateButton);
		Thread.sleep(1000);
        scrollInDropdown(ChargeBatch_CodingProductivityIdentifiers.clickExcelbutton);
        clickOn(ChargeBatch_CodingProductivityIdentifiers.clickExcelbutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(7000);
	}
	
	
	public void chargeBatch_CodingProductivityForCoding() throws InterruptedException 
	{
		clickOn(ChargeBatch_CodingProductivityIdentifiers.redirectionToDemoCECodingProdPage);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickCodingProductivity);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickCodingProductivityButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_CodingProductivityIdentifiers.pasteTicketNumberCoding);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickGetDetailButtonCoding);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickProductivityTypeDropdownCoding);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.selectGroupFromProductivityTypeDropdownCoding);
		Thread.sleep(2000);
		 driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		 Thread.sleep(1000);
		 driver.switchTo().defaultContent();
		 Thread.sleep(1000);
		scrollInDropdown(ChargeBatch_CodingProductivityIdentifiers.enterNumberOfAccountsCoding);
		Thread.sleep(2000);
		 sendKeys(ChargeBatch_CodingProductivityIdentifiers.enterNumberOfAccountsCoding, "2");
		selectCurrentDate(ChargeBatch_CodingProductivityIdentifiers.inputScanDateCoding);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickAddButton_2Coding);
		Thread.sleep(2000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickCodingProductivityButton);
		Thread.sleep(1000);
		pasteCopiedText(ChargeBatch_CodingProductivityIdentifiers.pasteTicketNumberCoding);
		Thread.sleep(1000);
		clickOn(ChargeBatch_CodingProductivityIdentifiers.clickGetDetailButtonCoding);
		Thread.sleep(2000);
	}
}

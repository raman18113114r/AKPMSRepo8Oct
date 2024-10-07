package com.testwebsite.helpers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.identifiers.QAManager_ByStaff_WC_Identifiers;
import com.testwebsite.identifiers.QAManager_General_WC_Identifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class QAManager_ByStaff_WC_Helper extends NSeleniumMethods
{
	
	private Actions actions;

	public QAManager_ByStaff_WC_Helper(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void WorkSheetWithoutParameters_Staff() throws InterruptedException 
	{
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickQAManager);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickQAWorkSheet);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickCreateWorkSheet);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickByStaffRadio);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDepartmentDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectARDepartmentDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickBillingMonthDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectBillingMonthDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickBillingYearDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectBillingYearDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDateFromCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickArrowCalendar);	
		clickOn(QAManager_ByStaff_WC_Identifiers.selectDateFromCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDateToCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickArrowCalendar1);	
		clickOn(QAManager_ByStaff_WC_Identifiers.selectDateFromCalendar1);
		String expectedNameOfWorkSheet = selectCurrentDateWithTime(QAManager_General_WC_Identifiers.enterWorksheetName);
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickSaveQAWorksheet);
		
		clickOn(QAManager_ByStaff_WC_Identifiers.clickSelectStaffDropdown);
		Thread.sleep(5000);
		sendKeys(QAManager_ByStaff_WC_Identifiers.enterNameinSelectStaff, "jawa");
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectStaffAsRahulJawa);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickOutSideSelectStaff);
        sendKeys(QAManager_ByStaff_WC_Identifiers.enterPercentageStaff, "100");
        clickOn(QAManager_ByStaff_WC_Identifiers.clickAddStaffButton);
        Thread.sleep(5000);
		actions = new Actions(driver);
        
		System.out.println("**** "+"Worksheet name expected = " +expectedNameOfWorkSheet+" ****");
		
		
		
	}
	
	public void WorkSheetWithParameters_Staff() throws InterruptedException 
	{
		driver.navigate().refresh();
		Thread.sleep(5000);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickByStaffRadio);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDepartmentDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectARDepartmentDropdown);
		
		clickOn(QAManager_ByStaff_WC_Identifiers.clickSubDepartmentDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectHMO_SubDepartmentDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickProductivityTypeDropdown);
		Thread.sleep(5000);
		
		/*List<WebElement> listOFDropdowns = driver.findElements(By.xpath("//td[@class='abcd']"));
		ArrayList<String> storingInArrayList = new ArrayList<> ();
		
		for(WebElement totalListOfDropdowns : listOFDropdowns ) 
		{
			storingInArrayList.add(totalListOfDropdowns.getText());
		}
		
		System.out.println("here = "+storingInArrayList);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.ESCAPE).perform();
		
		*/
		clickOn(QAManager_ByStaff_WC_Identifiers.clickBillingMonthDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectBillingMonthDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickBillingYearDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectBillingYearDropdown);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDateFromCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickArrowCalendar);	
		clickOn(QAManager_ByStaff_WC_Identifiers.selectDateFromCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickDateToCalendar);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickArrowCalendar1);	
		clickOn(QAManager_ByStaff_WC_Identifiers.selectDateFromCalendar1);
		String expectedNameOfWorkSheet = selectCurrentDateWithTime(QAManager_General_WC_Identifiers.enterWorksheetName);
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickSaveQAWorksheet);
		
		clickOn(QAManager_ByStaff_WC_Identifiers.clickSelectStaffDropdown);
		Thread.sleep(2000);
		sendKeys(QAManager_ByStaff_WC_Identifiers.enterNameinSelectStaff, "jawa");
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.selectStaffAsRahulJawa);
		Thread.sleep(2000);
		clickOn(QAManager_ByStaff_WC_Identifiers.clickOutSideSelectStaff);
		Thread.sleep(2000);
        sendKeys(QAManager_ByStaff_WC_Identifiers.enterPercentageStaff, "100");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickOn(QAManager_ByStaff_WC_Identifiers.clickAddStaffButton);
        Thread.sleep(2000);
        clickOn(QAManager_ByStaff_WC_Identifiers.clickOnCrossButton);
		
		System.out.println("**** "+"Worksheet name expected = " +expectedNameOfWorkSheet+" ****");
			
}
}

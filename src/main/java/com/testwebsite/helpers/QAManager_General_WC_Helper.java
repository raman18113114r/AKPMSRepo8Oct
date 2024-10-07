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
import com.testwebsite.identifiers.QAManager_General_WC_Identifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class QAManager_General_WC_Helper extends NSeleniumMethods
{
	
	private Actions actions;

	public QAManager_General_WC_Helper(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void createWorkSheetWithoutParameters(String department, String subDepartment, 
			String productivityType, String billingMonth, String billingYear, 
			String postedDateFrom, String postedDateTo, String generalPercentage) throws InterruptedException 
	{
		
		sendKeys(LoginProcessIdentifiers.enterUserName, "rahul.j@idsil.com");
		sendKeys(LoginProcessIdentifiers.enterPassword, "password123");
		clickOn(LoginProcessIdentifiers.clickLogIn);
		Thread.sleep(2000);
		clickOn(QAManager_General_WC_Identifiers.clickQAManager);
		clickOn(QAManager_General_WC_Identifiers.clickQAWorkSheet);
		clickOn(QAManager_General_WC_Identifiers.clickCreateWorkSheet);
		
		clickOn(QAManager_General_WC_Identifiers.clickDepartmentDropdown);
		//I WAS GETTING ERROR OVER HERE UNCOMMENT AND CHECK WHATS THE PROBLEM
		 //selectOptionFromDropdown(QAManager_General_WC_Identifiers.selectDepartmentDropdown, department); // Select the department passed as a parameter
        //getText(QAManager_General_WC_Identifiers.selectARDepartmentDropdown, department);
        identifyDropdown(QAManager_General_WC_Identifiers.selectARDepartmentDropdown, department);
        //identifyDropdown 
        
        
		clickOn(QAManager_General_WC_Identifiers.selectARDepartmentDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickBillingMonthDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectBillingMonthDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickBillingYearDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectBillingYearDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickDateFromCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickArrowCalendar);	
		clickOn(QAManager_General_WC_Identifiers.selectDateFromCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickDateToCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickArrowCalendar1);	
		clickOn(QAManager_General_WC_Identifiers.selectDateFromCalendar1);
		String expectedNameOfWorkSheet = selectCurrentDateWithTime(QAManager_General_WC_Identifiers.enterWorksheetName);
		Thread.sleep(2000);
		sendKeys(QAManager_General_WC_Identifiers.enterGeneralPercentage, "100");
		clickOn(QAManager_General_WC_Identifiers.clickSaveQAWorksheet);
		
		actions = new Actions(driver);
        
		System.out.println("**** "+"Worksheet name expected = " +expectedNameOfWorkSheet+" ****");
		
		
		
	}
	
	public void createWorkSheetWithParameters() throws InterruptedException 
	{
		driver.navigate().refresh();
		Thread.sleep(7000);
		clickOn(QAManager_General_WC_Identifiers.clickCreateWorkSheet);
		clickOn(QAManager_General_WC_Identifiers.clickDepartmentDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectARDepartmentDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickSubDepartmentDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectHMO_SubDepartmentDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickProductivityTypeDropdown);
		//Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.className("mat-option"));
		ArrayList<String> optionTexts = new ArrayList<>();

		// Store the text of each dropdown item in the ArrayList
		for (WebElement option : options)
		{
		    optionTexts.add(option.getText());
		}

		// Now click on each dropdown item
		for (WebElement option : options) 
		{
		    option.click(); // Click the dropdown item

		    // Optional: Wait for a moment if the UI needs time to update
		    Thread.sleep(500); // Adjust the time as necessary

		    // If the dropdown closes after a click, you may need to reopen it here
		    // driver.findElement(By.className("dropdown-toggle")).click(); // Example to reopen
		}

		// Print the option texts
		for (String text : optionTexts)
		{
		    System.out.println("HERE ARE THE LIST OF ITEMS IN DROPDOWN: " + text);
		}

		
		//Thread.sleep(2000);
		
		actions.sendKeys(Keys.ESCAPE).perform();
		
       // actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.ESCAPE).perform();
		
		clickOn(QAManager_General_WC_Identifiers.clickBillingYearDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectBillingYearDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickBillingMonthDropdown);
		clickOn(QAManager_General_WC_Identifiers.selectBillingMonthDropdown);
		clickOn(QAManager_General_WC_Identifiers.clickDateFromCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickArrowCalendar);	
		clickOn(QAManager_General_WC_Identifiers.selectDateFromCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickDateToCalendar);
		clickOn(QAManager_General_WC_Identifiers.clickArrowCalendar1);	
		clickOn(QAManager_General_WC_Identifiers.selectDateFromCalendar1);
		String expectedNameOfWorkSheet = selectCurrentDateWithTime(QAManager_General_WC_Identifiers.enterWorksheetName);
		Thread.sleep(2000);
		sendKeys(QAManager_General_WC_Identifiers.enterGeneralPercentage, "100");
		clickOn(QAManager_General_WC_Identifiers.clickSaveQAWorksheet);
		
		System.out.println("**** "+"Worksheet name expected = " +expectedNameOfWorkSheet+" ****");
		Thread.sleep(5000);
		
        actions.keyDown(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        actions.keyUp(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        actions.keyUp(Keys.ARROW_DOWN).perform();
		
	}
 	

}

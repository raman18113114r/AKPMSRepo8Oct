package com.testwebsite.identifiers;

public class QAManager_General_WC_Identifiers 
{
	
	public static String clickQAManager = "//span[text()='QA Manager']";
	public static String clickQAWorkSheet = "//a[text()='QA Work Sheet']";
	public static String clickCreateWorkSheet = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']";
	public static String clickDepartmentDropdown = "//div[@class='mat-select-arrow-wrapper ng-tns-c67-17']";
	public static String selectARDepartmentDropdown = "//span[text()='Accounts Receivable Department']";
	public static String clickBillingMonthDropdown = "//div[@class='mat-select-arrow-wrapper ng-tns-c67-21']";
	public static String selectBillingMonthDropdown = "//span[text()='Aug']";
	public static String clickBillingYearDropdown = "//div[@class='mat-select-arrow-wrapper ng-tns-c67-23']";
	public static String selectBillingYearDropdown = "//span[text()='2024']";
	public static String clickDateFromCalendar = "(//span[@class='mat-button-wrapper'])[12]";
	public static String clickArrowCalendar = "//button[@aria-label='Previous month']";
	public static String selectDateFromCalendar = "//td[@aria-label='August 1, 2024']";
	public static String clickDateToCalendar = "(//span[@class='mat-button-wrapper'])[13]";
	public static String clickArrowCalendar1 = "//button[@aria-label='Previous month']";
	public static String selectDateFromCalendar1 = "//td[@aria-label='August 2, 2024']";
	public static String enterWorksheetName = "//input[@data-placeholder='Enter Worksheet Name']";
	public static String enterGeneralPercentage = "//input[@data-placeholder='%']";
	public static String clickSaveQAWorksheet  = "//span[text()='Save QA Worksheet']";
	public static String getCreatedWorksheetName = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]//td[contains(text(),'Raman WS')]";
	public static String getNameOfWorksheet = "(//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted'])[1]";
	
	//clickSubdepartment
	public static String clickSubDepartmentDropdown = "//div[@class='mat-select-arrow-wrapper ng-tns-c67-19']";
	public static String selectHMO_SubDepartmentDropdown = "//span[text()='HMO']";
	public static String clickProductivityTypeDropdown = "//div[@class='mat-select-arrow-wrapper ng-tns-c67-28']";
	//public static String selectAll_ProductivityDropdown = ""
}

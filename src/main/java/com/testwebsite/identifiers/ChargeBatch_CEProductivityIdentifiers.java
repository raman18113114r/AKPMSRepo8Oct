package com.testwebsite.identifiers;

import org.openqa.selenium.WebDriver;

public class ChargeBatch_CEProductivityIdentifiers
{
	//Find identifiers for "Charge Batching System" Page/Class
	
	
	//ADDBATCHFUNCTIONALITY
	public static String clickChargeBatchingSystem = "//span[text()='Charge Batching System']";
	public static String clickCancelButton = "//span[text()='Cancel']";
	public static String clickAddNewButton = "//span[contains(text(), 'Add New')]";	
	public static String clickOnTypeDropdown = "//span[@class='mat-select-value-text ng-tns-c67-43 ng-star-inserted']";	
	public static String selectFromTypeDropdown = "//span[text()=' Urgent Care ']";
	public static String clickOnCompanyDropdown = "(//span[text()='Select Company / Database'])[2]";
	public static String selectFromCompanyDropdown = "(//span[contains(text(),'Gardner D MD Inc')])[1]";
	public static String clickOnGroupDropdown = "(//span[text()='Select Group'])[2]";
	public static String selectFromGroupDropdown = "//span[text()=' Gardner D. Tarlow, MD Inc ']";
	public static String clickOnDoctorDropdown = "(//span[text()='Select Doctor'])[2]";
	public static String selectFromDoctorDropdown = "//span[text()=' Gardner David Tarlow MD ']";
	public static String dateOfServiceCalenderfrom = "(//input[@data-placeholder='MM/DD/YYYY'])[9]";
	public static String dateOfServiceCalenderTo = "(//input[@data-placeholder='MM/DD/YYYY'])[10]";
	public static String clickAddButton_1 = "//span[text()='Add']";
	
	//FILTERFUNCTIONALITY
	public static String clickCompanyDatabaseDropdown = "//span[text()='Select Company / Database']";
	public static String selectCompanyDatabaseDropdown = "//span[text()=' Tarlow, Gardner D MD Inc ']";
	public static String clickSearchButton = "//span[text()='Search']";
	public static String selectFromCompanyDropdownFilter = "//span[text()=' Tarlow, Gardner D MD Inc ']";
	
	//VIEWBUTTONFUNCTIONALITY
	public static String clickViewButton = "(//mat-icon[text()='pageview'])[1]";
	public static String copyTicketNumber = "//h5[@class='m-0']";
	public static String clickViewCancelButton = "(//span[text()='Cancel'])[2]";
	
	//UPDATE/EDITFUNCTIONALITY
	public static String clickEditButton = "(//mat-icon[text()='edit'])[1]";
	public static String getTextForEditWindow = "//h1[text()='Update Charge Batch']";
	public static String clickTypeDropdownEdit = "(//div[contains(@class, 'mat-select-arrow-wrapper')])[8]";
	public static String selectOtherFromEdit = "//span[text()=' Telehealth ']";
	public static String selectSNFFromEdit = "//span[text()=' SNF ']";
	public static String clickUpdateButtonEdit = "//span[text()='Update']";
	
	//BATCHRECEIVEFUNCTIONALITY
	public static String clickReceiveButton = "(//mat-icon[text()='insert_drive_file'])[1]";
	public static String enterDateReceive = "(//input[@data-placeholder='MM/DD/YYYY'])[9]";
	public static String clickReceivedByDropdown = "(//span[text()='Select Received By'])[2]";
	public static String selectReceivedByDropdown = "//span[text()=' Rahul Jawa Ids ']";
	public static String enterNumberOfSuperBills = "//input[@data-placeholder='Number of Super Bills']";
	public static String enterNumberOfAttachments = "//input[@data-placeholder='Number of Attachments']";
	public static String clickUpdateButton = "//span[text()='Update']";
	
	//EXCELBUTTONFUNCTIONALITY
	public static String clickExcelbutton = "//span[text()=' Excel']";
	
	
	//Find identifiers for DemoCECodingProductivityPage/Class
	
		//CE PRODUCTIVITY FUNCTIONALITY
		public static String redirectionToDemoCECodingProdPage = "//span[text()='Demo/CE/Coding Prod.']";
		public static String clickCEProductivity = "//a[@href='#/user/CE-productivity/3']";
		public static String clickCEProductivityButton = "(//i[@class='material-icons'])[1]";
		public static String pasteTicketNumber = "(//span[@class='mat-button-focus-overlay'])[2]";
		public static String clickGetDetailButton = "//span[text()='Get Detail']";
		public static String inputCTPostedDate = "(//input[@placeholder='MM/DD/YYYY'])[5]";
		public static String enterNumberOfAccounts = "//input[@placeholder='Enter Number of Accounts']";
		public static String identifyInputScanDate = "//label[text()='Scan Date:']";
		public static String inputScanDate = "(//input[@placeholder='MM/DD/YYYY'])[6]";
		public static String clickAddButton_2 = "//span[text()='Add']";
	
	
	
}

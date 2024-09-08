package com.testwebsite.identifiers;

public class ChargeBatch_CodingProductivityIdentifiers
{
	
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
		
			//DEMO PRODUCTIVITY FUNCTIONALITY
			public static String redirectionToDemoCECodingProdPage = "//span[text()='Demo/CE/Coding Prod.']";
			public static String clickCodingProductivity = "//a[@href='#/user/CE-productivity/1']";
			public static String clickCodingProductivityButton = "(//i[@class='material-icons'])[1]";
			public static String pasteTicketNumberCoding = "(//span[@class='mat-button-focus-overlay'])[2]";
			public static String clickGetDetailButtonCoding = "//span[text()='Get Detail']";
			public static String clickProductivityTypeDropdownCoding = "(//div[contains(@class, 'mat-select-arrow-wrapper') and contains(@class, 'ng-tns-c')])[7]";
			public static String selectGroupFromProductivityTypeDropdownCoding = "//span[text()='Group A']";
			public static String identifyInputScanDateCoding = "(//input[@placeholder='MM/DD/YYYY'])[5]";
			public static String inputScanDateCoding = "(//input[@placeholder='MM/DD/YYYY'])[5]";
			public static String enterNumberOfAccountsCoding = "//input[@placeholder='Enter Number of Accounts']";
			public static String clickAddButton_2Coding = "//span[text()='Add']";
		

	
	
	
	

}

package com.testwebsite.identifiers;

public class PaymentBatch_ERAListIdentifiers 
{
	//ADD PAYMENT BATCH
	public static String clickCancelButton = "//span[text()='Cancel']";
	public static String clickPaymentBatchSystem = "//span[text()='Payment Batching System']";
	public static String clickAddNewPaymentBatchButton = "(//button[contains(@class, 'mat-flat-button') and contains(@class, 'mat-primary')])[1]";
	public static String enterDepositDateFromTexfield = "(//input[@placeholder='MM/DD/YYYY'])[7]";
	public static String clickCompanyDatabasedropdown = "(//span[text()='Select Company / Database'])[2]";
	public static String selectFromCompanyDatabasedropdown = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickPaymentTypeDropdown = "//div[@id='mat-select-value-29']";
	public static String selectFromPaymentTypedropdown = "//span[text()=' Admin Income ']";
	public static String clickGroupDropdown = "(//span[text()='Select Group'])[2]";
	public static String selectFromGroupdropdown = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickDoctorDropdown = "(//span[text()='Select Doctor'])[2]";
	public static String selectFromDoctorDropdown = "//span[text()=' Corey Jonathan Rood ']";
	public static String clickAddButton = "//span[text()='Add']";
	
	//FILTER PAYMENT BATCH
	public static String clickCompanyDatabasedropdownFilter = "//span[text()='Select Company / Database']";
	public static String selectFromCompanyDatabasedropdownFilter = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickSearchButtonFilter = "//span[text()='Search']";
	
	//VIEWBUTTONFUNCTIONALITY
	public static String clickViewButtonForPaymentBatch = "(//mat-icon[text()='pageview'])[1]";
	public static String copyticketnumberForPaymentBatch = "(//h5[@class='m-0'])[1]";
	public static String clickCancelButtonForPaymentBatch = "(//span[text()='Cancel'])[2]";
	
	//PAYMENTBATCH_ERALIST PRODUCTIVTY
	public static String clickPaymentProductivity = "//span[text()='Payment Productivity']";
	public static String redirectionToERAList = "//a[text()='ERA List']";
	public static String clickNewERAButton = "(//span[@class='mat-button-wrapper'])[1]";
	public static String enterTicketNumberERAList = "//input[@placeholder='Enter Ticket']";
	public static String clickGetDetailButtonERAList = "//span[text()='Get Detail']";
	public static String enterCKNumberERAList = "//input[@placeholder='Enter CK Number']";
	public static String enterDatePostedERAList = "(//input[@placeholder='MM/DD/YYYY'])[5]";
	public static String clickAddButtonERAList = "(//input[@placeholder='MM/DD/YYYY'])[5]";
}

package com.testwebsite.identifiers;

public class PaymentBatch_NonERAListIdentifiers 
{
	//ADD PAYMENT BATCH
	public static String clickCancelButtonNonERA = "//span[text()='Cancel']";
	public static String clickPaymentBatchSystemNonERA = "//span[text()='Payment Batching System']";
	public static String clickAddNewPaymentBatchButtonNonERA = "(//button[contains(@class, 'mat-flat-button') and contains(@class, 'mat-primary')])[1]";
	public static String enterDepositDateFromTexfieldNonERA = "(//input[@placeholder='MM/DD/YYYY'])[7]";
	public static String clickCompanyDatabasedropdownNonERA = "(//span[text()='Select Company / Database'])[2]";
	public static String selectFromCompanyDatabasedropdownNonERA = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickPaymentTypeDropdownNonERA = "//div[@id='mat-select-value-29']";
	public static String selectFromPaymentTypedropdownNonERA = "//span[text()=' Admin Income ']";
	public static String clickGroupDropdownNonERA = "(//span[text()='Select Group'])[2]";
	public static String selectFromGroupdropdownNonERA = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickDoctorDropdownNonERA = "(//span[text()='Select Doctor'])[2]";
	public static String selectFromDoctorDropdownNonERA = "//span[text()=' Corey Jonathan Rood ']";
	public static String clickAddButtonNonERA = "//span[text()='Add']";
	
	//FILTER PAYMENT BATCH
	public static String clickCompanyDatabasedropdownFilterNonERA = "//span[text()='Select Company / Database']";
	public static String selectFromCompanyDatabasedropdownFilterNonERA = "//span[text()=' Access Primary Care Physicians, Inc ']";
	public static String clickSearchButtonFilterNonERA = "//span[text()='Search']";
	
	//VIEWBUTTONFUNCTIONALITY
	public static String clickViewButtonForPaymentBatchNonERA = "(//mat-icon[text()='pageview'])[1]";
	public static String copyticketnumberForPaymentBatchNonERA = "(//h5[@class='m-0'])[1]";
	public static String clickCancelButtonForPaymentBatchNonERA = "(//span[text()='Cancel'])[2]";
	
	//PAYMENTBATCH_ERALIST PRODUCTIVTY
	public static String clickPaymentProductivityNonERA = "//span[text()='Payment Productivity']";
	public static String redirectionToERAListNonERA = "//a[text()='ERA List']";
	public static String clickNewERAButtonNonERA = "(//span[@class='mat-button-wrapper'])[1]";
	public static String enterTicketNumberERAListNonERA = "//input[@placeholder='Enter Ticket']";
	public static String clickGetDetailButtonERAListNonERA = "//span[text()='Get Detail']";
	public static String enterCKNumberERAListNonERA = "//input[@placeholder='Enter CK Number']";
	public static String enterDatePostedERAListNonERA = "(//input[@placeholder='MM/DD/YYYY'])[5]";
	public static String clickAddButtonERAListNonERA = "(//input[@placeholder='MM/DD/YYYY'])[5]";
}

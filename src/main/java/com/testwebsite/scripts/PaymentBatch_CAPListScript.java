package com.testwebsite.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class PaymentBatch_CAPListScript extends NBaseClass
{

	ExtentTest PaymentBatch_ERAListTest; 
	@Test(priority = 1)
	public void ClickOnThePaymentBatch() throws InterruptedException 
	{
		paymentbatchcaplistobject.ClickOnPaymentBatch();
	}
	
	@Test(priority = 2)
	public void AddAndVerifyThePaymentBatch() throws InterruptedException 
	{
		paymentbatchcaplistobject.AddAndVerifyPaymentBatch();
	}
	
	@Test(priority = 3)
	public void PaymentBatchCAPProductivity() throws InterruptedException 
	{
		paymentbatchcaplistobject.PaymentBatch_CAPProductivity();
	}
	
}

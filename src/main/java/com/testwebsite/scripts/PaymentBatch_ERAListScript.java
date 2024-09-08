package com.testwebsite.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class PaymentBatch_ERAListScript extends NBaseClass
{

	ExtentTest PaymentBatch_ERAListTest; 
	@Test(priority = 1)
	public void ClickOnThePaymentBatch() throws InterruptedException 
	{
		paymentbatcheralistobject.ClickOnPaymentBatch();
	}
	
	@Test(priority = 2)
	public void AddAndVerifyThePaymentBatch() throws InterruptedException 
	{
		paymentbatcheralistobject.AddAndVerifyPaymentBatch();
	}
	
	@Test(priority = 3)
	public void PaymentBatchERAProductivity() throws InterruptedException 
	{
		paymentbatcheralistobject.PaymentBatch_ERAProductivity();
	}
	
}

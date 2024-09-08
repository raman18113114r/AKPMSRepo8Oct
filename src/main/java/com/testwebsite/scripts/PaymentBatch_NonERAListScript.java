package com.testwebsite.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class PaymentBatch_NonERAListScript extends NBaseClass
{

	ExtentTest PaymentBatch_NonERAListTest; 
	@Test(priority = 1)
	public void ClickOnThePaymentBatchNonERA() throws InterruptedException 
	{
		paymentbatchnoneralistobject.ClickOnPaymentBatchNonERA();
	}
	
	@Test(priority = 2)
	public void AddAndVerifyThePaymentBatchNonERA() throws InterruptedException 
	{
		paymentbatchnoneralistobject.AddAndVerifyPaymentBatchNonERA();
		
	}
	
	@Test(priority = 3)
	public void PaymentBatchNonERAProductivityNonERA() throws InterruptedException 
	{
		paymentbatchnoneralistobject.PaymentBatch_ERAProductivityNonERA();
	}
	
}

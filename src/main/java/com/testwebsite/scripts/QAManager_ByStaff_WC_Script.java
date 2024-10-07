package com.testwebsite.scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class QAManager_ByStaff_WC_Script extends NBaseClass
{
	
	ExtentTest QAManagerTest;

  

    @Test(priority = 1)
		public void worksheetWithoutParameters() throws InterruptedException 
	{
		qamanagerobject_bystaff.WorkSheetWithoutParameters_Staff();
	}
    
    @Test(priority = 2)
	public void worksheetWithParameters() throws InterruptedException 
{
    	qamanagerobject_bystaff.WorkSheetWithParameters_Staff();
}

}

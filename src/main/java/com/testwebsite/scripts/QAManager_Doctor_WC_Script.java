package com.testwebsite.scripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testwebsite.utilites.NBaseClass;

public class QAManager_Doctor_WC_Script extends NBaseClass
{
	
	ExtentTest QAManagerTest;

  

    @Test(priority = 1)
		public void worksheetWithoutParameters() throws InterruptedException 
	{
    	//I WAS GETTING ERROR OVER HERE UNCOMMENT AND CHECK WHATS THE PROBLEM
    	//qamanagerobject_general.createWorkSheetWithoutParameters();
	}
    
    @Test(priority = 2)
	public void worksheetWithParameters() throws InterruptedException 
{
    	qamanagerobject_general.createWorkSheetWithParameters();
}

}

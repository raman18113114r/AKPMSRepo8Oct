package com.testwebsite.helpers;

import org.openqa.selenium.WebDriver;
import com.testwebsite.identifiers.LoginProcessIdentifiers;
import com.testwebsite.utilites.NSeleniumMethods;

public class LoginProcessHelper extends NSeleniumMethods
{

    public LoginProcessHelper(WebDriver driver)
    {
        super(driver);
    }

    public void enterUsername(String username) throws InterruptedException 
    {
    	//Login Process
    	sendKeys(LoginProcessIdentifiers.enterUserName, username);	
    }
    
    public void enterPassword(String password) 
    {
    	sendKeys(LoginProcessIdentifiers.enterPassword, password);	
    }
    
    public void clickLoginButton() throws InterruptedException 
    {
		clickOn(LoginProcessIdentifiers.clickLogIn); 
		Thread.sleep(5000);	
    }
    
    public String getErrorMessage() 
    {
        return getText(LoginProcessIdentifiers.unsuccessfulLoginMessage);
    }   
}
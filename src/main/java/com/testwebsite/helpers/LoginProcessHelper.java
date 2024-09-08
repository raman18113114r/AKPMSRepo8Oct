package com.testwebsite.helpers;

import org.openqa.selenium.WebDriver;
import com.testwebsite.utilites.NSeleniumMethods;

public class LoginProcessHelper extends NSeleniumMethods
{

    public LoginProcessHelper(WebDriver driver)
    {
        super(driver);
    }

    public void CheckLoginFunctionality() throws InterruptedException
    {
       
        Thread.sleep(3000); 
    }
}

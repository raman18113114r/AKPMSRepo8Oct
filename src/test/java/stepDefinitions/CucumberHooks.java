package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

import com.testwebsite.utilites.NBaseClass;

import io.cucumber.java.After;


public class CucumberHooks extends NBaseClass 
{

    // This will run before every scenario
    @Before
    public void setupCucumber() throws IOException, InterruptedException 
    {
        // Call the setup method from BaseClass
    	setup(); 
    	
    	driver.manage().deleteAllCookies();
    }

    // This will run after every scenario
    @After
    public void tearDownCucumber() {
        // Call the teardown method from BaseClass
    	quitBrowser();
    }
}
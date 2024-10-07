package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.testwebsite.helpers.LoginProcessHelper;
import com.testwebsite.utilites.NBaseClass;

public class LoginSteps extends NBaseClass 
{
	// Declare the LoginClassHelper object
	LoginProcessHelper loginpagehelperobject;
	
	 //Constructor
    public LoginSteps()
    {
        // Initialize the loginpagehelperobject
        loginpagehelperobject = new LoginProcessHelper(driver); // Pass the WebDriver instance
    }

    // Step definition for Given
    @Given("^the user enters \"([^\"]*)\" as the username$")
    public void user_enters_username(String username) throws InterruptedException 
    {
    	driver.findElement(By.xpath("//input[@id='username']")).clear();
    	loginpagehelperobject.enterUsername(username); // Use the helper method to enter username
    }

    @And("^enters \"([^\"]*)\" as the password$")
    public void user_enters_password(String password) 
    {
    	driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
    	loginpagehelperobject.enterPassword(password); // Use the helper method to enter password
    }

    @When("^clicks the login button$")
    public void user_clicks_login_button() throws InterruptedException 
    {
    	loginpagehelperobject.clickLoginButton(); // Use the helper method to click the login button
    	
    }
    
    @Then("^an error message \"([^\"]*)\" should be displayed$")
    public void error_message_should_be_displayed(String expectedErrorMessage) 
    {
    	String actualErrorMessage = loginpagehelperobject.getErrorMessage();
    	Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not displayed as expected.");
    }

    // Step definition for Then (Successful login)
    @Then("^the user should be redirected to the dashboard$")
    public void user_redirected_to_dashboard() throws InterruptedException
    {
    	Thread.sleep(5000);
        String expectedURL = "https://akpms2.idsil.in/akpmsui/#/user/dashboard"; // Update to your actual dashboard URL
        String actualURL = driver.getCurrentUrl(); 
        Assert.assertEquals(actualURL, expectedURL, "User was not redirected to the dashboard.");
    }
}


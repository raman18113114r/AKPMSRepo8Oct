package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features", // Path to your feature files
    glue = "stepDefinitions", // Path to your step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"} // Reporting options
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests
{
	
	
	
}
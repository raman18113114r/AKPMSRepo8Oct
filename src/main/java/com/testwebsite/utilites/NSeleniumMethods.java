package com.testwebsite.utilites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NSeleniumMethods 
{

	public StringSelection stringSelection;
	public Clipboard clipboard;
	// Define objects
	protected WebDriver driver;

	// Declare objects
	public NSeleniumMethods(WebDriver webdriver) 
	{
		driver = webdriver;
	}

	// Return web driver object
	public WebDriver getWebDriver() {
		return driver;
	}

	// Print message on screen
	public void log(String logMsg) {
		System.out.println(logMsg);
	}

	// Handle locator type
	public By byLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		}

		else if (locator.startsWith("tag")) {
			result = By.tagName(locator.replace("tag", ""));
		}

		else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("id=")) {
			result = By.id(locator.replace("id=", ""));
		} else {
			result = By.xpath(locator);
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getWebDriver().findElement(byLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	// Wait for element present
	public void waitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Handle click action
	public void clickOn(String locator) 
	{
	    try 
	    {
	        // Wait for the element to be present
	        this.waitForElementPresent(locator, 40);

	        // Create a WebDriverWait instance
	        WebDriverWait wait = new WebDriverWait(getWebDriver(), java.time.Duration.ofSeconds(30));

	        // Wait until the element is visible
	        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator(locator)));
	        
	        // Wait until the element is clickable
	        el = wait.until(ExpectedConditions.elementToBeClickable(byLocator(locator)));

	        // Debugging information
	        System.out.println("Element located by: " + locator);
	        System.out.println("Element text: " + el.getText());
	        System.out.println("Element tag name: " + el.getTagName());

	        // Optionally, you can also verify that the element is present one more time before clicking
	        Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");

	        // Perform the click action
	        el.click();
	        
	        System.out.println("Clicked on element with locator: " + locator);
	    } 
	    catch (Exception e)
	    {
	        // Print the error details
	        System.err.println("Error occurred while trying to click on element with locator: " + locator);
	        e.printStackTrace();
	    }
	}
	
	
	

	// Method to identify a dropdown element and return it
	public WebElement identifyDropdown(String dropdownLocator, String department) 
	{
	    // Wait for the dropdown element to be present
	    this.waitForElementPresent(dropdownLocator, 40);

	    // Create a WebDriverWait instance
	    WebDriverWait wait = new WebDriverWait(getWebDriver(), java.time.Duration.ofSeconds(30));

	    // Wait until the dropdown element is visible
	    WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator(dropdownLocator)));

	    // Debugging information
	    System.out.println("Dropdown identified: " + dropdownLocator);
	    System.out.println("Department value: " + department);
	    
	    // Return the identified dropdown element
	    return dropdown;
	}

	
	
	public String assertion(String locator1, String locator2)
	{
		//this.waitForElementPresent(locator1, 30);
		// waitForWorkAroundTime(4000);
		//Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		
		String  expectedoutcome = getWebDriver().findElement(byLocator(locator1)).getText();
		String  actualoutcome = getWebDriver().findElement(byLocator(locator2)).getText();
		System.out.println("expected = "+expectedoutcome + "actual = " +actualoutcome);
		Assert.assertEquals(expectedoutcome, actualoutcome);
		return actualoutcome;
		
		
		
	}
	
	
	
	
	
	

	// Handle send keys action
		public void sendKeys(String locator, String str)
		{
			this.waitForElementPresent(locator, 30);
			// waitForWorkAroundTime(4000);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
			WebElement el = getWebDriver().findElement(byLocator(locator));
			// el.sendKeys(Keys.CONTROL + "a");
			// el.sendKeys(Keys.DELETE);
			el.clear();
			el.sendKeys(str);
	}
		
		public void clearTextField(String locator) 
		{
		    // Wait for the element to be present
		    this.waitForElementPresent(locator, 30);
		    
		    // Assert that the element is present
		    Assert.assertTrue(isElementPresent(locator), "Element Locator: " + locator + " not found");
		    
		    // Find the WebElement using the locator
		    WebElement el = getWebDriver().findElement(byLocator(locator));
		    
		    // Clear the text field
		    el.clear();
		}


	// Store text from a locatorl
	public String getText(String locator) {
		waitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(byLocator(locator)).getText();
		return text;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		waitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(byLocator(locator)).getAttribute(attribute);
		return text;
	}

	public Integer getXpathCount(String locator) {
		waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		int a = driver.findElements(By.xpath(locator)).size();
		return a;
	}

	public void waitForWorkAroundTime(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyTitle(String title) {
		waitForWorkAroundTime(4000);
		String actualTitle = getWebDriver().getTitle();
		Assert.assertTrue(actualTitle.contains(title));
	}

	public void mouseHover(String locator) 
	{
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Actions action = new Actions(getWebDriver());
		action.moveToElement(el).build().perform();
	}
	
	public void doubleClickAndCopyText(String locator) 
	{
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Actions action = new Actions(getWebDriver());
		action.doubleClick(el).perform();
        // Perform CTRL+C action
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	}
	
	public void pasteCopiedText(String locator) 
	{
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Actions action = new Actions(getWebDriver());
		action.doubleClick(el).perform();
        // Perform CTRL+C action
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	}
	
	
	

	public void selectByText(String locator, String text) {
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Select select = new Select(el);
		select.selectByVisibleText(text);
	}

	public void typeKeys(String locator, Keys key) {
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		el.sendKeys(key);
	}

	public void verticalScroll(int val)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");
	}
	
	public void scrollMainPageVertically(int pixels) {
	    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
	    
	    // This scrolls the main page (right side scroller of the browser)
	    js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
	}

	public void scrollWithActionsClass()
	{
	    Actions actions = new Actions(getWebDriver());
	    
	    // Scroll down by simulating a mouse scroll wheel action
	    actions.sendKeys(Keys.PAGE_DOWN).perform();  // Scroll down a full page
	    actions.sendKeys(Keys.PAGE_UP).perform();    // Scroll up a full page
	}
	
	

	public void removeAttribute(String locator, String attribute) {
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		List<WebElement> inputs = driver.findElements(byLocator(locator));

		for (WebElement input : inputs) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attribute + "')", input);
		}
	}

	public void dropDown(String locator, String str) {
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		Select drp = new Select(driver.findElement(byLocator(locator)));
		drp.selectByVisibleText(str);

	}

	public void rightClick(String locator) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(byLocator(locator));
		actions.contextClick(elementLocator).perform();
	}
	
	
	public void scrollInDropdown(String locator)
	{
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement elementLocator = driver.findElement(byLocator(locator));
		Actions actions = new Actions(driver);
		actions.scrollToElement(elementLocator).perform();
	}

	   

    public void selectCurrentDate(String locator)
    {
    	this.waitForElementPresent(locator, 30);
		waitForWorkAroundTime(4000);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
    	  // Get today's date in MM/DD/YYYY format
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        String formattedDate = today.format(formatter);

        // Locate the date picker input field by its ID (adjust as necessary)
        WebElement datePicker = getWebDriver().findElement(byLocator(locator));

        // Enter the formatted date into the input field
        datePicker.sendKeys(formattedDate);

        // Optionally, you might need to trigger a blur event or submit the form to apply the change
        // datePicker.sendKeys(Keys.TAB);
    }
    
    
    public String selectCurrentDateWithTime(String locator)
    {
        this.waitForElementPresent(locator, 30);
        waitForWorkAroundTime(4000);
        Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");

        // Get the current date and time in MM/DD/YYYY HH:mm:ss format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Construct the expected worksheet name
        String worksheetName = "Raman WS " + formattedDateTime;

        // Locate the date-time picker input field by its locator
        WebElement datePicker = getWebDriver().findElement(byLocator(locator));

        // Enter the full worksheet name into the input field
        datePicker.sendKeys(worksheetName);

        // Debugging info
        System.out.println("Date and time entered: " + worksheetName);

        // Return the full worksheet name
        return worksheetName;
    }

	
	       
		

	public void switchToFrame(String frameName) {
		waitForWorkAroundTime(2000);
		driver.switchTo().frame(frameName);
		waitForWorkAroundTime(4000);
	}

	public void uploadFileWithRobotClass(String filePath) {
		waitForWorkAroundTime(4000);
		stringSelection = new StringSelection(filePath);
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void startDatePicker(String locator) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		// Integer to String Conversion
		String today = Integer.toString(todayInt);

		// This is from date picker table
		this.waitForElementPresent(locator, 30);
		waitForWorkAroundTime(4000);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		// This are the columns of the from date picker table
		List<WebElement> columns = el.findElements(By.tagName("td"));

		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		for (WebElement cell : columns) {
			/*
			 * //If you want to click 18th Date if (cell.getText().equals("18")) {
			 */
			// Select Today's Date
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

		// Wait for 4 Seconds to see Today's date selected.
		waitForWorkAroundTime(4000);

	}

	public void endDatePicker(String locator) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		todayInt = todayInt + 1;
		// Integer to String Conversion
		String today = Integer.toString(todayInt);
		// This is from date picker table
		this.waitForElementPresent(locator, 30);
		waitForWorkAroundTime(10000);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		// This are the columns of the from date picker table
		List<WebElement> columns = el.findElements(By.tagName("td"));

		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		for (WebElement cell : columns) {
			/*
			 * //If you want to click 18th Date if (cell.getText().equals("18")) {
			 */
			// Select Today's Date
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

		// Wait for 4 Seconds to see Today's date selected.
		waitForWorkAroundTime(4000);

	}

	public void switchBetweenTabs(int i) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// below code will switch to new tab
		/*
		 * driver.switchTo().window(tabs.get(1)); //perform whatever actions you want in
		 * new tab then close it driver.close(); //Switch back to your original tab
		 */
		driver.switchTo().window(tabs.get(i));
	}
	
	
	public void selectAllCheckboxesFromDropdown(String dropdownLocator) 
	{
        // Click dropdown to open using the passed locator
        WebElement dropdown = driver.findElement(By.xpath(dropdownLocator));
        dropdown.click();

        // Use Actions to simulate Ctrl + A
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();  // Perform Ctrl + A to select all
    }
	

	public void sendKeysWithActionClass(String locator, String str)
	{
		this.waitForElementPresent(locator, 30);
		waitForWorkAroundTime(4000);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		Actions actions = new Actions(driver);
		el.clear();
		actions.sendKeys(el, str).perform();
	}

	public void switchToFrameWithWebElement(String locator) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(byLocator(locator));
		driver.switchTo().frame(el);
		waitForWorkAroundTime(4000);
	}

	public void verifyText(String locator, String str) {
		waitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(byLocator(locator)).getText();
		Assert.assertTrue(text.contains(str));
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void changeAttributeValue(String locator, String attribute) {
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement w1 = driver.findElement(byLocator(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0]." + attribute + ".display = 'block';", w1);
	}

	public void navigateURL(String url) {
		driver.navigate().to(url);
	}

	public void verticalScrollUp(int val) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
	}


	// Method to read data from Excel
    public String[][] readCredentialsFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] credentials = new String[rowCount - 1][2];
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            credentials[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
            credentials[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
        }
        workbook.close();
        fis.close();
        return credentials;
    }
    
    
    // Method to write data to Excel
    public void writeDataToExcel(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Credentials.xlsx"));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);
        fis.close();

        FileOutputStream fos = new FileOutputStream(new File("C:Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Credentials.xlsx"));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
	
	

	
	
}

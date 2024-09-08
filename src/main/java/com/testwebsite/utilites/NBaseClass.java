package com.testwebsite.utilites;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.testwebsite.helpers.ChargeBatch_CEProductivityHelper;
import com.testwebsite.helpers.ChargeBatch_CodingProductivityHelper;
import com.testwebsite.helpers.ChargeBatch_DemoProductivityHelper;
import com.testwebsite.helpers.LoginProcessHelper;
import com.testwebsite.helpers.PaymentBatch_CAPListHelper;
import com.testwebsite.helpers.PaymentBatch_ERAListHelper;
import com.testwebsite.helpers.PaymentBatch_NonERAListHelper;
import com.testwebsite.identifiers.ChargeBatch_CEProductivityIdentifiers;

public class NBaseClass
{
    public static ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/AKPMS_ARGUSWebsiteTesting.html");
    public static ExtentReports extent = new ExtentReports();
    public static WebDriver driver;
    public LoginProcessHelper loginpagehelperobject;
    public ChargeBatch_CEProductivityHelper chargebatchsystemobject;
    public ChargeBatch_DemoProductivityHelper demobatchsystemobject;
    public ChargeBatch_CodingProductivityHelper codingbatchsystemobject;
    public PaymentBatch_ERAListHelper paymentbatcheralistobject;
    public PaymentBatch_CAPListHelper paymentbatchcaplistobject;
    public PaymentBatch_NonERAListHelper paymentbatchnoneralistobject;

    @BeforeSuite
    public void setup() throws IOException, InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\Chromedriver\\new\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f, new File("C:\\Users\\raman.kumar\\Desktop\\Apollo 247\\apolloscreenshot.jpg"));
        driver.manage().window().maximize();
        driver.get("https://st3.idsil.com/akpmsui/#/user/dashboard");    
    }

    @BeforeClass
    public void ArgusWebsiteObjects() 
    {
        loginpagehelperobject = new LoginProcessHelper(driver);
        chargebatchsystemobject = new ChargeBatch_CEProductivityHelper(driver);
        demobatchsystemobject = new ChargeBatch_DemoProductivityHelper(driver) ;
        codingbatchsystemobject= new ChargeBatch_CodingProductivityHelper(driver);
        paymentbatcheralistobject = new PaymentBatch_ERAListHelper(driver);
        paymentbatchcaplistobject = new PaymentBatch_CAPListHelper(driver);
        paymentbatchnoneralistobject = new PaymentBatch_NonERAListHelper(driver);  
    }

    @BeforeTest
    public void implementExtentReport() 
    {
        spark.config().setReportName("Automation Test Report for ArgusAKMPMS ||Raman||");
        spark.config().setDocumentTitle("ArgusAKPMS Test Results");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
        extent.attachReporter(spark); 
    }

    @AfterTest
    public void exitExtentReport()
    {
        extent.flush(); 
        System.out.println("flush was called");
    }
    
 // Method to read data from Excel
    public String[][] readCredentialsFromExcel(String filePath, String sheetName) throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] credentials = new String[rowCount - 1][2];
        for (int i = 1; i < rowCount; i++) 
        {
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
        if (row == null) 
        {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null)
        {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);
        fis.close();

        FileOutputStream fos = new FileOutputStream(new File("C:Users\\raman.kumar\\Desktop\\Argus (AKPMS)\\AKPMS Credentials.xlsx"));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
      
    @AfterSuite
    public void quitBrowser()
    {
      driver.quit();
    }
    
    
     
}

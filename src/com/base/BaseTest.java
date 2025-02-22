package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");  // Open site at startup
        Thread.sleep(2000);
        
        //extent report for report generation 
        extent = ExtentManager.getReport();  // Calls ExtentManager to get report instance
        test = extent.createTest("Setup Test"); // Creates a test entry in the report
        test.log(Status.INFO, "Browser launched and navigated to site");
    }
    
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            test.log(Status.INFO, "Browser closed");
        }
        extent.flush(); // Save the report data
    }
}
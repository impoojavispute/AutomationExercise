package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;


public class login  extends BaseTest
{
	String url = "https://automationexercise.com/login";
	
	@BeforeMethod
	public void before()
	{
		driver.get(url);
	}
	
	@Test
	public void Login () throws InterruptedException
	{
		Login_Obj lb = new Login_Obj (driver);
		
		test = extent.createTest("1.Visit URL");
		test.info("Get The Page Title ");
		lb.GetTitle();
		
		test = extent.createTest("2.Username");
		test.info("Enter Username ");
		lb.username ("vispute.pooja142@gmail.com");
		
		test = extent.createTest("3.Password");
		test.info("Enter Password");
		lb.password("Test@123");
		
		test = extent.createTest("4.Login");
		test.info("Click On Login Button");
		lb.login_button();
		
	}
	
}




/*WebDriver driver;




public void before () 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
     
			
	
}*/





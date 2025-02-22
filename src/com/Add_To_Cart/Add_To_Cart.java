 package com.Add_To_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;



public class Add_To_Cart extends BaseTest
{
	/*WebDriver driver;
	String url = "https://automationexercise.com/";
	
	
	@BeforeMethod
	
	public void before ()
	{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
	}*/
	 
	@Test (dependsOnMethods = "com.login.login.Login")
	public void Add_to_cart () throws InterruptedException
	{
		Add_To_Cart_Obj ac = new Add_To_Cart_Obj (driver);
		
		test = extent.createTest("5.Products");
		test.info("Click on Product");
		ac.products();
		
		test = extent.createTest("6.Select Product");
		test.info("Search and select product. ");
		ac.select_product();
		
		test = extent.createTest("7.Add Product");
		test.info("Click on Add to cart ");
		ac.add_product();
		
		test = extent.createTest("8.View Cart");
		test.info("Click on view cart ");
		ac.view_cart();
		
	}
	
	
	

}

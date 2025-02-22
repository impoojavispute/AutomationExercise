package com.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Obj
{

	WebDriver driver;
	
	By username = By.xpath("//input[@data-qa='login-email']");
	By password = By.xpath("//input[@placeholder='Password']");
	By login_button =  By.xpath("//button[normalize-space()='Login']");
	
	public Login_Obj(WebDriver d) 
	{
	        this.driver = d;
	}
	
	public void GetTitle () // Title 
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public void username (String uname) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(uname);
	}
	
	public void password (String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void login_button() 
	{
		driver.findElement(login_button).click();
		
	}
	
}

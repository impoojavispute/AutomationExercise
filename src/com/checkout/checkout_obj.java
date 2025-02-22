package com.checkout;
import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class checkout_obj 
{
	WebDriver driver;
	
	By Proceed_To_Checkout = By.xpath("//a[normalize-space()='Proceed To Checkout']");
	By comment = By.xpath("//textarea[@name='message']");
	By place_order_button = By.xpath("//a[normalize-space()='Place Order']");
	By Name_on_Card = By.xpath("//input[@name='name_on_card']");	
	By Card_Number = By.xpath("//input[@name='card_number']");
	By CVC = By.xpath("//input[@placeholder='ex. 311']");
	By Expiration_mm = By.xpath("//input[@placeholder='MM']");
	By Expiration_yyyy = By.xpath("//input[@placeholder='YYYY']");
	By Confirm_order_button = By.xpath("//button[@id='submit']");
	By Order_Placed = By.xpath("//b[normalize-space()='Order Placed!']");
	By order_confirmed = By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");
	By Continue_button = By.xpath("//a[normalize-space()='Continue']");
	By download_invoice = By.xpath("//a[normalize-space()='Download Invoice']");
	By LogOut = By.xpath("//a[normalize-space()='Logout']");
	
	public checkout_obj (WebDriver d)
	{
		this.driver = d;
	}
	
	public void Proceed_To_Checkout ()
	{
		driver.findElement(Proceed_To_Checkout).click();
	}
	
	public void place_order(String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600);");
		driver.findElement(comment).sendKeys(message);
		driver.findElement(place_order_button).click();
	}
	
	public void Payment (String name, String card_no, String cvc , String mm, String yyyy ) throws InterruptedException
	{
		driver.findElement(Name_on_Card).sendKeys(name);
		driver.findElement(Card_Number).sendKeys(card_no);
		driver.findElement(CVC).sendKeys(cvc);
		driver.findElement(Expiration_mm).sendKeys(mm);
		driver.findElement(Expiration_yyyy).sendKeys(yyyy);
		driver.findElement(Confirm_order_button).click();
		Thread.sleep(2000);
	}
	
	public void Order_Placed () throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(order_confirmed));
		String actualText = confirmationMessage.getText();
		Assert.assertEquals(actualText, "Congratulations! Your order has been confirmed!");
		System.out.println("Order successfully placed.");
		driver.findElement(download_invoice).click();
		driver.findElement(LogOut).click();
		
	}
}




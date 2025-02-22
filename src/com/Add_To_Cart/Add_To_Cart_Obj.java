package com.Add_To_Cart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Add_To_Cart_Obj 
{
	
	WebDriver driver;
	
	By products = By.xpath("//a[@href='/products']");
	By select_product = By.xpath("//input[@id='search_product']");
	By submit_button = By.xpath("//button[@id='submit_search']");
	By add_to_cart = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]");
	By overlay = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]");
	By product_added = By.xpath("//h4[normalize-space()='Added!']");
	By added_window = By.xpath("//div[@class='modal-content']");
	By view_cart = By.xpath("//u[normalize-space()='View Cart']");
	
	
	public Add_To_Cart_Obj (WebDriver d)
	{
		this.driver = d;
	}
	
	public void products ()
	{
		
		driver.findElement(products).click();
		
	}
	
	public void select_product() throws InterruptedException
	{
		driver.findElement(select_product).sendKeys("T-Shirt");
		driver.findElement(submit_button).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800);");
		//Thread.sleep(3000);
	}
	
	public void add_product()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(overlay)).perform();
		driver.findElement(add_to_cart).click();
		
	}
	
	public void view_cart ()
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement modalPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content"))); 
        
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[normalize-space()='View Cart']")));
        viewCartButton.click();
		
		//driver.findElement(view_cart).click();
		
		
	}
	 


	
	/*public void view_cart() 
	{
		
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(added_window)).click().perform();
		//driver.findElement(product_added).isDisplayed();
		driver.findElement(view_cart).click();
		
	}*/
	
}
	
	

	

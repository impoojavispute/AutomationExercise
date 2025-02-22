package com.checkout;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class checkout extends BaseTest

{
	
	
	@Test(dependsOnMethods = "com.Add_To_Cart.Add_To_Cart.Add_to_cart")
	public void test() throws InterruptedException
	{
		checkout_obj checkout = new checkout_obj (driver);
		
		test = extent.createTest("10.Proceed To Checkout");
		test.info("Click on proceed to checkout");
		checkout.Proceed_To_Checkout();
		
		test = extent.createTest("11.Message/ Comment ");
		test.info("Write Message/Comment");
		checkout.place_order("I will place it again");
		
		test = extent.createTest("12.Payment Details");
		test.info("Provide payment details");
		checkout.Payment("Test", "14325", "213", "23", "2025");
		
		test = extent.createTest("13.Order Placed and Logout");
		test.info("Click on Order placed button and Logout  ");
		checkout.Order_Placed();
		
		
		
		
	}
}

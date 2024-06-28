package Selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Abstractmethod.AbstracttMethod;

public class CartPage extends AbstracttMethod {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> li;
	
	@FindBy(xpath= "//button[text()='Checkout']")
	WebElement checkoutButton;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyAdditem(String item)
	{	
		
		
		for(WebElement j : li)
		{
			if(j.getText().equalsIgnoreCase(item))
				
				return true;
			
			else
				return false;
	    }
		
		return false;

   }
	
	
	public CheckoutPage goToCheckout()
	{
		checkoutButton.click();
		CheckoutPage ch = new CheckoutPage(driver);
		return ch;
	}
	
}

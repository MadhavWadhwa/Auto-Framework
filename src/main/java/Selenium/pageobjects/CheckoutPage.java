package Selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Selenium.Abstractmethod.AbstracttMethod;

public class CheckoutPage extends AbstracttMethod {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	

}

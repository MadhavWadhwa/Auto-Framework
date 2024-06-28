package Selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Abstractmethod.AbstracttMethod;

public class LoginPage extends AbstracttMethod {
	
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(@class,'flyInOut')]")
	WebElement message;
	
	public ProductPage Login(String name,String pass)
	{
		username.sendKeys(name);
		password.sendKeys(pass);
		submit.click();
		ProductPage p = new ProductPage(driver);
		return p;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMessage()
	{
		waitforElement(message);
		return message.getText();
	}
	
	
	
	

}

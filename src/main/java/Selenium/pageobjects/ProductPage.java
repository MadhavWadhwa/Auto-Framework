package Selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Abstractmethod.AbstracttMethod;

public class ProductPage extends AbstracttMethod {
	
	@FindBy(xpath = "//div[contains(@class,'mb-3')]")
	List<WebElement> items; 
	
	By addToCart = By.xpath("//div[@class='card-body']/button[2]");

	
	@FindBy(xpath = "//div[contains(@class,'la-ball-scale-multiple')]")
	WebElement spinner;
	
WebDriver driver;

By findby = By.xpath("//div[contains(@class,'mb-3')]");
By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");

	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this); 
		
	}
	
	
	
	public List<WebElement> fetchElements()
	{
		waitforappear(findby);
		return items;
	}
	
	
	public WebElement getItemName(String item,List<WebElement> it)
	{
        WebElement d=null;
		for(WebElement i : it)
		{
			System.out.println(i.findElement(By.tagName("b")).getText());
		    if(i.findElement(By.tagName("b")).getText().equalsIgnoreCase(item))
		    {
		    	d = i;
		    	break;
		    }    	
		    
	    }
		return d;
		
	}
	
	
	public void AddtoCart(WebElement d)
	{	
		d.findElement(addToCart).click();
		
	}
	
	
	public CartPage goToCart()
	{
		invisibleElement(spinner);
		elementTobeClickable(cartButton);
		driver.findElement(cartButton).click();
		return new CartPage(driver);
	}
	
	
	
	
	
}

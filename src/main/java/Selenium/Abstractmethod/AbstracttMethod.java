package Selenium.Abstractmethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstracttMethod {
	
	WebDriver driver;
	WebDriverWait w;
	
	public AbstracttMethod(WebDriver driver)
	{
		this.driver = driver;
		w = new WebDriverWait(driver,Duration.ofSeconds(7));
	}

	
	public void waitforappear(By findBy)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforElement(WebElement ele)
	{
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void invisibleElement(WebElement ele)
	{
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void elementTobeClickable(By ele)
	{
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	
	
	
}

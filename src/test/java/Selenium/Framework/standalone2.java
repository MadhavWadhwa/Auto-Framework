package Selenium.Framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.pageobjects.LoginPage;
import dev.failsafe.Timeout;
public class standalone2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String item = "ZARA COAT 3";
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mwadhwa2706@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("@Keshav1999");
		
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(6));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mb-3')]")));
		
		List<WebElement> q = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		
		System.out.println(q.size());
		
		for(int i=0;i<q.size();i++)
		{
			System.out.println(q.get(i).findElement(By.tagName("b")).getText());
		    if(q.get(i).findElement(By.tagName("b")).getText().equalsIgnoreCase(item))
		    {
		    	System.out.println("Inside if");
		    	System.out.print(i);
		    	 q.get(i).findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		    	break;
		    }
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@class,'la-ball-scale-multiple')]"))));
		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		for(WebElement j : li)
		{
			if(j.getText().equalsIgnoreCase(item))
			{
				Assert.assertTrue(true);
			}
			
			else
				
				Assert.assertTrue(false);
		}
		

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		
	}

}

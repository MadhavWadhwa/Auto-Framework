package Selenium.Framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.Abstractmethod.AbstracttMethod;
import Selenium.TestComp.BaseTest;
import Selenium.pageobjects.CartPage;
import Selenium.pageobjects.LoginPage;
import Selenium.pageobjects.ProductPage;
import dev.failsafe.Timeout;
public class standalone extends BaseTest {
	
	@Test(dataProvider = "data")
	
	public void submitOrder(HashMap<String,String> hp) throws IOException
	{

		String item = hp.get("product");
		
	   ProductPage p =  lp.Login(hp.get("email"),hp.get("password"));
		List<WebElement> items = p.fetchElements();
		
		WebElement d = p.getItemName(item,items);
		
		p.AddtoCart(d);
		
	    CartPage c =  p.goToCart();
	    
	    boolean m = c.verifyAdditem(item);
	    
	    Assert.assertTrue(m);	
		
	}
	
	
	
	@DataProvider
	
	public Object[][] data() throws IOException
	{
		
		List<HashMap<String,String>> data = getData(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\data\\data.json");
//		HashMap<String,String> hp = new HashMap<String,String>();
//		hp.put("email","mwadhwa2706@gmail.com");
//		hp.put("password","@Keshav1999");
//		hp.put("productname","ZARA COAT 3");
		
		return new Object[][] {{data.get(0)}};
	}
	

	
}


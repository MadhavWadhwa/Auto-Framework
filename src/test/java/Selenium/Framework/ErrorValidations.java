package Selenium.Framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.Abstractmethod.AbstracttMethod;
import Selenium.TestComp.BaseTest;
import Selenium.TestComp.Retry;
import Selenium.pageobjects.CartPage;
import Selenium.pageobjects.LoginPage;
import Selenium.pageobjects.ProductPage;
import dev.failsafe.Timeout;
public class ErrorValidations extends BaseTest {
	
	@Test(groups = "Error",retryAnalyzer = Retry.class)
	
	public void Loginerror() throws IOException
	{

		String item = "ADIDAS ORIGINAL";
		
	   ProductPage p =  lp.Login("mwadhwa2706@gmail.com","@oeshav1999");
		
	   String message = lp.getErrorMessage();
	   
	   Assert.assertEquals("Incorrect email password.", message);
		
	}

	
}


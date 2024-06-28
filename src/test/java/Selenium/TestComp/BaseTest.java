package Selenium.TestComp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage lp;
	
	public WebDriver initDriver() throws IOException
	{
		Properties p = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium\\resources\\Global.properties");
				p.load(fs);
				String browser = p.getProperty("browser");
				
				if(browser.equalsIgnoreCase("chrome"))
				{
					
              WebDriverManager.chromedriver().setup();
		
		      driver = new ChromeDriver();
				}
				
				else if(browser.equalsIgnoreCase("firefox"))
				{
					
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				
				return driver;
				
	}
	
	public List<HashMap<String, String>> getData(String filepath) throws IOException
	{
		String json = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		
		return data;
	}
	
	public String getScreenShot(String testcase,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
	    File fs =  ts.getScreenshotAs(OutputType.FILE);
	    File file = new File(System.getProperty("user.dir") + "//reports//" + testcase + ".png"); 
	    FileUtils.copyFile(fs,file);
	    
	    return System.getProperty("user.dir") + "//reports//" + testcase + ".png";
		
	}
	
	@BeforeMethod(alwaysRun = true)
	
	public LoginPage launch() throws IOException
	{
		driver = initDriver();
		
		 lp = new LoginPage(driver);
		
		lp.goTo();
		
		return lp;
		
	}
	
	

}

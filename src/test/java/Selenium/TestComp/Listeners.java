package Selenium.TestComp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Selenium.resources.extentReport;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ThreadLocal<ExtentTest> th = new ThreadLocal<ExtentTest>();
 
	ExtentReports ex = extentReport.report();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = ex.createTest(result.getMethod().getMethodName());
		
		th.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		th.get().fail(result.getThrowable());
		String file = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		th.get().addScreenCaptureFromPath(file);
		
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ex.flush();
	}
	
	
	
	

}

package Selenium.resources;

import java.lang.module.ModuleDescriptor.Exports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	
	public static ExtentReports report  ()
	{
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		
		ExtentSparkReporter ex = new ExtentSparkReporter(path);
		ex.config().setReportName("Web Automation Results");
		ex.config().setDocumentTitle("Test Results");
		
		 ExtentReports er = new ExtentReports();
		
		er.attachReporter(ex);
		
		er.setSystemInfo("Tester","Madhav Wadhwa");
		
		return er;
		
		
	}

}

package org.base.comp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.utility.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EngineClass extends BaseClass {

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		driver = new ChromeDriver();
		Htmlreport = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		report = new ExtentReports();
		report.attachReporter(Htmlreport);
		report.setSystemInfo("Tester", "Mohanraj");
			}
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.get(openURL("URL"));
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		report.flush();
		
	}
	
	@AfterSuite(alwaysRun=true)
	 public void afterSuite() {
		driver.close();
	}
}

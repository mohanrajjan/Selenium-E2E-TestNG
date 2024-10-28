package org.utility;

import java.io.File;
import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass extends JavaUtilities {

	public static WebDriver driver;
	public static ExtentSparkReporter Htmlreport= null;
	public static ExtentReports report= null;
	public static ExtentTest test= null;
	
	public static void buttonClick(WebElement element) {
		waitExplicit(element, 2);
		element.click();
		}
	public static void textKey(WebElement element, String value) {

		element.sendKeys(value);

	}

	public static void waitExplicit(WebElement element, int value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOf(element));}
	
	public static String elementText(WebElement element) {

		waitExplicit(element, 5);
		String value = element.getText();
		return value;
	}
	public static void waitImplicit(int value) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
	}
public static String takeScreenshot() {
		
		String location = System.getProperty("user.dir") + "/LoginPage.png";
		try {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File(location);
		
			FileHandler.copy(source, destination);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return location;

	}
     public static String getURL() {

	String value = driver.getCurrentUrl();

	return value;
    }
     public static String messageAlert() {

 		try {
 			Thread.sleep(2000);
 		} catch (Exception e) {
 			
 			e.printStackTrace();
 		}
 		String value = driver.switchTo().alert().getText();
 		driver.switchTo().alert().accept();
 		return value;
 	}




	
	
}

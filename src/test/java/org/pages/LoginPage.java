package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utility.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login2")
	static WebElement loginIcon;

	@FindBy(id = "loginusername")
	static WebElement userName;

	@FindBy(id = "loginpassword")
	static WebElement passWord;

	@FindBy(xpath = "//button[@onclick='logIn()']")
	static WebElement loginSubmit;

	@FindBy(xpath = "//a[@id='nameofuser']")
	static WebElement userText;

	@FindBy(id = "logout2")
	static WebElement logOut;
	
	public void validLogin(String userID, String passwd) {
		waitImplicit(5);
		
		buttonClick(loginIcon);
		waitExplicit(userName, 2);
		textKey(userName, userID);
		textKey(passWord, passwd);
		waitExplicit(loginSubmit, 2);
		buttonClick(loginSubmit);
		
		String Expected="Welcome "+userID;
		String Actual=elementText(userText);
		Assert.assertEquals(Expected,Actual);
		System.out.println(Actual);
		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		buttonClick(logOut);
	}
	
	public void invalidLogin(String userID1, String passwd1) {
		waitImplicit(5);
	
	buttonClick(loginIcon);
	waitExplicit(userName, 2);
	textKey(userName, userID1);
	textKey(passWord, passwd1);
	waitExplicit(loginSubmit, 2);
	buttonClick(loginSubmit);
	String Expected="Welcome "+userID1;
	String Actual=elementText(userText);
	Assert.assertEquals(Expected,Actual);
	}
}

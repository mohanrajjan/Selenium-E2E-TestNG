package org.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import org.base.comp.EngineClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends EngineClass {

	@FindBy (xpath ="//a[@id='signin2']")
	static WebElement signupIcon;
	
	@FindBy (xpath ="//input[@id='sign-username']")
	static WebElement userName;
	
	@FindBy (xpath ="//input[@id='sign-password']")
	static WebElement passWord;
	
	@FindBy (xpath ="//button[@onclick='register()']")
	static WebElement signUpButton;
	
	//PageFactory method 
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void signupFn(String userId, String passKey) {

		waitImplicit(5);
		waitExplicit(signupIcon, 5);
		buttonClick(signupIcon);
		waitExplicit(userName, 5);
		textKey(userName, userId);
		textKey(passWord, passKey);
		waitExplicit(signUpButton, 5);
		buttonClick(signUpButton);
		
		
		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String actual = messageAlert();

		Assert.assertEquals(actual, "Sign up successful.");
		
	}
}
//Sign up successful.
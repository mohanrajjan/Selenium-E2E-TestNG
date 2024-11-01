package org.test.components;

import org.base.comp.EngineClass;
import org.pages.LoginPage;
import org.pages.SignUpPage;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends EngineClass {

	@Test(groups= {"Login","Smoke","Regression"})
	public static void loginTC01() {
		test = report.createTest("loginTc01");
		LoginPage vLog = new LoginPage();
		vLog.validLogin(readingExcel("sheet1", 0, 0),readingExcel("sheet1", 0, 1));
		test.log(Status.PASS, "Login Successful");
	}
	
	@Test(groups="Login")
	public static void loginTC02() {
		test = report.createTest("loginTc01");
		LoginPage vLog = new LoginPage();
		vLog.invalidLogin("Mohan0191", "000");
		test.log(Status.PASS, "Login Successful");
	}
	@Test(groups= { "Regression"})
	public static void signUpTc01() {

		test = report.createTest("SignUpTc01");
		SignUpPage validSignUp = new SignUpPage();

		validSignUp.signupFn("Mohan0526", "pass@123");

		test.log(Status.PASS, "SignUp Successful."); //This user already exist.
                     //SignUp Successful.
	}
}

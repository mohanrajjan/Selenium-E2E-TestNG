package org.test.components;

import org.base.comp.EngineClass;
import org.pages.LoginPage;
import org.pages.SignUpPage;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends EngineClass {

	@Test(groups= {"Smoke","Regression"})
	public static void loginTC01() {
		test = report.createTest("loginTc01");
		LoginPage vLog = new LoginPage();
		vLog.validLogin("Mohan0191","Mohan@123");
		test.log(Status.PASS, "Login Successful");
	}
	
	@Test(groups= {"Smoke", "Regression"})
	public static void signUpTc01() {

		test = report.createTest("SignUpTc01");
		SignUpPage validSignUp = new SignUpPage();

		validSignUp.signupFn("Mohan0526", "pass@123");

		test.log(Status.PASS, "SignUp Successful."); //This user already exist.
                     //SignUp Successful.
	}
}

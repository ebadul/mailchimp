package com.mailchimp.automation.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;

public class LogoutPageTest {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeClass()
	public void setUp() {
		loginPage = new HomePage().clickOnLoginLink();
		dashboardPage = new DashboardPage();
	}

	@Test(priority = 6)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Login | MailChimp - email marketing made easy");
	}

	@Test(priority = 7)
	public void verifyLoginPageText() {
		ArrayList<String> al, al2 = new ArrayList<String>();
		al = loginPage.getLoginPageText();
		al2.add("Log In");
		al2.add("Need a MailChimp account?");
		al2.add("Create an account");
		al2.add("Get started with a free account");
		al2.add("Keep me logged in");
		Assert.assertEquals(al, al2);
	}

	@Test(priority = 8)
	public void verifyLoginWithBlankInfo() {
		String error = loginPage.getloginBlankErrorText();
		System.out.println(error);
		Assert.assertEquals(error, "Whoops\nYou did not enter a username or a password.");
	}

	@Test(priority = 9)
	public void verifyLoginWithOnlyUserName() {
		String error = loginPage.getloginUserNameErrorText();
		System.out.println(error);
		Assert.assertEquals(error,
				"Whoops\nLooks like you forgot your password there, " + loginPage.getUserName() + ".");

	}

	@Test(priority = 10)
	public void verifyLoginWithOnlyPassWord() {
		String error = loginPage.getloginPassWordErrorText();
		System.out.println(error);
		Assert.assertEquals(error, "Whoops\nYou entered a password but not a username.");

	}

	@Test(priority = 11)
	public void verifyLoginActionWithInvalidInfo() {
		String result = loginPage.loginActionWithInvalid_U_P();
		System.out.println(result);
		Assert.assertEquals(result,
				"Sorry, we couldn't find an account with that username. Can we help you recover your username?");
	}

	@Test(priority = 12)
	public void verifyLoginActionWithValid_User() {
		String result = loginPage.loginActionWithValid_User();
		System.out.println(result);
		Assert.assertEquals(result,
				"Whoops\nLooks like you forgot your password there, " + loginPage.getUserName() + ".");
	}

	@Test(priority = 13)
	public void verifyLoginActionWithValid_UP() {
		loginPage.loginAction();
		String mcUser = dashboardPage.getUser();
		System.out.println(mcUser);
		Assert.assertEquals(mcUser, "Root");
	}

	@Test(priority = 14)
	public void verifyLogOut() {
		String logTxt = dashboardPage.logOutAction();
		System.out.println(logTxt);
		Assert.assertEquals(logTxt, "You've been logged out.\nDon't worry, you can log back in below");

	}

	@Test(priority = 15)
	public void verifyForgotUserName() {
		String str = loginPage.clickOnForgotUserName();
		loginPage.clickOnNavigateBack();
		System.out.println(str);
		Assert.assertEquals(str, "Forgot Username | MailChimp - email marketing made easy");
	}

	@Test(priority = 16)
	public void verifyForgotPassWord() {
		String str = loginPage.clickOnForgotPassWord();
		System.out.println(str);
		Assert.assertEquals(str, "Password Reset | MailChimp - email marketing made easy");
	}

	@AfterMethod
	public void tearDown() {

	}

}
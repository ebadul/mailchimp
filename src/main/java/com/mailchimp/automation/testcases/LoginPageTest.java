package com.mailchimp.automation.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class LoginPageTest {
	public LoginPage page;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		page = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void logInPageTitleTest() {
		String expectedTitle="Login | MailChimp - email marketing made easy";
		String actualTitle = page.verifyPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	@Test(priority = 2)
	public void linkCreateAccountTest() {
		String expectedTitle="MailChimp | Signup";
		String actualTitle = page.checkLinkCreateAccount();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	
	@Test(priority = 3)
	public void linkForgetUserNameTest() {
		String expectedTitle="Forgot Username | MailChimp - email marketing made easy";
		String actualTitle = page.checkLinkForgetUserName();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	@Test(priority = 4)
	public void linkForgetPasswordTest() {
		String expectedTitle="Password Reset | MailChimp - email marketing made easy";
		String actualTitle = page.checkLinkForgetPassword();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	
	@Test(priority = 5)
	public void linkLearnAboutToolTest() {
		String expectedTitle="New GDPR Tools Available From MailChimp: Updated Forms, Improved Subscriber Management, and More";
		String actualTitle = page.checkLinkLearnAboutTool();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	@Test(priority = 6)
	public void linkPrivacy() {
		boolean actual = page.checkLinkPrivacy();
		Assert.assertEquals(actual, true);
		
		
	}
	
	@Test(priority = 7)
	public void linkTermTest() {
		boolean actual = page.checkLinkTerms();
		Assert.assertEquals(actual, true);
		
	}
	
	@Test(priority = 8)
	public void linkCookieTest() {
		boolean actual = page.checkLinkCookie();
		Assert.assertEquals(actual, true);
		
	}
	
	@Test(priority = 9)
	public void logInPageLoginTest() {
		
		String name="ronisaha0331";
		String password = "11M@rch1994";
		String actualTitle = page.userLogin(name, password);
		Assert.assertEquals(actualTitle, "MailChimp Dashboard | funny", "Title did not matched");
		
	}
	
	
	
	
	
	@AfterMethod
	public void cleanUp() {
		page.gotoLoginPage();
	}
	
	
	

}

package com.mailchimp.automation.testcases;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.SignUpPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
public class SignUpPageTest {
	
		public SignUpPage page;
		
		public SignUpPageTest() {
			super();
		}
		
		@BeforeSuite
		public void setUp() {
			page = new SignUpPage();
		}
		
		@Test(priority = 0)
		public void signUpPageTitleTest() {
			String expectedTitle="MailChimp | Signup";
			String actualTitle = page.verifySignupTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
			
		}
		
		@Test(priority = 1)
		public void logInLinkTest() {
			String expectedTitle="Login | MailChimp - email marketing made easy";
			String actualTitle = page.loginLinkTest();
			Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
			
		}
		@Test(priority = 2)
		public void signUpTest() {
			String expectedTitle="MailChimp | Success";
			String actualTitle = page.signUp("maichimp.roni475636@gmail.com", "user42234241", "11M@rch1994");
			Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
			
		}

		@AfterMethod
		public void cleanUp() {
			
			page.goSignUpPage();
			
		}
		
		
}

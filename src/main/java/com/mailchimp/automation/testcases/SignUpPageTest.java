package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.SignUpPage;

public class SignUpPageTest {
	SignUpPage signUpPage;

	@BeforeClass
	public void setUp() {
		signUpPage = new HomePage().clickOnSignUp();
	}

	@Test(priority = 3)
	public void verifySignUpWithInvalidEmail() {
		signUpPage.tryToSignUp("faizulcse@@gmail.com", "faizulssddd", "4shared-D");
		signUpPage.clickGetStarted();
		String s1 = signUpPage.getCheckTryMsg();
		String s2 = signUpPage.getEmailErrorMsg();		
		System.out.println(s1);
		System.out.println(s2);
		Assert.assertEquals(s1, "Please check your entry and try again.");
		Assert.assertEquals(s2, "An email address must contain a single @");
		signUpPage.clickRefresh();
	}

	@Test(priority = 4)
	public void verifySignUpWithExistingUser() {
		signUpPage.tryToSignUp("rootnextsqa@@gmail.com", "rootnextsqa", "4shared-D");
		signUpPage.clickGetStarted();
		String s1 = signUpPage.getCheckTryMsg();
		String s2 = signUpPage.getUserErrorMsg();
		System.out.println(s1);
		System.out.println(s2);
		Assert.assertEquals(s1, "Please check your entry and try again.");
		Assert.assertEquals(s2, "Another user with this username already exists. Maybe it's your evil twin. Spooky.");
		signUpPage.clickRefresh();
	}

	@Test(priority = 5)
	public void verifySignUpValidInfo() {
		signUpPage.tryToSignUp("hjzqqlh@gmail.com", "wealqqn5wsw45", "4shared-D");
		String s1 = signUpPage.getPassMsg();
		signUpPage.clickGetStarted();
		String s2 = signUpPage.getDoneMsg();
		System.out.println(s1);
		System.out.println(s2);
		Assert.assertEquals(s1, "Your password is secure and you're all set!");
		Assert.assertEquals(s2, "Check your email!");
		signUpPage.clickRefresh();
	}

	@AfterMethod
	public void tearDown() {

	}
}

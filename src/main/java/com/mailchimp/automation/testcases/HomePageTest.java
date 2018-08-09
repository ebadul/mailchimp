package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.util.*;
import com.mailchimp.automation.pages.*;

public class HomePageTest {
	TestUtil testUtil;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {

		testUtil = new TestUtil();
		homePage = new HomePage();
	}
		
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String actualTitle = homePage.verifyHomePageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Marketing Platform for Small Businesses - Sell More Stuff | MailChimp","Home page title not matched");
	}
		
	@Test(priority=2)
	public void verifyPricingTitleTest(){
		String actualTitle = homePage.clickOnPricingLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Pricing","Title did not matched");
	}
	@Test(priority=3)
	public void verifyFeaturesTitleTest(){
		String actualTitle = homePage.clickOnFeatureLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "MailChimp Features and Marketing Tools","Title did not matched");
	}
	
	@Test(priority=4)
	public void verifyLearningTitleTest(){
		String actualTitle = homePage.clickOnLearningLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Learning Resources - MailChimp","Title did not matched");
	}
	
	@Test(priority=5)
	public void verifyBlogTitleTest(){
		String actualTitle = homePage.clickOnBlogLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "MailChimp's Official Blog","Title did not matched");
	}
	
	@Test(priority=6)
	public void verifyWhatsNewTitleTest(){
		String actualTitle = homePage.clickOnWhatsNewLinkLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "What’s New at MailChimp","Title did not matched");
	}
	
	@Test(priority=7)
	public void verifyLoginTitleTest(){
		homePage.clickOnLoginLink();
		String actualTitle = new LoginPage().verifyPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Login | MailChimp - email marketing made easy","Title did not matched");
	}
	
	@Test(priority=8)
	public void verifySignUpTitleTest(){
		homePage.clickOnSignUpLink();
		String actualTitle = new SignUpPage().verifySignupTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "MailChimp | Signup","Title did not matched");
	}
	
	@Test(priority=9)
	public void verifySupportTitleTest(){
		String actualTitle = homePage.clickOnSupportLink();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Self-Service Support | MailChimp","Title did not matched");
	}
	
	
	@AfterMethod
	public void tearDown(){
		
			homePage.driver.get("https://mailchimp.com/");
	}
}

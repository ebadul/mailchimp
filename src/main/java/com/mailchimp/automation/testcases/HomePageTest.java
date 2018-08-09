package com.mailchimp.automation.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.util.*;
import com.mailchimp.automation.pages.*;

public class HomePageTest {
	TestUtil testUtil;
	HomePage homePage;

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {

		testUtil = new TestUtil();
		homePage = new HomePage();
	}

	// @Test(priority=1)
	@Test
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Marketing Platform for Small Businesses - Sell More Stuff | MailChimp",
				"Home page title not matched");
	}

	@Test
	public void verifyHomeHeaderElement() {

		ArrayList<String> al, al2 = new ArrayList<String>();
		al = homePage.getHomeHeaderElement();

		al2.add("Features");
		al2.add("Pricing");
		al2.add("Support");
		al2.add("Learning");
		al2.add("Blog");
		al2.add("What's New");
		al2.add("Sign Up Free");
		al2.add("Log In");

		System.out.println(al);
		System.out.println(al2);
		Assert.assertEquals(al, al2);
	}

	@AfterMethod
	public void tearDown() {

	}
}

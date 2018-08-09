package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CreateListPage;
import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.LogoutPage;

public class LogoutPageTest {
	public LogoutPageTest() {

	}

	LogoutPage logoutPage;
	DashboardPage dashboardPage;

	@BeforeMethod()
	public void setUp() {

		logoutPage = new DashboardPage().logOutAction(); // create LogoutPage object by logOutAction method from
															// DashboardPage
	}

	// @Test(priority = 4)
	@Test
	public void verifyLogOutSuccessfully() {

		String ss = logoutPage.getLogoutSuccessText();
		System.out.println(ss);
		Assert.assertEquals(ss, "You've been logged out.");
	}

	@AfterMethod
	public void tearDown() {

	}
}

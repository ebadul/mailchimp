package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.LoginPage;

public class DashboardPageTest {

	DashboardPage dashBoard;

	@BeforeMethod()
	public void setUp() {
		dashBoard = new DashboardPage();
	}

	// @Test(priority = 2)
	@Test
	public void verifyDashBoardSuccessfully() {
		String mcUser = dashBoard.getUser();
		System.out.println(mcUser);
		Assert.assertEquals(mcUser, "Root");
	}

	@AfterMethod
	public void tearDown() {

	}

}
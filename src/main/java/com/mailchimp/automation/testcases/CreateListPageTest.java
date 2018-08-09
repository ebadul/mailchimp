package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CreateListPage;
import com.mailchimp.automation.pages.DashboardPage;

public class CreateListPageTest {
	public CreateListPageTest() {
		super();
	}

	CreateListPage createListPage;

	@BeforeMethod()
	public void setUp() {

		createListPage = new DashboardPage().clickOnCreateNewList();
		createListPage.clikOnAddNewList();
	}

	// @Test(priority = 3)
	@Test
	public void verifyCreateNewList() {

		String ss = createListPage.getListCreateSuccessText();
		System.out.println(ss);
		Assert.assertEquals(ss, "Excellent! You have a brand new list.");
	}

	@AfterMethod
	public void tearDown() {

	}

}

package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DeshBoardPage;
import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.SignUpPage;

public class DashBoardListCreate {
	
	public DeshBoardPage page;
	
	public DashBoardListCreate() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		page = new DeshBoardPage();
	}
	
	@Test(priority = 1)
	public void gotoDashBoard() {
		String actualTitle =page.verifyDashboardTitle();
		String expectedTitle = "MailChimp Dashboard | funny";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test(priority = 2)
	public void createNewList() {
		page.createNewList("List of test");
	}
	
	@Test(priority = 3)
	public void createNewTemplate() {
		page.createNewTemplate("New Auto Template1");
	}
	
	@AfterMethod
	public void cleanUp() {
		
	
		
	}

}

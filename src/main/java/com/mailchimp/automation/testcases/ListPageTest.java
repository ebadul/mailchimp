package com.mailchimp.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.mailchimp.automation.pages.DashBoardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.ListPage;
import com.mailchimp.automation.pages.LoginPage;

public class ListPageTest {
	
	
	public DashBoardPage dPage;
	public ListPage page;
	public HomePage hpage;
	public LoginPage lpage;
	
	public ListPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		hpage = new HomePage();
		lpage = hpage.clickOnLoginLink();
		dPage = lpage.userLogin("ronisaha0331", "11M@rch1994");
		page = dPage.goToListPage();
		
	}
	
	
	
	@Test(priority = 1)
	public void createList() {
		page.createNewList("Awasome List");
		
	}
	
	@AfterMethod
	public void cleanUp() {
	
	}

}

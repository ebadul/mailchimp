package com.mailchimp.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CampaignPage;
import com.mailchimp.automation.pages.DashBoardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;

public class CampaignPageTest {
	
	public DashBoardPage dPage;
	public CampaignPage page;
	public HomePage hpage;
	public LoginPage lpage;
	
	public CampaignPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		hpage = new HomePage();
		lpage = hpage.clickOnLoginLink();
		dPage = lpage.userLogin("ronisaha0331", "11M@rch1994");
		page = dPage.goToCampaignPage();
		
	}
	
	
	
	@Test(priority = 1)
	public void createCampaign() {
		page.createNewCampaign("campaign ffrom page");
		
	}
	
	@AfterMethod
	public void cleanUp() {
		
	
		
	}
	
}

package com.mailchimp.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
	
	@BeforeTest
	public void setUp() {
		hpage = new HomePage();
		lpage = hpage.clickOnLoginLink();
		dPage = lpage.userLogin("ronisaha0331", "11M@rch1994");
		page = dPage.goToCampaignPage();
		
	}
	
	
	
	@Test(priority = 1)
	public void createCampaign() {
		page.createNewCampaign("campaign ffriom page");
		
	}
	
	@AfterMethod
	public void cleanUp() {

	}
	
	@AfterTest
	public void GoToHome(){
		
		hpage.driver.get("https://mailchimp.com/");
	}
	
}

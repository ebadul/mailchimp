package com.mailchimp.automation.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashBoardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.SignUpPage;

public class DashBoardPageTest {
	
	public LoginPage loginPage;
	public HomePage hpage;
	public DashBoardPage page;
	public DashBoardPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		hpage = new HomePage();
		loginPage = hpage.clickOnLoginLink();
		page = loginPage.userLogin("ronisaha0331", "11M@rch1994");
	}
	
	@Test(priority = 5)
	public void clickToHelpLink() {
		page.goToHelpPage();
	}
	
	@Test(priority = 0)
	public void checkTitle() {
		String expectedTitle = "MailChimp Dashboard | funny";
		String actualTitle = page.verifyDashboardTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 1)
	public void clickToReport() {
		String expectedTitle = "Reports | MailChimp";
		String actualTitle = page.goToReport();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 2)
	public void clickToListlink() {
		page.goToListPage();
	}
	
	@Test(priority = 3)
	public void clickToCampaignLink() {
		page.goToCampaignPage();
	}

	@Test(priority = 4)
	public void clickToTemplateLink() {
		page.goToTemplatePage();
	}
	
	@Test(priority = 6)
	public void clickToProfile() {
		page.goToProfile();
	}
	
	@Test(priority = 7)
	public void clickToAccount() {
		page.goToAccount();
	}
	
	@Test(priority = 8)
	public void clickToConnectedSite() {
		page.goToConnectedSite();
	}
	
	@Test(priority = 9)
	public void clickToNotification() {
		page.goToNotification();
	}
	
	@Test(priority = 10)
	public void clickToLogout() {
		page.logOut();
	}

	@AfterMethod
	public void cleanUp() {
		
		page.xpath.waitFor(3);
	
		
	}

}

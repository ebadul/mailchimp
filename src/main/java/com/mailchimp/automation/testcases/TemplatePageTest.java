package com.mailchimp.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashBoardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.TemplatePage;

public class TemplatePageTest {
	public DashBoardPage dPage;
	public TemplatePage page;
	public HomePage hpage;
	public LoginPage lpage;
	
	public TemplatePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		hpage = new HomePage();
		lpage = hpage.clickOnLoginLink();
		dPage = lpage.userLogin("ronisaha0331", "11M@rch1994");
		page = dPage.goToTemplatePage();
	}
	
	
	
	@Test(priority = 1)
	public void createList() {
		page.createNewTemplate("Awasome template");
		
	}
	
	@AfterMethod
	public void cleanUp() {
		
	}
	
	@AfterTest
	public void GoToHome(){
		
		hpage.driver.get("https://mailchimp.com/");
	}
}

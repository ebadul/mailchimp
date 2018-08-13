package com.mailchimp.automation.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashBoardPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginPageTest {
	
	public LoginPage page;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		homePage = new HomePage();
		page = homePage.clickOnLoginLink();
		
	}
	
	@Test(priority = 1)
	public void logInPageTitleTest() {
		String expectedTitle="Login | MailChimp - email marketing made easy";
		String actualTitle = page.verifyPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	@Test(priority = 2)
	public void loginElementTextTest() {	
		Assert.assertEquals(page.submitButton.getText(), "Log In", "Text did not matched");
		
	}
	
	@Test(priority = 3)
	public void keepMeLogInElementTextTest() {	
		Assert.assertEquals(page.keepMeLogedIn.getText(), "Keep me logged in", "Text did not matched");
		
	}
	@Test(priority = 4)
	public void needAccountElementTextTest() {	
		Assert.assertEquals(page.needAccountText.getText(), "Need a MailChimp account?", "Text did not matched");
		
	}
	
	@Test(priority = 5)
	public void linkCreateAccountTest() {
		String expectedTitle="MailChimp | Signup";
		String actualTitle = page.checkLinkCreateAccount();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 6)
	public void loginWithBlankInformationTest() {
		page.userLogin("", "");
		String expectedTitle="You did not enter a username or a password.";
		String actualTitle = page.errorMsgForBlankInfo.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 7)
	public void loginWithoutPasswordTest() {
		page.userLogin("ronisaha0331", "");
		String expectedTitle="Looks like you forgot your password there, "+"ronisaha0331"+".";
		String actualTitle = page.errorMsgForBlankPassword.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 8)
	public void loginWithoutUserNameTest() {
		page.userLogin("", "11M@rch1994");
		String expectedTitle="You entered a password but not a username.";
		String actualTitle = page.errorMsgForBlankUserName.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 9)
	public void loginWithWrongInfoTest() {
		page.userLogin("xdweaw4w4xrr4", "11sdfwerw44434M@rch1994");
		String expectedTitle="Sorry, we couldn't find an account with that username. Can we help you recover your username?";
		String actualTitle = page.errorMsgForWrongInfo.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 10)
	public void loginWithValidInfoTest() {
		page.userLogin("ronisaha0331", "11M@rch1994");
		String expectedTitle="MailChimp Dashboard | funny";
		String actualTitle = page.driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
	}
	
	@Test(priority = 11)
	public void logoutFromDashBoardAndForgotUserNameTest() {
		DashBoardPage dpage = page.userLogin("ronisaha0331", "11M@rch1994");
		dpage.logOut();
		String expectedTitle="You've been logged out.Don't worry, you can log back in below";
		String actualTitle = page.errorMsgForLogout1.getText()+page.errorMsgForLogout2.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");	
		
		String expectedTitle1="Forgot Username | MailChimp - email marketing made easy";
		String actualTitle1 = page.checkLinkForgetUserName();
		Assert.assertEquals(actualTitle1, expectedTitle1, "Title did not matched");
		}
	
	@Test(priority = 12)
	public void linkForgetPasswordTest() {
		String expectedTitle="Password Reset | MailChimp - email marketing made easy";
		String actualTitle = page.checkLinkForgetPassword();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	
	@Test(priority = 13)
	public void validUserWrongPasswordTest() {
		page.userLogin("ronisaha0331", "11M@rch41994");
		String expectedTitle="Sorry, that password isn't right. We can help you recover your password.";
		String actualTitle = page.errorMsgForValidUserWrongPassword.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	
	
	
	/*
	@Test(priority = 3)
	public void linkForgetUserNameTest() {
		String expectedTitle="Forgot Username | MailChimp - email marketing made easy";
		String actualTitle = page.checkLinkForgetUserName();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	@Test(priority = 4)
	public void linkForgetPasswordTest() {
		String expectedTitle="Password Reset | MailChimp - email marketing made easy";
		String actualTitle = page.checkLinkForgetPassword();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
		
	}
	
	
	@Test(priority = 5)
	public void linkPrivacy() {
		boolean actual = page.checkLinkPrivacy();
		Assert.assertEquals(actual, true);
		
		
	}
	
	@Test(priority = 6)
	public void linkTermTest() {
		boolean actual = page.checkLinkTerms();
		Assert.assertEquals(actual, true);
		
	}
	
	@Test(priority = 7)
	public void linkCookieTest() {
		boolean actual = page.checkLinkCookie();
		Assert.assertEquals(actual, true);
		
	}
	*/
	
	

	@AfterMethod
	public void cleanUp() {
		page.gotoLoginPage();
	}
	
	@AfterTest
	public void GoToHome(){
		
		homePage.driver.get("https://mailchimp.com/");
	}

}

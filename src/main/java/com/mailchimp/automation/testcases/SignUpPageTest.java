package com.mailchimp.automation.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
public class SignUpPageTest {
	
		public SignUpPage page;
		HomePage homePage;
		
		public SignUpPageTest() {
			super();
		}
		
		@BeforeTest
		public void setUp() {
			page = new SignUpPage();
			homePage = new HomePage();
			page = homePage.clickOnSignUpLink();
		}
		
		@Test(priority = 0)
		public void signUpPageTitleTest() {
			String expectedTitle="MailChimp | Signup";
			String actualTitle = page.verifySignupTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
			
		}
		
		@Test(priority = 1)
		public void logInLinkTest() {
			String expectedTitle="Login | MailChimp - email marketing made easy";
			String actualTitle = page.loginLinkTest();
			Assert.assertEquals(actualTitle, expectedTitle, "Title did not matched");
			
		}
		
		@Test(priority = 3)
		public void signUp_With_Invalid_Email_Test() {
			page.signUp("maichimproni4", "user422342342343242241", "11M@rch1994");
			String errorTopActualTop = page.getErrorTopMsg();
			String errorTopActualEmail = page.getErrorEmailMsg();
			
			boolean msg1Test = errorTopActualTop.equalsIgnoreCase("Please check your entry and try again.");
			boolean msg2Test = errorTopActualEmail.equalsIgnoreCase("An email address must contain a single @");
			
			if(msg1Test&msg2Test)
			{
				System.out.println("Test Passed");
			}
			
		}
		
		
		
		
		@Test(priority = 4)
		public void signUp_With_Invalid_Email_And_Existing_UserName_Test() {
			page.driver.navigate().refresh();
			page.signUp("maichimproni4", "ronisaha0331", "11M@rch1994");
			String errorTopActualTop = page.getErrorTopMsg();
			String errorTopActualEmail = page.getErrorUserNameMsg();
			
			boolean msg1Test = errorTopActualTop.equalsIgnoreCase("Please check your entry and try again.");
			boolean msg2Test = errorTopActualEmail.equalsIgnoreCase("Another user with this username already exists. Maybe it's your evil twin. Spooky.");
			
			if(msg1Test&msg2Test)
			{
				System.out.println("Test Passed");
			}
			
		}
		
		
		@Test(priority = 5)
		public void signUp_With_Valid_Email_And_UserName_Test() {
			page.driver.navigate().refresh();
			String msg = page.signUp("maichimp.roni15ygg201@gmail.com", "ronisa980ha33185676", "11M@rch1994");
			boolean msg1Test = msg.equalsIgnoreCase("Your password is secure and you're all set!");
			page.getStarted.click();
			boolean msg2 = page.successMsg.getText().equalsIgnoreCase("Check your email!");
		
			if(msg1Test & msg2)
			{
				System.out.println("Test Passed");
			}
			
		}
		
		

		@AfterMethod
		public void cleanUp() {
			
			page.goSignUpPage();
			
		}
		
		@AfterTest
		public void GoToHome(){
			
				homePage.driver.get("https://mailchimp.com/");
		}
		
}

package com.mailchimp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class SignUpPage extends PageBase{
	

	
	CustomeXpath xpath;
	HomePage homePage;
	

	// Initializing the Page Objects:
		public SignUpPage() {
			super();
			PageFactory.initElements(driver, this);
			xpath =new CustomeXpath();
			homePage = new HomePage();
			homePage.signUpLink.click();
			
		}
		
		
		public String verifySignupTitle(){
			return driver.getTitle();
		}
		
		public String signUp(String email, String userName, String password) {
			try {
				WebElement emailElement = xpath.selectItemByTagContain("input", "id", "email");
				WebElement userNameElement = xpath.selectItemByTagContain("input", "id", "new_username");
				WebElement passWordElement = driver.findElement(By.id("new_password"));
				emailElement.sendKeys(email);
				userNameElement.sendKeys(userName);
				passWordElement.sendKeys(password);
				
				WebElement submitButton = xpath.selectItemByTagContain("button", "id", "create-account");
				xpath.waitSomeSec(3, submitButton);		
				submitButton.click();
				return driver.getTitle();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		
		
		public void goSignUpPage() {
			driver.get("https://login.mailchimp.com/signup/");
			
		}
	
	
		public String loginLinkTest() {
			xpath.selectItemByText("a", "Log in").click();
			
			return driver.getTitle();
			
		}
		
		public void driverClose()
		{
			driver.close();
		}
		
}

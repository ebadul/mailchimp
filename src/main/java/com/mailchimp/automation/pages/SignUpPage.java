package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class SignUpPage extends PageBase{
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement linkToLogIn;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailElement;
	
	@FindBy(xpath = "//input[@id='new_username']")
	WebElement userNameElement;
	
	@FindBy(xpath = "//input[@id='new_password']")
	WebElement passWordElement;
	
	@FindBy(xpath = "//button[@id='create-account']")
	WebElement submitButton;
	
	CustomeXpath xpath;
	HomePage homePage;
	
		public SignUpPage() {
			super();
			PageFactory.initElements(driver, this);
			xpath =new CustomeXpath();	
		}
		
		
		public String verifySignupTitle(){
			return driver.getTitle();
		}
		
		public String signUp(String email, String userName, String password) {
			try {
				emailElement.sendKeys(email);
				userNameElement.sendKeys(userName);
				passWordElement.sendKeys(password);
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
			linkToLogIn.click();
			return driver.getTitle();
			
		}
		
		public void driverClose()
		{
			driver.close();
		}
		
}

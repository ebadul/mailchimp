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
	
	@FindBy(xpath = "//li[contains(text(),'Please check your entry and try again.')]")
	WebElement errorMsgTop;
	
	@FindBy(xpath = "//span[@class='invalid-error']")
	WebElement errorMsgEmail;
	
	@FindBy(xpath = "//span[contains(text(),'Another user with this username already exists. Ma')]")
	WebElement errorMsgUserName;
	
	@FindBy(xpath = "//h4[contains(text(),\"Your password is secure and you're all set!\")]")
	WebElement readyToGoMsg;
	
	@FindBy(xpath = "//button[@id='create-account']")
	public WebElement getStarted;
	
	@FindBy(xpath = "//h1[@class='!margin-bottom--lv3 no-transform center-on-medium']")
	public WebElement successMsg;
	
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
				emailElement.clear();
				emailElement.sendKeys(email);
				userNameElement.clear();
				userNameElement.sendKeys(userName);
				passWordElement.clear();
				passWordElement.sendKeys(password);
				xpath.waitSomeSec(5, readyToGoMsg);		
				String msg = getrReadyToGoMsg();
				xpath.waitSomeSec(3, submitButton);		
				submitButton.click();
				return msg;
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
		
		public String getErrorTopMsg() {
			return errorMsgTop.getText();
		}
		
		public String getErrorEmailMsg() {
			return errorMsgEmail.getText();
		}
		
		public String getErrorUserNameMsg() {
			return errorMsgUserName.getText();
		}
		
		public String getrReadyToGoMsg() {
			return readyToGoMsg.getText();
		}
		
		public void driverClose()
		{
			driver.close();
		}
		
}

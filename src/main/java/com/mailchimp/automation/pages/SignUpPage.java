package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends PageBase {
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']") WebElement emailName;
	@FindBy(xpath="//input[@id='new_username']") WebElement userName;
	@FindBy(xpath="//input[@id='new_password']") WebElement userPass;
	@FindBy(xpath="//h4[contains(text(),\"Your password is secure and you're all set!\")]") WebElement passMsg;
	@FindBy(xpath="//label[@title='Show Password']") WebElement showPass;
	@FindBy(xpath="//button[@id='create-account']") WebElement getStartedBtn;
	@FindBy(xpath="//li[contains(text(),'Please check your entry and try again.')]") WebElement checkTryMsg;
	@FindBy(xpath="//span[contains(text(),'Another user with this username already exists. Ma')]") WebElement userErrorMsg;
	@FindBy(xpath="//span[@class='invalid-error']") WebElement emailErrorMsg;
	@FindBy(xpath="//h1[@class='!margin-bottom--lv3 no-transform center-on-medium']") WebElement doneMsg;
	
	public String getPassMsg() {
		return passMsg.getText();
	}
	
	public String getCheckTryMsg() {
		return checkTryMsg.getText();
	}
	
	public String getEmailErrorMsg() {
		return emailErrorMsg.getText();
	}
	public String getUserErrorMsg() {
		return userErrorMsg.getText();
	}
	public String getDoneMsg() {
		return doneMsg.getText();
	}
	
	public void clickRefresh() {
		driver.get("https://login.mailchimp.com/signup/");		
	}
	
	public void clickGetStarted() {
		getStartedBtn.click();
	}
	
	public void tryToSignUp(String email, String user, String passWord) {
		emailName.clear();
		emailName.sendKeys(email);
		userName.clear();
		userName.sendKeys(user);
		userPass.clear();
		userPass.sendKeys(passWord);
	}
	
	public void clickOnGetStarted() {
		getStartedBtn.click();
	}
}

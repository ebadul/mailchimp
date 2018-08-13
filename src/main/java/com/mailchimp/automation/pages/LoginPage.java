package com.mailchimp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class LoginPage extends PageBase {
	
	
	CustomeXpath xpath;
	HomePage homePage;
	SignUpPage signupPage;
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
		homePage = new HomePage();
		homePage.loginLink.click();
	}

	public String verifyPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public void gotoLoginPage() {
		driver.get("https://login.mailchimp.com/");
	}

	public String userLogin(String userName, String password) {

		try {
			WebElement userNameElement = xpath.selectItemByTagContain("input", "id", "username");
			WebElement passWordElement = driver.findElement(By.id("password"));
			WebElement submitButton = xpath.selectItemByTagContain("button", "value", "log in");
			
			userNameElement.sendKeys(userName);
			passWordElement.sendKeys(password);
			submitButton.click();
			
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String checkLinkCreateAccount() {
		try {
			//WebElement element =  xpath.selectItemByTagContain("a", "title", "Signup for a MailChimp account");
			WebElement element =  driver.findElement(By.linkText("Create an account"));
			element.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String checkLinkForgetUserName() {
		try {
			WebElement element =  xpath.selectItemByText("a", "Forgot username?");
			element.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String checkLinkForgetPassword() {
		try {
			WebElement element =  xpath.selectItemByText("a", " Forgot password?");
			element.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkLinkCookie() {
		try {
			WebElement element =  xpath.selectItemByText("a", "Cookie Preferences");
			element.click();
			WebElement elementPopUp =  xpath.selectItemByTagContain("div", "id", "optanon-popup-body");
			return elementPopUp.isDisplayed();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkLinkPrivacy() {
		try {
			WebElement element =  xpath.selectItemByText("a", "Privacy");
			element.click();
			String url = driver.getCurrentUrl();
			driver.get(url);
			
			// focusing to new tab
			driver = this.changedriverFocus(driver);
			
			WebElement elementVerify =  xpath.selectItemByText("a", "Legal");
			xpath.waitSomeSec(5, elementVerify);
			return elementVerify.isDisplayed();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkLinkTerms() {
		try {
			WebElement element =  xpath.selectItemByText("a", "Terms");
			element.click();
			String url = driver.getCurrentUrl();
			driver.get(url);
			
			// focusing to new tab
			driver = this.changedriverFocus(driver);
			
			WebElement elementVerify =  xpath.selectItemByText("h2", "Terms of Use");		
			xpath.waitSomeSec(5, elementVerify);
			return elementVerify.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public String checkLinkLearnAboutTool() {
		try {
			WebElement element =  xpath.selectItemByTagContain("a", "id", "billboard-cta-button");
			element.click();
			String url = driver.getCurrentUrl();
			driver.get(url);
			
			// focusing to new tab	
			driver = this.changedriverFocus(driver);	
			
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public WebDriver changedriverFocus(WebDriver dvr) {
		String currentWindow = driver.getWindowHandle();
		for (String handle : dvr.getWindowHandles()) {
		    if (!handle.equals(currentWindow)) {
		        driver.switchTo().window(handle);
		    }
		}
		return driver;
	}
	
	
	

}

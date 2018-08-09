package com.mailchimp.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class LoginPage extends PageBase {

	HomePage homePage;
	SignUpPage signupPage;
	CustomeXpath xpath;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameElement;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWordElement;
	
	@FindBy(xpath = "//button[@value='log in']")
	WebElement submitButton;
	
	@FindBy(xpath = "//a[@title='Signup for a MailChimp account']")
	WebElement linkToCreateAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	WebElement linkToForgetPassword;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot username?')]")
	WebElement linkToForgetUserName;
	
	@FindBy(xpath = "//a[@id='dijit__WidgetBase_1']")
	WebElement linkToCheckCookie;
	
	@FindBy(xpath = "//div[@id='optanon-popup-top']")
	WebElement elementPopUp;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy')]")
	WebElement linkToCheckPrivacy;
	
	@FindBy(xpath = "//a[@class='cta-link']")
	WebElement linkToCheckPrivacyPage;
	
	@FindBy(xpath = "//a[contains(text(),'Terms')]")
	WebElement linkToCheckTerm;
	
	@FindBy(xpath = "//h2[contains(text(),'Terms of Use')]")
	WebElement linkToCheckTermPage;

	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath = new CustomeXpath();
	}

	public String verifyPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public void gotoLoginPage() {
		driver.get("https://login.mailchimp.com/");
	}

	public DashBoardPage userLogin(String userName, String password) {

		try {
			userNameElement.sendKeys(userName);
			passWordElement.sendKeys(password);
			submitButton.click();
			return new DashBoardPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String checkLinkCreateAccount() {
		try {
			linkToCreateAccount.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String checkLinkForgetUserName() {
		try {
			linkToForgetUserName.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public String checkLinkForgetPassword() {
		try {
			linkToForgetPassword.click();
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkLinkCookie() {
		try {
			linkToCheckCookie.click();
			return elementPopUp.isDisplayed();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkLinkPrivacy() {
		try {
			linkToCheckPrivacy.click();
			String url = driver.getCurrentUrl();
			driver.get(url);
			
			// focusing to new tab
			driver = this.changedriverFocus(driver);
			xpath.waitSomeSec(5, linkToCheckPrivacyPage);
			return linkToCheckPrivacyPage.isDisplayed();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkLinkTerms() {
		try {
			linkToCheckTerm.click();
			String url = driver.getCurrentUrl();
			driver.get(url);
			
			// focusing to new tab
			driver = this.changedriverFocus(driver);		
			xpath.waitSomeSec(5, linkToCheckTermPage);
			return linkToCheckTermPage.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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

package com.mailchimp.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

	@FindBy(partialLinkText = "About MailChimp")
	WebElement aboutLink;
	
	@FindBy(partialLinkText = "Sign Up Free")
	WebElement signUpLink;
	
	@FindBy(partialLinkText = "Log In")
	WebElement loginLink;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);

	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public void scrollToAboutLink(){
		Actions actions = new Actions(driver);
        actions.moveToElement(aboutLink);
        //actions.build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	public AboutPage clickOnAboutLink(){
		waitFor(3);
		aboutLink.click();
		
		return new AboutPage();
	}
	
	public SignUpPage clickOnSignUpLink(){
		waitFor(3);
		signUpLink.click();
		return new SignUpPage();
	}
	public LoginPage clickOnLoginLink(){
		waitFor(3);
		loginLink.click();
		return new LoginPage();
	}
	
}

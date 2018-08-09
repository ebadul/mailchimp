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
	
	@FindBy(partialLinkText = "Pricing")
	WebElement pricingLink;
	
	@FindBy(partialLinkText = "Features")
	WebElement featureLink;
	
	@FindBy(partialLinkText = "Support")
	WebElement supportLink;
	
	@FindBy(partialLinkText = "Learning")
	WebElement learningLink;
	
	@FindBy(partialLinkText = "Blog")
	WebElement blogLink;
	
	@FindBy(xpath = "//a[@class='item whatsNewNavUnvisited']")
	WebElement whatsNewLink;
	
	// Initializing the Page Objects:
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void goToHomePage() {
		driver.get("https://mailchimp.com");
	}
	
	public String clickOnLearningLink(){
		waitFor(3);
		learningLink.click();
		return driver.getTitle();
	}

	public String clickOnBlogLink(){
		waitFor(3);
		blogLink.click();
		return driver.getTitle();
	}
	public String clickOnWhatsNewLinkLink(){
		waitFor(3);
		whatsNewLink.click();
		return driver.getTitle();
	}
	public String clickOnPricingLink(){
		waitFor(3);
		pricingLink.click();
		return driver.getTitle();
	}
	public String clickOnFeatureLink(){
		waitFor(3);
		featureLink.click();
		return driver.getTitle();
	}
	public String clickOnSupportLink(){
		waitFor(3);
		supportLink.click();
		return driver.getTitle();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public void scrollToAboutLink(){
		Actions actions = new Actions(driver);
        actions.moveToElement(aboutLink);
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

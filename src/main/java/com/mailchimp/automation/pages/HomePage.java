package com.mailchimp.automation.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

	//Initializing the Page Objects:	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Features')]")WebElement featureLink;
	@FindBy(xpath="//a[contains(text(),'Pricing')]")WebElement pricingLink;
	@FindBy(xpath="//a[contains(text(),'Support')]")WebElement supportLink;
	@FindBy(xpath="//a[contains(text(),'Learning')]")WebElement learningLink;
	@FindBy(xpath="//a[contains(text(),'Blog')]")WebElement blogLink;
	@FindBy(xpath="//a[@class='item whatsNewNavUnvisited']")WebElement whatNewLink;
	@FindBy(xpath="//a[@class='btn-small pop']")WebElement signUpLink;
	@FindBy(xpath="//a[contains(text(),'Log In')]")WebElement logInLink;
	@FindBy(xpath="//a[contains(text(),'About MailChimp')]")WebElement aboutLink;
	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public ArrayList<String> getHomePageHeaderText() {
		
		ArrayList<String> arrayList =new ArrayList<String>();
		waitFor(2);
		arrayList.add(featureLink.getText());
		arrayList.add(pricingLink.getText());
		arrayList.add(supportLink.getText());
		arrayList.add(learningLink.getText());
		arrayList.add(blogLink.getText());
		arrayList.add(whatNewLink.getText());
		arrayList.add(signUpLink.getText());
		arrayList.add(logInLink.getText());	
		return arrayList;
	}
	
	public SignUpPage clickOnSignUp() {
		signUpLink.click();
		return new SignUpPage();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void scrollToAboutLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutLink);
		// actions.build().perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}

	public AboutPage clickOnAboutLink() {
		waitFor(3);
		aboutLink.click();
		return new AboutPage();
	}

	public LoginPage clickOnLoginLink() {
		driver.get("https://mailchimp.com");
		waitFor(1);
		logInLink.click();
		return new LoginPage();
	}
	
}

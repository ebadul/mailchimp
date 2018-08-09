package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class TemplatePage extends PageBase{
	
	@FindBy(xpath = "//a[@class='add-btn button p0']")
	WebElement createTemplate;
	
	@FindBy(xpath = "//a[@title='Selected Sell Products']")
	WebElement createTemplateTheme;
	
	@FindBy(xpath = "//span[@class='step-details nowrap']")
	WebElement saveAndExit;
	
	@FindBy(xpath = "//input[@id='template-name']")
	WebElement template;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement save;
	
	CustomeXpath xpath;
	Actions actions = new Actions(driver);

	public TemplatePage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
	}
	

	public void createNewTemplate(String templateName) {
		createTemplate.click();
		xpath.waitSomeSec(5,createTemplateTheme );
		createTemplateTheme.click();
		xpath.waitSomeSec(15,saveAndExit );
		saveAndExit.click();
		xpath.waitSomeSec(10,template );
		template.sendKeys(templateName);
		xpath.waitSomeSec(15,save);
		save.click();
	}
	
	
}

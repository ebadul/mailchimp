package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class TemplatePage extends PageBase{
	CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public TemplatePage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();

	}
	
	
	

public void createNewTemplate(String templateName) {
		
		WebElement createTemplate = xpath.selectItemByText("a","Create Template");
		createTemplate.click();
		
		WebElement createTemplate1 = xpath.selectItemByTagContain("a","title", "Selected 1 Column");
		xpath.waitSomeSec(5,createTemplate1 );
		createTemplate1.click();
		
		WebElement saveAndExit = xpath.selectItemByText("span","Save and Exit");
		xpath.waitSomeSec(15,saveAndExit );
		saveAndExit.click();
		
		WebElement template = xpath.selectItemByTagContain("input","id","template-name");
		xpath.waitSomeSec(10,template );
		template.sendKeys(templateName);
		
		WebElement save= xpath.selectItemByText("span","Save");
		xpath.waitSomeSec(15,save);
		save.click();
		
		WebElement checkTemplate= xpath.selectItemByText("a",templateName);
		xpath.waitSomeSec(15,save);

	}
	
	
	
}

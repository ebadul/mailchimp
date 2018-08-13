package com.mailchimp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class DeshBoardPage  extends PageBase{
	CustomeXpath xpath;
	LoginPage page;
	public DeshBoardPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
		page = new LoginPage();
		page.userLogin("ronisaha0331", "11M@rch1994");
		
	}
	
	
	
public void createNewTemplate(String templateName) {
		
		WebElement goToTemplate = xpath.selectItemByText("a","Templates");
		goToTemplate.click();
		
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
	
	
	
	public String verifyDashboardTitle() {
		 return driver.getTitle();
	}
	
	public void createNewList(String listNameString) {
		
		WebElement goToList = xpath.selectItemByText("a","Lists");
		goToList.click();
		
		WebElement createList = xpath.selectItemByText("a","Create List");
		createList.click();
		
		WebElement createList1 = xpath.selectItemByTagContain("a","class", "new-list-button button p0");
		xpath.waitSomeSec(5,createList1 );
		createList1.click();
		
		WebElement listName = xpath.selectItemByTagContain("input","id","name");
		listName.sendKeys(listNameString);
		
		WebElement fromEmail = xpath.selectItemByTagContain("input","id","default-fromemail");
		fromEmail.sendKeys("mailchimp.roni@gmail.com");
		
		WebElement fromName = xpath.selectItemByTagContain("input","id","from_name");
		fromName.sendKeys("Automation Testing Group");
		
		WebElement description = xpath.selectItemByTagContain("textarea","id","description");
		description.sendKeys("You are receiving this email because you are awesome");
		
		WebElement company = xpath.selectItemByTagContain("input","id","company");
		company.sendKeys("Robot Company");
		
		WebElement address1 = xpath.selectItemByTagContain("input","id","address1");
		address1.sendKeys("Mirpur-1");
		
		WebElement city = xpath.selectItemByTagContain("input","id","city");
		city.sendKeys("Dhaka");
		
		WebElement zip = xpath.selectItemByTagContain("input","id","zip");
		zip.sendKeys("1226");
		
		WebElement country = xpath.selectItemByTagContain("table","id","country");
		country.click();
		
		WebElement countryName = xpath.selectItemByText("td","Belarus");
		xpath.waitSomeSec(5, countryName);
		countryName.click();
		
		WebElement newListSave = xpath.selectItemByText("button","Save");
		newListSave.click();
		
		
		
	}
	
	
	
	
	
	

}

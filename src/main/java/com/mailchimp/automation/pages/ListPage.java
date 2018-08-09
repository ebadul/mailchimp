package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class ListPage extends PageBase{
	CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public ListPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();

	}
	
	
public void createNewList(String listNameString) {
		
		WebElement createList = xpath.selectItemByText("a","Create List");
		createList.click();
		
		WebElement createList1 = xpath.selectItemByTagContain("a","class", "new-list-button button p0");
		xpath.waitSomeSec(5,createList1 );
		createList1.click();
		
		WebElement listName = xpath.selectItemByTagContain("input","id","name");
		listName.clear();
		listName.sendKeys(listNameString);
		
		WebElement fromEmail = xpath.selectItemByTagContain("input","id","default-fromemail");
		fromEmail.clear();
		fromEmail.sendKeys("mailchimp.roni@gmail.com");
		
		WebElement fromName = xpath.selectItemByTagContain("input","id","from_name");
		fromName.clear();
		fromName.sendKeys("Automation Testing Group");
		
		WebElement description = xpath.selectItemByTagContain("textarea","id","description");
		description.clear();
		description.sendKeys("You are receiving this email because you are awesome");
		
		WebElement company = xpath.selectItemByTagContain("input","id","company");
		company.clear();
		company.sendKeys("Robot Company");
		
		WebElement address1 = xpath.selectItemByTagContain("input","id","address1");
		address1.clear();
		address1.sendKeys("Mirpur-1");
		
		WebElement city = xpath.selectItemByTagContain("input","id","city");
		city.clear();
		city.sendKeys("Dhaka");
		
		WebElement zip = xpath.selectItemByTagContain("input","id","zip");
		zip.clear();
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

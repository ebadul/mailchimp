package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class ListPage extends PageBase{
	
	@FindBy(xpath = "//a[@id='add-list-btn']")
	WebElement createList;
	
	@FindBy(xpath = "//a[@class='new-list-button button p0']")
	WebElement createList1;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement listName;
	
	@FindBy(xpath = "//input[@id='default-fromemail']")
	WebElement fromEmail;
	
	@FindBy(xpath = "//input[@id='from_name']")
	WebElement fromName;
	
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement description;
	
	@FindBy(xpath = "//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='zip']")
	WebElement zip;
	
	@FindBy(xpath = "//table[@id='country']")
	WebElement country;
	
	@FindBy(xpath = "//td[text()='India']")
	WebElement countryName;
	
	@FindBy(xpath = "//button[@id='new-list-save']")
	WebElement newListSave;
	
	CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public ListPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();

	}
	
	
public void createNewList(String listNameString) {	
		createList.click();		
		xpath.waitSomeSec(5,createList1 );
		createList1.click();	
		listName.clear();
		listName.sendKeys(listNameString);	
		fromEmail.clear();
		fromEmail.sendKeys("mailchimp.roni@gmail.com");	
		fromName.clear();
		fromName.sendKeys("Automation Testing Group");	
		description.clear();
		description.sendKeys("You are receiving this email because you are awesome");		
		company.clear();
		company.sendKeys("Robot Company");		
		address1.clear();
		address1.sendKeys("Mirpur-1");		
		city.clear();
		city.sendKeys("Dhaka");		
		zip.clear();
		zip.sendKeys("1226");		
		country.click();	
		xpath.waitSomeSec(5, countryName);
		countryName.click();
		newListSave.click();
	}

}

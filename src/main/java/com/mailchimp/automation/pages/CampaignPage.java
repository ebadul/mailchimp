package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class CampaignPage extends PageBase{
	
	@FindBy(xpath = "//button[@id='dijit__TemplatedMixin_2']")
	WebElement createCampaign;
	
	@FindBy(xpath = "//p[@class='fwb margin--lv0'][contains(text(),'Email')]")
	WebElement emailCampaign;
	
	@FindBy(xpath = "//fieldset[@id='dijit__TemplatedMixin_8']//input[contains(@name,'name')]")
	WebElement newCampaignName;
	
	@FindBy(xpath = "//div[@id='dijit__WidgetsInTemplateMixin_31']//button[@type='submit'][contains(text(),'Begin')]")
	WebElement beginButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add Recipients')]")
	WebElement addRecipients;
	
	@FindBy(xpath = "//table[@id='dijit_form_Select_1']")
	WebElement chooseList;
	
	@FindBy(xpath = "//td[contains(text(),'funny')]")
	WebElement listName;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveList;
	
	@FindBy(xpath = "//button[contains(text(),'Add From')]")
	WebElement addFrom;
	
	@FindBy(xpath = "//input[@id='from_name']")
	WebElement fromName;
	
	@FindBy(xpath = "//input[@id='from_email']")
	WebElement fromEmail;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveFrom;
	
	@FindBy(xpath = "//button[contains(text(),'Add Subject')]")
	WebElement addSub;
	
	@FindBy(xpath = "//div[@id='EmojiPicker_0']//div[contains(@class,'faux-file')]")
	WebElement addSubject;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveSubject;
	
	@FindBy(xpath = "//button[contains(@class,'c-slatButton button-small p0')]")
	WebElement designEmail;
	
	@FindBy(xpath = "//span[@id='template-container_tablist_templates']")
	WebElement savedTemplate;
	
	@FindBy(xpath = "//label[contains(@title,'Select test for campaign')]")
	WebElement selectSavedTemplate;
	
	@FindBy(xpath = "//span[@id='dijit_form_Button_0_label']")
	WebElement confirmTemplate;
	
	@FindBy(xpath = "//a[@title='Save and Close']")
	WebElement saveAndClose;
	
	@FindBy(xpath = "//button[contains(@class,'c-slatButton button p1')]")
	WebElement sendCampaign;
	
	@FindBy(xpath = "//input[@value='Send Now']")
	WebElement sendNow;
	
	CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public CampaignPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
	}
	
	
public void createNewCampaign(String campaignName) {
		xpath.waitSomeSec(5,createCampaign );
		createCampaign.click();
		
		xpath.waitSomeSec(5,emailCampaign );
		emailCampaign.click();
		
		
		xpath.waitSomeSec(5,newCampaignName );
		newCampaignName.clear();
		newCampaignName.sendKeys(campaignName);
		
		beginButton.click();
		
		xpath.waitSomeSec(5,addRecipients );
		addRecipients.click();
		
		chooseList.click();
		actions.moveToElement(listName);
		xpath.waitSomeSec(5,listName );
		listName.click();
	
		
		actions.moveToElement(saveList);
		actions.perform();
		saveList.click();
		
		xpath.waitFor(3);
		xpath.waitSomeSec(5, addFrom);
		addFrom.click();
		
		fromName.clear();
		fromName.sendKeys("Automation Team");
		
		fromEmail.clear();
		fromEmail.sendKeys("mailchimp.roni1@gmail.com");
		
		xpath.waitFor(2);
		xpath.waitSomeSec(5, saveFrom);
		saveFrom.click();
		
		xpath.waitFor(3);
		addSub.click();
		
		addSubject.clear();
		addSubject.sendKeys("Automated campaign");
		
		actions.moveToElement(saveSubject);
		actions.perform();
		saveSubject.click();
		
		xpath.waitFor(5);
		designEmail.click();
		
		xpath.waitSomeSec(15,savedTemplate );
		savedTemplate.click();
		
		xpath.waitSomeSec(15,selectSavedTemplate );
		selectSavedTemplate.click();
		
		if(confirmTemplate.isDisplayed()) {
			xpath.waitFor(5);
		confirmTemplate.click();
		}
		
		xpath.waitFor(5);
		xpath.waitSomeSec(5,saveAndClose );
		saveAndClose.click();
		
		sendCampaign.click();

		xpath.waitFor(5);
		xpath.waitSomeSec(5,sendNow );
		sendNow.click();
		
	}
	
	

}

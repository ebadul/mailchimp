package com.mailchimp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class CampaignPage extends PageBase{
	CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public CampaignPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();

	}
	
	
public void createNewCampaign(String campaignName) {
//		
//		WebElement goToCampaign = xpath.selectItemByText("a","Campaigns");
//		goToCampaign.click();
//		
		WebElement createCampaign = xpath.selectItemByText("button","Create campaign");
		createCampaign.click();
		
		WebElement emailCampaign = xpath.selectItemByText("p","Email");
		emailCampaign.click();
		
		WebElement newCampaignName = xpath.selectItemByTagContain("input","name", "name");
		xpath.waitSomeSec(5,newCampaignName );
		newCampaignName.clear();
		newCampaignName.sendKeys(campaignName);
		
		WebElement beginButton = xpath.selectItemByText("button","Begin");
		beginButton.click();
		
		WebElement addRecipients = driver.findElement(By.xpath("//button[contains(text(),'Add Recipients')]"));
		xpath.waitSomeSec(5,addRecipients );
		addRecipients.click();
		
		WebElement chooseList = xpath.selectItemByTagContain("table","id","dijit_form_Select_1");
		chooseList.click();
		
		//WebElement listName = xpath.selectItemByTagContain("td","id", "dijit_MenuItem_20_text");
		WebElement listName = xpath.selectItemByText("div","4 subscribed contacts");
		xpath.waitSomeSec(5,listName );
		listName.click();
		xpath.waitFor(5);
		
		//WebElement saveList = driver.findElement(By.xpath("//div[@id='uniqName_6_44']//button[contains(@class,'button p0')][contains(text(),'Save')]"));
		WebElement saveList = xpath.selectItemByTagContain("button", "class", "button p0");
		actions.moveToElement(saveList);
		actions.perform();
		saveList.click();
		
		xpath.waitFor(3);
		WebElement addFrom =driver.findElement(By.xpath("//button[contains(text(),'Add From')]"));
		xpath.waitSomeSec(5, addFrom);
		addFrom.click();
		
		WebElement fromName = xpath.selectItemByTagContain("input","id", "from_name");
		fromName.clear();
		fromName.sendKeys("Automation Team");
		
		WebElement fromEmail = xpath.selectItemByTagContain("input","id", "from_email");
		fromEmail.clear();
		fromEmail.sendKeys("mailchimp.roni1@gmail.com");
		
		WebElement saveFrom = xpath.selectItemByTagContain("button", "class", "button p0");
		xpath.waitFor(3);
		xpath.waitSomeSec(5, saveFrom);
		saveFrom.click();
		//div[@id='uniqName_6_56']//button[contains(@class,'button p0')][contains(text(),'Save')]
		
		xpath.waitFor(3);
		WebElement addSub = driver.findElement(By.xpath("//button[contains(text(),'Add Subject')]"));
		addSub.click();
		
		
		WebElement addSubject = driver.findElement(By.xpath("//div[@id='EmojiPicker_0']//div[contains(@class,'faux-file')]"));
		addSubject.clear();
		addSubject.sendKeys("Automated campaign");
		
		WebElement saveSubject = xpath.selectItemByTagContain("button","class","button p0 ");
		actions.moveToElement(saveSubject);
		actions.perform();
		saveSubject.click();
		
		xpath.waitFor(5);
		WebElement designEmail = driver.findElement(By.xpath("//button[contains(text(),'Design Email')]"));
		designEmail.click();
		

		WebElement savedTemplate = xpath.selectItemByTagContain("span","id", "template-container_tablist_templates");
		xpath.waitSomeSec(15,savedTemplate );
		savedTemplate.click();
		
		WebElement selectSavedTemplate = xpath.selectItemByTagContain("label","title", "Select test for campaign");
		xpath.waitSomeSec(15,selectSavedTemplate );
		selectSavedTemplate.click();
		
		WebElement confirmTemplate = xpath.selectItemByTagContain("span","id", "dijit_form_Button_0_label");
		//xpath.waitSomeSec(5,confirmTemplate );
		if(confirmTemplate.isDisplayed()) {
			xpath.waitFor(5);
		confirmTemplate.click();
		}
		
		xpath.waitFor(5);
		//WebElement saveAndClose = driver.findElement(By.xpath("//a[@title='Save and Close']"));
		WebElement saveAndClose = xpath.selectItemByTagContain("span", "class", "freddicon menu-right on-right");
		xpath.waitSomeSec(5,saveAndClose );
		saveAndClose.click();
		
		WebElement sendCampaign = xpath.selectItemByText("button","Send");
		sendCampaign.click();
		
		
		xpath.waitFor(5);
		WebElement sendNow = xpath.selectItemByTagContain("input", "class", "button p0 confirm-send-button");
		xpath.waitSomeSec(5,sendNow );
		sendNow.click();
		
	}
	
	

}

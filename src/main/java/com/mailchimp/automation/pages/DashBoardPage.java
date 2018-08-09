package com.mailchimp.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class DashBoardPage  extends PageBase{
	
	public CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public DashBoardPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
		
	}
		
	public LoginPage logOut() {
		WebElement  userTab = xpath.selectItemByText("span", "roni");
		userTab.click();
		WebElement logout= xpath.selectItemByTagAndText("a","class","account-link nolink padding--lv3","Log Out");
		logout.click();
		return new LoginPage();	
	}
	
	public String goToReport() {
		WebElement linkReport= xpath.selectItemByText("a","Reports");
		linkReport.click();
		return driver.getTitle();	
	}
	
	public CampaignPage goToCampaignPage() {
		WebElement goToCampaign = xpath.selectItemByText("a","Campaigns");
		goToCampaign.click();
		return new CampaignPage();	
	}
	
	public ListPage goToListPage() {
		WebElement goToList = xpath.selectItemByText("a","Lists");
		goToList.click();
		return new ListPage();	
	}
	
	public TemplatePage goToTemplatePage() {
		WebElement goToTemplate = xpath.selectItemByText("a","Templates");
		goToTemplate.click();
		return new TemplatePage();	
	}
	
	public String verifyDashboardTitle() {
		 return driver.getTitle();
	}
	
	public void goToHelpPage() {
		WebElement goToHelp = xpath.selectItemByText("a","Help");
		goToHelp.click();
		xpath.waitFor(3);
		driver.navigate().refresh();
	}
	
	public void goToNotification() {
		WebElement userTab = xpath.selectItemByText("span", "roni");
		userTab.click();
		WebElement goToNotification = xpath.selectItemByTagAndText("a", "id", "notifications-link","Notifications ");
		xpath.waitSomeSec(5, goToNotification);
		goToNotification.click();
		
		WebElement goToNotificationback = driver.findElement(By.xpath("//div[@class='small-meta sliding-card--sticky padding-top--lv2 padding-bottom--lv2 padding-left--lv3 padding-right--lv3 font-weight--bold alignc flex flex-between']//a[@class='sliding-card--back fwn']"));
		xpath.waitSomeSec(5, goToNotificationback);
		goToNotificationback.click();
		userTab.click();
	}
	
	public void goToProfile() {
		WebElement userTab = xpath.selectItemByText("span", "roni");
		userTab.click();
		WebElement goToprofile = xpath.selectItemByTagAndText("a","class","account-link nolink padding--lv3","Profile");
		xpath.waitSomeSec(5, goToprofile);
		goToprofile.click();
	}
	
	public void goToAccount() {
		WebElement userTab = xpath.selectItemByText("span", "roni");
		userTab.click();
		WebElement goToaccount = xpath.selectItemByTagAndText("a","class","account-link nolink padding--lv3","Account");
		xpath.waitSomeSec(5, goToaccount);
		goToaccount.click();
	}
	
	public void goToConnectedSite() {
		WebElement userTab = xpath.selectItemByText("span", "roni");
		userTab.click();
		WebElement goToconnectedSite = xpath.selectItemByText("div","Connected Sites");
		xpath.waitSomeSec(5, goToconnectedSite);
		goToconnectedSite.click();
	}

}

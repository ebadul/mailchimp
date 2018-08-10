package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailchimp.automation.util.CustomeXpath;

public class DashBoardPage  extends PageBase{
	
	@FindBy(xpath = "//div[contains(@class,'logged-in-avatar inline-block avatar !margin--lv0')]")
	WebElement userTabLink;
	
	@FindBy(xpath = "//a[contains(@class,'account-link nolink padding--lv3')][contains(text(),'Log Out')]")
	WebElement logOutLink;
	
	@FindBy(xpath = "//li[contains(@class,'nav-link hide-mobile')]//a[contains(@title,'Track the outcome of your campaigns')][contains(text(),'Reports')]")
	WebElement linkReport;
	
	@FindBy(xpath = "//li[contains(@class,'nav-link hide-mobile')]//a[contains(@title,'Design and send campaigns')][contains(text(),'Campaigns')]")
	WebElement goToCampaign;
	
	@FindBy(xpath = "//li[contains(@class,'nav-link hide-mobile')]//a[contains(@title,'Create lists, add subscribers, create sign up forms')][contains(text(),'Lists')]")
	WebElement goToList;
	
	@FindBy(xpath = "//li[contains(@class,'nav-link hide-mobile')]//a[contains(@title,'Create and edit reusable email templates')][contains(text(),'Templates')]")
	WebElement goToTemplate;
	
	@FindBy(xpath = "//a[contains(@title,'Get help by referring to the knowledge base articles, answers and glossary')]")
	WebElement goToHelp;
	
	@FindBy(xpath = "//a[@id='notifications-link']")
	WebElement goToNotification;
	
	@FindBy(xpath = "//div[contains(@class,'small-meta sliding-card--sticky padding-top--lv2 padding-bottom--lv2 padding-left--lv3 padding-right--lv3 font-weight--bold alignc flex flex-between')]//span[contains(@class,'freddicon menu-left-on-left')]")
	WebElement goToNotificationback;
	
	@FindBy(xpath = "//a[contains(@class,'account-link nolink padding--lv3')][contains(text(),'Profile')]")
	WebElement goToprofile;
	
	@FindBy(xpath = "//a[contains(@class,'account-link nolink padding--lv3')][contains(text(),'Account')]")
	WebElement goToaccount;
	
	@FindBy(xpath = "//div[@id='dijit__WidgetsInTemplateMixin_0']")
	WebElement goToconnectedSite;
	
	public CustomeXpath xpath;
	Actions actions = new Actions(driver);
	
	public DashBoardPage() {
		super();
		PageFactory.initElements(driver, this);
		xpath =new CustomeXpath();
		
	}
		
	public LoginPage logOut() {
		userTabLink.click();
		logOutLink.click();
		return new LoginPage();	
	}
	
	public String goToReport() {
		linkReport.click();
		return driver.getTitle();	
		
	}
	
	public CampaignPage goToCampaignPage() {
		goToCampaign.click();
		return new CampaignPage();	
	}
	
	public ListPage goToListPage() {
		goToList.click();
		return new ListPage();	
	}
	
	public TemplatePage goToTemplatePage() {
		goToTemplate.click();
		return new TemplatePage();	
	}
	
	public String verifyDashboardTitle() {
		 return driver.getTitle();
	}
	
	public void goToHelpPage() {
		goToHelp.click();
		xpath.waitFor(3);
		driver.navigate().refresh();
	}
	
	public void goToNotification() {
		userTabLink.click();
		xpath.waitSomeSec(5, goToNotification);
		goToNotification.click();
		xpath.waitSomeSec(5, goToNotificationback);
		goToNotificationback.click();
		userTabLink.click();
		
	}
	
	public void goToProfile() {
		userTabLink.click();
		xpath.waitSomeSec(5, goToprofile);
		goToprofile.click();
	}
	
	public void goToAccount() {
		userTabLink.click();
		xpath.waitSomeSec(5, goToaccount);
		goToaccount.click();
	}
	
	public void goToConnectedSite() {
		userTabLink.click();
		xpath.waitSomeSec(5, goToconnectedSite);
		goToconnectedSite.click();
	}

}

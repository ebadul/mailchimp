package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageBase {

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(@class,'inline-block freddicon menu-down margin--lv1 !margin-top-bottom--lv0 !margin-right--lv0')]")
	WebElement userButton;

	@FindBy(xpath = "//a[contains(@class,'account-link nolink padding--lv3')][contains(text(),'Log Out')]")
	WebElement logOutButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[5]/a")
	WebElement listsButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[4]/a")
	WebElement templatesButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[3]/a")
	WebElement campaignsButton;

	@FindBy(xpath = "//*[@id=\"freddielink\"]/img")
	WebElement homeImgButton;

	@FindBy(xpath = "//div/nav[2]/ul/li[3]/a/div[2]/span[1]")
	WebElement currntUser;

	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[1]")
	WebElement logoutTxt;

	public void clickUser() {
		userButton.click();
	}

	public void clickHome() {
		homeImgButton.click();
	}

	public void clickCampaign() {
		campaignsButton.click();
	}

	public void clickTemplate() {
		templatesButton.click();
	}

	public CreateListPage clickOnCreateNewList() {
		listsButton.click();
		return new CreateListPage();
	}

	public String logOutAction() {
		clickUser();
		logOutButton.click();
		return getLogoutTxt();
	}

	public String getLogoutTxt() {
		return logoutTxt.getText();
	}

	public void clickBack() {
		driver.navigate().back();
	}

	public String getUser() {
		return currntUser.getText();
	}

}

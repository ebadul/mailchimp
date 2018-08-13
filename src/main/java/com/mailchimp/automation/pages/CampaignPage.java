package com.mailchimp.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage extends PageBase {
	public CampaignPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Campaigns")
	WebElement campaignTab;

	@FindBy(id = "dijit__TemplatedMixin_2")
	WebElement createCampaignBtn;

	@FindBy(xpath = "//p[@class='fwb margin--lv0'][contains(text(),'Email')]")
	WebElement emailBtn;

	@FindBy(xpath = "//span[@id='dijit_layout_TabContainer_0_tablist_dijit_layout_ContentPane_0']")
	WebElement regularTab;
	
	@FindBy(xpath = "//span[@id='dijit_layout_TabContainer_3_tablist_dijit_layout_ContentPane_33']")
	WebElement automatedTab;

	@FindBy(xpath = "//fieldset[@id='dijit__TemplatedMixin_8']//input[@name='name']")
	WebElement campaignName;

	@FindBy(xpath = "//button[@class='button p0'][contains(text(),'Begin')]")
	WebElement beginBtn;////*[@id="dijit__WidgetsInTemplateMixin_33"]/div/form/div[2]/button

	@FindBy(xpath = "//button[contains(text(),'Add Recipients')]")
	WebElement addReceiptBtn;

	@FindBy(xpath = "//table[@id='dijit_form_Select_1']")
	////table[@id='dijit_form_Select_1']
	WebElement chooseListBtn;

	@FindBy(xpath = "//td[contains(text(),'Testing')]")
	////td[@id='dijit_MenuItem_19_text']
	WebElement chooseList;

	@FindBy(xpath = "//div[@id='uniqName_6_44']//button[contains(text(),'Save')]")
	WebElement saveListBtn;

	@FindBy(xpath = "//button[contains(text(),'Add From')]")
	WebElement addFormBtn;

	@FindBy(xpath = "//input[@id='from_name']")
	WebElement fromName;

	@FindBy(xpath = "//input[@id='from_email']")
	WebElement fromEmail;

	@FindBy(xpath = "//div[@id='uniqName_6_93']//button[contains(text(),'Save')]")
	WebElement saveFromBtn;

	@FindBy(xpath = "//button[contains(text(),'Add Subject')]")
	WebElement addSubBtn;

	@FindBy(xpath = "//div[@id='EmojiPicker_4']//div[@class='faux-file']")
	WebElement subNameText;

	@FindBy(xpath = "//div[@id='EmojiPicker_5']//div[@class='faux-file']")
	WebElement subPreviewText;

	@FindBy(xpath = "//div[@id='uniqName_6_198']//button[contains(@class,'button p0')][contains(text(),'Save')]")
	WebElement saveSubBtn;

	@FindBy(xpath = "//button[contains(@class,'c-slatButton button-small p0')]")
	WebElement designEmailBtn;

	@FindBy(xpath = "//span[@id='template-container_tablist_templates']")
	WebElement savedTempTab;

	@FindBy(xpath = "//label[@title='Select Edited Template']")
	WebElement savedTemp;

	@FindBy(xpath = "//span[@class='display--none@tablet-min']")
	WebElement nextBtn;

	@FindBy(xpath = "//a[@title='Save and Close']")
	WebElement saveAndcloseBtn;

	@FindBy(xpath = "//button[contains(@class,'c-slatButton button p1')]")
	WebElement sendEmailBtn;

	@FindBy(xpath = "//a[contains(text(),'Finish later')]")
	WebElement finishLaterBtn;

	public void clickOnCampaignTab() {
		campaignTab.click();
	}

	public void clickOnCreateCampaign() {
		createCampaignBtn.click();
	}

	public void clickOnEmail() {
		emailBtn.click();
	}

	public void clickOnRegularTab() {
		regularTab.click();
	}

	public void setCampaignName() {
		waitFor(1);
		campaignName.clear();
		waitFor(1);
		campaignName.sendKeys("Automated Campaign");
		waitFor(2);
		beginBtn.click();
		waitFor(1);
	}

	public void clickOnAddReceiptBtn() {
		waitFor(1);
		addReceiptBtn.click();
		waitFor(1);
		chooseListBtn.click();
		waitFor(1);
		chooseList.click();
		waitFor(2);
		saveListBtn.click();
		waitFor(2);
	}

	public void clickOnAddFrom() {
		addFormBtn.click();
		waitFor(2);
		fromName.clear();
		fromName.sendKeys("faizul_islam");
		waitFor(2);
		fromEmail.clear();
		fromEmail.sendKeys("rootnextsqa@gmail.com");
		waitFor(2);
		saveFromBtn.click();
		waitFor(2);
	}

	public void clickOnAddSubject() {
		addSubBtn.click();
		waitFor(2);
		subNameText.sendKeys("Auto Campaign Test");
		waitFor(2);
		subPreviewText.sendKeys("Auto Campaign Test Preview");
		waitFor(2);
	}

	public void clickOnDesignEmail() {
		designEmailBtn.click();
	}

	public void clickOnSavedTemp() {
		savedTempTab.click();
		savedTemp.click();
	}

	public void clickOnTempNextBtn() {
		nextBtn.click();
	}

	public void clickOnSaveAndClose() {
		saveAndcloseBtn.click();
	}

	public void clickOnSendEmailBtn() {
		sendEmailBtn.click();
	}

	public void createAndSendCampaign() {
		clickOnCampaignTab();
		clickOnCreateCampaign();
		waitFor(1);
		clickOnEmail();
		//clickOnRegularTab();
		setCampaignName();
		clickOnAddReceiptBtn();
		clickOnAddFrom();
		clickOnAddSubject();
		clickOnDesignEmail();
		clickOnSavedTemp();
		clickOnTempNextBtn();
		clickOnSaveAndClose();
		clickOnSendEmailBtn();
	}

}

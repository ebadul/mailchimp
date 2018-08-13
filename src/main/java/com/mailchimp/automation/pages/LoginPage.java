package com.mailchimp.automation.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement passWord;
	@FindBy(xpath = "//button[@value='log in']") WebElement loginBtn;////button[@value='log in']
	@FindBy(xpath = "//label[@class='block !padding--lv0']") WebElement checkBoxBtn;
	@FindBy(xpath = "//label[@title='Show Password']") WebElement showPassBtn;
	@FindBy(xpath = "//a[contains(text(),'Forgot username?')]") WebElement forgotUsernameLink;
	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]") WebElement forgotPasswordLink;
	@FindBy(xpath = "//*[@id=\"dijit__WidgetBase_1\"]")	WebElement cookiesPrefLink;
	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[2]/div/p/span/a[1]") WebElement privacyLink;
	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[2]/div/p/span/a[2]") WebElement TermsLink;
	@FindBy(xpath = "//*[@id=\"billboard-cta-button\"]") WebElement theDeal;
	
	@FindBy(xpath = "//h1[@class='text-align--center !margin-bottom--lv3']")WebElement logInTxt;
	@FindBy(xpath = "//a[@title='Signup for a MailChimp account']") WebElement createNewAccntLink;
	@FindBy(xpath = "//span[@class='padding-right--lv1']") WebElement needMcAccTxt;
	@FindBy(xpath = "//label[@for='username']") WebElement userTxt;
	@FindBy(xpath = "//label[contains(@class,'float-left')]") WebElement passTxt;

	@FindBy(xpath = "//h1[@class='no-transform !margin-bottom--lv3 center-on-medium']") WebElement signUpPageTxt;
	@FindBy(xpath = "//*[@id=\"empty-error\"]/div/div/div[2]") WebElement loginBlankErrTxt;
	@FindBy(xpath = "//div[@class='c-mediaBody--centered']//p") WebElement invalidUserErrTxt;
	
	
	
	private String user = "rootnext33";
	private String pass = "4shared-D";
	
	public String getUserName() {
		return "rootnext333";
	}
	public String getPassWord() {
		return "4shared-DD";
	}

	public void clickShowPass() {
		showPassBtn.click();
	}

	public void clickCheckBox() {
		if (!checkBoxBtn.isSelected())
			checkBoxBtn.click();
	}

	public String loginActionWithInvalid_U_P() {
		userName.clear();
		userName.sendKeys(getUserName());
		passWord.clear();
		passWord.sendKeys(getPassWord());
		waitFor(2);
		showPassBtn.click();
		clickCheckBox();		
		loginBtn.click();
		return invalidUserErrTxt.getText();
	}
		
	
	public void loginAction() {
		driver.navigate().refresh();
		userName.clear();
		userName.sendKeys(user);
		passWord.clear();
		passWord.sendKeys(pass);
		waitFor(2);
		showPassBtn.click();
		clickCheckBox();		
		loginBtn.click();
	}
	
	public String loginActionWithValid_User() {
		driver.navigate().refresh();
		userName.clear();
		userName.sendKeys(user);
		passWord.clear();
		passWord.sendKeys(getPassWord());
		waitFor(2);
		showPassBtn.click();
		clickCheckBox();		
		loginBtn.click();
		waitFor(2);
		return loginBlankErrTxt.getText();
	}
	
	
	
	public String getloginBlankErrorText() {
		userName.clear();
		passWord.clear();	
		loginBtn.click();
		return loginBlankErrTxt.getText();
	}
	
	public String getloginUserNameErrorText() {
		driver.navigate().refresh();
		userName.clear();
		userName.sendKeys(getUserName());	
		passWord.clear();
		loginBtn.click();
		waitFor(1);
		return loginBlankErrTxt.getText();
	}
		
	public String getloginPassWordErrorText() {
		driver.navigate().refresh();
		passWord.clear();
		passWord.sendKeys(getPassWord());	
		loginBtn.click();
		waitFor(1);
		return loginBlankErrTxt.getText();
	}
	
	public ArrayList<String> getLoginPageText() {
		
		ArrayList<String> arrayList =new ArrayList<String>();
		arrayList.add(logInTxt.getText());
		arrayList.add(needMcAccTxt.getText());
		arrayList.add(createNewAccntLink.getText());
		createNewAccntLink.click();
		arrayList.add(signUpPageTxt.getText());
		driver.navigate().back();
		arrayList.add(checkBoxBtn.getText());
		return arrayList;
	}

	
	public void clickOnNavigateBack() {
		driver.navigate().back();
	}
	
	public String clickOnForgotUserName() {
		forgotUsernameLink.click();
		return driver.getTitle();
	}
	
	public String clickOnForgotPassWord() {
		forgotPasswordLink.click();
		return driver.getTitle();
	}
	
	public void checkOnLoginPageLink() {
		createNewAccntLink.click();
		driver.navigate().back();

		forgotUsernameLink.click();
		driver.navigate().back();

		forgotPasswordLink.click();
		driver.navigate().back();

		cookiesPrefLink.click();
		driver.navigate().back();

		privacyLink.click();
		driver.navigate().back();

		TermsLink.click();
		driver.navigate().back();

	}

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

}

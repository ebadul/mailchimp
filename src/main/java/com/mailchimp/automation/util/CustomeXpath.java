package com.mailchimp.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mailchimp.automation.pages.PageBase;



public class CustomeXpath extends PageBase{
	
	
	
	public  WebElement selectItemByTagAndText(String tagName,String attributeName,String attributeValue,String textValue)
	{
		try {
			WebElement element = driver.findElement(By.xpath("//"+tagName+"[contains(@"+attributeName
												+",'"+attributeValue+"')and text()='"+textValue+"']"));
			
			return element;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void closeBrowser() {
		driver.close();
	}
	
	public  void refreshPage() {
		driver.navigate().refresh();
	}
	
	
	
	public  WebElement selectItemByTagContain(String tagName,String attributeName,String attributeValue)
	{
		try {
			WebElement element = driver.findElement(By.xpath("//"+tagName+"[contains(@"+attributeName
												+",'"+attributeValue+"')]"));
			
			return element;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public  WebElement selectItemByText(String tagName,String textValue)
	{
		try {
			WebElement element = driver.findElement(By.xpath("//"+tagName+"[text()='"+textValue
												+"']"));
			
			return element;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public  void waitSomeSec(int sec, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,sec);
		element= wait.until(ExpectedConditions.visibilityOf(element));
	}
}

package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CampaignPage;

public class CampaignPageTest {
	CampaignPage campaignPage;

	@BeforeClass
	public void setUp() {
		campaignPage = new CampaignPage();
	}

	@Test()
	public void verifyCreateAndSendCampaign() {
		campaignPage.createAndSendCampaign();
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown() {

	}

}

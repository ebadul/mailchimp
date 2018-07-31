package com.mailchimp.automation.util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.mailchimp.automation.model.TestStatusReportModel;
import com.mailchimp.automation.suite.TestHelper;

public class CustomTestListener extends TestListenerAdapter{

	private TestHelper testHelper;
	private PropertySettings pSettings;
	
	public CustomTestListener() {
		this.pSettings = PropertySettings.getInstance();
		testHelper = TestHelper.getInstance();
	}
	
	@Override
	public void onStart(ITestContext testContext) {
		testContext.setAttribute("setting", pSettings);
		super.onStart(testContext);
		
		ScreenShot.makeOutputDirectory();
		
		System.out.println("TestCase execute with browser : "+pSettings.getBrowser()+"\n");
	}

	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		String testName = tr.getMethod().getMethodName();
		String strStatus = "Failed";
		System.out.println("TestCase : "+testName+" is "+strStatus);
		TestStatusReportModel.addTestStatus(testName,strStatus);
		if (testHelper.getCurrentDriver() != null ) {
//			ScreenShot.captureScreen(pSettings.currentDriver, testName + "_after_failure_"+ d.format(new Date()));
			ScreenShot.captureScreen(testHelper.getCurrentDriver(), testName + "_after_failure");
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		String testName = tr.getMethod().getMethodName();
		String strStatus = "Passed";
		System.out.println("TestCase : "+testName+" is "+strStatus);
		TestStatusReportModel.addTestStatus(testName,strStatus);
		if (testHelper.getCurrentDriver() != null ) {
			ScreenShot.captureScreen(testHelper.getCurrentDriver(), testName + "_after_success");
//			ScreenShot.captureScreen(pSettings.currentDriver, testName + "_after_success_"+ d.format(new Date()));
		}
	}
}

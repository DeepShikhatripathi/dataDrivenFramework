package com.goibibo.testScripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObject.LandingPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShots;
import com.goibibo.utilities.Excell;

public class TC001 {

	WebDriver browser;
	ArrayList<String> data;

	@BeforeMethod(groups = {"smoke" , "regration"})
	public void setUp() throws Exception {
		browser = BrowserObject.get(ObjectRepository.browserName);
		browser.get(ObjectRepository.url);
		data = Excell.getRowData("TC001", 1);
	}

	@AfterMethod(groups = {"smoke", "regration"})
	public void tearDown(ITestResult testResult) throws Exception {
		
		if(testResult.getStatus() == ITestResult.FAILURE) {
			 CaptureScreenShots.asFile(browser, testResult.getName());
			
		}
		browser.close();
	}

	@Test(groups = {"smoke" , "regration"})
	public void defaulPageIsFlightSearch() {

		Assert.assertEquals(LandingPage.getHeaderText(browser),data.get(0));
	}
}

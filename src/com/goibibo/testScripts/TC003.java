package com.goibibo.testScripts;

import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObject.LandingPage;
import com.goibibo.pageObject.SearchResults;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShots;
import com.goibibo.utilities.Excell;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TC003 {
	
	WebDriver browser;
	ArrayList<String> data;

  @Test(groups = {"smoke"})
  public void searchReturnsNoResults() {
	  LandingPage.enterSourceCity(browser, data.get(0));
	  LandingPage.enterDestinationCity(browser, data.get(1));
	  LandingPage.selectDate(browser, data.get(2));
	  LandingPage.clickSearch(browser);
	 Assert.assertFalse(SearchResults.checkResultsAreShown(browser));
  }

  @BeforeMethod(groups = {"smoke"})
  
	  public void setup() throws Exception {
			browser = BrowserObject.get(ObjectRepository.browserName);
			browser.get(ObjectRepository.url);
			data = Excell.getRowData("TC003", 1);
		}

  

  @AfterMethod(groups = {"smoke"})
  
	  
	  public void tearDown(ITestResult testResult) throws Exception {
	  if(testResult.getStatus() == ITestResult.FAILURE) {
			 CaptureScreenShots.asFile(browser, testResult.getName());
	  }
			browser.close();
		}


  }



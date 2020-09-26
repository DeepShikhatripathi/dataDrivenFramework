package com.goibibo.testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObject.LandingPage;
import com.goibibo.pageObject.SearchResults;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShots;
import com.goibibo.utilities.Excell;
import com.goibibo.utilities.ScrollPage;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

   public class TC004 {
	WebDriver browser;
	ArrayList<String> data;
	SoftAssert sa;
	
     @Test(priority=1 ,groups = {"regration"})
     public void roundTripFlightSearch() throws Exception {
    	 
      browser.get(ObjectRepository.url);
   	  LandingPage.selectTripType(browser, data.get(0));
   	  LandingPage.enterSourceCity(browser, data.get(1));
   	  LandingPage.enterDestinationCity(browser, data.get(2));
   	  LandingPage.selectDate(browser, data.get(3));
   	  LandingPage.selectDate(browser, data.get(4));
   	  LandingPage.clickSearch(browser);
      Assert.assertTrue(SearchResults.checkRoundTripResultsAreShown(browser));
   //  sa.assertTrue(SearchResults.checkRoundTripResultsAreShown(browser));
   	  ScrollPage.verticalByPixel(browser,"-1000");
   	  SearchResults.selectRoundTripDepartureFlightByNameTime(browser,data.get(5), data.get(6));
   	  SearchResults.selectRTReturnFlightByNameTime(browser, data.get(7), data.get(8));
   	 //sa.assertAll();
     }
     @Test(priority=2 ,dependsOnMethods = {"roundTripFlightSearch"} , groups = {"regration"})
     public void selectFlights() throws Exception {
    	 ScrollPage.verticalByPixel(browser,"-1000");
      	  SearchResults.selectRoundTripDepartureFlightByNameTime(browser,data.get(5), data.get(6));
      	  SearchResults.selectRTReturnFlightByNameTime(browser, data.get(7), data.get(8));
    	 
     }
       @BeforeClass(groups = {"regration"})
       public void beforeMethod() throws Exception {
	   browser = BrowserObject.get(ObjectRepository.browserName);
		browser.get(ObjectRepository.url);
		data = Excell.getRowData("TC004", 0);
		sa = new SoftAssert();
  }

    /*   @AfterMethod
        public void afterMethod(ITestResult testResult) throws Exception {
    	  if(testResult.getStatus() == ITestResult.FAILURE) {
				 CaptureScreenShots.asFile(browser, testResult.getName());
				}
			browser.close();
		}
*/ 
       @AfterClass(groups = {"regration"})
       public void afterMethod() throws Exception {
   	         browser.close();
		}
       }



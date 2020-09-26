package com.goibibo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {

	public static String getValue(WebDriver browser) {

		String text = browser.findElement(By.xpath("//span[@class='fb ico16']")).getText();
		return text;
	}
	public static Boolean checkResultsAreShown(WebDriver browser) {
		
		boolean flightExists= false;
		List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='clr']"));
		if(all_results.size() > 0) {
			flightExists = true;
		}
		return flightExists;

	}
      public static Boolean checkRoundTripResultsAreShown(WebDriver browser) {
		
		boolean flightExists= false;
		List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyOnwrdWrp']/div/div"));
		if(all_results.size() > 0) {
			flightExists = true;
		}
		return flightExists;

	}

	public static void selectFlightByName(WebDriver browser, String airlineName) {

		List<WebElement> all_result = browser.findElements(By.xpath("//div[@class='clr']"));

		for (WebElement result : all_result) {

			String flightName = result.findElement(By.xpath(".//div[@class='dF width100 alignItemsCenter']")).getText();
			//System.out.println(flightName);
			if (flightName.equals(airlineName)) {
				result.findElement(By.xpath(".//input[@data-cy='bookBtn']")).click();
				break;
			}

		}

	}

	public static void selectFlightByNameTime(WebDriver browser, String airlineName, String depTime) {

		List<WebElement> all_result = browser.findElements(By.xpath("//div[@class='clr']"));

		for (WebElement result : all_result) {

			String flightName = result.findElement(By.xpath(".//div[@class='dF width100 alignItemsCenter']")).getText();
			//System.out.println(flightName);
			if (flightName.equals(airlineName)) {

				String time = result.findElement(By.xpath(".//Span[@data-cy='depTime']")).getText();
				if (time.equals(depTime)) {
					result.findElement(By.xpath(".//input[@data-cy='bookBtn']")).click();
					break;
				}
			}
		}

	}

	public static void selectFlightByTime(WebDriver browser, String depTime) {

		List<WebElement> all_result = browser.findElements(By.xpath("//div[@class='clr']"));

		for (WebElement result : all_result) {

			String flightName = result.findElement(By.xpath(".//div[@class='dF width100 alignItemsCenter']")).getText();
			//System.out.println(flightName);

		}
	}
	public static void selectRoundTripDepartureFlightByName(WebDriver browser, String airlineName) throws Exception {
		Thread.sleep(5000);
		List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyOnwrdWrp']/div/div"));
		System.out.println(all_results.size());
		String flightName="";
		for (WebElement result : all_results) {
			flightName = result.findElement(By.xpath(".//*[@class='col-md-3 col-sm-2 col-xs-2 padL10']")).getText();
			//System.out.println("FlightName :" + flightName);
			if(flightName.equals(airlineName))
			{
				result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
				break;

			}
		}
		}
		public static void selectRoundTripReturnFlightByName(WebDriver browser, String airlineName) throws Exception {
			Thread.sleep(5000);
			List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyRtrnWrp']/div/div"));
			System.out.println(all_results.size());
			String flightName="";
			for (WebElement result : all_results) {
				flightName = result.findElement(By.xpath(".//*[@class='col-md-3 col-sm-2 col-xs-2 padL10']")).getText();
				//System.out.println("FlightName :" + flightName);
				if(flightName.equals(airlineName))
				{
					result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
					break;
				}
			}
			}

			public static void selectRTReturnFlightByNameTime(WebDriver browser, String airlineName, String time) throws Exception {
				Thread.sleep(5000);
				List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyRtrnWrp']/div/div"));
				System.out.println(all_results.size());
				String flightName="";
				for (WebElement result : all_results) {
					flightName = result.findElement(By.xpath(".//*[@class='col-md-3 col-sm-2 col-xs-2 padL10']")).getText();
					//System.out.println("FlightName :" + flightName);
					if(flightName.equals(airlineName))
					{
						String fTime = result.findElement(By.xpath(".//span[@class='fb ico16 quicks']")).getText();
						//System.out.println(fTime);
						if(fTime.equals(time)) {
							result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
							break;
						}
						
					}

	}

	
			}
			public static void selectRoundTripDepartureFlightByNameTime(WebDriver browser, String airlineName ,String time) throws Exception {
				Thread.sleep(5000);
				List<WebElement> all_results = browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyOnwrdWrp']/div/div"));
				System.out.println(all_results.size());
				String flightName="";
				for (WebElement result : all_results) {
					flightName = result.findElement(By.xpath(".//*[@class='col-md-3 col-sm-2 col-xs-2 padL10']")).getText();
					//System.out.println("FlightName :" + flightName);
					if(flightName.equals(airlineName))
					{
						String fTime = result.findElement(By.xpath(".//span[@class='fb ico16 quicks']")).getText();
						//System.out.println(fTime);
						if(fTime.equals(time)) {
							result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
							break;
						

					}
				}
				}

}
}
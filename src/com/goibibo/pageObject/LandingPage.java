package com.goibibo.pageObject;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public static void selectTripType(WebDriver browser , String tripType) {
		
		String locator = "";
		if(tripType.equals("round")) {
			
			locator="roundTrip";
			
		}else if(tripType.equals("multi")) {
			
			locator="multiCity";
		}
		browser.findElement(By.id(locator)).click();;
	}

	
	public static void enterSourceCity(WebDriver browser , String cityName) {
		
		browser.findElement(By.id("gosuggest_inputSrc")).sendKeys(cityName);
		browser.findElement(By.xpath("//ul[@id='react-autosuggest-1']/li")).click();
	}
	public static void enterDestinationCity(WebDriver browser , String cityName) {
		
		browser.findElement(By.id("gosuggest_inputDest")).sendKeys(cityName);
		browser.findElement(By.xpath("//ul[@id='react-autosuggest-1']/li")).click();
	}
	public static void selectDate(WebDriver browser , String date) {
		
		String mmToMonthYear =getMothAndYeatInString(date);
		String monthYear = browser.findElement(By.cssSelector(".DayPicker-Month > div")).getText();
		
		while(! monthYear.equals( mmToMonthYear)){
			
			browser.findElement(By.cssSelector(".DayPicker-NavButton--next")).click();
			 monthYear = browser.findElement(By.cssSelector(".DayPicker-Month > div")).getText();
			}
		if(monthYear.equals(mmToMonthYear)) {
			browser.findElement(By.id("fare_"+date)).click();
		}
		
	}
	public static String getMothAndYeatInString(String inputData) {
		
		HashMap<String, String> mmToMonth = new HashMap<String , String>();
		mmToMonth.put("01", "January");
		mmToMonth.put("02", "February");
		mmToMonth.put("03", "March");
		mmToMonth.put("04", "April");
		mmToMonth.put("05", "May");
		mmToMonth.put("06", "Jun");
		mmToMonth.put("07", "July");
		mmToMonth.put("08", "August");
		mmToMonth.put("09", "September");
		mmToMonth.put("10", "October");
		mmToMonth.put("11", "November");
		mmToMonth.put("12", "December");
		
		String mm = inputData.substring(4,6);
		String yr = inputData.substring(0,4);
		String month = mmToMonth.get(mm);
		
		return month + " " +yr;
		
		
	}
	public static void clickSearch(WebDriver browser) {
		browser.findElement(By.id("gi_search_btn")).click();
	}
	
	public static String getHeaderText(WebDriver browser) {
		String text;
		text = browser.findElement(By.xpath("//*[@class='fltHypContain posRel']/h1")).getText();
		return text;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

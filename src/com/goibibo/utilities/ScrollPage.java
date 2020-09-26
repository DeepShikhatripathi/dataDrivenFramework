package com.goibibo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollPage {
	
	public static void verticalByPixel(WebDriver browser , String pixels) {
		
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript("window.scrollBy(0," +pixels +")");
	}

}

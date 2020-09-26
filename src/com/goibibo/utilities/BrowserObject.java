package com.goibibo.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserObject {

	 WebDriver browser;

	public static WebDriver get(String browserName) throws Exception {
		 WebDriver browser;

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\win10\\Documents\\chromedriver_win32_84\\chromedriver.exe");
			browser = new ChromeDriver();
			browser.manage().window().maximize();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\win10\\Documents\\selenium program\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			browser = new FirefoxDriver();

		} else {

			throw new Exception("invalidBrowserName");

		}
		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return browser;
	}
}
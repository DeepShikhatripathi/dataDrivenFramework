package com.goibibo.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScreenShot {
  @Test
  public void f() throws Exception {
	  
	  WebDriver browser = BrowserObject.get("chrome");
	  browser.get("http://www.amazon.in");
	  JavascriptExecutor js = (JavascriptExecutor) browser;
	  
	  WebElement signIn = browser.findElement(By.linkText("Sign in"));
	  js.executeScript("arguments[0].scrollIntoView();", signIn);
	  signIn.click();
	  
	  browser.findElement(By.name("email")).sendKeys("shikha tripathi");
      browser.findElement(By.id("continue")).click();
      
//      TakesScreenshot ss = (TakesScreenshot) browser;
//      File screenGrab =  ss.getScreenshotAs(OutputType.FILE);
//      FileUtils.copyFile(screenGrab, new File("D:\\java\\new batch\\DataDrivenFrameWork\\src\\com\\goibibo\\Screen shot\\amazon.jpg")); 

      CaptureScreenShots.asFile(browser, "amazon_login");
  }
}

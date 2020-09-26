package com.goibibo.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShots {
	
	public static void asFile(WebDriver browser ,String fileName) throws Exception {
		
		String fileLocation = "D:\\java\\new batch\\DataDrivenFrameWork\\src\\com\\goibibo\\screenShots\\";
		String ssPath = fileLocation + fileName + ".jpg";
		TakesScreenshot ss = (TakesScreenshot) browser;
		File screenGrab = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenGrab, new File(ssPath));
		
	}

}

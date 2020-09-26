package com.goibibo.pageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TravellersDetails {
	
	public static void travellersProtection(WebDriver browser) {
		
     List<WebElement> select = browser.findElements(By.xpath("//div[@class='fl width100 ico17 padTB10 marginT5 padL10 notSecureMsg']/div"));
	
	for (WebElement radio : select) {
		
		radio.findElement(By.id("secure-trip")).click();
		//radio.findElement(By.id("risk-trip")).click();
	}
	
	}
	
	public static void titleName(WebDriver browser , String title) {
		
		browser.findElement(By.id("Adulttitle1")).sendKeys(title);
	}
	public static void firstName(WebDriver browser , String fName) {
	
    browser.findElement(By.xpath("//input[@name='AdultfirstName1']")).sendKeys(fName);
}
	public static void lastName(WebDriver browser , String lName) {
		
	    browser.findElement(By.xpath("//input[@name='AdultlastName1']")).sendKeys(lName);
	}
    public static void eMail(WebDriver browser , String email) {
		
	    browser.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	}
   public static void mobNo(WebDriver browser , String contact) {
	   
	   browser.findElement(By.xpath("//input[@name='mobile']")).sendKeys(contact);
	
 }
   public static void proceedPage(WebDriver browser) {
	   		
	 browser.findElement(By.xpath("//button[contains(text(),Proceed)]"));
   
	
   }
}

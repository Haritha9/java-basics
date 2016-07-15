package in.srssprojects.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Validations {
	
	//based on the text present in the page
	public static boolean isTextPresent(WebDriver driver, String expText){
		String actText = driver.findElement(By.tagName("body")).getText();
		if(actText.contains(expText)){
			return true;
		}else{
			return false;
		}
	}
	
	//based on the title of the page
	public static boolean isTitlePresent(WebDriver driver, String expTitle){
		String actTitle = driver.getTitle();
		if(actTitle.equalsIgnoreCase(expTitle)){
			return true;
		}else{
			return false;
		}
	}
	
	//based on url of the page
	public static boolean isURLContains(WebDriver driver, String expURL){
		String actURL = driver.getCurrentUrl();
		if(actURL.contains(expURL)){
			return true;
		}else{
			return false;
		}
	}
	
	//based on the element presence
	public static boolean isElementPresent(WebDriver driver, By loc){
		return driver.findElement(loc).isDisplayed();
	}
	
	//based on the alert text
	public static boolean isAlertTextContains(WebDriver driver, String expAlertText){
		String actAlertText = driver.switchTo().alert().getText();
		if(actAlertText.contains(expAlertText)){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

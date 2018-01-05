package com.TestRoom.CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

	
	public static void waitForElementToBeVisible(WebDriver driver,int timeInSec,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver,int timeInSec,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}

package com.TestRoom.CommonClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandel {
 
	public static void acceptAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public static void cancelAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	public static String readingTextFromAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		String text=alt.getText();
		return text;
	}
}

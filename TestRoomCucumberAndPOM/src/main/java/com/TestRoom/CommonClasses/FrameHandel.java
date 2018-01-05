package com.TestRoom.CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandel {

	public static void handelframeByText(WebDriver driver,String text){
		driver.switchTo().frame(text);
	}
	
	public static void handelFrameByIndex(WebDriver driver,int index){
		driver.switchTo().frame(index);
	}
	
	public static void handelFrameByXpath(WebDriver driver,WebElement element){
		driver.switchTo().frame(element);
	}
	
}

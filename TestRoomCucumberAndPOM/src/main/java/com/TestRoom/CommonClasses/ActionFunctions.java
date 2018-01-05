package com.TestRoom.CommonClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {

	public static void hoverOnElement(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void moveToCordiNateOfElement(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		act.moveToElement(element, x, y).perform();
	}
	
	public static void dragAndDropElement(WebDriver driver,WebElement srcElement,WebElement dstElement){
		Actions act=new Actions(driver);
		act.clickAndHold(srcElement).moveToElement(dstElement).release().perform();
	}
	
	public static void openLinkInANewTab(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.contextClick(element).sendKeys("t").perform();
	}
	
	public static void opanAnewTab(WebDriver driver){
		Actions act=new Actions(driver);
		act.sendKeys(Keys.chord(Keys.SHIFT,"t")).perform();
	}
	
}

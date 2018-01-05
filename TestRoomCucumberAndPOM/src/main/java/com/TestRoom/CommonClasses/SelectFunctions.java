package com.TestRoom.CommonClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
  
	public static void selectBytext(WebElement element,String text){
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String value){
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
}

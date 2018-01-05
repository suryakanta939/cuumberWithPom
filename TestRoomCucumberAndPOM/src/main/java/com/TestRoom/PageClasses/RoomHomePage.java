package com.TestRoom.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class RoomHomePage {
	
	  WebDriver driver;
	 static WebElement element;
	static  ExtentTest test;
	
	@FindBy(id="home_link")
	public WebElement home;
	
	@FindBy(xpath="//h1[contains(text(),'WELCOME')]")
	public WebElement welcome_message;
	
	@FindBy(xpath="//p[contains(text(),'Thank you')]")
	public WebElement description;
	
	@FindBy(id="footer_term")
	public WebElement terms;
	
	@FindBy(xpath="html/body/p")
	public WebElement newWindowMessage;
	
	public RoomHomePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	

}

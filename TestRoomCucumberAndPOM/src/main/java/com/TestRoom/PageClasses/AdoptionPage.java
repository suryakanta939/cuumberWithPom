package com.TestRoom.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class AdoptionPage {

	 static WebDriver driver;
	 static WebElement element;
	 ExtentTest test;
	static String xpath1="//*[@id='table1']/tbody/tr[2]/td[2]/table/tbody/tr[";
	static String xpath2="]/td[1]";
	
	 @FindBy(id="adoption_link")
	 public WebElement adoption;
	 
	 @FindBy(xpath="//h1[contains(text(),'ADOPTION OPTIONS')]")
	 public WebElement adoptionconfirm;
	 
	 @FindBy(id="start_select")
	 public WebElement date;
	 
	 @FindBy(id="check_btn_01")
	 public WebElement checkbutton1;
	 
	 @FindBy(id="result")
	 public WebElement result;
	 
	 @FindBy(id="check_btn_02")
	 public WebElement checkbutton2;
	 
	 @FindBy(name="name_field")
	 public WebElement nameField;
	 
	 @FindBy(name="address_field")
	 public WebElement adressField;
	 
	 
	 @FindBy(name="postcode_field")
	 public WebElement postcodeField;
	 
	 @FindBy(name="email_field")
	 public WebElement emailField;
	 
	 @FindBy(id="submit_adoption")
	 public WebElement submit;
	 
	 public static WebElement animalType(int i){
		element=driver.findElement(By.xpath(xpath1+i+xpath2));
		return element;
	 }
	 
	 
	public AdoptionPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

}

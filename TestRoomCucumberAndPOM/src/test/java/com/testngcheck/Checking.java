package com.testngcheck;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.TestRoom.BaseClasses.InvokeBrowser;
import com.TestRoom.BaseClasses.ReadPropertyData;
import com.TestRoom.CommonClasses.ActionFunctions;
import com.TestRoom.CommonClasses.WindowHandel;
import com.TestRoom.PageClasses.RoomHomePage;
import com.TestRoom.ReportClasses.ExtentFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Checking {
	static WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	RoomHomePage hp;
	String brwoser;
	String baseUrl;
  @Test
  public void f() throws IOException {
	  File f=new File("Drivers");
		File fs=new File(f,"chromedriver.exe");
		System.out.println(fs.getAbsolutePath());
		String url=ReadPropertyData.getData("testdata", "URL");
		System.out.println(url);
		 File f1=new File("Reports");
		  File fs1=new File(f1,"");
		  System.out.println(fs1.getAbsolutePath()+"\\room.html");
		  report=ExtentFactory.getInstance();
			test=report.startTest("checking the home page");
		  brwoser=ReadPropertyData.getData("testdata", "browserName");
		  baseUrl=ReadPropertyData.getData("testdata", "URL");
			driver=InvokeBrowser.openBrowser(brwoser);
			test.log(LogStatus.INFO, "browser opened");
			driver.get(baseUrl);
			test.log(LogStatus.INFO, "url is entered");
			driver.manage().window().maximize();
			hp=new RoomHomePage(driver, test);
			driver.findElement(By.id("footer_term")).click();
//			Set<String> id=driver.getWindowHandles();
//			Iterator<String> itr=id.iterator();
//			String pid=itr.next();
//			String cid=itr.next();
//			driver.switchTo().window(cid);
			
//			ActionFunctions.openLinkInANewTab(driver, driver.findElement(By.id("footer_term")));
//			Actions act=new Actions(driver);
//			act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
			WindowHandel.handelWindowByNo(driver,2);
			String msg=driver.findElement(By.xpath("html/body/p")).getText();
			
			System.out.println(msg);
  }
  
}

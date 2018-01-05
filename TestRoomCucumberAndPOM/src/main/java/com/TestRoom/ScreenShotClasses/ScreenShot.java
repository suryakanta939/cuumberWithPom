package com.TestRoom.ScreenShotClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {

	public static EventFiringWebDriver eDriver;
	
	public static String takeAScreenShot(WebDriver driver,String filename) throws IOException{
		File f=new File("Images");
		File fs=new File(f,"");
		eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstfile=new File(fs.getAbsolutePath()+"//"+filename+".png");
		FileUtils.copyFile(srcFile, dstfile);
		String imagePath=fs.getAbsolutePath()+"//"+filename+".png";
		return imagePath;
		
	}
}

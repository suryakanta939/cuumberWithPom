package com.TestRoom.CommonClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandel {
	
	public static void hadndelWindowByTitle(WebDriver driver,String title){
		String parentId=driver.getWindowHandle();
		Set<String> Ids=driver.getWindowHandles();
		for(String windowId:Ids){
			if(!windowId.equals(parentId)){
				driver.switchTo().window(windowId);
				String windowTitle=driver.getTitle();
				if(windowTitle.equals(title)){
					driver.switchTo().window(windowId);
				}
			}
		}
	}
     
	public static void handelWindowByNo(WebDriver driver,int windowNo){
		Set<String> ids=driver.getWindowHandles();
		System.out.println(ids.size());
		Iterator<String> itr=ids.iterator();
		for(int i=1;i<=ids.size();i++){
			String id=itr.next();
			if(i==windowNo){
				driver.switchTo().window(id);
			}
		}
	}
}

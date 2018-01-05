package com.TestRoom.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyData {
 
	public static Properties pro;
	
	public static String getData(String fileName,String keyName) throws IOException{
		File f=new File("PropertyFiles");
		File fs=new File(f,fileName+".properties");
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		pro=new Properties();
		pro.load(fis);
		String data=pro.getProperty(keyName);
		return data;
	}
}

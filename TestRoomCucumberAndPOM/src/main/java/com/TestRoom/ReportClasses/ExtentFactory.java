package com.TestRoom.ReportClasses;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
  public static ExtentReports report;
  
  public static ExtentReports getInstance(){
	  File f=new File("Reports");
	  File fs=new File(f,"");
	  report=new ExtentReports(fs.getAbsolutePath()+"\\room.html", false);
	  return report;
  }
}

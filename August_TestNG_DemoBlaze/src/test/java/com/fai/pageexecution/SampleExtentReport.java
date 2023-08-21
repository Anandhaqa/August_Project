package com.fai.pageexecution;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fai.basepackage.BaseClass;

public class SampleExtentReport {
	
	public static void main(String[] args) {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(htmlreporter);
		
		
		ExtentTest test = extentreport.createTest("Extent_Report1");
		BaseClass.flaunch();
		BaseClass.loadurl("https://www.amazon.in/");
		test.info("URL Loaded");
		BaseClass.close();
		
		extentreport.flush();
		
		
		
		
	}

}

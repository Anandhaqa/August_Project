package com.fai.pageexecution;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

@Listeners(com.fai.pageexecution.ListenerExample.class)
public class Amazon_Service {
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extentreport;
	@BeforeClass
	public void db_connection() {
		System.out.println("DB_Connected");
		htmlreporter = new ExtentHtmlReporter("extent.html");
		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlreporter);

	}
	
	@AfterClass
	public void db_close() {
		System.out.println("DB_Disconnected");
		extentreport.flush();
	}
	
	@BeforeMethod
	public void bmethod() throws IOException {
		BaseClass.blaunch();
		BaseClass.loadurl(BaseClass.proFile("url"));
	}
	
	@AfterMethod
	public void amethod() throws InterruptedException {
		Thread.sleep(5000);
		BaseClass.close();
	}
	
	@Test//(dependsOnMethods = {"com.fai.pageexecution.Amazon_Service.aws", "com.fai.pageexecution.Amazon_Service.career"}, alwaysRun = true)
	public void amazon_sceience() throws IOException, InterruptedException {
		
		ExtentTest Science = extentreport.createTest("Extent_Report2");
		//BaseClass.blaunch();
		//BaseClass.loadurl(BaseClass.proFile("url"));
		Page_Data pd = new Page_Data();
		pd.Amazon_Science.click();
		Science.info("Clicked Successfully on the Link");
		Science.pass("Link working Properly");
		//Thread.sleep(5000);
		//BaseClass.close();
	}
	
	@Test //(groups = {"Group1"})
	public void aws() throws IOException, InterruptedException {
		ExtentTest aws = extentreport.createTest("Extent_Report2");
		//BaseClass.blaunch();
		//BaseClass.loadurl(BaseClass.proFile("url"));
		Page_Data pd = new Page_Data();
		pd.aws.click();
		aws.info("Clicked Successfully on the Link");
		//BaseClass.takeScreenShot();
		//System.out.println(2/0);
		aws.pass("Link not working Properly");
		//Thread.sleep(5000);
		//BaseClass.close();
	}
	
	public void aws1() {
		ExtentTest aws1 = extentreport.createTest("Extent_Report2");
		try {
			Page_Data pd = new Page_Data();
			pd.aws.click();
			aws1.info("Clicked Successfully on the Link");
			System.out.println(2/0);
			
			
		} catch (Exception e) {
			aws1.error(e);
		}

		
	}
	
	@Test //(invocationCount = 2, threadPoolSize = 2)
	
	public void career() throws InterruptedException {
		ExtentTest career = extentreport.createTest("Extent_Report2");
		Page_Data pd = new Page_Data();
		pd.career.click();
		career.info("Clicked Successfully on the Link");
		career.pass("Link working Properly");
	    throw new NoSuchElementException("Element not Found");
		
	}
	
}

package com.fai.pageexecution;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

public class Wallmart_Services {
	
	@Test
	public void deals() throws AWTException {
		BaseClass.blaunch();
		//BaseClass.flaunch();
		try {
			BaseClass.loadurl(BaseClass.excelRead(58, 1));
			//BaseClass.robot();
			Page_Data pd = new Page_Data();
			pd.Deals.click();
			Thread.sleep(3000);
			BaseClass.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void allDepartments() {
		BaseClass.blaunch();
		try {
			BaseClass.loadurl(BaseClass.excelRead(58, 1));
			Page_Data pd = new Page_Data();
			pd.All_Department.click();
			Thread.sleep(3000);
			BaseClass.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.fai.pageexecution;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

public class Demo_Login {
	@Test
	public void login() throws IOException, InterruptedException {
		BaseClass.blaunch();
		BaseClass.loadurl(BaseClass.excelRead(44, 1));
		Page_Data pd = new Page_Data();
		pd.Login.click();
		Thread.sleep(5000);
		pd.U_Name.sendKeys(BaseClass.excelRead(45, 1));
		pd.password.sendKeys(BaseClass.excelRead(46, 1));
		pd.Loginbtn.click();
		Thread.sleep(3000);
		BaseClass.close();
	}
}

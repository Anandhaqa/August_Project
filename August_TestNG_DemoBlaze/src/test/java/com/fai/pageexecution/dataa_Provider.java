package com.fai.pageexecution;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

public class dataa_Provider {
	@Test(dataProvider = "credentials") //dataProviderClass = PageExecution.class
	public void login(String name, String pass) throws IOException, InterruptedException {
		BaseClass.blaunch();
		BaseClass.loadurl(BaseClass.excelRead(44, 1));
		Page_Data pd = new Page_Data();
		pd.Login.click();
		Thread.sleep(5000);
		pd.U_Name.sendKeys(name);
		pd.password.sendKeys(pass);
		pd.Loginbtn.click();
	}
	
	@DataProvider(name = "credentials") //(indices = 1, parallel = true)
	public Object[][] data() throws IOException {
		/*Object[][] obj = new Object[2][2];
		obj[0][0] = "Anandh";
		obj[0][1] = "Test@123";
		obj[1][0] = "Krishnan";
		obj[1][1] = "Test@1234";
		return obj;*/
		Object[][] obj1 = Excell.excelRead();
		return obj1;
		
	}
}

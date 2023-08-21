package com.fai.pageexecution;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

public class HomePage {
	@Parameters({"browser"})
	@Test
	public void amazon_sceience(String browser) throws IOException, InterruptedException {
		BaseClass.launch(browser);
		BaseClass.loadurl(BaseClass.proFile("url"));
		Page_Data pd = new Page_Data();
		pd.Amazon_Science.click();
		
		Thread.sleep(5000);
		BaseClass.close();
	}

}

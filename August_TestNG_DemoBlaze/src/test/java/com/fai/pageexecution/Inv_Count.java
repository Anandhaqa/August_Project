package com.fai.pageexecution;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import com.fai.basepackage.BaseClass;
import com.fai.pagefactory.Page_Data;

public class Inv_Count {
@Test(invocationCount = 2)
	
	public void career() throws InterruptedException, IOException {
	BaseClass.blaunch();
	BaseClass.loadurl(BaseClass.proFile("url"));
		Page_Data pd = new Page_Data();
		pd.career.click();
		//throw new NoSuchElementException("Element not Found");
		}
}

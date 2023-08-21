package com.fai.basepackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	static String directory = System.getProperty("user.dir");

	public static WebDriver driver;

	public static String ExcelPath = directory+"\\src\\test\\resources\\Excel_Data.xlsx";
	public static String ProPath = directory+"\\src\\test\\resources\\Data\\data.properties";
	public static String PhotoPath = directory + "\\src\\test\\resources\\Screen_Shot";
	public static String value;

	public static void blaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println(browser+" "+"Unidentified browser to Launch");
		}
	}
	
	public static void flaunch() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public static void loadurl(String url) {
		driver.get(url);
	}

	public static String getcurrenturl() {
		return driver.getCurrentUrl();
	}

	public static void close() {
		driver.close();
	}

	public static String excelRead(int i, int j) throws IOException {
		File f = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("Credential");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		
		CellType cellType = cell.getCellType();
		
		if (cellType==CellType.STRING) {
			String value1 = cell.getStringCellValue();
			value = value1;
		}else if (cellType==CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String value2 = sdf.format(dateCellValue);
				value = value2;
			}else {
				double numericCellValue = cell.getNumericCellValue();
				DecimalFormat df = new DecimalFormat();
				String value3 = df.format(numericCellValue).toString();
				value= value3;
			}
		}
		return value;
		}

	public static void excelWrite(int i, int j, String data) throws IOException {
		File f = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheet = wb.getSheet("Sheet2");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static String proFile(String key) throws IOException {
		File f = new File(ProPath);
		FileInputStream fis = new FileInputStream(f);
		Properties pro = new Properties();
		pro.load(fis);

		String value = pro.getProperty(key);
		return value;

	}

	public static WebElement selectByIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);
		return element;

	}

	public static void takeScreenShot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(PhotoPath + driver.getTitle() + ".png");
		org.openqa.selenium.io.FileHandler.copy(source, dest);
		System.out.println("WebPage_Captured as" + driver.getTitle());
	}

	public static void jScriptV() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void alert() {
		driver.switchTo().alert().accept();
	}
	
	public static void robot() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void newWindow(String url) {
		driver.navigate().to(url);
	}

}

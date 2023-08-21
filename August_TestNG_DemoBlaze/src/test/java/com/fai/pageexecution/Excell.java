package com.fai.pageexecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excell {
	static String directory = System.getProperty("user.dir");
	public static String value;
	public static String ExcelPath = directory+"\\src\\test\\resources\\Excel_Data.xlsx";
	public static Object[][] excelRead() throws IOException {
		File f = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		int a = sheet.getPhysicalNumberOfRows();
		short c = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[a][c];
		for (int i = 0; i < a; i++) {
			Row row = sheet.getRow(i);
			int b = row.getPhysicalNumberOfCells();
			for (int k = 0; k < b; k++) {
				Cell cell = row.getCell(k);
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
					obj[i][k] = value;
				}
			}
			
		}
	
		return obj;
		}
}
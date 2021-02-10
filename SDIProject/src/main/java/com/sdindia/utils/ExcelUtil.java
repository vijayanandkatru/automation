package com.sdindia.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static Object[][] GetSheetData(String filename, String Sheetname) throws IOException{
		FileInputStream resultStream = new FileInputStream(filename);
		XSSFWorkbook dWorkBook = new XSSFWorkbook(resultStream);
		XSSFSheet dsheet = dWorkBook.getSheet(Sheetname);
			
			Object[][] data = new Object[dsheet.getLastRowNum()][dsheet.getRow(0).getLastCellNum()];
		for(int i=0; i<dsheet.getLastRowNum();i++) {
			Row row = dsheet.getRow(i+1);
		for(int k=0;k<dsheet.getRow(0).getLastCellNum();k++) {
			Cell cell = row.getCell(k);
			String value;
		data[i][k] = dsheet.getRow(i+1).getCell(k).toString();
		try{
			value=cell.getRichStringCellValue().toString();
		}catch(Exception e){
			value = ((XSSFCell)cell).getRawValue();
		}
		data[i][k] = value;
		}
		
	}
		dWorkBook.close();
		return data;
	}

}

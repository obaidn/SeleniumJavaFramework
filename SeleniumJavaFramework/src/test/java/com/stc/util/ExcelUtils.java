package com.stc.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {

	static XSSFWorkbook wrkBk;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			wrkBk = new XSSFWorkbook(excelPath);
			sheet = wrkBk.getSheet(sheetName);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getRowCount();
		getColCount();
	}	

	public static int getRowCount() {
		int rcount;
		//rcount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows : "+rcount);
		String cellData = sheet.getRow(0).getCell(1).getStringCellValue();
		
		return rcount;
	}
	public static int getColCount() {
		int ccount;
		ccount = sheet.getRow(0).getPhysicalNumberOfCells();
		String cellData = sheet.getRow(0).getCell(0).getStringCellValue();

		return ccount;
	}}

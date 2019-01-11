package com.stc.util;

import org.testng.annotations.Test;

public class ExcelDataProvider {
	public static void main(String[] args) {
		String excelFile = System.getProperty("user.dir");
		String excelPath = (excelFile+"/excel/data.xlsx");
		getData(excelPath, "Sheet1");
	}
	public static void getData(String excelPath, String sheetName) {
		
		String excelFile = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(excelPath, "sheetName");
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		for (int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				System.out.println(i +"   |   "+j);
			}
			
		}
	}

}

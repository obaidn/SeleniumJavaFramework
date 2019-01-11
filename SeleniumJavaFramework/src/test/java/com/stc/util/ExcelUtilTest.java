package com.stc.util;

import org.testng.annotations.Test;

public class ExcelUtilTest {
	
	@Test
	public void getExcelData() {
		String excelFile = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(excelFile+"/excel/data.xlsx", "Sheet1");
		excel.getRowCount();
	}

}

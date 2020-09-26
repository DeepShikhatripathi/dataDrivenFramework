package com.goibibo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excell {
	
	public static ArrayList<String> getRowData(String sheetName , int rowNumber) throws Exception{
		
		ArrayList<String> data = new ArrayList<String>();
		File file = new File("D:\\java\\new batch\\DataDrivenFrameWork\\src\\com\\goibibo\\testData\\goibibo.xls");
		FileInputStream ip = new FileInputStream(file);
		
		HSSFWorkbook wb = new HSSFWorkbook(ip);
		HSSFSheet sheet = wb.getSheet(sheetName);
		HSSFRow row = sheet.getRow(rowNumber);
		
		int maxCell = row.getLastCellNum();
		
		for(int i = 0 ; i<maxCell ; i++) {
			
			HSSFCell cell = row.getCell(i);
			data.add(cell.getStringCellValue());
		}
		return data;
	}

}

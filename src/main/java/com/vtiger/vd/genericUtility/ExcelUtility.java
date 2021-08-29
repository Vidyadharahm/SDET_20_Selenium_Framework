package com.vtiger.vd.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
	 * This method is used to handle the Excel Sheets and developed by Apache POi libraries.
	 * @author Vidyadhara
	 *
	 */
	public class ExcelUtility {
		
		/**
		 * This method is used read the data from excel sheet
		 * 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throws Throwable
		 */
		public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
			FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(celNum).getStringCellValue();
			wb.close();
			return data;
		}
	
		/**
		 * This method is used to get the last row number in the Sheet
		 * 
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}
		
		/**
		 * This method is used to set the value of the cell in excel sheet
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @param data
		 * @throws Throwable
		 */
		public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
			FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(cellNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
			wb.write(fos);
			wb.close();
	
		}
	}

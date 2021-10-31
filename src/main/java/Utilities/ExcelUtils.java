package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Reports.Log;
import Reports.Reports;

public class ExcelUtils {
	/*
	 * ExelUtils.java (Apache poi) 1. InvokeExcel(String filePath) --> void 2.
	 * readSpecificCellData(int rowNum, int colNum) --> String 3.
	 * readExcelData(String sheetname) --> Object[][] 4. setSpecificCellValue(String
	 * result, int rowNum, int columNum) --> void
	 */

	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static Object[][] excelData;
	public static FileOutputStream fout;

	/**
	 * @author Gopu Reddy
	 * @param FilePath
	 * @category ExcelUtility Invoke Excel This method is invoking the FilePath
	 *           excel return void
	 */

	// ---------------------------------------------------------------------------
	public static void InvokeExcel(String FilePath) {
		try {
			fis = new FileInputStream(FilePath);
			Reports.pass("Invoke Excel", "Excel invoked successfully " + FilePath);
			Log.info("Excel invoked successfully" + FilePath);
		} catch (FileNotFoundException e) {
			Log.info(e.fillInStackTrace().toString()); // write under log file
			e.printStackTrace(); // prints under console
			Reports.fail("invoke Excel ", e.toString(), "Screenshot");
		}

		try {
		
			workbook = new XSSFWorkbook(fis);
			Reports.pass("Invoke workbook", "workbook invoked successfully ");
			Log.info("Workbook invoked successfully");
			System.out.println("Workbook invoked successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.info(e.fillInStackTrace().toString()); // write under log file
			e.printStackTrace(); // prints under console
			Reports.fail("invoke workbook ", e.toString(), "Screenshot");
		}
	}

	// -------------------------------------------------------------------------------------
	/**
	 * @author Gopu Reddy
	 * @param rowNum
	 * @param colNum
	 * @return String
	 */
	// 2. readSpecificCellData(int rowNum, int colNum) --> String
	public static String readSpecificCellData(int rowNum, int colNum) {
		String data = null;
		cell = sheet.getRow(rowNum).getCell(colNum);
		try {
			data = cell.getStringCellValue();
			// Log.info(data);
		} catch (Exception e) {
			cell = sheet.getRow(rowNum).getCell(colNum);
			DataFormatter fomater = new DataFormatter();
			data = fomater.formatCellValue(cell);
		}
		return data;
	}
	// --------------------------------------------------------------------------------------
//	3. readExcelData(String sheetname)   --> Object[][]
	public static Object[][] readExcelData(String sheetname) throws IOException {
		fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\com.gcreddyClasses.selenium.BatchNo24\\src\\test\\resources\\InputData\\InputData.xlsx");
		workbook = new XSSFWorkbook(fis);
		Object[][] excelData = null;
		System.out.println(sheetname);
		sheet = workbook.getSheet(sheetname);

		int nur = sheet.getPhysicalNumberOfRows();
		int nuc = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(nur);
		System.out.println(nuc);

		excelData = new Object[nur - 1][nuc];
		// i represents the rows
		int ci = 0; // ci represents the double dimentional array
		int i = 1; // excel sheet
		for (i = 1; i < nur; i++, ci++) {
			// j loop represent the columns
			int j = 0;
			int cj = 0;
			for (j = 0; j < nuc; j++, cj++) {
				excelData[ci][cj] = readSpecificCellData(i, j);
				System.out.println("Data store at index-- " + "Data[" + ci + "]" + "[" + cj + "]==>>" + "[" + i
						+ "]" + "[" + j + "]" + "--->" + excelData[ci][cj]);
			}
		}
		return excelData;
	}
//-------------------------------------------------------------------------------------------	
           //set excel status 	result, int rowNum, int columNum) --> void\
	public static void setExcelStatus(String FilePath, String result, int rowNum, int colNum ) {
		cell = sheet.getRow(rowNum).createCell(colNum);
		cell.setCellValue(result);
		
		 try {
			fout = new FileOutputStream(FilePath);
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		 
		 try {
			workbook.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
}

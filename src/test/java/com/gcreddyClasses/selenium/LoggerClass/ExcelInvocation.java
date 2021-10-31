package com.gcreddyClasses.selenium.LoggerClass;

import org.testng.annotations.Test;

import Reports.Log;
import Reports.Reports;
import Utilities.ExcelUtils;

public class ExcelInvocation {
  @Test
  public void ExcelInvocation() {
	  Log.startTest("ExcelInvocation");
	  Reports.startTest("ExelInvocation", "Invokign and reading the data");
	 
	  ExcelUtils.InvokeExcel("ExcelData1.xlsx");
	//  ExcelUtils.readExcelData("1001");
	
	  Log.endTest();
	  Reports.endTest();
	  Reports.flush();
  }
}

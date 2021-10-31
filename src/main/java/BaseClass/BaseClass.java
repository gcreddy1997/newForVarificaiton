package BaseClass;

import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import Constants.Constant;
import Reports.Reports;
import Utilities.ExcelUtils;
import Utilities.Utilities;



public class BaseClass {
	
	public static Properties prop_config;
	public static Properties prop_loct;
	
	@BeforeSuite
	public void intiliaseFiles()
	{		
		DOMConfigurator.configure("log4j.xml");
		prop_config = Utilities.loadProperty(Constant.config_path);
		prop_loct = Utilities.loadProperty(Constant.locaters_path);
	//	ExcelUtils.InvokeExcel(Constant.TestData_excel_path);	
	//	ExcelUtils.InvokeExcel("C:\\Users\\User\\eclipse-workspace\\com.gcreddyClasses.selenium.BatchNo24\\src\\test\\resources\\InputData\\InputData.xlsx");
	}
	
	@AfterTest
	public void FLushReports()
	{
		Reports.flush();
	}  

}

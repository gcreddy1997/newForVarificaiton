package Constants;

import Utilities.Utilities;

public class Constant {
	
	public static final String TestData_excel_path = System.getProperty("user.dir")+"\\src\\test\\resources\\InputData\\InputData.xlsx";
	
	public static final String locaters_path = System.getProperty("user.dir")+"\\src\\test\\resources\\Repositories\\Locators.properties";
	
	public static final String config_path = System.getProperty("user.dir")+"\\src\\test\\resources\\Repositories\\Config.properties";
	
	public static final String chromepath = System.getProperty("user.dir")+"\\Driver1\\chromedriver.exe";
	
	public static final String log4jpath = System.getProperty("user.dir")+"\\log4j.xml";
	
	public static final String ReportsPath = System.getProperty("user.dir")+"\\Execution Reports\\"+Utilities.getDate()+"\\"+Utilities.getDatetime()+".html";
	

}

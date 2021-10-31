package Reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Constants.Constant;

public class Reports {
	public static ExtentReports report = new ExtentReports(Constant.ReportsPath,false);
	public static ExtentTest test;
	
	public static void startTest(String TestCaseName, String description) {
		test =report.startTest(TestCaseName, description);
		addSystemInformation();
		test.assignAuthor("Preeti");
		test.assignCategory("Regression");
	}
	// info, pass, fail, warn, fatal
	
	public static void info(String stepName, String details) {
		test.log(LogStatus.INFO, stepName, details);
	}
	
	public static void pass(String stepName, String details) {
		test.log(LogStatus.PASS, stepName, details);
	}
	
	public static void fail(String stepName, String details, String impathPath) {
		test.log(LogStatus.FAIL, stepName, details  + test.addScreenCapture(impathPath));
	}
	
	public static void warn(String stepName, String details) {
		test.log(LogStatus.WARNING, stepName, "<span style ='font-weight:bold;color:brown'>"+  details +"</span>")  ;
	}
	
	public static void fatal(String stepName, String details) {
		test.log(LogStatus.FATAL, stepName, details);
	}
		
	public static void endTest() {
		report.endTest(test);		
	}	
	
	public static void flush() {
		report.flush();
	}
	
	
	public static void addSystemInformation() {
		Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Version", "2.53.1");
		report.addSystemInfo(sysInfo);
		
	}
	
	
	

}



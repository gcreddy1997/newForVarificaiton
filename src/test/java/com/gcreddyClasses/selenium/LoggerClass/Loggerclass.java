package com.gcreddyClasses.selenium.LoggerClass;

import org.testng.annotations.Test;

import Reports.Log;



public class Loggerclass {
	@Test
	public static void loginActions1() {
	Log.startTest("Sample test case 1");
	
	Log.info("info method is executing");
	Log.pass("Pass method is executing");
	Log.fail("fail method is executing");
	Log.warn("warn method is exeucuting");
	Log.fatal("fatal method is exeucing");
	
	Log.endTest();
		
	}
	
	@Test
	public static void loginActions2() {
	Log.startTest("Sample test case 2");
	
	Log.info("info method is executing");
	Log.pass("Pass method is executing");
	Log.fail("fail method is executing");
	Log.warn("warn method is exeucuting");
	Log.fatal("fatal method is exeucing");
	
	Log.endTest();
		
	}
 
}

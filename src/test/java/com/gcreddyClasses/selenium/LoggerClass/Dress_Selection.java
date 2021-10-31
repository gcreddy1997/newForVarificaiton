package com.gcreddyClasses.selenium.LoggerClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppModule.AutomationPractice_LoginActions1;
import AppModule.LaunchEnv;
import Reports.Log;
import Reports.Reports;
import Utilities.Utilities;

public class Dress_Selection extends AutomationPractice_LoginActions1{
	
	@BeforeMethod
	public  void loginActions_validData() throws InterruptedException, IOException {
		Reports.startTest("LoginActiolns_ValidData", "Calling Re-usable component Login actions ");
		Log.info( "Calling Re-usable component Login actions ");	
		AutomationPractice_LoginActions1.LiginActions("gcreddy1997@gmail.com", "Test@1234","Valid","My account - My Store");	
	}
	 
	
	@Test
	public static void DressSelection() {
		
		
	}
	
	@AfterMethod
	public  void endTest() throws IOException {
		//Utilities.closeBrowser();
		Reports.endTest();
		Log.endTest();
	}
	
	
  
}

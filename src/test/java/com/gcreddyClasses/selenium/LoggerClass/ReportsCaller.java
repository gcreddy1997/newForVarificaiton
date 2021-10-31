package com.gcreddyClasses.selenium.LoggerClass;

import org.testng.annotations.Test;

import Reports.Reports;
import jdk.internal.org.jline.utils.Log;

public class ReportsCaller {
/*  @Test
  public void TestCase1() {
	  //start test ....infor, fail, pass,,,   endtest
	  Reports.startTest("Frist test case","Info level");
	  Reports.info("step 1", "This Info level test case");
	  Reports.endTest();
		  
  }
  
  @Test
  public void TestCase2() {
	  //start test ....infor, fail, pass,,,   endtest
	  Reports.startTest("Second test case","Pass level");
	  Reports.info("step 1", "This Info level test case");
	  Reports.pass("step 2", "This Pass level test case");
	  Reports.endTest();		  
  }
  
  @Test
  public void TestCase3() {
	  //start test ....infor, fail, pass,,,   endtest
	  Reports.startTest("Third test case","Fail level");
	  Reports.info("step 1", "This Info level test case");
//	  Reports.pass("step 2", "This Pass level test case");
	//  Log.warn("This Pass level test case");
	  Reports.fail("step 3", "This Fail level test case","‪C:\\Users\\User\\Desktop\\sample.png");
	  Reports.endTest();		  
  } 
  
  @Test
  public void TestCase4() {
	  //start test ....infor, fail, pass,,,   endtest
	  Reports.startTest("forth test case","Fail level");
	//  Log.info("This warn level test case");
	  Reports.info("step 1", "This Info level test case");
	  Reports.pass("step 2", "This Pass level test case");
	  Reports.fail("step 3", "This Fail level test case","‪C:\\Users\\User\\Desktop\\sample.png");
	  Reports.warn("step 4", "This warn level test case");
	  Reports.endTest();		  
  }  */
  
  @Test
  public void TestCase5() {
	  //start test ....infor, fail, pass,,,   endtest
	  Reports.startTest("fifth test case","Fail level");	  
	  Reports.warn("step 4", "This warn level test case");
	  Log.info("Browser invoked successfully");
	  Reports.fatal("step 5", "This fatal level test case");
	  Reports.endTest();
	  Reports.flush();
		  
  }
  
  
  
  
}

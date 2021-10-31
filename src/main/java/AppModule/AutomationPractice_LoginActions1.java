package AppModule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AppModule.LaunchEnv;
import AppModule.LoginActions;
import Reports.Log;
import Reports.Reports;
import Utilities.Utilities;
import Utilities.ExcelUtils;

public class AutomationPractice_LoginActions1 extends LaunchEnv {	
	
 
	public static void LiginActions(String un, String pw, String Criteria, String ExpContions) throws InterruptedException, IOException {
	
	
	// invoke the browser  -- re-usable component
	Assert.assertTrue( LaunchEnv.LaunchBrowser(prop_config.getProperty("Browser")),"Browser invocation failed");
	
	// invoke the application byr providng the url..
	Assert.assertTrue( LaunchEnv.launURL(prop_config.getProperty("App_URL")),"Application invocation failed");
	
	// click on sign in button.....
	Utilities.getLocator("Login_SignIn_Button_xpath").click();
	//	Reports.startTest("BrowserInvocation", "Browser invocation done successfully");
	//	Log.startTest("BrowserInvocation");
		
		// calling login Actions Re-usable component through AppModule
		Assert.assertTrue(LoginActions.Login(un, pw, Criteria,ExpContions  ));	
		Utilities.closeBrowser();
	}	
	
	
	
	
	
	
	
	
	
}

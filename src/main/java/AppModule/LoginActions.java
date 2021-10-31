package AppModule;

import org.testng.Assert;

import Reports.Log;
import Reports.Reports;
import Utilities.Utilities;

public class LoginActions extends Utilities {
	public static boolean flag;

	public static boolean Login(String uname, String password, String Criteria, String ExpConcitions) {
		flag = false;
		try {
			Log.info("Performing click on signin  ");

			Log.info("Performing Login operation");

			Utilities.getLocator("Login_userName_txtBox_id").sendKeys(uname);
			Log.info("Username entered : " + uname);
			Utilities.getLocator("Login_password_txtbox_name").sendKeys(password);
			Log.info("Password entered : " + password);
			Utilities.getLocator("Login_submit_button_id").click();
			Log.info("Submit button clicked");
			

			if (Criteria.equalsIgnoreCase("Valid")) {
				try {
					Assert.assertEquals(config_Repository.getProperty("Home_Title"), driver.getTitle());
					Reports.pass("Test Login", "User successfully Logged in");
					Log.info("picas_dashboard page is displayed successfully");
					flag = true;
				} catch (AssertionError e) {
					Reports.fail("Test Login", "Unable to Login", "");
				}
			}
			if (Criteria.equalsIgnoreCase( "InValid") ){
				try {
					Assert.assertEquals(ExpConcitions, driver.getTitle());
					Reports.pass("Test Login", "User successfully Logged in");
					Log.info("picas_dashboard page is displayed successfully");
					flag = true;
				} catch (AssertionError e) {
					Reports.fail("Test Login", "Unable to Login", "");
				}
			}

			Reports.pass("User Login", "User successfully Logged in with UID " + uname + "and password " + password);
		} catch (Exception e) {
			String filepath = Utilities.getfailScreenshot();
			// Reports.attachfailScreenshot("Login", e.getMessage(), filepath);
			e.printStackTrace();
		}
		return flag;
	}

}

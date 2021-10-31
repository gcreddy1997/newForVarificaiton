package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppModule.LaunchEnv;
import Constants.Constant;
import Reports.Log;
import Reports.Reports;


public class Utilities extends LaunchEnv {
	public static Properties prop;
	public static FileInputStream f;
	public static WebElement element;
	public static Properties config_Repository  = Utilities.loadProperty(Constant.config_path);
	public static Properties locator_Repository = Utilities.loadProperty(Constant.locaters_path);
    public static String filepath;
	public static Properties loadProperty(String Filepath) {
			prop = null;
		prop = new Properties();

		try {
			f = new FileInputStream(Filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

//---------------------------------------------------------------------------------------------------------------------	
	public static WebElement getLocator(String Key) {
		element = null;
		String value = locator_Repository.getProperty(Key);
		Log.info("Value of the proovided " + Key + "  = :" + value);
		if (Key.endsWith("_name")) {
			element = driver.findElement(By.name(value));
			HighlighElement(element);
		} else if (Key.endsWith("_id")) {
			element = driver.findElement(By.id(value));
			HighlighElement(element);
		} else if (Key.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(value));
			HighlighElement(element);
		} else if (Key.endsWith("_lnkText")) {
			element = driver.findElement(By.linkText(value));
			HighlighElement(element);
		} else
			Log.info("Your provided key is not valid");

		return element;
	}
//---------------------------------------------------------------------------------------------------------------------
	
	
	public static void HighlighElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');", element);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Reports.fail("",e.toString(),"filepath");
				e.printStackTrace();
			}
			//((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'border: solid 2px green ');",
			//		element);
		}
	//---------------------------------------------------------------
	public static void closeBrowser() throws IOException {
		try {
			Log.info("Closing Browser");
			driver.quit();

		} catch (Exception e) {
			Reports.fail("",e.toString(),"FilePath");
			e.printStackTrace();

		}

	}
 //--------------------------------------------------------------

	public static List<WebElement> ElementCollection(String xpath)
	{
		List<WebElement> collections = driver.findElements(By.xpath(xpath));
		return collections;
	}
//	-----------------------------------------------------------------------------------------

	/***************************************************************************************
	 * This function will take screenshot on faliure of test cases.
	 * 
	 * @return filepath
	 * @see Use this function on negative secnarios.
	 * 
	 **************************************************************************************/
	
	public static String getfailScreenshot() {
		try {
			 filepath = null;
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir") + "\\Screenshots\\FaliureScreenshots\\" + System.currentTimeMillis()
					+ ".png";
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			Reports.fail("",e.toString(),filepath);
			e.printStackTrace();
		}
		return filepath;
	}
//--------------------------------------------------------------------------------------

	/*************************************************************************************
	 * This function will get screenshot on Success of executed Test Cases.
	 * 
	 * @return filepath This function will return the String path of the
	 *         screenshot.
	 * @exception IOException
	 **************************************************************************************/
	public static String getSuccessScreenshot() {
		try {
			filepath = null;
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir") + "\\Screenshots\\SuccessScreenshots\\"
					+ System.currentTimeMillis() + ".png";
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			Reports.fail("",e.toString(),filepath);
			e.printStackTrace();
		}
		return filepath;
	}

	/*****************************************************************************************
	 * This function will dynamically wait for pageload.
	 * 
	 * @exception Exception
	 ****************************************************************************************/
	public static void Elementwait() throws Exception {	
		Log.info("Waiting for page load");
		Thread.sleep(1000);
		WebDriverWait explicitwait = new WebDriverWait(driver, 120);
		explicitwait.withTimeout(60, TimeUnit.SECONDS);
		explicitwait.pollingEvery(2, TimeUnit.SECONDS);
		explicitwait.ignoring(NoSuchElementException.class);
	//	explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img.timer.center-block")));
		Thread.sleep(500);	
	}

	/*****************************************************************************************
	 * This function will dynamically wait for text on element to be present.
	 * 
	 * @param Key
	 * @param text
	 * @throws InterruptedException 
	 * @exception Exception
	 ****************************************************************************************/
	public static void waitForTextToBeDisplayed(String Key) throws InterruptedException {
			Thread.sleep(1000);
			Log.info("Waiting for the Element to be visible");
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.withTimeout(200, TimeUnit.SECONDS);
			wait.pollingEvery(3, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(InvalidSelectorException.class);
			wait.until(ExpectedConditions.visibilityOf(Utilities.getLocator(Key)));		
	}

	/*	public static void waitinfo("Waiting for the text '"+text+"' to display"){
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.withTimeout(200, TimeUnit.SECONDS);
				wait.pollingEvery(2, TimeUnit.SECONDS);
				wait.ignoring(NoSuchElementException.class);
			//	wait.ignoring(InForTextToBeDisplayed(String Key, String text) throws InterruptedException {
	
				Thread.sleep(2000);
			//	LovalidSelectorException.class;
		//		wait.until(ExpectedConditions.textToBePresentInElement(getLocater(Key), text));	
	
		}   */
		//--------------------------------------------------------
		public static void waitForElementClickable(String Key) throws InterruptedException {	
			Thread.sleep(2000);
			Log.info("Waiting for the Element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.withTimeout(60, TimeUnit.SECONDS);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(InvalidSelectorException.class);
			wait.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.elementToBeClickable(getLocator(Key)));
	
	}

		/*****************************************************************************************
		 * This function wait implicitly for mentioned time duration.
		 * 
		 * @exception Exception
		 ****************************************************************************************/
		public static void waitImplicit() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		public static void getCurrentDate() {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			Date date = new Date();
			System.out.println(date);
			//String founddate = dateFormat.format(date);
			// System.out.println(founddate);
			// System.out.println(dateFormat);// 2014/08/06 15:59:48
			// return founddate;
			/*sys
		
			String[] parts = founddate.split(" ");
			// String part1 = parts[0]; // 004
			String[] appenderpart1 = parts[0].split("/");
			String[] appenderpart2 = parts[1].split(":");
			String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];*/
			// System.out.println(appender);
			//return appender;
		}

		/***************************************************************************************
		 * This function will give you System date time in string format
		 * 
		 * @return This function will return date time in String format.
		 **************************************************************************************/
		public static String getDate() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String founddate = dateFormat.format(date);
			String[] parts = founddate.split(" ");
			String[] appenderpart1 = parts[0].split("/");
			String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
			return appender;
		}

		/***************************************************************************************
		 * This function will give you System date time in string format
		 * 
		 * @return This function will return date time in String format.
		 **************************************************************************************/
		public static String getDatetime() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String founddate = dateFormat.format(date);
			Log.info(dateFormat.format(date));    // 2014/08/06 15:59:48
		
			String[] parts = founddate.split(" ");
			// String part1 = parts[0]; // 004
			String[] appenderpart1 = parts[0].split("/");
			String[] appenderpart2 = parts[1].split(":");
			String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
			Log.info(appender);
			return appender;
		}

		/*******************************************************************************************
		 * This function will clean the framework and will delete the files and
		 * folder for specific mentioned time duration
		 * 
		 * @param daysBack
		 * @param dirWay
		 ******************************************************************************************/
		public static void FrameworkcleanUp(int daysBack, String dirWay) {
		
			File directory = new File(dirWay);
			if (directory.exists()) {
		
				File[] listFiles = directory.listFiles();
				long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
				for (File listFile : listFiles) {
					if (listFile.lastModified() < purgeTime) {
						if (!listFile.delete()) {
							System.err.println("Unable to delete file: " + listFile);
						}
					}
				}
			}
		}
	
//----------------------------------------------------------------------------------------------------	
	
	}
package com.utilities;


import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public static SoftAssert softAssert;


	// creating the ReadConfig to use/read method from ReadConfig.java class
	ReadConfig readconfig = new ReadConfig();

	public String br = readconfig.getConfigValue("browser");
	public String url = readconfig.getConfigValue("Openurl");
	public String username = readconfig.getConfigValue("username");
	public String password = readconfig.getConfigValue("password");

	@Parameters({"url"})// This is for TestNG.xml file
	@BeforeClass
	//public void setup(@Optional() String url) throws InterruptedException, IOException {// This is for TestNG.xml file
		public void setup() throws InterruptedException, IOException {// This is for Test case Run
		try {

			if (br.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (br.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (br.equalsIgnoreCase("ie")) {
				//System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}

			else if (br.equalsIgnoreCase("edge")) {
				//System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Successfully launch brwoser " + br);
				Reporting.successLog("Successfully launch brwoser " + br);
			}
		}catch(Exception e){
			System.out.println("Failure to launch brwoser " + br);
		}

		driver.get(url);
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		logger = Logger.getLogger("smms");
		PropertyConfigurator.configure("log4j.properties");

	}

	@BeforeMethod
	public void beforeMethod() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		softAssert.assertAll();
	}
	// Click any ObjectElement. This Method we can use in our any test case to click elements
	public void ClickObj(WebElement ele, String msg) {
		try {
			waitForElementToBeClickable(ele);
			ele.click();
			System.out.println("Successfully Click " + msg);
			Reporting.successLog("Successfully Click " + msg);
		}catch(Exception e) {

			System.out.println("Failure to Click " + msg);
			Reporting.failureLog("Failure to Click " + msg);
			//Assert.fail("Failure to Click " + msg+" "+e.getMessage());
			softAssert.fail("Failure to Click " + msg+" "+e.getMessage());
		}
	}

	// Enter any text in then textElement box. This Method we can use in our any test case to enter text in the  elements
	public void EnterTxt(WebElement element, String txt, String msg) {

		try {
			waitForElementToBeClickable(element);
			element.sendKeys(txt);
			System.out.println("Successfully Enter Text " + msg);
			Reporting.successLog("Successfully Enter Text " + msg);
		}catch (Exception e) {
			System.out.println("Failure to Enter " + msg);
			Reporting.failureLog("Failure to Enter " + msg);
			Assert.fail("Failure to Enter " + msg+" "+e.getMessage());
		}		
	}
	// This is for get text
	public String getElementText(WebElement ele, String msg) {
		String text =null;
		try {
			waitForElementToBeClickable(ele);
			text = ele.getText();
			//System.out.println("Successfully get element text " + msg);
			//Reporting.successLog("Successfully get element text " + msg);
			return text;
		}catch (Exception e) {
			System.out.println("Failure to Enter " + msg);
			Reporting.failureLog("Failure to get element text " + msg);
			Assert.fail("Failure to  get element text " + msg+" "+e.getMessage());
			return null;
		}		
	}
	// To generate rendom String
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	// To generate rendom Number
	public String randomeNum() {
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}


	// Wait for element argument is By locator
	public static WebElement waitForElementToBeVisible(By locator) {
		try {
			WebElement ele = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			return ele;
		}catch (Exception e) {
			return null;
		}
	}
	// Wait for element argument is WebElement locator
	public static WebElement waitForElementToBeClickable(WebElement locator) {
		try {
			WebElement ele = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			return ele;
		}catch (Exception e) {
			return null;
		}
	}

	public static void pauseExecution(int milliSec) {
		try {
			Thread.sleep(milliSec);
		}catch (Exception e) {
			// TODO: handle exception
		}		 
	}
	// Select from Drop down List using Visible Text
	public static void selectfromlist(WebElement ele, String text, String msg) {
		try {
			waitForElementToBeClickable(ele);
			Select select = new Select(ele);
			select.selectByVisibleText(text);
			System.out.println("Successfully select " + msg);
			Reporting.successLog("Successfully select " + msg);
		}catch(Exception e) {
			System.out.println("Failure to  select " + msg);
			Reporting.failureLog("Failure to  select " + msg);
			Assert.fail("Failure to  select " + msg+" "+e.getMessage());
		}

	}
	// Select from Drop down List using Index
	public static void selectIndexfromlist(WebElement ele, int indexNumber, String msg) {
		try {
			waitForElementToBeClickable(ele);
			Select select = new Select(ele);
			select.selectByIndex(indexNumber);
			System.out.println("Successfully select " + msg);
			Reporting.successLog("Successfully select " + msg);
		} catch (Exception e) {
			System.out.println("Failure to select " + msg);
			Reporting.failureLog("Failure to select " + msg);
			Assert.fail("Failure to  select " + msg+" "+e.getMessage());
		}
	}
// Get Element Display
	public static boolean getElementDiaplay(By locator, String msg) {
		boolean eleDisplay=false;
		try {
			WebElement ele = waitForElementToBeVisible(locator);
			eleDisplay =ele.isDisplayed();
			System.out.println("Successfully element display " + msg);
		}catch(Exception e) {
			System.out.println("Failure to  display element " + msg);
			Reporting.failureLog("Failure to  display element " + msg);
			Assert.fail("Failure to  display element " + msg+" "+e.getMessage());
		}
		return eleDisplay;
	}
	// Get Element Display
	public static boolean getElementDiaplay(WebElement ele, String msg) {
		boolean eleDisplay=false;
		try {		
			waitForElementToBeClickable(ele);
			eleDisplay =ele.isDisplayed();
			System.out.println("Successfully element display " + msg);
			Reporting.successLog("Successfully element display " + msg);
		}catch(Exception e) {
			System.out.println("Failure to  display element " + msg);
			Reporting.failureLog("Failure to  display element " + msg);
		}
		return eleDisplay;
	}

	public static boolean getElementDiaplayWithoutWait(WebElement ele, String msg) {
		boolean eleDisplay=false;
		try {		
			eleDisplay =ele.isDisplayed();
			System.out.println("Error PopUp displayed for" + msg);
			Reporting.successLog("Error PopUp displayed for" + msg);
		}catch(Exception e) {
			System.out.println("Red Popup was not present for " + msg);
			Reporting.failureLog("Red Popup was not present for " + msg);
		}
		return eleDisplay;
	}
	// Mouse HoverOver
	public void mouseHoverOver(WebElement ele, String msg) {
		try {
			//Creating object of an Actions class
			Actions action = new Actions(driver);

			//Performing the mouse hover action on the target element.
			action.moveToElement(ele).perform();
			System.out.println("Successfully element HoverOver " + msg);
			Reporting.successLog("Successfully element HoverOver " + msg);
		}catch(Exception e) {
			System.out.println("Failed to element HoverOver " + msg);
			Reporting.failureLog("Failed to element HoverOver " + msg);
	}
	

	
	// To Close all the Browser
	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */
	}
}

package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JavaScriptUtil {
	
	// To Draw Border with any color
	public static void DrawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
			}
	
	//To get the title of the page
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
			}
	
	// To click any elements
	public static void ClickElementByJS(WebElement element, WebDriver driver) {
		try {
			BaseClass.waitForElementToBeClickable(element);
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", element);
			Reporting.successLog("Successfully Click " );
		}catch(Exception e) {
			Reporting.failureLog("Failure to Click " );
			Assert.fail("Failure to Click " +e.getMessage());
		}
	}
	// To generate own Alert
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}

	// To Refresh the Browser
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	// Scroll  Page Down
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	// Scroll  Page Up
		public static void scrollPageUp(WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		}
		
		// Zoom In/Out
				public static void zoomPageByJS(WebDriver driver) {
					JavascriptExecutor js=((JavascriptExecutor)driver);
					js.executeScript("document.body.style.zoom='50%'");
				}
}

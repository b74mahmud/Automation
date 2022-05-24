// This is listener class to generate extent report. which will listen and take action according to the method we used here.it has one entry in TestNG.xml class as Listener tag. whenever we have to use this classes then we have to add this tag in all the xml file we will create.

package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter
{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest logger;
	//public static WebDriver driver;



	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//will give you current time stamp.
		String repName="Test-Report-"+timeStamp+".html"; // we can give any report name here instad "Test-Report". we can type Smoke test report or etc.

		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

		extent=new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost"); // we have to mention computer name in LocalHost place.
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Biplab");

		htmlReporter.config().setDocumentTitle("SMMS Test Project"); // Tile of report
		htmlReporter.config().setReportName("SMMS Project Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	public void onTestStart(ITestResult tr) {
		logger=extent.createTest(tr.getName());
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		
		successLog(tr.getName());
	}


	public void onTestFailure(ITestResult tr)
	{
				failureLog(tr.getName());// create new entry in the report
	}


	public void onTestSkipped(ITestResult tr)
	{
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
    public static void successLog(String message) {
    	logger.log(Status.PASS,MarkupHelper.createLabel(message,ExtentColor.GREEN));
    }
    
    public static void failureLog(String message) {
    	try {
    		 logger.log(Status.FAIL,MarkupHelper.createLabel(message,ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
    			
    	        String base64Screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BASE64);
    	        
    			logger.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	}catch (Exception e) {
    		 logger.log(Status.FAIL,MarkupHelper.createLabel("Failure to take screenshot",ExtentColor.RED));
		}
       
    }
    
    public static void infoLog(String message) {
    	logger.log(Status.INFO,MarkupHelper.createLabel(message,ExtentColor.BLUE));
    }
    
    public static void infoLogWithSS(String message) {
    	try {
    		 logger.log(Status.INFO,MarkupHelper.createLabel(message,ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
    			
    	        String base64Screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BASE64);
    	        
    			logger.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	}catch (Exception e) {
    		 logger.log(Status.FAIL,MarkupHelper.createLabel("Failure to take screenshot",ExtentColor.RED));
		}
       
    }
}
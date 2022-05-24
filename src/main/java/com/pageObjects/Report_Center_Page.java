package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.BaseClass;
import com.utilities.Reporting;

public class Report_Center_Page extends BaseClass {
	WebDriver driver;

	public Report_Center_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//*[text()='Reporting Center']") 
	public WebElement Auvs_ReportingCenter;
	//
	@FindBy(xpath="//*[contains(text(),'Reports Center')]") 
	public WebElement CLI_reportCenter;

	@FindBy(xpath="//*[contains(text(),'Reports')])[2]") 
	public WebElement etracker_reportCenter;

	@FindBy(xpath="(//*[contains(text(),'Reports')])[2]") 
	public WebElement RMS_reportCenter;

	@FindBy(xpath="//*[contains(text(),'Reporting Center')]") 
	public WebElement tibercreekRMS_reportCenter;

	@FindBy(xpath="//i[@alt=\\\"Reporting Center Icon\\") 
	public WebElement icon_reportCenter;

	@FindBy(xpath="/html/body/div[4]/div/div/div[1]/button") 
	public WebElement pop_Xbutton;

	public void ReportingCenter() {


		String url1 = driver.getCurrentUrl();
		System.out.println("URL is: " + url1);
		Reporting.successLog("URL is: " + url1);
		pauseExecution(10000);
		if ((url1.equalsIgnoreCase("https://testusarv3.tibercreek.local/v3/CLI")
				|| (url1.equalsIgnoreCase("https://g1-hub.rcms.local/v4/etrackerHRP/")))) {
			ClickObj(CLI_reportCenter, "Report Blade");
			//			 driver.findElement(By.xpath("//*[contains(text(),'Reports Center')]")).click();

		} else if (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS")) {
			//driver.findElement(By.xpath("(//*[text()='Reporting Center']")).click();
			ClickObj(Auvs_ReportingCenter, "Report Blade");
			
		} else if (url1.equalsIgnoreCase("https://g1-hub.rcms.local/v4/etracker/")) {
			//driver.findElement(By.xpath("(//*[contains(text(),'Reports')])[2]")).click();
			ClickObj(etracker_reportCenter, "Report Blade");


		} else if (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/RMS/")) {
			//driver.findElement(By.xpath("(//*[contains(text(),'Reports')])[2]")).click();
			ClickObj(RMS_reportCenter, "Report Blade");


		} else if (url1.equalsIgnoreCase("https://buildusarv3.tibercreek.local/v3/rms/")) {
			//driver.findElement(By.xpath("//*[contains(text(),'Reporting Center')]")).click();
			ClickObj(tibercreekRMS_reportCenter, "Report Blade");

		} else {
			ClickObj(icon_reportCenter, "Report Blade");
			//driver.findElement(By.xpath("//i[@alt=\"Reporting Center Icon\"]")).click();
		}

		List<WebElement> childLinks = driver.findElements(By.xpath("//a[@class='rc-node rc-node-without-children']"));
		int childLinksSize = childLinks.size();
		System.out.println("Total Links are: " + childLinksSize);
		Reporting.successLog("Total Links are: " + childLinksSize);// added
		// starting from here
		if (!(url1.equalsIgnoreCase("https://buildusarv3.tibercreek.local/v3/rms/"))) 
		{

			// below is originals
			for (int i = 0; i < childLinksSize; i++) {
				System.out.println("I value is: " + i);
				Reporting.successLog("I value is: " + i);
				childLinks.get(i).click();
				pauseExecution(10000);
				
				boolean textdisplayed2 = driver
						.findElement(By.xpath("//select[@name='DataTables_Table_" + i + "_length']")).isDisplayed();
				if (textdisplayed2 == false) {
					Assert.assertTrue(false);
				}
// To closing extra popup window (index 3,7,8)
				if ((i == 3) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS"))
						|| ((i == 7) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS"))
								|| ((i == 8) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS")))))
				{
					pauseExecution(10000);
					ClickObj(pop_Xbutton, "Popup close Button");
					// driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click();
					pauseExecution(50000);
				}
			}
		} else {

			for (int j = 0; j < childLinksSize; j++) {
				System.out.println("j value is: " + j);
				Reporting.successLog("j value is: " + j);
				childLinks.get(j).click(); 
				pauseExecution(10000);
				boolean textdisplayed = driver
						.findElement(By.xpath("//select[@name='DataTables_Table_" + (+j + 1) + "_length']"))
						.isDisplayed();
				if (textdisplayed == false) {
					Assert.assertTrue(false);
				}
			}
		}
	}
}

//ClickObj(reportCenter, "Report Blade");
//pauseExecution(10000);

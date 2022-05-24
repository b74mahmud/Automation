package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.BaseClass;

public class Sample_original_Page extends BaseClass {
	WebDriver driver;

	public Sample_original_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 @FindBy(xpath="(//*[@class='noselect panel-title'])[4]") 
	  public WebElement reportCenter;
	 
	 public void sample_Test() {
	
		 
			 String url1 = driver.getCurrentUrl();
			 System.out.println("URL is: " + url1);
				pauseExecution(10000);
			 if ((url1.equalsIgnoreCase("https://testusarv3.tibercreek.local/v3/CLI")
			 || (url1.equalsIgnoreCase("https://g1-hub.rcms.local/v4/etrackerHRP/")))) {
			 driver.findElement(By.xpath("//*[contains(text(),'Reports Center')]")).click();



			 } else if (url1.equalsIgnoreCase("https://g1-hub.rcms.local/v4/etracker/")) {
			 driver.findElement(By.xpath("(//*[contains(text(),'Reports')])[2]")).click();



			 } else if (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/RMS/")) {
			 driver.findElement(By.xpath("(//*[contains(text(),'Reports')])[2]")).click();



			 } else if (url1.equalsIgnoreCase("https://buildusarv3.tibercreek.local/v3/rms/")) {
			 driver.findElement(By.xpath("//*[contains(text(),'Reporting Center')]")).click();



			 } else {
			 driver.findElement(By.xpath("//i[@alt=\"Reporting Center Icon\"]")).click();
			 }
			 List<WebElement> childLinks = driver.findElements(By.xpath("//a[@class='rc-node rc-node-without-children']"));
			 int childLinksSize = childLinks.size();
			 System.out.println("Total Links are: " + childLinksSize);
			 // starting from here
			 if (!(url1.equalsIgnoreCase("https://buildusarv3.tibercreek.local/v3/rms/"))) {



			 // below is originals
			 for (int i = 0; i < childLinksSize; i++) {
			 System.out.println("I value is: " + i);
			 childLinks.get(i).click();
				pauseExecution(10000);
			 boolean textdisplayed2 = driver
			 .findElement(By.xpath("//select[@name='DataTables_Table_" + i + "_length']")).isDisplayed();
			 if (textdisplayed2 == false) {
			 Assert.assertTrue(false);
			 }



			 if ((i == 3) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS"))
			 || ((i == 7) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS"))
			 || ((i == 8) && (url1.equalsIgnoreCase("https://smms-hub.rcms.local/v3/AUVS"))))) {
					pauseExecution(10000);
			 driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click();
			 }
			 }
			 } else {



			 for (int j = 0; j < childLinksSize; j++) {
			 System.out.println("j value is: " + j);
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
		
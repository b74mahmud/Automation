package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.BaseClass;


  public class Panel1_ClickRecordAndSeePanel3And4Opens extends BaseClass{
	  
	  WebDriver ldriver;

		public Panel1_ClickRecordAndSeePanel3And4Opens(WebDriver rdriver) {
			this.ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath = "//a[@class='treeitem-node wb-node wb-node-without-children']") 
		@CacheLookup
		public WebElement panel1firstrow;
		
		@FindBy(xpath = "//*[@id=\\\"DataTables_Table_0\\\"]/tbody/tr[1]") 
		@CacheLookup
		public WebElement panel2firstrow;
		
  
  public void panel1_clickRecordAndSeePanel3And4Opens() throws  InterruptedException {
  
	  
 		ClickObj(panel1firstrow, "Panel 1 ");
		Thread.sleep(18000);
		ClickObj(panel2firstrow, "Panel2");
		Thread.sleep(18000);
		// it is
		boolean isPanel3Displayed = driver
		.findElement(By.xpath("(//div[@class='tab-pane fade nav-panel-parent active in'])[2]")).isDisplayed();
		System.out.println(isPanel3Displayed);
		boolean isPanel4Displayed = driver
		.findElement(By.xpath("(//div[@class='tab-pane fade nav-panel-parent active in'])[3]")).isDisplayed();
		System.out.println(isPanel4Displayed);
		if ((isPanel3Displayed) && (isPanel4Displayed)) {
		Assert.assertTrue(true);
		} else {
		Assert.assertTrue(false);
		}
		//driver.quit();
		}
		}


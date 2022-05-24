package com.pageSteps;

import org.openqa.selenium.WebElement;

import com.pageObjects.AdministrationCenterPage;
import com.utilities.BaseClass;
import com.utilities.Reporting;

public class AdministrationCenterSteps extends BaseClass{
	
	/*
	 * @FindBy(xpath="//button[@class='toast-close-button']") public WebElement
	 * closeIconOnPopup; WebDriver driver;
	 * 
	 * public AdministrationCenterPage(WebDriver rdriver) { this.driver = rdriver;
	 * PageFactory.initElements(rdriver, this); }
	 * 
	 * 
	 * @FindBy(xpath="//span[normalize-space()='Administration Center']") public
	 * WebElement Admin_bld;
	 * 
	 * @FindBy(xpath="//a[@class='node-without-children']") public List<WebElement>
	 * treeItems;
	 */

	
	public void AdminCenterTree() {
		pauseExecution(5000);
		AdministrationCenterPage acp= new AdministrationCenterPage(driver);
		
		 ClickObj(acp.Admin_bld, "Administration Center"); 
		 
		for (int i=0; i<acp.treeItems.size(); i++) {
			WebElement ChildList = acp.treeItems.get(i);
			String itemName = getElementText(ChildList,"Tree items text");
			pauseExecution(2000);
			ClickObj(ChildList, "Tree items text " + itemName);
			// This is for Red popup handel
			if(getElementDiaplayWithoutWait(acp.closeIconOnPopup, "Popup on item "+itemName)) {
				Reporting.infoLogWithSS("Screenshot for item "+itemName);
				pauseExecution(2000);
			}
		}
	}
}

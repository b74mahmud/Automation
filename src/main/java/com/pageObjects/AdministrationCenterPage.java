package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;


public class AdministrationCenterPage extends BaseClass{
	
	
	WebDriver driver;
	
	public AdministrationCenterPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 @FindBy(xpath="//button[@class='toast-close-button']") 
	  public WebElement closeIconOnPopup;

	@FindBy(xpath="//*[contains(text(),'Administration')]")
	
	//span[normalize-space()='Administration Center']
	public WebElement Admin_bld;

	@FindBy(xpath="//a[@class='node-without-children']")
	public List<WebElement> treeItems;
	

	
	/*
	 * public void AdminCenterTree() {
	 * 
	 * ClickObj(Admin_bld, "Administration Center");
	 * 
	 * for (int i=0; i<treeItems.size(); i++) { WebElement ChildList =
	 * treeItems.get(i); String itemName =
	 * getElementText(ChildList,"Tree items text"); pauseExecution(2000);
	 * ClickObj(ChildList, "Tree items text " + itemName); // This is for Red popup
	 * handel if(getElementDiaplayWithoutWait(closeIconOnPopup,
	 * "Popup on item "+itemName)) {
	 * Reporting.infoLogWithSS("Screenshot for item "+itemName);
	 * pauseExecution(2000); } } }
	 */
}

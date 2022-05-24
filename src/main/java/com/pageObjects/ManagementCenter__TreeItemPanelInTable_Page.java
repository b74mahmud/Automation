package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.BaseClass;
import com.utilities.JavaScriptUtil;
import com.utilities.Reporting;

public class ManagementCenter__TreeItemPanelInTable_Page extends BaseClass{

	WebDriver driver;

	public ManagementCenter__TreeItemPanelInTable_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath="//h2[text()='Command Center']") 
	  public WebElement commandCenter;

	  @FindBy(xpath="//div[@id='entityViewNavigatorOne']") 
	  public WebElement firstTable;
	//div[@id='entityViewNavigatorOne']//div[@class='widget-body']
	  
	  @FindBy(xpath="//div[@id='entityViewNavigatorTwo-widget']") 
	  public WebElement secondTable;
	//div[@id='entityViewNavigatorTwo-widget']//div[@class='widget-body']
	  
	  @FindBy(xpath="//button[@class='toast-close-button']") 
	  public WebElement closeIconOnPopup;
	  
	public void TreeItemPanelInTable() {

		List<WebElement> Weblist = driver .findElements(By.xpath("//a[@class='treeitem-node wb-node wb-node-without-children']"));

		List<WebElement> parent = driver.findElements(By.xpath("//li[@class='parent_li closed-node']"));
	
		for (int j = 0; j < parent.size(); j++) {
			WebElement parentList = parent.get(j);
			String parentText = getElementText(parentList, "Parent text is: "+parentList.getText()); 
			ClickObj(parentList, "Parent text: "+parentText);
			//pauseExecution(1000);
		}
		for (int i = 0; i <Weblist.size() ; i++) {
			WebElement ChildLists = Weblist.get(i);

			String itemName = getElementText(ChildLists,"Tree items text is: "+ChildLists.getText());//Pending Review 15,274				
			WebElement totalCountInTree = null;
			
			try {
				totalCountInTree =  ChildLists.findElement(By.tagName("span"));
			}catch (Exception e) {
			}
			
			if(totalCountInTree == null) {
				continue;
				} 	

			ClickObj(ChildLists, "The Tree Item: "+itemName); 			
			
			// This is for Red popup handel
			if(getElementDiaplayWithoutWait(closeIconOnPopup, "Popup on item "+itemName)) {
				Reporting.infoLogWithSS("Screenshot for item "+itemName);
				ClickObj(closeIconOnPopup, "Popup closed "+itemName);
			}
			
			pauseExecution(5000);
			By locator_FirstRecordInTable = By.xpath("//div[contains(@class,'active in')]//table[contains(@id,'DataTables_Table')]//tbody//td[2]");
			WebElement firstRecord = waitForElementToBeVisible(locator_FirstRecordInTable);
			ClickObj(firstRecord, "Select First record in table "+itemName); 	
			//pauseExecution(3000);
			if(getElementDiaplay(firstTable,"First Panel") && getElementDiaplay(secondTable,"Second Panel") ) {
				System.out.println("Two panels displayed correctly " + itemName);
				Reporting.successLog("Two panels displayed correctly " + itemName);
				//Assert.assertTrue(true,"Two panels not displayed correctly " + itemName);
			}else {
				System.out.println("Two panels not displayed correctly " + itemName);
				Reporting.failureLog("Two panels not displayed correctly " + itemName);
				//Assert.fail("Two panels not displayed correctly " + itemName);
			}			
			//waitForElementToBeClickable(commandCenter);
			//pauseExecution(8000);
			JavaScriptUtil.ClickElementByJS(commandCenter, driver);
			//ClickObj(commandCenter, "Command center"); 
			pauseExecution(3000);
		}

	}
}


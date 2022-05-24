package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Reporting;

public class RMS_ManagementCenter_Page extends com.utilities.BaseClass{

	WebDriver driver;

	public RMS_ManagementCenter_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="//div[contains(@class,'active in')]//div[contains(@id,'DataTables_Table_') and contains(@class,'dataTables_info')]")
	public WebElement totalRecords;	
	
	
	  @FindBy(xpath
	  ="//*[@class='treeitem-node wb-node-with-children' and @data-type='6']")
	  public List<WebElement> treeFolders;
	 
	
	public void validateTreeItemCountInTable() {
		for (int i = 0; i < treeFolders.size(); i++) {
			WebElement treeFolder = treeFolders.get(i);
			String folderText = getElementText(treeFolder, "Folder text");
			ClickObj(treeFolder, "Click foler "+folderText);
			
			By locator = By.xpath("(//*[@class='treeitem-node wb-node-with-children' and @data-type='6'])["+(i+1)+"]//following-sibling::ul//a[contains(@class,'treeitem-node wb-node wb-node-without-children')]");
			pauseExecution(3000);
			waitForElementToBeVisible(locator);
			List<WebElement> lst_TreeItems =  driver.findElements(locator);
			
			for(int j=0;j<lst_TreeItems.size();j++) {
				WebElement ChildList = lst_TreeItems.get(j);
				String itemName = getElementText(ChildList,"Tree items text");//Pending Review 15,274
				String tot_Records = getElementText(ChildList,"Tree items text").replaceAll("[^0-9]", "");//15,274
			
				if(tot_Records.isEmpty()) {tot_Records="0";}
				
				//String tot_Records = getElementText(treeItemsCount.get(i),"Item count");
				System.out.println("Total Records in Tree item "+tot_Records);
				Reporting.infoLog("Total Records in Tree item "+tot_Records);
				ClickObj(ChildList, "the Tree Item "+itemName); 			   
				
				pauseExecution(3000);
				
				String str_TotRecords = getElementText(totalRecords,"Item count");// Showing 1 to 100 of 15,274 entries
				
				String tableTotRecord1 =str_TotRecords.split("of")[1].trim();//15,274 entries
				String tableTotRecord2 = tableTotRecord1.split(" ")[0].trim().replace(",", "");//15274
			
				if(tot_Records.equals(tableTotRecord2)) {
					System.out.println("Count matched Successfully for tree item " + itemName);
					Reporting.successLog("Count matched Successfully for tree item " + itemName);
				}else {
					System.out.println("Failure to match Count for tree item " + itemName);
					Reporting.failureLog(" Failure to match Count for tree item " + itemName);
				}
				pauseExecution(3000);
			}
			
		}
	}
}

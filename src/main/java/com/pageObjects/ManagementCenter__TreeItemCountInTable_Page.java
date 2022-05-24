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

public class ManagementCenter__TreeItemCountInTable_Page extends BaseClass{

	WebDriver driver;

	public ManagementCenter__TreeItemCountInTable_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath="//div[contains(@class,'active in')]//div[contains(@id,'DataTables_Table_') and contains(@class,'dataTables_info')]") 
	  public WebElement totalRecords;
	  @FindBy(xpath="//button[@class='toast-close-button']") 
	  public WebElement closeIconOnPopup;
	  
	public void TreeItemCountInTable() {
		
		  List<WebElement> Weblist = driver .findElements(By.xpath("//a[@class='treeitem-node wb-node wb-node-without-children']"));
					System.out.println(Weblist.size());

				List<WebElement> parent = driver.findElements(By.xpath("//li[@class=\"parent_li closed-node\"]"));
				System.out.println(parent.size());
				//span[@aria-expanded='false']
				
				for (int j = 0; j < parent.size(); j++) {
				WebElement parentList = parent.get(j);
				String parentText = getElementText(parentList, "Parent text is: "+parentList.getText()); 
				ClickObj(parentList, "Parent text: "+parentText);
				pauseExecution(1000);
				}
	for (int i = 0; i <Weblist.size() ; i++) {
				WebElement ChildLists = Weblist.get(i);
			
				String itemName = getElementText(ChildLists,"Tree items text is: "+ChildLists.getText());//Pending Review 15,274				
				String tot_Records=null;
				WebElement total = null;
				
				try {
					total =  ChildLists.findElement(By.tagName("span"));
				}catch (Exception e) {
				}
				
				if(total == null) {
					tot_Records="0";
					} else {
						
					tot_Records = getElementText(total,"Tree items text "+ChildLists.getText()).replaceAll("[^0-9]", "");//15,274	
				}
				
				System.out.println("Total Records in Tree item "+tot_Records);
				Reporting.infoLog("Total Records in Tree item "+tot_Records);
				
				ClickObj(ChildLists, "The Tree Item: "+itemName); 			   
				// This is for Red popup handel
				if(getElementDiaplayWithoutWait(closeIconOnPopup, "the item "+itemName)) {
					Reporting.infoLogWithSS("Screenshot for item "+itemName);
				}
				pauseExecution(3000);
				
				String str_TotRecords = getElementText(totalRecords,"Item count is: "+ChildLists.getText());// Showing 1 to 100 of 15,274 entries
				
				String tableTotRecord1 =str_TotRecords.split("of")[1].trim();//15,274 entries
				String tableTotRecord2 = tableTotRecord1.split(" ")[0].trim().replace(",", "");//15274
			
				if(tot_Records.equals(tableTotRecord2)) {
					System.out.println("Count matched Successfully for tree item " + itemName);
					Reporting.successLog("Count matched Successfully for tree item " + itemName);
					//Assert.assertTrue(true);
				}else {
					System.out.println("Failure to match Count for tree item " + itemName);
					Reporting.failureLog(" Failure to match Count for tree item " + itemName);
					//Assert.assertTrue(false);
				}
				pauseExecution(3000);
			}
			
		}
	
	
}


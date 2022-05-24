package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Reporting;

public class MultiApplication_MCenter_Page extends com.utilities.BaseClass{

	WebDriver driver;

	public MultiApplication_MCenter_Page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath="//div[contains(@class,'active in')]//div[contains(@id,'DataTables_Table_') and contains(@class,'dataTables_info')]") 
	  public WebElement totalRecords;
	
		
		  @FindBy(xpath="//a[contains(@class,'treeitem-node wb-node wb-node-without-children')]")
		  public List<WebElement> Weblist;
		  
		  @FindBy(xpath="//span[@aria-expanded='false']") 
		  public List<WebElement>parent;
		 
		
	public void TreeItemCountInTable() {
		
		  //List<WebElement> Weblist = driver .findElements(By.xpath("//a[@class='treeitem-node wb-node wb-node-without-children']"));
		 
				System.out.println(Weblist.size());

				//List<WebElement> parent = driver.findElements(By.xpath("//span[@aria-expanded='false']"));
				System.out.println(parent.size());

				for (int j = 0; j < parent.size(); j++) {
				WebElement parentList = parent.get(0);
				String parentText = getElementText(parentList, "Get parent text ");
				ClickObj(parentList, "Click parent "+parentText);
				pauseExecution(1000);
				}

	for (int i = 0; i < Weblist.size(); i++) {
				WebElement ChildLists = Weblist.get(i);
								
				String itemName = getElementText(ChildLists,"Tree items text");//Pending Review 15,274				
				String tot_Records=null;
				WebElement total = null;
				
				try {
					total =  ChildLists.findElement(By.tagName("span"));
				}catch (Exception e) {
				}
				
				if(total == null) {
					tot_Records="0";
					} else {
					tot_Records = getElementText(total,"Tree items text").replaceAll("[^0-9]", "");//15,274	
				}
				
				System.out.println("Total Records in Tree item "+tot_Records);
				Reporting.infoLog("Total Records in Tree item "+tot_Records);
				ClickObj(ChildLists, "the Tree Item "+itemName); 			   
				
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


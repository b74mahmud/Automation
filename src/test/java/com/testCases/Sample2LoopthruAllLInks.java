package com.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageSteps.LoginSteps;
import com.utilities.BaseClass;
@Listeners(com.utilities.Reporting.class)
public class Sample2LoopthruAllLInks extends BaseClass{
	
	@Test
	public void cLI_WorkBuckets_i_and_ii_ClickingOnAllLinksAndSeePanel2opensAndMatchCounts()
	throws InterruptedException {


		LoginSteps LoginSteps= new LoginSteps();
		LoginSteps.performLogin(username, password);
	
		//loginToRCMSApp();
	
		//loginToAUVSApp();



	List<WebElement> Weblist = driver
	.findElements(By.xpath("//a[@class='treeitem-node wb-node wb-node-without-children']"));
	System.out.println(Weblist.size());



	List<WebElement> parent = driver.findElements(By.xpath("//span[@aria-expanded='false']"));
	System.out.println(parent.size());



	for (int j = 0; j < parent.size(); j++) {
	WebElement parentList = parent.get(j);
	parentList.click();
	}



	for (int i = 0; i < Weblist.size(); i++) {
	WebElement ChildLists = Weblist.get(i);
	// need to get solution for 4856 entry
	String linksNumber = ChildLists.getText()
	.replaceAll("Prepare 4856 ", "").
	replaceAll("Soldiers within 6 years of ETS ", "").
	replaceAll("Soldiers within 5 years of ETS ", "").
	replaceAll("Soldiers within 4 years of ETS ", "").
	replaceAll("Soldiers within 3 years of ETS ", "").
	replaceAll("Soldiers within 2 years of ETS ", "").
	replaceAll("Soldiers within 450 days of ETS ", "").
	replaceAll("Soldiers within 365 days of ETS ", "").
	replaceAll("Soldiers within 270 days of ETS ", "").
	replaceAll("Soldiers within 180 days of ETS ", "").
	replaceAll("Soldiers within 120 days of ETS ", "").
	replaceAll("Soldiers within 90 days of ETS ", "").
	replaceAll("Soldiers within 60 days of ETS ", "").
	replaceAll("Soldiers within 30 days of ETS ", "").
	replaceAll("90-Day Shipper", "").
	replaceAll("60-Day Shipper", "").
	replaceAll("30-Day Shipper", "").
	replaceAll("/", "").
	replaceAll("()", "").
	replaceAll("[^0-9]", "");
	System.out.println("Total Link number are: " + linksNumber + " and value of i is: " + i);
	String tgName = ChildLists.getTagName();
	System.out.println(tgName);



	if (tgName.equals("a"))
	Thread.sleep(3000);
	ChildLists.click();



	String beforeXpath2 = "//*[@id=\"DataTables_Table_";
	String afterXpath2 = "_info\"]";



	String element_TotEnt = driver.findElement(By.xpath(beforeXpath2 + (+i) + afterXpath2)).getText();



	String totEntries_numOnly = element_TotEnt
	.substring(element_TotEnt.indexOf("f") + 1, element_TotEnt.indexOf("entries") - 1)
	.replaceAll(",", "").trim();



	System.out.println("Total Entries are: " + totEntries_numOnly);



	if (linksNumber.equals(totEntries_numOnly)) {
	Assert.assertTrue(true);
	} else if (linksNumber.isEmpty() && totEntries_numOnly.contains("0")) {
	Assert.assertTrue(true);
	} else {
	Assert.assertTrue(false);
	}
	}



	}

}

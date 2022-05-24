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

public class BladeValidationPage  extends BaseClass{
	WebDriver ldriver;

	public BladeValidationPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath = "//h3[@class='noselect panel-title']") 
	  List<WebElement> blade;
	  
	  @FindBy(xpath = "//div[@class='panel-collapse collapse in']") 
	  List<WebElement> empty;
	 
	// TEST CASE: Open each blade to see if there are any errors
	  
	public void panel1_OpenEachBladeToSeeThereAreAnyErrors() {
		
	//List<WebElement> blade = driver.findElements(By.xpath("//h3[@class='noselect panel-title']"));
	int bladeSize = blade.size();
	System.out.println("Total Blades on panel1 are: " + bladeSize);
	Reporting.successLog("Total Blades on panel1 are: " + bladeSize);
	
	for (int i = 1; i < bladeSize; i++) {
	pauseExecution(8000);
	ClickObj(blade.get(i), "Blade");
	//blade.get(i).click();
	
	//boolean bladeExpand = driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']")).isDisplayed();
	boolean bladeExpand = blade.get(0).isDisplayed();
	//boolean bladeExpand = empty.get(0).isDisplayed();
	
	System.out.println("Is this expanded: " + bladeExpand); 
	Reporting.successLog("Is this blade empty:" + bladeExpand);
	//List<WebElement> empty = driver.findElements(By.xpath("//div[@class='panel-collapse collapse in']"));
	boolean isBladeEmpty = empty.isEmpty();
	System.out.println("Is this blade empty:" + isBladeEmpty);
	Reporting.successLog("Is this blade empty:" + isBladeEmpty);
	if ((bladeExpand == true) && (!(isBladeEmpty == true))) {
	System.out.println("It displayed");	
	Reporting.successLog("It displayed");
	Assert.assertTrue(true);
	} else {
	System.out.println("It is not displayed");
	Reporting.failureLog("It is not displayed");
	Assert.assertTrue(false);
	} 
	}
	}

}


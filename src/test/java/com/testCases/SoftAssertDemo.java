package com.testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo {

	@FindBy(id = "main_ctl00_LoginView1_l_Password")
	@CacheLookup
	public WebElement Password;
	
	@FindBy(id = "main_ctl00_LoginView1_l_LoginButton")
	@CacheLookup
	public WebElement LogIn_btn;
	
	@FindBy(id = "details-button")
	@CacheLookup
	public WebElement advance_btn;
	
	@FindBy(id = "proceed-link")
	@CacheLookup
	public WebElement proceed_link_btn;	
	
	@FindBy(name = "agreement")
	@CacheLookup
	public WebElement agree_btn;
	
	@FindBy(id = "main_ctl00_LoginView1_l_UserName") 
	@CacheLookup
	public WebElement UserID;
	@Test
	public void test1() {
		
		SoftAssert softAssert = new SoftAssert();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		PageFactory.initElements(driver, this);
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://smms-hub.rcms.local/v3/RMS/");
		//LoginPage loginPage= new LoginPage(driver);
		  //loginPage.performLogin("kevin.shook","pwd");
		  
		  advance_btn.click();
			proceed_link_btn.click();
			agree_btn.click();
			
			//Assert.assertTrue("",false);
			softAssert.assertTrue(false, "");
			// Enter user name
			
			//EnterTxt(UserID, userName, "UserName");
			
			// Enter password name
			//EnterTxt(Password, password, "Password");
			
			LogIn_btn.click();
			
			softAssert.assertAll();
	}
}

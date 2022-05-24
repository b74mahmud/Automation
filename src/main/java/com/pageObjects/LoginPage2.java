package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utilities.BaseClass;



public class LoginPage2 extends BaseClass{
	
	WebDriver ldriver;

	public LoginPage2(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Dev_UserName") 
	@CacheLookup
	public WebElement UserID;
	
	
	@FindBy(id = "main_ctl00_LoginView1_l_Password")
	@CacheLookup
	public WebElement Password;
	
	@FindBy(xpath = "//input[@type='submit']")
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

	@FindBy(xpath = "//select[@class='form-select-control dropdown width-100-percent jquery-select2 select2-hidden-accessible']")
	@CacheLookup
	public WebElement drop_down;
	
	
	public void performLogin(String userName) {
		ClickObj(advance_btn, "Advance Button");
		ClickObj(proceed_link_btn, "Proceed Link");
		ClickObj(agree_btn, "Agree");
		// Enter user name
		pauseExecution(2000);
		EnterTxt(UserID, userName, "UserName");
		
		// Enter password name
		//EnterTxt(Password, password, "Password");
		
		ClickObj(LogIn_btn, "Login");
		pauseExecution(5000);
		
		/*
		 * WebElement dropdown = driver.findElement(By.
		 * xpath("//select[@class='form-select-control dropdown width-100-percent jquery-select2 select2-hidden-accessible']"
		 * )); Select select = new Select(dropdown); select.selectByIndex(1);
		 */
	
		selectIndexfromlist(drop_down, 2, "DropDown Role");
		pauseExecution(5000);
		selectfromlist(drop_down, "Unit Admin", "Unit Admin Selected");
	}

}

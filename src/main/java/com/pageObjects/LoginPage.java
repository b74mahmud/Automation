package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends com.utilities.BaseClass{
	
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "main_ctl00_LoginView1_l_UserName") 
	@CacheLookup
	public WebElement UserID;
	
	
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

	
	/*
	 * public void performLogin(String userName, String password) {
	 * //ClickObj(advance_btn, "Advance Button"); //ClickObj(proceed_link_btn,
	 * "Proceed Link"); ClickObj(agree_btn, "Agree"); // Enter user name
	 * pauseExecution(2000); EnterTxt(UserID, userName, "UserName");
	 * 
	 * // Enter password name EnterTxt(Password, password, "Password");
	 * 
	 * ClickObj(LogIn_btn, "Login");
	 * 
	 * 
	 * }
	 */
}

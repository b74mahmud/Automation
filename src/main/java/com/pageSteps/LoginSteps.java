package com.pageSteps;

import com.pageObjects.LoginPage;
import com.utilities.BaseClass;

public class LoginSteps extends BaseClass{
	
	LoginPage lp=new LoginPage(driver);
	
	public void performLogin(String userName, String password) {
		//ClickObj(lp.advance_btn, "Advance Button");
		//ClickObj(lp.proceed_link_btn, "Proceed Link");
		ClickObj(lp.agree_btn, "Agree");
		// Enter user name
		pauseExecution(2000);
		EnterTxt(lp.UserID, userName, "UserName");
		
		// Enter password name
		EnterTxt(lp.Password, password, "Password");
		
		ClickObj(lp.LogIn_btn, "Login");
	

	}



}

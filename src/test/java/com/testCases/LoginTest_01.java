package com.testCases;

import java.io.IOException;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pageObjects.LoginPage;
import com.pageSteps.LoginSteps;
import com.utilities.BaseClass;
import com.utilities.JavaScriptUtil;
import com.utilities.Reporting;


@Listeners(com.utilities.Reporting.class)

public class LoginTest_01 extends BaseClass{
	
	@Test
	public void LoginToSMMS() throws IOException {
		Reporting.infoLog("Info Regarding login To SMMS");
		
		
		LoginSteps LoginSteps= new LoginSteps();
		LoginSteps.performLogin(username, password);
		System.out.println("Title is " +JavaScriptUtil.getTitleByJS(driver));
	}

}

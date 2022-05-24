package com.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.LoginPage2;
import com.pageObjects.Report_Center_Page;
import com.pageSteps.LoginSteps;
import com.utilities.BaseClass;


@Listeners(com.utilities.Reporting.class)

public class ReportCenterTest07
extends BaseClass {

	@Test
	@Parameters({"username", "password","login"} )
	public void sample(@Optional String username, @Optional String password, String login) throws InterruptedException, Exception {// This is for TestNG.xml file

		//public void sample() throws InterruptedException, Exception {// This is for Test case Run


		if(login.equalsIgnoreCase("normal")) {
			LoginSteps LoginSteps= new LoginSteps();
			LoginSteps.performLogin(username,password);

		}else{
			LoginPage2 loginPage= new LoginPage2(driver);
			loginPage.performLogin(username);
		}


		Report_Center_Page reports=new Report_Center_Page(driver);
		reports.ReportingCenter();

	}

}

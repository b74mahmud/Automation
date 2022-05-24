package com.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObjects.BladeValidationPage;
import com.pageObjects.LoginPage;
import com.pageObjects.LoginPage2;
import com.pageSteps.LoginSteps;
import com.utilities.BaseClass;


@Listeners(com.utilities.Reporting.class)

public class BladeValidationTest03
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
	
		 BladeValidationPage bladeValid=new BladeValidationPage(driver);
		bladeValid.panel1_OpenEachBladeToSeeThereAreAnyErrors();
		
		  // RMS ONLY Test Case[ Change BaseCalss: public String url = readconfig.getConfigValue("rmsurl");]
		/*
		 * RMS_ManagementCenter_Page avsHomePage = new RMS_ManagementCenter_Page(driver);
		 * avsHomePage.validateTreeItemCountInTable();
		 */
		
		
		/*
		 * MultiProject_MCenter_Page rms= new MultiProject_MCenter_Page(driver);
		 * rms.TreeItemCountInTable();
		 */
		/*
		 * SearchBladePage searchBlade= new SearchBladePage(driver);
		 * searchBlade.panel1_SearchValidation();
		 */
			/*
			 * Sample_original sm=new Sample_original(driver); sm.sample_Test();
			 */
		  
			
			/*
			 * Report_Center_Page reports=new Report_Center_Page(driver);
			 * reports.ReportingCenter();
			 */
	}
	
}

// Important Note"
//----------------
// this is package, we have to create a specific method for all the variables we are going to use. See example below.(public String getApplicationURL().

package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadConfig {

	Properties pro;

	// below creating constructor to read properties and its value from config
	// properties. This is is one time configuration.
	public ReadConfig() {
		File scr = new File("./Configuration/config.properties"); // this statement is referring the file which we are
																	// going to access. ( this statement is to create
																	// link/access the file)

		try {
			FileInputStream fis = new FileInputStream(scr); // this statement is to open the file which we link in above
															// statement in reading mode.
			pro = new Properties(); // This statement is initiating Pro object which we declare globally above (
									// properties pro).
			pro.load(fis); // load is the method which load the complete "config.properties" file.

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// Using this method we can access any Element from config file to Base class
	public String getConfigValue(String key) {
		String value = pro.getProperty(key);
		return value;
	}

	// we are creating all the method to read the values from the config properties.
	// We will add method in future if we need to add property and its value in
	// Config properties file.

	/*
	 * public String smmsgetApplicationURL() { 
	 * String url=pro.getProperty("smmsurl"); 
	 * return url;
	 * 
	 * }
	 */
	/*
	 * public String smmsgetUsername() { String
	 * username=pro.getProperty("username"); return username; }
	 * 
	 * public String smmsgetPassword() { String
	 * password=pro.getProperty("password"); return password; }
	 */
	/*
	 * public String getChromePath() { String
	 * chromepath=pro.getProperty("chromepath"); return chromepath; }
	 * 
	 * public String getFirefoxPath() { String
	 * firefoxpath=pro.getProperty("firefoxpath"); return firefoxpath; }
	 * 
	 * public String getIEpath() { String iePath=pro.getProperty("iepath"); return
	 * iePath; } public String getEdgepath() { String
	 * edgePath=pro.getProperty("edgepath"); return edgePath; }
	 * 
	 * 
	 * 
	 * public String smmsgetBrowser() { String br=pro.getProperty("browser"); return
	 * br; }
	 */

}
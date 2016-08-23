package com.yourcompany;

import org.openqa.selenium.WebDriver; //allows us to use the WebDriver class/object from Selenium lib
import org.openqa.selenium.remote.DesiredCapabilities; //allows us to use the Desired Capabilities class/object to set Sauce Labs capabilities
import org.openqa.selenium.remote.RemoteWebDriver;  //allows us to use the RemoteWebDriver class/object, to talk to remote browsers using Sauce Labs
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.saucelabs.saucerest.SauceREST; //allows us to use the Sauce Labs API to send and query data

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By; //allows us to use the By object to create locator expressions


public class SampleSauceReportScript {

	//global variables required to authenticate w/ Sauce Labs and spin up new VMs to test on
	  public static final String USERNAME = "USERNAME";
	  public static final String ACCESS_KEY = "ACCESS_KEY";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	  public static String id;
	  
	@Test
    public static void main() throws MalformedURLException {
    	 
		//capabilities to send to Sauce Labs - to label tests and start remote browser
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "43.0");
        
        //remote webdriver object that sends commands to remote web browser on Sauce Labs VM
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		
		//session id string queried from Sauce Labs
        //id = ((RemoteWebDriver) driver).getSessionId().toString();

        //grab page title to compare against expected string value below
        driver.get("https://saucelabs.github.io/training-test-page/");
        String pageTitle = driver.getTitle();     
        assertEquals(pageTitle, "I am a page title - Sauce Banana");
        
        driver.quit();
      }
/*
    @AfterMethod
	 public void after(ITestResult testResult) {		 
        //sends passed or failed value from sauce labs api object to Sauce Labs account - shows passed or fail on test in UI
		 SauceREST restAPI = new SauceREST(USERNAME, ACCESS_KEY);
		 
		 if (testResult.isSuccess()) {
	        restAPI.jobPassed(id);
	     } else {
	        restAPI.jobFailed(id);
	     }
	 }*/
	
}

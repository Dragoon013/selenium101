package com.yourcompany;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.saucelabs.saucerest.SauceREST;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;


public class SampleSauceTest {

	 public static final String USERNAME = "dragoon013";
	  public static final String ACCESS_KEY = "98d61e8d-a05f-4581-8572-3fb129fe5e9e";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	@Test
    public static void main() throws MalformedURLException {
    	 
		DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");
        
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        String id = ((RemoteWebDriver) driver).getSessionId().toString();
        SauceREST r = new SauceREST(USERNAME, ACCESS_KEY);
        driver.get("https://saucelabs.github.io/training-test-page/");
        String pageTitle = driver.getTitle();

        

        if (pageTitle.equals("I am a page title - Sauce Labs")) {
        	r.jobPassed(id);
        } else {
        	r.jobFailed(id);
        }

        driver.quit();
      }

}

package com.yourcompany;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;

//asserts
public class SampleSauceTest {

	@Test
    public static void main() throws MalformedURLException {
    	 
        
        WebDriver driver = new FirefoxDriver();
     
        /**
         * Goes to Sauce Labs' website and prints the title and clicks on the drop down.
         */
        driver.get("http://saucelabs.github.io/training-test-page/");
        
        assertEquals(driver.getTitle(), "I am a page title - Sauce Labs");
        
        
        driver.quit();
      }

}

package com.yourcompany;

import org.openqa.selenium.WebDriver; //allows us to use the WebDriver class/object from Selenium lib
import org.openqa.selenium.firefox.FirefoxDriver; //allows us to use the Firefox WebDriver
import org.openqa.selenium.chrome.ChromeDriver; //allows us to use the Chrome WebDriver
import org.openqa.selenium.remote.DesiredCapabilities; //allows us to use the Desired Capabilities class/object to set Sauce Labs capabilities
import org.openqa.selenium.remote.RemoteWebDriver;  //allows us to use the RemoteWebDriver class/object, to talk to remote browsers using Sauce Labs
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals; //allows us to use the assertEquals function to evaluate a boolean expression and fail the test if it the expression is not true

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By; //allows us to use the By object to create locator expressions

//asserts
public class SampleSauceAssert {

	@Test
    public static void main() throws MalformedURLException {
    	 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neil\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //WebDriver object that sends commands to local firefox browser
        WebDriver driver = new ChromeDriver();
     
        /**
         * Goes to Sauce Labs' website and prints the title and clicks on the drop down.
         */
        driver.get("http://saucelabs.github.io/training-test-page/");
        
        //assert that grabs the title, compares it to the expected value, and returns true or fails the test
        
               
        //close the browser, ends the test
        driver.quit();
      }

}

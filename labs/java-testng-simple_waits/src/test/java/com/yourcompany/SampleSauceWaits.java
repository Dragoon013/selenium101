package com.yourcompany;

import org.openqa.selenium.WebDriver; //allows us to use the WebDriver class/object from Selenium lib
import org.openqa.selenium.WebElement; //allows us to use the WebElement class/object from Selenium lib
import org.openqa.selenium.remote.DesiredCapabilities; //allows us to use the Desired Capabilities class/object to set Sauce Labs capabilities
import org.openqa.selenium.remote.RemoteWebDriver;  //allows us to use the RemoteWebDriver class/object, to talk to remote browsers using Sauce Labs
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By; //allows us to use the By object to create locator expressions
import org.openqa.selenium.support.ui.ExpectedConditions; //allows us to use the ExpectedConditions class/object to evaluate a boolean expression
import org.openqa.selenium.support.ui.WebDriverWait; //allows us to set waits on the webdriver


public class SampleSauceWaits {

	//global variables required to authenticate w/ Sauce Labs and spin up new VMs to test on
	  public static final String USERNAME = "USERNAME";
	  public static final String ACCESS_KEY = "ACCESS_KEY";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@Test
    public static void main() throws MalformedURLException {
    	 
		//capabilities to send to Sauce Labs - to label tests and start remote browser
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "43.0");
        
        //remote webdriver object that sends commands to remote web browser on Sauce Labs VM
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        
        //generic 10 second wait object
        //WebDriverWait wait = new WebDriverWait(driver, 10);
     
        /**	
         * Goes to Dave Haeffner's waits page and clicks the start button.
         */
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//div[2]/div/div/div/button")).click();
        
        //wait 10 seconds (testing all the while) until element of id "finish" is found
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        
        /* Find element by ID, "finish", then print it's text value to the console. */
        WebElement end = driver.findElement(By.id("finish"));
        String text = end.getText();
        
        System.out.println("Title of page is: " + text);
        
        //close the browser, end the test
        driver.quit();
      }

}

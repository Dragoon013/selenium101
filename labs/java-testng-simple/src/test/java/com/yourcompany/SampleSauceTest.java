package com.yourcompany;


import org.openqa.selenium.WebDriver; //allows us to use the WebDriver class/object from Selenium lib
import org.openqa.selenium.WebElement; //allows us to use the WebElement class/object from Selenium lib
import org.openqa.selenium.chrome.ChromeDriver; //allows us to use the Chrome WebDriver
import org.openqa.selenium.firefox.FirefoxDriver; //allows us to use the Firefox WebDriver
import org.openqa.selenium.remote.DesiredCapabilities; //allows us to use the Desired Capabilities class/object to set Sauce Labs capabilities
import org.openqa.selenium.remote.RemoteWebDriver; //allows us to use the RemoteWebDriver class/object, to talk to remote browsers using Sauce Labs

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By; //allows us to use the By object to create locator expressions


public class SampleSauceTest {
	
	@Test
    public static void main() throws MalformedURLException {
	        
		//create a new webdriver to send commands to a local Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neil\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
     
        /**
         * Goes to Sauce Labs' website.
         */
        driver.get("http://saucelabs.com/");
        
        WebElement search = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[3]/div/div/div[3]/div/span/button"));
        //identify element (button) by xpath
        search.click();
        //click action
        WebElement search_text = driver.findElement(By.name("q"));
        //identify element by name
        search_text.sendKeys("SAUCE LABS TRAINING");
        //sendkeys action
        
        /* This while loop is for Lab 2*/
        
        /* int i =0;
        while(i<=20) {
        	
        	i++;
        } */
                       
        //print to the console: "Title of page is: " the title of the webpage
        System.out.println("title of page is: " + driver.getTitle());

        //close the browser, ends the test
        driver.quit();
      }

}

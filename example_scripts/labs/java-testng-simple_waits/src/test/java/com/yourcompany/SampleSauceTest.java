package com.yourcompany;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SampleSauceTest {

	  public static final String USERNAME = "USERNAME";
	  public static final String ACCESS_KEY = "ACCESS_KEY";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@Test
    public static void main() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "43.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        //WebDriverWait wait = new WebDriverWait(driver, 10);

        /**
         * Goes to Dave Haeffner's waits page and clicks a button and waits for the text to appear.
         */
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//div[2]/div/div/div/button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        System.out.println("Hidden Element: " + driver.findElement(By.id("finish")).getText());

        driver.quit();
      }

}

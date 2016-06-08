import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import java.net.URL;

public class SampleSauceTest_lab3 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://saucelabs.github.io/training-test-page/");

        driver.findElement(By.id("comments")).sendKeys("Nice page you got here");

        int i=0;
        while (i!=10){

            driver.findElement(By.id("unchecked_checkbox")).click();
            driver.findElement(By.id("checked_checkbox")).click();
            i++;
        }

        driver.findElement(By.id("submit")).click();

        driver.quit();
    }
}

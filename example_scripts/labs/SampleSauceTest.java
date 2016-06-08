import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import java.net.URL;

public class SampleSauceTest {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();

      /**
       * Goes to Sauce Lab's guinea-pig page and prints title
       */

        driver.get("http://saucelabs.com/");
        driver.findElement(By.id("ham")).click();

        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();
    }
}

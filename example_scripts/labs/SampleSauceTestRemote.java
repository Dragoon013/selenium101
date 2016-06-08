import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

public class SampleSauceTestRemote {

    public static final String USERNAME = "dragoon013";
    public static final String ACCESS_KEY = "98d61e8d-a05f-4581-8572-3fb129fe5e9e";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws Exception {

      DesiredCapabilities caps = DesiredCapabilities.chrome();
      caps.setCapability("platform", "Mac OS X 10.9");
      caps.setCapability("version", "43.0");
      caps.setCapability("tags","tag_awesome");
      caps.setCapability("build","cool_builds1");
            caps.setCapability("name","Java Remote Sample Test");
      WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

      /**
       * Goes to Sauce Lab's guinea-pig page and prints title
       */



      driver.get("http://saucelabs.github.io/training-test-page/");
      System.out.println("title of page is: " + driver.getTitle());



      driver.quit();
    }
}

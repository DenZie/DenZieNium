package Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelUtil {
	
	public static WebDriver createDriver(String Browser) {
		WebDriver driver = null;
		switch (Browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/home/denzie/selenium/drivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", "/home/denzie/selenium/drivers/chromedriver");
			
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/home/denzie/selenium/drivers/chromedriver");
			driver = new ChromeDriver();
			break;
		}
	return driver;
	}

}

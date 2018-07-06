package com.dd.DenZieNium.Grid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;


/**
 * Utility class making it easy to write tests based on Selenium driver in a
 * multi-thread context.
 * 
 * 
 * in parallel to those from WebSelenium since we have to support both Selenium
 * and WebDriver in this release.
 * 
 * In the next release we will deprecate Selenium, CatPawSelenium,
 * WebDriverBackedSelenium and only support WebDriver part of the Selenium-2
 * 
 */
public class Grid {


	private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<WebDriver>();

	private static long TIME_OUT=1000;
	/**
	 * Starts a web session based on the browser flavor.
	 * The browser flavor and also the test name (which becomes relevant for Sauce Labs runs) are now
	 * passed as attributes to the {@link ITestResult} object.
	 * 
	 * @param webTestConfig - A {@link WebTestConfig} object that represents the Web Configurations of a 
	 * <code>{@literal @}WebTest</code> annotated method.
	 * 
	 * @return a {@link CatPawWebSession} that represents the created session
	 */
	public static void startSession(String browser){
		WebDriver driver = createDriver(browser);
		threadLocalWebDriver.set(driver);
	}	

	/**
	 * The existing session is closed when this method is invoked. This method
	 * takes care of closing both the selenium session as well as the driver
	 * sessions as well
	 */
	public static synchronized void closeSession() {
		if (driver() != null) {
			WebDriver driver = driver();
			threadLocalWebDriver.set(null);
			driver.quit();
		}
	}

	public static WebDriver driver( ) {
		return threadLocalWebDriver.get();
	}

	/**
	 * Helper method that can be used to load a URL in a browser.
	 * @param url - The url of the web application that needs to be opened.
	 */
	public static void open(String url) {
		Grid.driver().get(url);
	}

	private static WebDriver createDriver(String browser) {
		WebDriver driver = null;
		switch (browser) {
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
	
	public static void waitUntilElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver(),TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

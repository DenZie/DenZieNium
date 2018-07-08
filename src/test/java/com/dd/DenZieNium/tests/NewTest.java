package com.dd.DenZieNium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.DenZieNium.Grid.Grid;
import com.dd.DenZieNium.html.Frame;
import com.dd.DenZieNium.html.react.ReactSelect;

import Register.UserVO;

public class NewTest {
	String Url = "https://www.iqa002.com/tob/live/usp-core/app/register";
	
	
	
	@Test(dataProvider="userDataProvider")
	public void register(UserVO user) {
		System.setProperty("webdriver.gecko.driver", "/home/denzie/selenium/drivers/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/home/denzie/selenium/drivers/chromedriver");
		Grid.driver().get(Url);
		Frame frame = new  Frame(By.id("regframe"));
		ReactSelect countrySelect =  new ReactSelect(By.xpath("//div[@id='countrySelect']/div/div"));
		ReactSelect stateSelect =  new ReactSelect(By.xpath("//div[@id='stateSelect']/div/div"));
		
		frame.switchTo();
//		stateSelect.selectByIndex(3);
		stateSelect.selectByLabel("Indiana");
		System.out.println(stateSelect.getText());
//		rsel.select(5);
//		System.out.println(rsel.getText());
//		rsel.selectByLabel("India");
//		System.out.println(rsel.getText());
//		Grid.driver().findElement(By.xpath("//div[@id='countrySelect']/div/div")).click();
//		
//		List<WebElement> list = Grid.driver().findElements(By.cssSelector(".Select-option"));
//		for( WebElement el : list) {
//			System.out.println(el.getText());
//		}
//		driver.findElement(lid).sendKeys(user.getLoginID());
//		driver.findElement(pwd).sendKeys(user.getPassword());
//		driver.findElement(rpwd).sendKeys(user.getPassword());
//		driver.findElement(fnm).sendKeys(user.getFirstName());
//		driver.findElement(lnm).sendKeys(user.getLastName());
//		driver.findElement(bdt).sendKeys(user.getBirthDate());
//		driver.findElement(mnm).sendKeys(user.getMotherName());
//		driver.findElement(ssn).sendKeys(user.getMotherName());
//		driver.findElement(mno).sendKeys(user.getMotherName());
//		driver.findElement(cnm).sendKeys(user.getMotherName());
//		driver.findElement(pcd).sendKeys(user.getMotherName());
//		driver.findElement(pem).sendKeys(user.getMotherName());
		
	}
	
	@DataProvider
	public Object[][] userDataProvider() {
		Object[][] data = new Object[1][1];
		UserVO user = new UserVO();
		user.setLoginID("AUTOOFX004");
		user.setPassword("test@123#");
		 
		data[0][0] = user; 
		return data;
	}
	
	@BeforeClass
	public void createSession() {
		Grid.startSession("chrome");
	}

	@AfterClass
	public void closeSession() {
		Grid.closeSession();
	}
}

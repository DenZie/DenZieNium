package com.dd.DenZieNium.html;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dd.DenZieNium.Grid.Grid;


/**
 * This class is the web element Link wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'click' is encapsulated and invoke claws session to do the click against the specified
 * element.
 * </p>
 * 
 */
public class Slider extends AbstractElement {
	/**
	 * Link Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private Link lnkSYI = new Link("//a[contains(@href,'?eBayCommand')]"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public Slider() {
		super();
	}
	public Slider(By locator) {
		super(locator);
	}

	public Slider(By locator, String controlName) {
		super(locator, controlName);
	}
	
	public void slide(int pixel) {
		  //Locate slider pointer.
		  WebElement dragElementFrom = Grid.driver().findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));   
		  Dimension s = getElement().getSize();
		        
		  //To Move jQuery slider by 100 pixel offset using dragAndDropBy method of Actions class.
		  new Actions(Grid.driver()).dragAndDropBy(dragElementFrom, pixel, 0).build().perform();
	}
	
	public void slideByPercentage(int percentage) {
		  //Locate slider pointer.
		  WebElement dragElementFrom = Grid.driver().findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));   
		  Dimension s = getElement().getSize();
		  int pixel = s.width * percentage/100;
		  //To Move jQuery slider by 100 pixel offset using dragAndDropBy method of Actions class.
		  new Actions(Grid.driver()).dragAndDropBy(dragElementFrom, pixel, 0).build().perform();
	}
	
	public int getProgress() {
		WebElement sliderHandle = Grid.driver().findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));
		String prog = sliderHandle.getAttribute("style").replace("left: ", "").replaceAll("%;", "");
		return Integer.valueOf(prog);
	}
	

}

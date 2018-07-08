package com.dd.DenZieNium.html.react;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dd.DenZieNium.Grid.Grid;
import com.dd.DenZieNium.html.AbstractElement;


/**
 * This class is the web element Select wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'select' is encapsulated and invoke claws Grid.selenium() to select option against the
 * specified element.
 * </p>
 * 
 */
public class ReactSelect extends AbstractElement {
	/**
	 * SelectList Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private SelectList selShippingService = new
	 *         SelectList("//select[@id='shipping']"}
	 * @param locator - the element locator
	 */
	public ReactSelect(By locator) {
		super(locator);
	}

	public ReactSelect(By locator, String controlName) {
		super(locator, controlName);
	}

	public void selectByLabel(String label) {
		getElement().click();
		List<WebElement> list = Grid.driver().findElements(By.cssSelector(".Select-option"));
		for( int i=0;i< list.size();i++) {
			if(list.get(i).getText().equals(label)) {
				selectByIndex(i+1);
				break;
			}
		}
	}
	
	public void selectByIndex(int index) {
		getElement().click();
		Grid.driver().findElement(By.cssSelector("div.Select-option:nth-child(" +String.valueOf(index)+")")).click();
		System.err.println("");
	}

}

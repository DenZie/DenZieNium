package com.dd.DenZieNium.html;

import org.openqa.selenium.By;

import com.dd.DenZieNium.Grid.Grid;

/**
 * This class is the web element Form wrapper for handling infrastructure
 * testing technology.
 * <p>
 * In this class, the method 'submit' are encapsulated and invoke claws
 * session to do submit against the specified element.
 * </p>
 * 
 */
public class Frame extends AbstractElement {

	/**
	 * Form Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private Form frmDummy = new Form("//Form[@name='DummyForm']"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public Frame(By locator) {
		super(locator);
	}
	public Frame(By locator, String controlName) {
		super(locator, controlName);
	}
	
	
	public void switchTo() { 
		Grid.waitUntilElementPresent(getLocator());
		Grid.driver().switchTo().frame(getElement());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
